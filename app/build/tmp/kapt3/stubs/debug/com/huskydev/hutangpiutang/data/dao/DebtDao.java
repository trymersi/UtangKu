package com.huskydev.hutangpiutang.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\'J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000f\u001a\u00020\u000bH\'J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\'J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00072\u0006\u0010\u0012\u001a\u00020\u000bH\'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000f\u001a\u00020\u000bH\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\'J&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\'J\u0018\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\'J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006 "}, d2 = {"Lcom/huskydev/hutangpiutang/data/dao/DebtDao;", "", "delete", "", "debt", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "getActiveDebts", "Landroidx/lifecycle/LiveData;", "", "getActiveReminders", "nowMillis", "", "getAllDebts", "getAllDebtsSync", "getByContactId", "contactId", "getByContactIdSync", "getById", "id", "getByIdLive", "getDebtIdsByContact", "getDebtsByStatus", "status", "Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;", "getFilteredDebts", "query", "", "getTotalByType", "type", "Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "insert", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface DebtDao {
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE status != \'LUNAS\' ORDER BY dueDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getActiveDebts();
    
    @androidx.room.Query(value = "SELECT * FROM debts ORDER BY dueDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getAllDebts();
    
    @androidx.room.Query(value = "SELECT * FROM debts ORDER BY dueDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.huskydev.hutangpiutang.data.entity.Debt> getAllDebtsSync();
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE status = :status ORDER BY dueDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getDebtsByStatus(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtStatus status);
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract com.huskydev.hutangpiutang.data.entity.Debt getById(long id);
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Debt> getByIdLive(long id);
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE contactId = :contactId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getByContactId(long contactId);
    
    @androidx.room.Query(value = "SELECT * FROM debts WHERE contactId = :contactId ORDER BY createdAt DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.huskydev.hutangpiutang.data.entity.Debt> getByContactIdSync(long contactId);
    
    @androidx.room.Query(value = "SELECT id FROM debts WHERE contactId = :contactId")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.lang.Long> getDebtIdsByContact(long contactId);
    
    /**
     * Query gabungan untuk filter chip + search box.
     * - status = null → semua status (filter "Semua")
     * - query = '' → tanpa filter search
     * Keduanya digabung jadi satu query via MediatorLiveData di ViewModel.
     */
    @androidx.room.Query(value = "\n        SELECT debts.* FROM debts\n        JOIN contacts ON debts.contactId = contacts.id\n        WHERE (:status IS NULL OR debts.status = :status)\n          AND (:query = \'\' OR contacts.name LIKE \'%\' || :query || \'%\'\n               OR debts.description LIKE \'%\' || :query || \'%\')\n        ORDER BY debts.dueDate ASC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getFilteredDebts(@org.jetbrains.annotations.Nullable()
    com.huskydev.hutangpiutang.data.entity.DebtStatus status, @org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT SUM(remainingAmount) FROM debts WHERE type = :type AND status != \'LUNAS\'")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Long> getTotalByType(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtType type);
    
    /**
     * Query untuk BootReceiver: ambil debt yang remindernya aktif, belum lunas,
     * dan waktu reminder belum lewat — untuk dijadwal ulang setelah reboot.
     */
    @androidx.room.Query(value = "\n        SELECT * FROM debts\n        WHERE reminderEnabled = 1\n          AND status != \'LUNAS\'\n          AND reminderDatetime > :nowMillis\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.huskydev.hutangpiutang.data.entity.Debt> getActiveReminders(long nowMillis);
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Debt debt);
}