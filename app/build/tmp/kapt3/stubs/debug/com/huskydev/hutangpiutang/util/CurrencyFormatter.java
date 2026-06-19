package com.huskydev.hutangpiutang.util;

/**
 * Format nominal ke tampilan rupiah Indonesia.
 * Contoh: 1500000 → "Rp 1.500.000"
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/huskydev/hutangpiutang/util/CurrencyFormatter;", "", "()V", "formatter", "Ljava/text/DecimalFormat;", "symbols", "Ljava/text/DecimalFormatSymbols;", "format", "", "amount", "", "formatRaw", "text", "parse", "app_debug"})
public final class CurrencyFormatter {
    @org.jetbrains.annotations.NotNull()
    private static final java.text.DecimalFormatSymbols symbols = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.text.DecimalFormat formatter = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.util.CurrencyFormatter INSTANCE = null;
    
    private CurrencyFormatter() {
        super();
    }
    
    /**
     * Format long ke string rupiah tanpa desimal.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String format(long amount) {
        return null;
    }
    
    /**
     * Parse string angka (mungkin mengandung titik pemisah ribuan) ke Long.
     * Menghapus semua karakter non-digit.
     * Return 0 jika string kosong atau tidak valid.
     */
    public final long parse(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return 0L;
    }
    
    /**
     * Format string angka mentah ke format ribuan (tanpa prefix "Rp").
     * Dipakai untuk real-time formatting di TextWatcher.
     * Contoh: "1500000" → "1.500.000"
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatRaw(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
}