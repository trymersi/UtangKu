package com.huskydev.hutangpiutang.data.repository

import androidx.lifecycle.LiveData
import com.huskydev.hutangpiutang.data.dao.PaymentDao
import com.huskydev.hutangpiutang.data.entity.Payment
import java.util.concurrent.ExecutorService

class PaymentRepository(
    private val paymentDao: PaymentDao,
    private val executor: ExecutorService
) {
    fun getByDebtId(debtId: Long): LiveData<List<Payment>> = paymentDao.getByDebtId(debtId)

    fun getByDebtIdSync(debtId: Long): List<Payment> = paymentDao.getByDebtIdSync(debtId)

    fun getAllSync(): List<Payment> = paymentDao.getAllSync()

    fun insert(payment: Payment, callback: ((Long) -> Unit)? = null) {
        executor.execute {
            val id = paymentDao.insert(payment)
            callback?.invoke(id)
        }
    }

    /** Blocking insert — call ONLY from executor thread */
    fun insertSync(payment: Payment): Long = paymentDao.insert(payment)

    fun delete(payment: Payment, callback: (() -> Unit)? = null) {
        executor.execute {
            paymentDao.delete(payment)
            callback?.invoke()
        }
    }
}
