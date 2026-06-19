package com.huskydev.hutangpiutang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val phone: String? = null,
    val note: String? = null,
    val avatarColor: Int,
    val createdAt: Long
)
