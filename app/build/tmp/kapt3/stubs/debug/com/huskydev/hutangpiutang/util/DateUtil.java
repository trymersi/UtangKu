package com.huskydev.hutangpiutang.util;

/**
 * Utility untuk konversi dan format tanggal.
 * Semua data disimpan sebagai epoch millis UTC, di-render ke local timezone saat ditampilkan.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/huskydev/hutangpiutang/util/DateUtil;", "", "()V", "displayFormat", "Ljava/text/SimpleDateFormat;", "fullFormat", "calculateReminderTime", "", "dueDateMillis", "leadDays", "", "hourOfDay", "(JII)Ljava/lang/Long;", "daysFromNow", "targetMillis", "dueDateLabel", "", "formatDate", "millis", "formatDateTime", "startOfToday", "app_debug"})
public final class DateUtil {
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat displayFormat = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.text.SimpleDateFormat fullFormat = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.util.DateUtil INSTANCE = null;
    
    private DateUtil() {
        super();
    }
    
    /**
     * Format epoch millis ke "dd MMM yyyy" (misal: "15 Jun 2026").
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDate(long millis) {
        return null;
    }
    
    /**
     * Format epoch millis ke "dd MMMM yyyy, HH:mm" (misal: "15 Juni 2026, 09:00").
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String formatDateTime(long millis) {
        return null;
    }
    
    /**
     * Hitung selisih hari dari sekarang ke target date.
     * - Positif = target di masa depan (H-x)
     * - Negatif = target sudah lewat (terlambat x hari)
     * - 0 = hari ini
     */
    public final long daysFromNow(long targetMillis) {
        return 0L;
    }
    
    /**
     * Dapatkan epoch millis untuk awal hari ini (00:00:00.000 local timezone).
     */
    public final long startOfToday() {
        return 0L;
    }
    
    /**
     * Hitung waktu reminder berdasarkan due date dan lead time.
     * @param dueDateMillis epoch millis due date
     * @param leadDays jumlah hari sebelum due date
     * @param hourOfDay jam reminder (0-23)
     * @return epoch millis waktu reminder, atau null jika sudah lewat
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long calculateReminderTime(long dueDateMillis, int leadDays, int hourOfDay) {
        return null;
    }
    
    /**
     * Label selisih hari untuk tampilan di UI.
     * Contoh: "Hari ini", "Besok", "H-3", "Terlambat 5 hari"
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String dueDateLabel(long dueDateMillis) {
        return null;
    }
}