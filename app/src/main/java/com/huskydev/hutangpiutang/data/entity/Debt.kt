package com.huskydev.hutangpiutang.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "debts",
    foreignKeys = [
        ForeignKey(
            entity = Contact::class,
            parentColumns = ["id"],
            childColumns = ["contactId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("contactId"),
        Index("status"),
        Index("dueDate")
    ]
)
data class Debt(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val contactId: Long,
    val type: DebtType,
    val originalAmount: Long,
    val remainingAmount: Long,
    val description: String? = null,
    val dateCreated: Long,
    val dueDate: Long? = null,
    val status: DebtStatus,
    val reminderEnabled: Boolean = false,
    val reminderDatetime: Long? = null,
    val createdAt: Long,
    val updatedAt: Long
)
