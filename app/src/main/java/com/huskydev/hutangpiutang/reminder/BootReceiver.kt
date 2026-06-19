package com.huskydev.hutangpiutang.reminder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.huskydev.hutangpiutang.data.AppDatabase
import java.util.concurrent.Executors

/**
 * BroadcastReceiver untuk BOOT_COMPLETED.
 * Setelah reboot, semua alarm hilang — jadwal ulang yang masih aktif.
 * Query: reminderEnabled=true AND status!=LUNAS AND reminderDatetime > now()
 */
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED) return

        Executors.newSingleThreadExecutor().execute {
            val db = AppDatabase.getInstance(context)
            val now = System.currentTimeMillis()
            val debtsToReschedule = db.debtDao().getActiveReminders(now)

            for (debt in debtsToReschedule) {
                val reminderTime = debt.reminderDatetime ?: continue
                if (reminderTime > now) {
                    ReminderScheduler.schedule(context, debt.id, reminderTime)
                }
            }
        }
    }
}
