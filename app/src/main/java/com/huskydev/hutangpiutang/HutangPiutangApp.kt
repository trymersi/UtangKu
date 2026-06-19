package com.huskydev.hutangpiutang

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import com.huskydev.hutangpiutang.data.AppDatabase
import com.huskydev.hutangpiutang.data.repository.ContactRepository
import com.huskydev.hutangpiutang.data.repository.DebtRepository
import com.huskydev.hutangpiutang.data.repository.PaymentRepository
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Application class — single entry point for DI manual.
 * Membuat shared ExecutorService, database, dan semua Repository sekali saja.
 */
class HutangPiutangApp : Application() {

    /** Shared single-thread executor untuk SEMUA operasi tulis ke database. */
    lateinit var executor: ExecutorService
        private set

    lateinit var database: AppDatabase
        private set

    lateinit var contactRepository: ContactRepository
        private set

    lateinit var debtRepository: DebtRepository
        private set

    lateinit var paymentRepository: PaymentRepository
        private set

    override fun onCreate() {
        super.onCreate()

        // Single thread executor — urutan operasi tulis se-app konsisten,
        // tidak ada race condition antar Repository yang nulis ke tabel berelasi.
        executor = Executors.newSingleThreadExecutor()

        database = AppDatabase.getInstance(this)

        contactRepository = ContactRepository(database.contactDao(), executor)
        debtRepository = DebtRepository(database.debtDao(), executor)
        paymentRepository = PaymentRepository(database.paymentDao(), executor)

        createNotificationChannel()
    }

    /**
     * Buat NotificationChannel sekali di Application.onCreate().
     * Wajib untuk Android 8.0+ (API 26+), dan minSdk kita 26.
     */
    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Pengingat Hutang Piutang",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "Notifikasi pengingat jatuh tempo hutang piutang"
            enableVibration(true)
        }

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    companion object {
        const val CHANNEL_ID = "utangku_reminder_channel"

        // SharedPreferences keys
        const val PREFS_NAME = "utangku_prefs"
        const val PREF_DEFAULT_REMINDER_HOUR = "default_reminder_hour"
        const val PREF_DEFAULT_REMINDER_LEAD_DAYS = "default_reminder_lead_days"
        const val PREF_THEME_MODE = "theme_mode"

        // Default values
        const val DEFAULT_REMINDER_HOUR = 9
        const val DEFAULT_LEAD_DAYS = 1
    }
}
