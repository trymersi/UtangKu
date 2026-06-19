package com.huskydev.hutangpiutang.data.entity

/**
 * Status catatan hutang/piutang.
 * - BELUM_LUNAS: remaining == original (belum ada pembayaran)
 * - SEBAGIAN: 0 < remaining < original (ada pembayaran sebagian)
 * - LUNAS: remaining <= 0 (sudah lunas, clamp ke 0)
 */
enum class DebtStatus {
    BELUM_LUNAS,
    SEBAGIAN,
    LUNAS
}
