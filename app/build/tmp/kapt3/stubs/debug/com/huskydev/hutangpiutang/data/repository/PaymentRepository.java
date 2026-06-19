package com.huskydev.hutangpiutang.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J&\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/huskydev/hutangpiutang/data/repository/PaymentRepository;", "", "paymentDao", "Lcom/huskydev/hutangpiutang/data/dao/PaymentDao;", "executor", "Ljava/util/concurrent/ExecutorService;", "(Lcom/huskydev/hutangpiutang/data/dao/PaymentDao;Ljava/util/concurrent/ExecutorService;)V", "delete", "", "payment", "Lcom/huskydev/hutangpiutang/data/entity/Payment;", "callback", "Lkotlin/Function0;", "getAllSync", "", "getByDebtId", "Landroidx/lifecycle/LiveData;", "debtId", "", "getByDebtIdSync", "insert", "Lkotlin/Function1;", "insertSync", "app_debug"})
public final class PaymentRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.dao.PaymentDao paymentDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService executor = null;
    
    public PaymentRepository(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.dao.PaymentDao paymentDao, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.ExecutorService executor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Payment>> getByDebtId(long debtId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.huskydev.hutangpiutang.data.entity.Payment> getByDebtIdSync(long debtId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.huskydev.hutangpiutang.data.entity.Payment> getAllSync() {
        return null;
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Payment payment, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> callback) {
    }
    
    /**
     * Blocking insert — call ONLY from executor thread
     */
    public final long insertSync(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Payment payment) {
        return 0L;
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Payment payment, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
}