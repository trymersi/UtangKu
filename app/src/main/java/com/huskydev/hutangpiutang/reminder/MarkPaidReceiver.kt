package com.huskydev.hutangpiutang.reminder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationManagerCompat
import com.huskydev.hutangpiutang.data.AppDatabase
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.Payment
import java.util.concurrent.Executors

/**
 * BroadcastReceiver untuk action "Tandai Lunas" dari notifikasi.
 * 
 * PENTING: Sebelum set remainingAmount = 0 / status = LUNAS,
 * insert Payment record sebesar remainingAmount saat itu.
 * Ini menjaga invariant sum(payments) == originalAmount tetap konsisten.
 */
class MarkPaidReceiver : BroadcastReceiver() {

    companion object {
        const val EXTRA_DEBT_ID = "extra_debt_id"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val debtId = intent.getLongExtra(EXTRA_DEBT_ID, -1)
        if (debtId == -1L) return

        Executors.newSingleThreadExecutor().execute {
            val db = AppDatabase.getInstance(context)
            val debt = db.debtDao().getById(debtId) ?: return@execute

            // Skip if already lunas
            if (debt.status == DebtStatus.LUNAS) return@execute

            val now = System.currentTimeMillis()

            // Insert Payment record for remaining amount (menjaga invariant)
            val payment = Payment(
                debtId = debtId,
                amount = debt.remainingAmount,
                paymentDate = now,
                note = "Pelunasan otomatis"
            )
            db.paymentDao().insert(payment)

            // Update debt status
            val updatedDebt = debt.copy(
                remainingAmount = 0,
                status = DebtStatus.LUNAS,
                updatedAt = now
            )
            db.debtDao().update(updatedDebt)

            // Cancel alarm — jangan biarkan alarm zombie
            ReminderScheduler.cancel(context, debtId)

            // Dismiss notification
            NotificationManagerCompat.from(context).cancel(debtId.toInt())
        }
    }
}
