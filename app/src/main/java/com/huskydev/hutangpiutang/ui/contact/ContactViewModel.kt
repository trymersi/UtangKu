package com.huskydev.hutangpiutang.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.huskydev.hutangpiutang.data.entity.Contact
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.data.repository.ContactRepository
import com.huskydev.hutangpiutang.data.repository.DebtRepository
import java.util.concurrent.ExecutorService

class ContactViewModel(
    private val contactRepository: ContactRepository,
    private val debtRepository: DebtRepository,
    private val executor: ExecutorService
) : ViewModel() {

    val allContacts: LiveData<List<Contact>> = contactRepository.getAll()

    private val _contactWithNetBalance = MutableLiveData<List<ContactWithNetBalance>>()
    val contactWithNetBalance: LiveData<List<ContactWithNetBalance>> = _contactWithNetBalance

    private val _contactDetails = MutableLiveData<Contact?>()
    val contactDetails: LiveData<Contact?> = _contactDetails

    private val _contactNetBalance = MutableLiveData<Long>()
    val contactNetBalance: LiveData<Long> = _contactNetBalance
    
    private val _contactNetType = MutableLiveData<DebtType?>()
    val contactNetType: LiveData<DebtType?> = _contactNetType

    private val _deleteResult = MutableLiveData<Boolean>()
    val deleteResult: LiveData<Boolean> = _deleteResult

    fun getDebtsByContact(contactId: Long): LiveData<List<Debt>> {
        return debtRepository.getByContactId(contactId)
    }

    /**
     * Load all contacts and calculate their net balances.
     * We don't use MediatorLiveData because doing DB queries for each contact on UI thread is bad.
     */
    fun loadContactsWithBalances() {
        executor.execute {
            val contacts = contactRepository.getAllSync()
            val resultList = mutableListOf<ContactWithNetBalance>()

            for (contact in contacts) {
                val debts = debtRepository.getByContactIdSync(contact.id)
                var net = 0L

                for (debt in debts) {
                    if (debt.status == DebtStatus.LUNAS) continue
                    if (debt.type == DebtType.PIUTANG) {
                        net += debt.remainingAmount
                    } else {
                        net -= debt.remainingAmount
                    }
                }

                val type = when {
                    net > 0 -> DebtType.PIUTANG
                    net < 0 -> DebtType.HUTANG
                    else -> null // Balance 0 (semua lunas)
                }

                resultList.add(ContactWithNetBalance(contact, Math.abs(net), type))
            }

            // Sort: PIUTANG (desc) -> HUTANG (desc) -> name
            resultList.sortWith(compareByDescending<ContactWithNetBalance> { it.type == DebtType.PIUTANG }
                .thenByDescending { it.type == DebtType.HUTANG }
                .thenByDescending { it.netBalance }
                .thenBy { it.contact.name.lowercase() })

            _contactWithNetBalance.postValue(resultList)
        }
    }

    fun loadContactDetails(contactId: Long) {
        executor.execute {
            val contact = contactRepository.getById(contactId)
            _contactDetails.postValue(contact)

            if (contact != null) {
                val debts = debtRepository.getByContactIdSync(contactId)
                var net = 0L

                for (debt in debts) {
                    if (debt.status == DebtStatus.LUNAS) continue
                    if (debt.type == DebtType.PIUTANG) {
                        net += debt.remainingAmount
                    } else {
                        net -= debt.remainingAmount
                    }
                }

                _contactNetBalance.postValue(Math.abs(net))
                _contactNetType.postValue(when {
                    net > 0 -> DebtType.PIUTANG
                    net < 0 -> DebtType.HUTANG
                    else -> null
                })
            }
        }
    }

    fun deleteContact(contact: Contact) {
        executor.execute {
            // Delete will cascade to debts and payments due to foreign keys,
            // but we MUST CANCEL ALARMS manually first.
            val debts = debtRepository.getByContactIdSync(contact.id)
            val activeDebtIds = debts.filter { it.status != DebtStatus.LUNAS }.map { it.id }

            contactRepository.delete(contact) {
                _deleteResult.postValue(true)
                // Returning list of IDs so UI can cancel their alarms
                _deletedDebtIds.postValue(activeDebtIds)
            }
        }
    }

    private val _deletedDebtIds = MutableLiveData<List<Long>>()
    val deletedDebtIds: LiveData<List<Long>> = _deletedDebtIds

    data class ContactWithNetBalance(
        val contact: Contact,
        val netBalance: Long,
        val type: DebtType?
    )
}
