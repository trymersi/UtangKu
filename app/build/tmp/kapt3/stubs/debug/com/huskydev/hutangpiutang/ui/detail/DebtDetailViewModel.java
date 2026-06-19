package com.huskydev.hutangpiutang.ui.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0017J\u000e\u0010\'\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "debtRepository", "Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;", "contactRepository", "Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;", "paymentRepository", "Lcom/huskydev/hutangpiutang/data/repository/PaymentRepository;", "executor", "Ljava/util/concurrent/ExecutorService;", "(Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;Lcom/huskydev/hutangpiutang/data/repository/PaymentRepository;Ljava/util/concurrent/ExecutorService;)V", "_actionResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult;", "_contact", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "actionResult", "Landroidx/lifecycle/LiveData;", "getActionResult", "()Landroidx/lifecycle/LiveData;", "contact", "getContact", "debtId", "", "addPayment", "", "amount", "paymentDate", "note", "", "deleteDebt", "debt", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "getDebtLive", "getPayments", "", "Lcom/huskydev/hutangpiutang/data/entity/Payment;", "loadContact", "contactId", "markAsPaid", "ActionResult", "app_debug"})
public final class DebtDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.ContactRepository contactRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.PaymentRepository paymentRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService executor = null;
    private long debtId = -1L;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.data.entity.Contact> _contact = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> contact = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult> _actionResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult> actionResult = null;
    
    public DebtDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.ContactRepository contactRepository, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.PaymentRepository paymentRepository, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.ExecutorService executor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> getContact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult> getActionResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Debt> getDebtLive(long debtId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Payment>> getPayments(long debtId) {
        return null;
    }
    
    public final void loadContact(long contactId) {
    }
    
    /**
     * Catat pembayaran sebagian.
     * Update remainingAmount & status. Jika remaining jadi 0 → LUNAS.
     */
    public final void addPayment(long debtId, long amount, long paymentDate, @org.jetbrains.annotations.Nullable()
    java.lang.String note) {
    }
    
    /**
     * Tandai lunas sepenuhnya.
     * Insert Payment record sebesar remainingAmount ("Pelunasan otomatis").
     */
    public final void markAsPaid(long debtId) {
    }
    
    public final void deleteDebt(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult;", "", "()V", "Deleted", "MarkedPaid", "PaymentAdded", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult$Deleted;", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult$MarkedPaid;", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult$PaymentAdded;", "app_debug"})
    public static abstract class ActionResult {
        
        private ActionResult() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult$Deleted;", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Deleted extends com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult {
            @org.jetbrains.annotations.NotNull()
            public static final com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult.Deleted INSTANCE = null;
            
            private Deleted() {
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult$MarkedPaid;", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult;", "debtId", "", "(J)V", "getDebtId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class MarkedPaid extends com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult {
            private final long debtId = 0L;
            
            public MarkedPaid(long debtId) {
            }
            
            public final long getDebtId() {
                return 0L;
            }
            
            public final long component1() {
                return 0L;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult.MarkedPaid copy(long debtId) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult$PaymentAdded;", "Lcom/huskydev/hutangpiutang/ui/detail/DebtDetailViewModel$ActionResult;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class PaymentAdded extends com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult {
            @org.jetbrains.annotations.NotNull()
            public static final com.huskydev.hutangpiutang.ui.detail.DebtDetailViewModel.ActionResult.PaymentAdded INSTANCE = null;
            
            private PaymentAdded() {
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
    }
}