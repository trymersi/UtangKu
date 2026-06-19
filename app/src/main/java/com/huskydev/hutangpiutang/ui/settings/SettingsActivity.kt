package com.huskydev.hutangpiutang.ui.settings

import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.huskydev.hutangpiutang.HutangPiutangApp
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.AppDatabase
import com.huskydev.hutangpiutang.databinding.ActivitySettingsBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    // Launcher for creating backup document
    private val backupLauncher = registerForActivityResult(ActivityResultContracts.CreateDocument("application/octet-stream")) { uri ->
        if (uri != null) {
            performBackup(uri)
        }
    }

    // Launcher for opening backup document
    private val restoreLauncher = registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            confirmRestore(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupReminderSettings()
        setupThemeSettings()
        setupBackupRestore()
    }

    override fun onResume() {
        super.onResume()
        checkNotificationPermission()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun checkNotificationPermission() {
        val notifEnabled = NotificationManagerCompat.from(this).areNotificationsEnabled()
        binding.tvNotifWarning.visibility = if (!notifEnabled) android.view.View.VISIBLE else android.view.View.GONE
    }

    private fun setupReminderSettings() {
        val prefs = getSharedPreferences(HutangPiutangApp.PREFS_NAME, Context.MODE_PRIVATE)

        // Default Hour
        val defaultHour = prefs.getInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_HOUR, HutangPiutangApp.DEFAULT_REMINDER_HOUR)
        binding.tvReminderHour.text = String.format(Locale.getDefault(), "%02d:00", defaultHour)

        binding.layoutReminderHour.setOnClickListener {
            val currentHour = prefs.getInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_HOUR, HutangPiutangApp.DEFAULT_REMINDER_HOUR)
            TimePickerDialog(this, { _, hourOfDay, _ ->
                prefs.edit().putInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_HOUR, hourOfDay).apply()
                binding.tvReminderHour.text = String.format(Locale.getDefault(), "%02d:00", hourOfDay)
            }, currentHour, 0, true).show()
        }

        // Default Lead Days
        val defaultDays = prefs.getInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_LEAD_DAYS, HutangPiutangApp.DEFAULT_LEAD_DAYS)
        binding.tvLeadDays.text = "$defaultDays hari"

        binding.layoutLeadDays.setOnClickListener {
            val days = arrayOf("Pada hari H (0 hari)", "1 hari sebelumnya", "2 hari sebelumnya", "3 hari sebelumnya", "7 hari sebelumnya")
            val values = intArrayOf(0, 1, 2, 3, 7)
            val current = prefs.getInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_LEAD_DAYS, HutangPiutangApp.DEFAULT_LEAD_DAYS)
            val selectedIndex = values.indexOf(current).takeIf { it >= 0 } ?: 1

            MaterialAlertDialogBuilder(this)
                .setTitle("Pilih Lead Time")
                .setSingleChoiceItems(days, selectedIndex) { dialog, which ->
                    val selectedValue = values[which]
                    prefs.edit().putInt(HutangPiutangApp.PREF_DEFAULT_REMINDER_LEAD_DAYS, selectedValue).apply()
                    binding.tvLeadDays.text = "${selectedValue} hari"
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun setupThemeSettings() {
        val prefs = getSharedPreferences(HutangPiutangApp.PREFS_NAME, Context.MODE_PRIVATE)
        val currentTheme = prefs.getInt(HutangPiutangApp.PREF_THEME_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        binding.tvTheme.text = when (currentTheme) {
            AppCompatDelegate.MODE_NIGHT_NO -> "Terang"
            AppCompatDelegate.MODE_NIGHT_YES -> "Gelap"
            else -> "Ikuti Sistem"
        }

        binding.layoutTheme.setOnClickListener {
            val themes = arrayOf("Ikuti Sistem", "Terang", "Gelap")
            val values = intArrayOf(
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM,
                AppCompatDelegate.MODE_NIGHT_NO,
                AppCompatDelegate.MODE_NIGHT_YES
            )
            val selectedIndex = values.indexOf(currentTheme).takeIf { it >= 0 } ?: 0

            MaterialAlertDialogBuilder(this)
                .setTitle("Pilih Tema")
                .setSingleChoiceItems(themes, selectedIndex) { dialog, which ->
                    val selectedValue = values[which]
                    prefs.edit().putInt(HutangPiutangApp.PREF_THEME_MODE, selectedValue).apply()
                    AppCompatDelegate.setDefaultNightMode(selectedValue)
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun setupBackupRestore() {
        binding.layoutBackup.setOnClickListener {
            val sdf = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            val dateStr = sdf.format(Date())
            val fileName = "UtangKu_Backup_$dateStr.db"
            backupLauncher.launch(fileName)
        }

        binding.layoutRestore.setOnClickListener {
            restoreLauncher.launch(arrayOf("application/octet-stream", "application/x-sqlite3", "*/*"))
        }
    }

    private fun performBackup(uri: Uri) {
        try {
            val dbFile = getDatabasePath("hutang_piutang.db")
            if (!dbFile.exists()) {
                Toast.makeText(this, "Data belum ada", Toast.LENGTH_SHORT).show()
                return
            }

            // Checkpoint WAL before copying to ensure all data is in the main DB file
            AppDatabase.getInstance(this).openHelper.writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close()

            contentResolver.openOutputStream(uri)?.use { outStream ->
                FileInputStream(dbFile).use { inStream ->
                    inStream.copyTo(outStream)
                }
            }
            Toast.makeText(this, "Backup berhasil disimpan", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Gagal backup: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun confirmRestore(uri: Uri) {
        // Cek nama file (opsional)
        var fileName = "File tidak diketahui"
        contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (nameIndex >= 0) {
                    fileName = cursor.getString(nameIndex)
                }
            }
        }

        MaterialAlertDialogBuilder(this)
            .setTitle("Pulihkan Data?")
            .setMessage("Anda akan memulihkan data dari file:\n$fileName\n\nData saat ini akan ditimpa dan aplikasi akan dimuat ulang. Lanjutkan?")
            .setPositiveButton("Pulihkan") { _, _ ->
                performRestore(uri)
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun performRestore(uri: Uri) {
        try {
            // Close database first
            AppDatabase.getInstance(this).close()

            val dbFile = getDatabasePath("hutang_piutang.db")
            
            // Delete WAL and SHM files to avoid corruption
            val walFile = File(dbFile.path + "-wal")
            val shmFile = File(dbFile.path + "-shm")
            if (walFile.exists()) walFile.delete()
            if (shmFile.exists()) shmFile.delete()

            contentResolver.openInputStream(uri)?.use { inStream ->
                FileOutputStream(dbFile).use { outStream ->
                    inStream.copyTo(outStream)
                }
            }

            Toast.makeText(this, "Restore berhasil! Aplikasi akan dimuat ulang.", Toast.LENGTH_LONG).show()

            // Restart app
            val intent = packageManager.getLaunchIntentForPackage(packageName)
            intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            Runtime.getRuntime().exit(0)

        } catch (e: Exception) {
            Toast.makeText(this, "Gagal restore: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}
