package com.huskydev.hutangpiutang.ui.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/huskydev/hutangpiutang/databinding/ActivityDebtDetailBinding;", "currentDebt", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "paymentAdapter", "Lcom/huskydev/hutangpiutang/ui/detail/PaymentHistoryAdapter;", "viewModel", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel;", "bindDebt", "", "debt", "observeData", "debtId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupButtons", "setupPaymentList", "setupToolbar", "Companion", "app_debug"})
public final class DebtDetailActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.huskydev.hutangpiutang.databinding.ActivityDebtDetailBinding binding;
    private com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel viewModel;
    private com.huskydev.hutangpiutang.ui.detail.PaymentHistoryAdapter paymentAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.huskydev.hutangpiutang.data.entity.Debt currentDebt;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_DEBT_ID = "extra_debt_id";
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.ui.detail.DebtDetailActivity.Companion Companion = null;
    
    public DebtDetailActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupPaymentList() {
    }
    
    private final void setupButtons(long debtId) {
    }
    
    private final void observeData(long debtId) {
    }
    
    private final void bindDebt(com.huskydev.hutangpiutang.data.entity.Debt debt) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailActivity$Companion;", "", "()V", "EXTRA_DEBT_ID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}