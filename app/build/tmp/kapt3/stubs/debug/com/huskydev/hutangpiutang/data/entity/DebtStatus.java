package com.huskydev.hutangpiutang.data.entity;

/**
 * Status catatan hutang/piutang.
 * - BELUM_LUNAS: remaining == original (belum ada pembayaran)
 * - SEBAGIAN: 0 < remaining < original (ada pembayaran sebagian)
 * - LUNAS: remaining <= 0 (sudah lunas, clamp ke 0)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;", "", "(Ljava/lang/String;I)V", "BELUM_LUNAS", "SEBAGIAN", "LUNAS", "app_debug"})
public enum DebtStatus {
    /*public static final*/ BELUM_LUNAS /* = new BELUM_LUNAS() */,
    /*public static final*/ SEBAGIAN /* = new SEBAGIAN() */,
    /*public static final*/ LUNAS /* = new LUNAS() */;
    
    DebtStatus() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.huskydev.hutangpiutang.data.entity.DebtStatus> getEntries() {
        return null;
    }
}