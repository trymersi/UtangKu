package com.huskydev.hutangpiutang.data

import androidx.room.TypeConverter
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType

class Converters {
    @TypeConverter
    fun fromDebtType(value: DebtType?): String? = value?.name

    @TypeConverter
    fun toDebtType(value: String?): DebtType? = value?.let { DebtType.valueOf(it) }

    @TypeConverter
    fun fromDebtStatus(value: DebtStatus?): String? = value?.name

    @TypeConverter
    fun toDebtStatus(value: String?): DebtStatus? = value?.let { DebtStatus.valueOf(it) }
}
