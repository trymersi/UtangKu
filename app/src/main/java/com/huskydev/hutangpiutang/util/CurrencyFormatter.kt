package com.huskydev.hutangpiutang.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

/**
 * Format nominal ke tampilan rupiah Indonesia.
 * Contoh: 1500000 → "Rp 1.500.000"
 */
object CurrencyFormatter {

    private val symbols = DecimalFormatSymbols(Locale("id", "ID")).apply {
        groupingSeparator = '.'
        decimalSeparator = ','
    }

    private val formatter = DecimalFormat("#,###", symbols)

    /**
     * Format long ke string rupiah tanpa desimal.
     */
    fun format(amount: Long): String {
        return "Rp ${formatter.format(amount)}"
    }

    /**
     * Parse string angka (mungkin mengandung titik pemisah ribuan) ke Long.
     * Menghapus semua karakter non-digit.
     * Return 0 jika string kosong atau tidak valid.
     */
    fun parse(text: String): Long {
        val cleaned = text.replace(Regex("[^\\d]"), "")
        return if (cleaned.isEmpty()) 0L else cleaned.toLongOrNull() ?: 0L
    }

    /**
     * Format string angka mentah ke format ribuan (tanpa prefix "Rp").
     * Dipakai untuk real-time formatting di TextWatcher.
     * Contoh: "1500000" → "1.500.000"
     */
    fun formatRaw(text: String): String {
        val amount = parse(text)
        return if (amount == 0L) "" else formatter.format(amount)
    }
}
