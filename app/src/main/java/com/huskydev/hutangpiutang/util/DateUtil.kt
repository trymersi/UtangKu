package com.huskydev.hutangpiutang.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

/**
 * Utility untuk konversi dan format tanggal.
 * Semua data disimpan sebagai epoch millis UTC, di-render ke local timezone saat ditampilkan.
 */
object DateUtil {

    private val displayFormat = SimpleDateFormat("dd MMM yyyy", Locale("id", "ID"))
    private val fullFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale("id", "ID"))

    /**
     * Format epoch millis ke "dd MMM yyyy" (misal: "15 Jun 2026").
     */
    fun formatDate(millis: Long): String {
        return displayFormat.format(Date(millis))
    }

    /**
     * Format epoch millis ke "dd MMMM yyyy, HH:mm" (misal: "15 Juni 2026, 09:00").
     */
    fun formatDateTime(millis: Long): String {
        return fullFormat.format(Date(millis))
    }

    /**
     * Hitung selisih hari dari sekarang ke target date.
     * - Positif = target di masa depan (H-x)
     * - Negatif = target sudah lewat (terlambat x hari)
     * - 0 = hari ini
     */
    fun daysFromNow(targetMillis: Long): Long {
        val now = System.currentTimeMillis()
        val diffMillis = targetMillis - now
        return TimeUnit.MILLISECONDS.toDays(diffMillis)
    }

    /**
     * Dapatkan epoch millis untuk awal hari ini (00:00:00.000 local timezone).
     */
    fun startOfToday(): Long {
        val cal = Calendar.getInstance()
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)
        return cal.timeInMillis
    }

    /**
     * Hitung waktu reminder berdasarkan due date dan lead time.
     * @param dueDateMillis epoch millis due date
     * @param leadDays jumlah hari sebelum due date
     * @param hourOfDay jam reminder (0-23)
     * @return epoch millis waktu reminder, atau null jika sudah lewat
     */
    fun calculateReminderTime(dueDateMillis: Long, leadDays: Int, hourOfDay: Int): Long? {
        val cal = Calendar.getInstance()
        cal.timeInMillis = dueDateMillis
        cal.add(Calendar.DAY_OF_YEAR, -leadDays)
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
        cal.set(Calendar.MINUTE, 0)
        cal.set(Calendar.SECOND, 0)
        cal.set(Calendar.MILLISECOND, 0)

        val reminderTime = cal.timeInMillis
        // Jangan jadwalkan ke masa lalu
        return if (reminderTime > System.currentTimeMillis()) reminderTime else null
    }

    /**
     * Label selisih hari untuk tampilan di UI.
     * Contoh: "Hari ini", "Besok", "H-3", "Terlambat 5 hari"
     */
    fun dueDateLabel(dueDateMillis: Long): String {
        val days = daysFromNow(dueDateMillis)
        return when {
            days < -1 -> "Terlambat ${-days} hari"
            days == -1L -> "Terlambat 1 hari"
            days == 0L -> "Hari ini"
            days == 1L -> "Besok"
            else -> "H-$days"
        }
    }
}
