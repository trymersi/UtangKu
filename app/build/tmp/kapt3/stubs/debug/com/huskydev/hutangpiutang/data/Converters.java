package com.huskydev.hutangpiutang.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0007J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/huskydev/hutangpiutang/data/Converters;", "", "()V", "fromDebtStatus", "", "value", "Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;", "fromDebtType", "Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "toDebtStatus", "toDebtType", "app_debug"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String fromDebtType(@org.jetbrains.annotations.Nullable()
    com.huskydev.hutangpiutang.data.entity.DebtType value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final com.huskydev.hutangpiutang.data.entity.DebtType toDebtType(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String fromDebtStatus(@org.jetbrains.annotations.Nullable()
    com.huskydev.hutangpiutang.data.entity.DebtStatus value) {
        return null;
    }
    
    @androidx.room.TypeConverter()
    @org.jetbrains.annotations.Nullable()
    public final com.huskydev.hutangpiutang.data.entity.DebtStatus toDebtStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
        return null;
    }
}