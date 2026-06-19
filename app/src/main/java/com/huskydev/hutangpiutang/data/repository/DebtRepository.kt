package com.huskydev.hutangpiutang.data.repository

import androidx.lifecycle.LiveData
import com.huskydev.hutangpiutang.data.dao.DebtDao
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType
import java.util.concurrent.ExecutorService

class DebtRepository(
    private val debtDao: DebtDao,
    private val executor: ExecutorService
) {
    fun getActiveDebts(): LiveData<List<Debt>> = debtDao.getActiveDebts()

    fun getAllDebts(): LiveData<List<Debt>> = debtDao.getAllDebts()

    fun getAllDebtsSync(): List<Debt> = debtDao.getAllDebtsSync()

    fun getDebtsByStatus(status: DebtStatus): LiveData<List<Debt>> = debtDao.getDebtsByStatus(status)

    fun getById(id: Long): Debt? = debtDao.getById(id)

    fun getByIdLive(id: Long): LiveData<Debt?> = debtDao.getByIdLive(id)

    fun getByContactId(contactId: Long): LiveData<List<Debt>> = debtDao.getByContactId(contactId)

    /** Blocking read by contact — call ONLY from executor thread */
    fun getByContactIdSync(contactId: Long): List<Debt> = debtDao.getByContactIdSync(contactId)

    fun getDebtIdsByContact(contactId: Long): List<Long> = debtDao.getDebtIdsByContact(contactId)

    fun getFilteredDebts(status: DebtStatus?, query: String): LiveData<List<Debt>> =
        debtDao.getFilteredDebts(status, query)

    fun getTotalByType(type: DebtType): LiveData<Long?> = debtDao.getTotalByType(type)

    fun getActiveReminders(nowMillis: Long): List<Debt> = debtDao.getActiveReminders(nowMillis)

    fun insert(debt: Debt, callback: ((Long) -> Unit)? = null) {
        executor.execute {
            val id = debtDao.insert(debt)
            callback?.invoke(id)
        }
    }

    /** Blocking insert — call ONLY from executor thread */
    fun insertSync(debt: Debt): Long = debtDao.insert(debt)

    fun update(debt: Debt, callback: (() -> Unit)? = null) {
        executor.execute {
            debtDao.update(debt)
            callback?.invoke()
        }
    }

    fun delete(debt: Debt, callback: (() -> Unit)? = null) {
        executor.execute {
            debtDao.delete(debt)
            callback?.invoke()
        }
    }
}
