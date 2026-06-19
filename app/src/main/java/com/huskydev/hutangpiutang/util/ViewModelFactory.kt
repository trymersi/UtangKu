package com.huskydev.hutangpiutang.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Generic ViewModelFactory untuk constructor injection manual (tanpa Hilt/Dagger).
 *
 * Contoh pakai:
 * ```
 * val vm = ViewModelProvider(this, ViewModelFactory {
 *     DashboardViewModel(debtRepo, contactRepo)
 * })[DashboardViewModel::class.java]
 * ```
 */
class ViewModelFactory<T : ViewModel>(
    private val creator: () -> T
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <V : ViewModel> create(modelClass: Class<V>): V {
        return creator() as V
    }
}
