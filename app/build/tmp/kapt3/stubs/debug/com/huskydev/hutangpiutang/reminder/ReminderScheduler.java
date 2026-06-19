package com.huskydev.hutangpiutang.reminder;

/**
 * Helper untuk jadwal & batalkan alarm reminder.
 * requestCode = debtId.toInt() — konsisten di schedule() dan cancel().
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lcom/huskydev/hutangpiutang/reminder/ReminderScheduler;", "", "()V", "canScheduleExactAlarms", "", "context", "Landroid/content/Context;", "cancel", "", "debtId", "", "createPendingIntent", "Landroid/app/PendingIntent;", "openExactAlarmSettings", "schedule", "triggerAtMillis", "app_debug"})
public final class ReminderScheduler {
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.reminder.ReminderScheduler INSTANCE = null;
    
    private ReminderScheduler() {
        super();
    }
    
    /**
     * Jadwalkan reminder alarm exact.
     * @param debtId ID debt (Long, di-cast ke Int untuk requestCode)
     * @param triggerAtMillis epoch millis waktu reminder
     */
    public final void schedule(@org.jetbrains.annotations.NotNull()
    android.content.Context context, long debtId, long triggerAtMillis) {
    }
    
    /**
     * Batalkan alarm reminder yang sudah terjadwal.
     * WAJIB dipanggil:
     * - Sebelum update/edit debt yang remindernya berubah
     * - Saat status berubah ke LUNAS (dari jalur mana pun)
     * - Sebelum hapus kontak (loop semua debtId milik kontak)
     */
    public final void cancel(@org.jetbrains.annotations.NotNull()
    android.content.Context context, long debtId) {
    }
    
    /**
     * Cek apakah exact alarm bisa dijadwalkan (API 31+).
     * Return true jika bisa atau API < 31.
     */
    public final boolean canScheduleExactAlarms(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Buka halaman system settings untuk mengaktifkan exact alarm permission.
     */
    public final void openExactAlarmSettings(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * Buat PendingIntent untuk alarm.
     * requestCode = debtId.toInt() — harus konsisten antara schedule dan cancel.
     */
    private final android.app.PendingIntent createPendingIntent(android.content.Context context, long debtId) {
        return null;
    }
}