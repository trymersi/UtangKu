package com.huskydev.hutangpiutang.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.huskydev.hutangpiutang.data.entity.Payment

@Dao
interface PaymentDao {

    @Query("SELECT * FROM payments WHERE debtId = :debtId ORDER BY paymentDate DESC")
    fun getByDebtId(debtId: Long): LiveData<List<Payment>>

    @Query("SELECT * FROM payments WHERE debtId = :debtId ORDER BY paymentDate DESC")
    fun getByDebtIdSync(debtId: Long): List<Payment>

    @Query("SELECT * FROM payments ORDER BY paymentDate DESC")
    fun getAllSync(): List<Payment>

    @Insert
    fun insert(payment: Payment): Long

    @Delete
    fun delete(payment: Payment)
}
