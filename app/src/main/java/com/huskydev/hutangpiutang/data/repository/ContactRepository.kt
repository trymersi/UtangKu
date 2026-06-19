package com.huskydev.hutangpiutang.data.repository

import androidx.lifecycle.LiveData
import com.huskydev.hutangpiutang.data.dao.ContactDao
import com.huskydev.hutangpiutang.data.entity.Contact
import java.util.concurrent.ExecutorService

class ContactRepository(
    private val contactDao: ContactDao,
    private val executor: ExecutorService
) {
    fun getAll(): LiveData<List<Contact>> = contactDao.getAll()


    fun getById(id: Long): Contact? = contactDao.getById(id)

    fun getByIdLive(id: Long): LiveData<Contact?> = contactDao.getByIdLive(id)

    /** Blocking read by id — call ONLY from executor thread */
    fun getByIdSync(id: Long): Contact? = contactDao.getById(id)

    /** Blocking read all — call ONLY from executor thread */
    fun getAllSync(): List<Contact> = contactDao.getAllSync()

    fun searchByName(query: String): LiveData<List<Contact>> = contactDao.searchByName(query)

    fun findByName(name: String): Contact? = contactDao.findByName(name)

    fun insert(contact: Contact, callback: ((Long) -> Unit)? = null) {
        executor.execute {
            val id = contactDao.insert(contact)
            callback?.invoke(id)
        }
    }

    /** Blocking insert — call ONLY from executor thread */
    fun insertSync(contact: Contact): Long = contactDao.insert(contact)

    fun update(contact: Contact, callback: (() -> Unit)? = null) {
        executor.execute {
            contactDao.update(contact)
            callback?.invoke()
        }
    }

    /** Blocking update — call ONLY from executor thread */
    fun updateSync(contact: Contact) = contactDao.update(contact)

    fun delete(contact: Contact, callback: (() -> Unit)? = null) {
        executor.execute {
            contactDao.delete(contact)
            callback?.invoke()
        }
    }
}
