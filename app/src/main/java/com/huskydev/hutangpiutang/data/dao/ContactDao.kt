package com.huskydev.hutangpiutang.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.huskydev.hutangpiutang.data.entity.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun getAll(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun getAllSync(): List<Contact>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getById(id: Long): Contact?

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getByIdSync(id: Long): Contact?

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getByIdLive(id: Long): LiveData<Contact?>

    @Query("SELECT * FROM contacts WHERE name LIKE '%' || :query || '%' ORDER BY name ASC")
    fun searchByName(query: String): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts WHERE name = :name LIMIT 1")
    fun findByName(name: String): Contact?

    @Insert
    fun insert(contact: Contact): Long

    @Update
    fun update(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}
