package com.huskydev.hutangpiutang;

/**
 * Application class — single entry point for DI manual.
 * Membuat shared ExecutorService, database, dan semua Repository sekali saja.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/huskydev/hutangpiutang/HutangPiutangApp;", "Landroid/app/Application;", "()V", "<set-?>", "Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;", "contactRepository", "getContactRepository", "()Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;", "Lcom/huskydev/hutangpiutang/data/AppDatabase;", "database", "getDatabase", "()Lcom/huskydev/hutangpiutang/data/AppDatabase;", "Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;", "debtRepository", "getDebtRepository", "()Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;", "Ljava/util/concurrent/ExecutorService;", "executor", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "Lcom/huskydev/hutangpiutang/data/repository/PaymentRepository;", "paymentRepository", "getPaymentRepository", "()Lcom/huskydev/hutangpiutang/data/repository/PaymentRepository;", "createNotificationChannel", "", "onCreate", "Companion", "app_debug"})
public final class HutangPiutangApp extends android.app.Application {
    
    /**
     * Shared single-thread executor untuk SEMUA operasi tulis ke database.
     */
    private java.util.concurrent.ExecutorService executor;
    private com.huskydev.hutangpiutang.data.AppDatabase database;
    private com.huskydev.hutangpiutang.data.repository.ContactRepository contactRepository;
    private com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository;
    private com.huskydev.hutangpiutang.data.repository.PaymentRepository paymentRepository;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID = "utangku_reminder_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREFS_NAME = "utangku_prefs";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEFAULT_REMINDER_HOUR = "default_reminder_hour";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_DEFAULT_REMINDER_LEAD_DAYS = "default_reminder_lead_days";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PREF_THEME_MODE = "theme_mode";
    public static final int DEFAULT_REMINDER_HOUR = 9;
    public static final int DEFAULT_LEAD_DAYS = 1;
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.HutangPiutangApp.Companion Companion = null;
    
    public HutangPiutangApp() {
        super();
    }
    
    /**
     * Shared single-thread executor untuk SEMUA operasi tulis ke database.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.concurrent.ExecutorService getExecutor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.repository.ContactRepository getContactRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.repository.DebtRepository getDebtRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.repository.PaymentRepository getPaymentRepository() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * Buat NotificationChannel sekali di Application.onCreate().
     * Wajib untuk Android 8.0+ (API 26+), dan minSdk kita 26.
     */
    private final void createNotificationChannel() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/huskydev/hutangpiutang/HutangPiutangApp$Companion;", "", "()V", "CHANNEL_ID", "", "DEFAULT_LEAD_DAYS", "", "DEFAULT_REMINDER_HOUR", "PREFS_NAME", "PREF_DEFAULT_REMINDER_HOUR", "PREF_DEFAULT_REMINDER_LEAD_DAYS", "PREF_THEME_MODE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}