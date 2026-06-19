package com.huskydev.hutangpiutang.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType

@Dao
interface DebtDao {

    @Query("SELECT * FROM debts WHERE status != 'LUNAS' ORDER BY dueDate ASC")
    fun getActiveDebts(): LiveData<List<Debt>>

    @Query("SELECT * FROM debts ORDER BY dueDate ASC")
    fun getAllDebts(): LiveData<List<Debt>>

    @Query("SELECT * FROM debts ORDER BY dueDate ASC")
    fun getAllDebtsSync(): List<Debt>

    @Query("SELECT * FROM debts WHERE status = :status ORDER BY dueDate ASC")
    fun getDebtsByStatus(status: DebtStatus): LiveData<List<Debt>>

    @Query("SELECT * FROM debts WHERE id = :id")
    fun getById(id: Long): Debt?

    @Query("SELECT * FROM debts WHERE id = :id")
    fun getByIdLive(id: Long): LiveData<Debt?>

    @Query("SELECT * FROM debts WHERE contactId = :contactId ORDER BY createdAt DESC")
    fun getByContactId(contactId: Long): LiveData<List<Debt>>

    @Query("SELECT * FROM debts WHERE contactId = :contactId ORDER BY createdAt DESC")
    fun getByContactIdSync(contactId: Long): List<Debt>

    @Query("SELECT id FROM debts WHERE contactId = :contactId")
    fun getDebtIdsByContact(contactId: Long): List<Long>

    /**
     * Query gabungan untuk filter chip + search box.
     * - status = null → semua status (filter "Semua")
     * - query = '' → tanpa filter search
     * Keduanya digabung jadi satu query via MediatorLiveData di ViewModel.
     */
    @Query("""
        SELECT debts.* FROM debts
        JOIN contacts ON debts.contactId = contacts.id
        WHERE (:status IS NULL OR debts.status = :status)
          AND (:query = '' OR contacts.name LIKE '%' || :query || '%'
               OR debts.description LIKE '%' || :query || '%')
        ORDER BY debts.dueDate ASC
    """)
    fun getFilteredDebts(status: DebtStatus?, query: String): LiveData<List<Debt>>

    @Query("SELECT SUM(remainingAmount) FROM debts WHERE type = :type AND status != 'LUNAS'")
    fun getTotalByType(type: DebtType): LiveData<Long?>

    /**
     * Query untuk BootReceiver: ambil debt yang remindernya aktif, belum lunas,
     * dan waktu reminder belum lewat — untuk dijadwal ulang setelah reboot.
     */
    @Query("""
        SELECT * FROM debts
        WHERE reminderEnabled = 1
          AND status != 'LUNAS'
          AND reminderDatetime > :nowMillis
    """)
    fun getActiveReminders(nowMillis: Long): List<Debt>

    @Insert
    fun insert(debt: Debt): Long

    @Update
    fun update(debt: Debt)

    @Delete
    fun delete(debt: Debt)
}
