package com.huskydev.hutangpiutang.reminder

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings

/**
 * Helper untuk jadwal & batalkan alarm reminder.
 * requestCode = debtId.toInt() — konsisten di schedule() dan cancel().
 */
object ReminderScheduler {

    /**
     * Jadwalkan reminder alarm exact.
     * @param debtId ID debt (Long, di-cast ke Int untuk requestCode)
     * @param triggerAtMillis epoch millis waktu reminder
     */
    fun schedule(context: Context, debtId: Long, triggerAtMillis: Long) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Cek izin exact alarm (API 31+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!alarmManager.canScheduleExactAlarms()) {
                // Fallback ke inexact alarm
                alarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    triggerAtMillis,
                    createPendingIntent(context, debtId)
                )
                return
            }
        }

        // Exact alarm
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            triggerAtMillis,
            createPendingIntent(context, debtId)
        )
    }

    /**
     * Batalkan alarm reminder yang sudah terjadwal.
     * WAJIB dipanggil:
     * - Sebelum update/edit debt yang remindernya berubah
     * - Saat status berubah ke LUNAS (dari jalur mana pun)
     * - Sebelum hapus kontak (loop semua debtId milik kontak)
     */
    fun cancel(context: Context, debtId: Long) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(createPendingIntent(context, debtId))
    }

    /**
     * Cek apakah exact alarm bisa dijadwalkan (API 31+).
     * Return true jika bisa atau API < 31.
     */
    fun canScheduleExactAlarms(context: Context): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            return alarmManager.canScheduleExactAlarms()
        }
        return true
    }

    /**
     * Buka halaman system settings untuk mengaktifkan exact alarm permission.
     */
    fun openExactAlarmSettings(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    /**
     * Buat PendingIntent untuk alarm.
     * requestCode = debtId.toInt() — harus konsisten antara schedule dan cancel.
     */
    private fun createPendingIntent(context: Context, debtId: Long): PendingIntent {
        val intent = Intent(context, ReminderReceiver::class.java).apply {
            putExtra(ReminderReceiver.EXTRA_DEBT_ID, debtId)
        }
        return PendingIntent.getBroadcast(
            context,
            debtId.toInt(), // Cast aman untuk app personal
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
}
