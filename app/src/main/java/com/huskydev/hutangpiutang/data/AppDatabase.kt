package com.huskydev.hutangpiutang.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.huskydev.hutangpiutang.data.dao.ContactDao
import com.huskydev.hutangpiutang.data.dao.DebtDao
import com.huskydev.hutangpiutang.data.dao.PaymentDao
import com.huskydev.hutangpiutang.data.entity.Contact
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.Payment

@Database(
    entities = [Contact::class, Debt::class, Payment::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao
    abstract fun debtDao(): DebtDao
    abstract fun paymentDao(): PaymentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "utangku.db"
                )
                    // MVP: destructive migration acceptable karena belum ada user nyata.
                    // WAJIB ganti ke Migration object resmi begitu app sudah live di Play Store.
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
