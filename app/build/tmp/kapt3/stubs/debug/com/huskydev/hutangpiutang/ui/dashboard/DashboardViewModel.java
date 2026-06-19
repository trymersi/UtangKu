package com.huskydev.hutangpiutang.ui.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00130\u00130\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\nR\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\n\u00a8\u0006!"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "debtRepository", "Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;", "(Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;)V", "displayedDebts", "Landroidx/lifecycle/LiveData;", "", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "getDisplayedDebts", "()Landroidx/lifecycle/LiveData;", "filterStatus", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;", "getFilterStatus", "()Landroidx/lifecycle/MutableLiveData;", "filterTrigger", "Landroidx/lifecycle/MediatorLiveData;", "Lkotlin/Pair;", "", "searchQuery", "kotlin.jvm.PlatformType", "getSearchQuery", "totalHutang", "", "getTotalHutang", "totalPiutang", "getTotalPiutang", "setFilter", "", "status", "setSearchQuery", "query", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository = null;
    
    /**
     * Filter chip state — null means "Semua" (no filter)
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.data.entity.DebtStatus> filterStatus = null;
    
    /**
     * Search query dari SearchView
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> searchQuery = null;
    
    /**
     * MediatorLiveData menggabungkan dua sinyal independen (filter chip + search box)
     * jadi satu trigger. Setiap kali salah satu berubah, trigger update.
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<kotlin.Pair<com.huskydev.hutangpiutang.data.entity.DebtStatus, java.lang.String>> filterTrigger = null;
    
    /**
     * List debt yang ditampilkan — hasil gabungan filter+search jadi satu query.
     * switchMap memastikan LiveData Room yang lama di-unsubscribe saat query baru dibuat.
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> displayedDebts = null;
    
    /**
     * Total piutang aktif (belum lunas)
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> totalPiutang = null;
    
    /**
     * Total hutang aktif (belum lunas)
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> totalHutang = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository) {
        super();
    }
    
    /**
     * Filter chip state — null means "Semua" (no filter)
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.data.entity.DebtStatus> getFilterStatus() {
        return null;
    }
    
    /**
     * Search query dari SearchView
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getSearchQuery() {
        return null;
    }
    
    /**
     * List debt yang ditampilkan — hasil gabungan filter+search jadi satu query.
     * switchMap memastikan LiveData Room yang lama di-unsubscribe saat query baru dibuat.
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getDisplayedDebts() {
        return null;
    }
    
    /**
     * Total piutang aktif (belum lunas)
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getTotalPiutang() {
        return null;
    }
    
    /**
     * Total hutang aktif (belum lunas)
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getTotalHutang() {
        return null;
    }
    
    public final void setFilter(@org.jetbrains.annotations.Nullable()
    com.huskydev.hutangpiutang.data.entity.DebtStatus status) {
    }
    
    public final void setSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
}