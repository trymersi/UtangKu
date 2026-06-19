package com.huskydev.hutangpiutang.util

/**
 * Array tetap berisi warna Material untuk avatar kontak.
 * Index dipilih deterministik: Math.abs(name.hashCode()) % size
 * Supaya kontak dengan nama sama selalu dapat warna sama.
 */
object AvatarColors {
    val COLORS = intArrayOf(
        0xFFE57373.toInt(), // Red 300
        0xFF64B5F6.toInt(), // Blue 300
        0xFF81C784.toInt(), // Green 300
        0xFFFFB74D.toInt(), // Orange 300
        0xFFBA68C8.toInt(), // Purple 300
        0xFF4DB6AC.toInt(), // Teal 300
        0xFFF06292.toInt(), // Pink 300
        0xFFA1887F.toInt(), // Brown 300
        0xFF7986CB.toInt(), // Indigo 300
        0xFFAED581.toInt()  // Light Green 300
    )

    /**
     * Dapatkan warna avatar deterministik berdasarkan nama kontak.
     */
    fun getColorForName(name: String): Int {
        val index = Math.abs(name.hashCode()) % COLORS.size
        return COLORS[index]
    }
}
