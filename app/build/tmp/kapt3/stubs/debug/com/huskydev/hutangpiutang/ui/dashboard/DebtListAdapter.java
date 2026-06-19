package com.huskydev.hutangpiutang.ui.dashboard;

/**
 * Adapter untuk daftar debt di Dashboard.
 * Butuh Map<Long, Contact> untuk resolve nama kontak dari contactId.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0017\u0018B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0014\u0010\u0014\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/dashboard/DebtListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "Lcom/huskydev/hutangpiutang/ui/dashboard/DebtListAdapter$DebtViewHolder;", "onClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "contactMap", "", "", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setContacts", "contacts", "", "Companion", "DebtViewHolder", "app_debug"})
public final class DebtListAdapter extends androidx.recyclerview.widget.ListAdapter<com.huskydev.hutangpiutang.data.entity.Debt, com.huskydev.hutangpiutang.ui.dashboard.DebtListAdapter.DebtViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.huskydev.hutangpiutang.data.entity.Debt, kotlin.Unit> onClick = null;
    
    /**
     * Map contactId → Contact, di-update dari luar via setContacts()
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.Long, com.huskydev.hutangpiutang.data.entity.Contact> contactMap;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.huskydev.hutangpiutang.data.entity.Debt> DIFF_CALLBACK = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.huskydev.hutangpiutang.ui.dashboard.DebtListAdapter.Companion Companion = null;
    
    public DebtListAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.huskydev.hutangpiutang.data.entity.Debt, kotlin.Unit> onClick) {
        super(null);
    }
    
    public final void setContacts(@org.jetbrains.annotations.NotNull()
    java.util.List<com.huskydev.hutangpiutang.data.entity.Contact> contacts) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.huskydev.hutangpiutang.ui.dashboard.DebtListAdapter.DebtViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.ui.dashboard.DebtListAdapter.DebtViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/dashboard/DebtListAdapter$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u0017R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/dashboard/DebtListAdapter$DebtViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarCircle", "progressBar", "Lcom/google/android/material/progressindicator/LinearProgressIndicator;", "tvAmount", "Landroid/widget/TextView;", "tvAvatarInitial", "tvContactName", "tvDescription", "tvDueDate", "tvStatus", "tvType", "bind", "", "debt", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "contact", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "onClick", "Lkotlin/Function1;", "app_debug"})
    public static final class DebtViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View avatarCircle = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvAvatarInitial = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvContactName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvType = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvAmount = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDescription = null;
        @org.jetbrains.annotations.NotNull()
        private final com.google.android.material.progressindicator.LinearProgressIndicator progressBar = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDueDate = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvStatus = null;
        
        public DebtViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.huskydev.hutangpiutang.data.entity.Debt debt, @org.jetbrains.annotations.Nullable()
        com.huskydev.hutangpiutang.data.entity.Contact contact, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.huskydev.hutangpiutang.data.entity.Debt, kotlin.Unit> onClick) {
        }
    }
}