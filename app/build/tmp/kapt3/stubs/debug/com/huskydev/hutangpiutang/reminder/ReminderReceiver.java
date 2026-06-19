package com.huskydev.hutangpiutang.reminder;

/**
 * BroadcastReceiver untuk alarm reminder.
 * Query ulang debt dari Room saat trigger — skip kalau sudah LUNAS.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/huskydev/hutangpiutang/reminder/ReminderReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "buildNotifBody", "", "context", "Landroid/content/Context;", "dueDate", "", "remainingAmount", "(Landroid/content/Context;Ljava/lang/Long;J)Ljava/lang/String;", "onReceive", "", "intent", "Landroid/content/Intent;", "Companion", "app_debug"})
public final class ReminderReceiver extends android.content.BroadcastReceiver {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DEBT_ID = "extra_debt_id";
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.reminder.ReminderReceiver.Companion Companion = null;
    
    public ReminderReceiver() {
        super();
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    private final java.lang.String buildNotifBody(android.content.Context context, java.lang.Long dueDate, long remainingAmount) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/huskydev/hutangpiutang/reminder/ReminderReceiver$Companion;", "", "()V", "EXTRA_DEBT_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}