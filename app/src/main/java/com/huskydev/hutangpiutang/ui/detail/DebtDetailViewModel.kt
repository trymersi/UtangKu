package com.huskydev.hutangpiutang.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huskydev.hutangpiutang.data.entity.Contact
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.Payment
import com.huskydev.hutangpiutang.data.repository.ContactRepository
import com.huskydev.hutangpiutang.data.repository.DebtRepository
import com.huskydev.hutangpiutang.data.repository.PaymentRepository
import java.util.concurrent.ExecutorService

class DebtDetailViewModel(
    private val debtRepository: DebtRepository,
    private val contactRepository: ContactRepository,
    private val paymentRepository: PaymentRepository,
    private val executor: ExecutorService
) : ViewModel() {

    private var debtId: Long = -1

    private val _contact = MutableLiveData<Contact?>()
    val contact: LiveData<Contact?> = _contact

    private val _actionResult = MutableLiveData<ActionResult>()
    val actionResult: LiveData<ActionResult> = _actionResult

    fun getDebtLive(debtId: Long): LiveData<Debt?> {
        this.debtId = debtId
        return debtRepository.getByIdLive(debtId)
    }

    fun getPayments(debtId: Long): LiveData<List<Payment>> {
        return paymentRepository.getByDebtId(debtId)
    }

    fun loadContact(contactId: Long) {
        executor.execute {
            val c = contactRepository.getById(contactId)
            _contact.postValue(c)
        }
    }

    /**
     * Catat pembayaran sebagian.
     * Update remainingAmount & status. Jika remaining jadi 0 → LUNAS.
     */
    fun addPayment(debtId: Long, amount: Long, paymentDate: Long, note: String?) {
        executor.execute {
            val debt = debtRepository.getById(debtId) ?: return@execute
            val newRemaining = (debt.remainingAmount - amount).coerceAtLeast(0)
            val now = System.currentTimeMillis()

            // Insert payment record
            val payment = Payment(
                debtId = debtId,
                amount = amount,
                paymentDate = paymentDate,
                note = note
            )
            paymentRepository.insertSync(payment)

            // Determine new status
            val newStatus = when {
                newRemaining <= 0 -> DebtStatus.LUNAS
                newRemaining < debt.originalAmount -> DebtStatus.SEBAGIAN
                else -> DebtStatus.BELUM_LUNAS
            }

            // Update debt
            val updatedDebt = debt.copy(
                remainingAmount = newRemaining,
                status = newStatus,
                updatedAt = now
            )
            debtRepository.update(updatedDebt)

            _actionResult.postValue(
                if (newStatus == DebtStatus.LUNAS) ActionResult.MarkedPaid(debtId)
                else ActionResult.PaymentAdded
            )
        }
    }

    /**
     * Tandai lunas sepenuhnya.
     * Insert Payment record sebesar remainingAmount ("Pelunasan otomatis").
     */
    fun markAsPaid(debtId: Long) {
        executor.execute {
            val debt = debtRepository.getById(debtId) ?: return@execute
            if (debt.status == DebtStatus.LUNAS) return@execute

            val now = System.currentTimeMillis()

            // Insert payment for remaining (menjaga invariant sum == original)
            val payment = Payment(
                debtId = debtId,
                amount = debt.remainingAmount,
                paymentDate = now,
                note = "Pelunasan otomatis"
            )
            paymentRepository.insertSync(payment)

            // Update debt
            val updatedDebt = debt.copy(
                remainingAmount = 0,
                status = DebtStatus.LUNAS,
                updatedAt = now
            )
            debtRepository.update(updatedDebt)

            _actionResult.postValue(ActionResult.MarkedPaid(debtId))
        }
    }

    fun deleteDebt(debt: Debt) {
        executor.execute {
            debtRepository.delete(debt)
            _actionResult.postValue(ActionResult.Deleted)
        }
    }

    sealed class ActionResult {
        data object PaymentAdded : ActionResult()
        data class MarkedPaid(val debtId: Long) : ActionResult()
        data object Deleted : ActionResult()
    }
}
