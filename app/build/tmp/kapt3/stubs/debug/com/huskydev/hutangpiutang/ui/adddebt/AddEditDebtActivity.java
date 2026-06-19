package com.huskydev.hutangpiutang.ui.adddebt;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J,\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130#H\u0002J\b\u0010$\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/huskydev/hutangpiutang/databinding/ActivityAddEditDebtBinding;", "dateCreatedMillis", "", "dueDateMillis", "Ljava/lang/Long;", "editDebtId", "isFormatting", "", "notificationPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "viewModel", "Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel;", "checkDueDateWarning", "", "checkNotificationPermissionStatus", "observeData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setupAmountFormatter", "setupDatePickers", "setupReminderToggle", "setupSaveButton", "setupToolbar", "showDatePicker", "title", "initialSelection", "onDateSelected", "Lkotlin/Function1;", "validate", "Companion", "app_debug"})
public final class AddEditDebtActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.huskydev.hutangpiutang.databinding.ActivityAddEditDebtBinding binding;
    private com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel viewModel;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long editDebtId;
    private long dateCreatedMillis;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long dueDateMillis;
    private boolean isFormatting = false;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DEBT_ID = "extra_debt_id";
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> notificationPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtActivity.Companion Companion = null;
    
    public AddEditDebtActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupAmountFormatter() {
    }
    
    private final void setupDatePickers() {
    }
    
    private final void showDatePicker(java.lang.String title, long initialSelection, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onDateSelected) {
    }
    
    private final void checkDueDateWarning() {
    }
    
    private final void setupReminderToggle() {
    }
    
    private final void checkNotificationPermissionStatus() {
    }
    
    private final void setupSaveButton() {
    }
    
    private final boolean validate() {
        return false;
    }
    
    private final void observeData() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtActivity$Companion;", "", "()V", "EXTRA_DEBT_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}