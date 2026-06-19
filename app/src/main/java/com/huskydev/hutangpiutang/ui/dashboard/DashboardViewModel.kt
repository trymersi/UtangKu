package com.huskydev.hutangpiutang.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.ViewModel
import com.huskydev.hutangpiutang.data.entity.Debt
import com.huskydev.hutangpiutang.data.entity.DebtStatus
import com.huskydev.hutangpiutang.data.entity.DebtType
import com.huskydev.hutangpiutang.data.repository.DebtRepository

class DashboardViewModel(
    private val debtRepository: DebtRepository
) : ViewModel() {

    /** Filter chip state — null means "Semua" (no filter) */
    val filterStatus = MutableLiveData<DebtStatus?>(null)

    /** Search query dari SearchView */
    val searchQuery = MutableLiveData("")

    /**
     * MediatorLiveData menggabungkan dua sinyal independen (filter chip + search box)
     * jadi satu trigger. Setiap kali salah satu berubah, trigger update.
     */
    private val filterTrigger = MediatorLiveData<Pair<DebtStatus?, String>>().apply {
        addSource(filterStatus) { value = it to (searchQuery.value ?: "") }
        addSource(searchQuery) { value = (filterStatus.value) to it }
    }

    /**
     * List debt yang ditampilkan — hasil gabungan filter+search jadi satu query.
     * switchMap memastikan LiveData Room yang lama di-unsubscribe saat query baru dibuat.
     */
    val displayedDebts: LiveData<List<Debt>> = filterTrigger.switchMap { pair ->
        val status = pair?.first
        val query = pair?.second ?: ""
        // Untuk filter "Hutang" dan "Piutang" yang bukan DebtStatus,
        // kita filter by type di sini, bukan by status
        debtRepository.getFilteredDebts(status, query)
    }

    /** Total piutang aktif (belum lunas) */
    val totalPiutang: LiveData<Long?> = debtRepository.getTotalByType(DebtType.PIUTANG)

    /** Total hutang aktif (belum lunas) */
    val totalHutang: LiveData<Long?> = debtRepository.getTotalByType(DebtType.HUTANG)

    fun setFilter(status: DebtStatus?) {
        filterStatus.value = status
    }

    fun setSearchQuery(query: String) {
        searchQuery.value = query
    }
}
