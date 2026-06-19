package com.huskydev.hutangpiutang.reminder

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.huskydev.hutangpiutang.HutangPiutangApp
import com.huskydev.hutangpiutang.R
import com.huskydev.hutangpiutang.data.AppDatabase
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.ui.detail.DebtDetailActivity
import com.huskydev.hutangpiutang.util.CurrencyFormatter
import com.huskydev.hutangpiutang.util.DateUtil
import java.util.concurrent.Executors

/**
 * BroadcastReceiver untuk alarm reminder.
 * Query ulang debt dari Room saat trigger — skip kalau sudah LUNAS.
 */
class ReminderReceiver : BroadcastReceiver() {

    companion object {
        const val EXTRA_DEBT_ID = "extra_debt_id"
    }

    override fun onReceive(context: Context, intent: Intent) {
        val debtId = intent.getLongExtra(EXTRA_DEBT_ID, -1)
        if (debtId == -1L) return

        // Query di background thread
        Executors.newSingleThreadExecutor().execute {
            val db = AppDatabase.getInstance(context)
            val debt = db.debtDao().getById(debtId) ?: return@execute

            // Skip notifikasi kalau sudah lunas
            if (debt.status == DebtStatus.LUNAS) return@execute

            val contact = db.contactDao().getById(debt.contactId)
            val contactName = contact?.name ?: "Tidak diketahui"

            // Build notification content
            val title = if (debt.type == DebtType.PIUTANG)
                context.getString(R.string.notif_piutang_title, contactName)
            else
                context.getString(R.string.notif_hutang_title, contactName)

            val body = buildNotifBody(context, debt.dueDate, debt.remainingAmount)

            // Tap notification → DebtDetailActivity
            val detailIntent = Intent(context, DebtDetailActivity::class.java).apply {
                putExtra(DebtDetailActivity.EXTRA_DEBT_ID, debtId)
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            val detailPendingIntent = PendingIntent.getActivity(
                context, debtId.toInt(), detailIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            // Action button "Tandai Lunas"
            val markPaidIntent = Intent(context, MarkPaidReceiver::class.java).apply {
                putExtra(MarkPaidReceiver.EXTRA_DEBT_ID, debtId)
            }
            val markPaidPendingIntent = PendingIntent.getBroadcast(
                context, (debtId + 10000).toInt(), markPaidIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

            val notification = NotificationCompat.Builder(context, HutangPiutangApp.CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(body)
                .setContentIntent(detailPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(0, context.getString(R.string.notif_action_mark_paid), markPaidPendingIntent)
                .build()

            try {
                NotificationManagerCompat.from(context).notify(debtId.toInt(), notification)
            } catch (e: SecurityException) {
                // POST_NOTIFICATIONS permission not granted
            }
        }
    }

    private fun buildNotifBody(context: Context, dueDate: Long?, remainingAmount: Long): String {
        val amountStr = CurrencyFormatter.format(remainingAmount)
        if (dueDate == null) return amountStr

        val days = DateUtil.daysFromNow(dueDate)
        return when {
            days == 0L -> context.getString(R.string.notif_body_today, amountStr)
            days == 1L -> context.getString(R.string.notif_body_tomorrow, amountStr)
            days > 1 -> context.getString(R.string.notif_body_days, days.toInt(), amountStr)
            else -> context.getString(R.string.notif_body_overdue, amountStr)
        }
    }
}
