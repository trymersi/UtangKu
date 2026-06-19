package com.huskydev.hutangpiutang.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\t2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/huskydev/hutangpiutang/data/dao/PaymentDao;", "", "delete", "", "payment", "Lcom/huskydev/hutangpiutang/data/entity/Payment;", "getAllSync", "", "getByDebtId", "Landroidx/lifecycle/LiveData;", "debtId", "", "getByDebtIdSync", "insert", "app_debug"})
@androidx.room.Dao()
public abstract interface PaymentDao {
    
    @androidx.room.Query(value = "SELECT * FROM payments WHERE debtId = :debtId ORDER BY paymentDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Payment>> getByDebtId(long debtId);
    
    @androidx.room.Query(value = "SELECT * FROM payments WHERE debtId = :debtId ORDER BY paymentDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.huskydev.hutangpiutang.data.entity.Payment> getByDebtIdSync(long debtId);
    
    @androidx.room.Query(value = "SELECT * FROM payments ORDER BY paymentDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.huskydev.hutangpiutang.data.entity.Payment> getAllSync();
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Payment payment);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Payment payment);
}