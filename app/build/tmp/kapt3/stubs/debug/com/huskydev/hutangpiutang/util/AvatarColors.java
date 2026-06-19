package com.huskydev.hutangpiutang.util;

/**
 * Array tetap berisi warna Material untuk avatar kontak.
 * Index dipilih deterministik: Math.abs(name.hashCode()) % size
 * Supaya kontak dengan nama sama selalu dapat warna sama.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/huskydev/hutangpiutang/util/AvatarColors;", "", "()V", "COLORS", "", "getCOLORS", "()[I", "getColorForName", "", "name", "", "app_debug"})
public final class AvatarColors {
    @org.jetbrains.annotations.NotNull()
    private static final int[] COLORS = {-1739917, -10177034, -8271996, -18611, -4560696, -11684180, -1023342, -6190977, -8812853, -5319295};
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.util.AvatarColors INSTANCE = null;
    
    private AvatarColors() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getCOLORS() {
        return null;
    }
    
    /**
     * Dapatkan warna avatar deterministik berdasarkan nama kontak.
     */
    public final int getColorForName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return 0;
    }
}