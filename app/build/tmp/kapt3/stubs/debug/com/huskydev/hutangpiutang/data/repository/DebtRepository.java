package com.huskydev.hutangpiutang.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\u000eJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\u000eJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u000fJ\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u0012J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\u0016\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u0012J\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e2\u0006\u0010\u0019\u001a\u00020\u0012J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0016\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\u000e2\u0006\u0010\u001d\u001a\u00020\u001eJ$\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f0\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e2\u0006\u0010#\u001a\u00020$J&\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010&J\u000e\u0010\'\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nJ \u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;", "", "debtDao", "Lcom/huskydev/hutangpiutang/data/dao/DebtDao;", "executor", "Ljava/util/concurrent/ExecutorService;", "(Lcom/huskydev/hutangpiutang/data/dao/DebtDao;Ljava/util/concurrent/ExecutorService;)V", "delete", "", "debt", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "callback", "Lkotlin/Function0;", "getActiveDebts", "Landroidx/lifecycle/LiveData;", "", "getActiveReminders", "nowMillis", "", "getAllDebts", "getAllDebtsSync", "getByContactId", "contactId", "getByContactIdSync", "getById", "id", "getByIdLive", "getDebtIdsByContact", "getDebtsByStatus", "status", "Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;", "getFilteredDebts", "query", "", "getTotalByType", "type", "Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "insert", "Lkotlin/Function1;", "insertSync", "update", "app_debug"})
public final class DebtRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.dao.DebtDao debtDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService executor = null;
    
    public DebtRepository(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.dao.DebtDao debtDao, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.ExecutorService executor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getActiveDebts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getAllDebts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.huskydev.hutangpiutang.data.entity.Debt> getAllDebtsSync() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getDebtsByStatus(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.huskydev.hutangpiutang.data.entity.Debt getById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Debt> getByIdLive(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getByContactId(long contactId) {
        return null;
    }
    
    /**
     * Blocking read by contact — call ONLY from executor thread
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.huskydev.hutangpiutang.data.entity.Debt> getByContactIdSync(long contactId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Long> getDebtIdsByContact(long contactId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getFilteredDebts(@org.jetbrains.annotations.Nullable()
    com.huskydev.hutangpiutang.data.entity.DebtStatus status, @org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getTotalByType(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtType type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.huskydev.hutangpiutang.data.entity.Debt> getActiveReminders(long nowMillis) {
        return null;
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> callback) {
    }
    
    /**
     * Blocking insert — call ONLY from executor thread
     */
    public final long insertSync(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt) {
        return 0L;
    }
    
    public final void update(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
}