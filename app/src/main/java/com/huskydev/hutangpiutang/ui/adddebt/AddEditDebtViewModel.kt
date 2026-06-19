package com.huskydev.hutangpiutang.ui.adddebt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huskydev.hutangpiutang.data.entity.Contact
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.data.repository.ContactRepository
import com.huskydev.hutangpiutang.data.repository.DebtRepository
import com.huskydev.hutangpiutang.util.AvatarColors
import java.util.concurrent.ExecutorService

class AddEditDebtViewModel(
    private val contactRepository: ContactRepository,
    private val debtRepository: DebtRepository,
    private val executor: ExecutorService
) : ViewModel() {

    private val _existingDebt = MutableLiveData<Debt?>()
    val existingDebt: LiveData<Debt?> = _existingDebt

    private val _existingContact = MutableLiveData<Contact?>()
    val existingContact: LiveData<Contact?> = _existingContact

    private val _saveResult = MutableLiveData<SaveResult>()
    val saveResult: LiveData<SaveResult> = _saveResult

    val contacts: LiveData<List<Contact>> = contactRepository.getAll()

    /** Load existing debt + contact for edit mode */
    fun loadDebt(debtId: Long) {
        executor.execute {
            val debt = debtRepository.getById(debtId)
            _existingDebt.postValue(debt)
            if (debt != null) {
                val contact = contactRepository.getById(debt.contactId)
                _existingContact.postValue(contact)
            }
        }
    }

    /**
     * Save debt — handles both add and edit modes.
     * Reminder cancel/reschedule is done in Activity after SaveResult,
     * because it needs Context for AlarmManager.
     */
    fun save(
        contactName: String,
        contactPhone: String?,
        type: DebtType,
        amount: Long,
        description: String?,
        dateCreated: Long,
        dueDate: Long?,
        reminderEnabled: Boolean,
        reminderDatetime: Long?,
        editDebtId: Long?
    ) {
        executor.execute {
            try {
                val now = System.currentTimeMillis()

                // Find or create contact
                val contactId: Long
                val existing = contactRepository.findByName(contactName)
                if (existing != null) {
                    contactId = existing.id
                    // Update phone if provided and different
                    if (!contactPhone.isNullOrBlank() && contactPhone != existing.phone) {
                        contactRepository.updateSync(existing.copy(phone = contactPhone))
                    }
                } else {
                    val newContact = Contact(
                        name = contactName,
                        phone = if (contactPhone.isNullOrBlank()) null else contactPhone,
                        avatarColor = AvatarColors.getColorForName(contactName),
                        createdAt = now
                    )
                    contactId = contactRepository.insertSync(newContact)
                }

                val savedDebtId: Long
                val savedDebt: Debt

                if (editDebtId != null) {
                    // Edit mode
                    val existingDebt = debtRepository.getById(editDebtId)
                    if (existingDebt == null) {
                        _saveResult.postValue(SaveResult.Error("Catatan tidak ditemukan"))
                        return@execute
                    }
                    savedDebt = existingDebt.copy(
                        contactId = contactId,
                        type = type,
                        originalAmount = amount,
                        // If amount changed and was previously not partially paid, reset remaining
                        remainingAmount = if (existingDebt.originalAmount != amount && existingDebt.status == DebtStatus.BELUM_LUNAS)
                            amount else existingDebt.remainingAmount,
                        description = description,
                        dateCreated = dateCreated,
                        dueDate = dueDate,
                        reminderEnabled = reminderEnabled,
                        reminderDatetime = reminderDatetime,
                        updatedAt = now
                    )
                    debtRepository.update(savedDebt)
                    savedDebtId = editDebtId
                } else {
                    // Add mode
                    savedDebt = Debt(
                        contactId = contactId,
                        type = type,
                        originalAmount = amount,
                        remainingAmount = amount,
                        description = description,
                        dateCreated = dateCreated,
                        dueDate = dueDate,
                        status = DebtStatus.BELUM_LUNAS,
                        reminderEnabled = reminderEnabled,
                        reminderDatetime = reminderDatetime,
                        createdAt = now,
                        updatedAt = now
                    )
                    savedDebtId = debtRepository.insertSync(savedDebt)
                }

                _saveResult.postValue(SaveResult.Success(savedDebtId, savedDebt.copy(id = savedDebtId)))
            } catch (e: Exception) {
                _saveResult.postValue(SaveResult.Error(e.message ?: "Gagal menyimpan"))
            }
        }
    }

    sealed class SaveResult {
        data class Success(val debtId: Long, val debt: Debt) : SaveResult()
        data class Error(val message: String) : SaveResult()
    }
}
