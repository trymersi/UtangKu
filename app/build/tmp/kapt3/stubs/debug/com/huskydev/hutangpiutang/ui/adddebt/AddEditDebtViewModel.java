package com.huskydev.hutangpiutang.ui.adddebt;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001.B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJe\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010\'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010\u001e2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0002\u0010-R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014\u00a8\u0006/"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel;", "Landroidx/lifecycle/ViewModel;", "contactRepository", "Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;", "debtRepository", "Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;", "executor", "Ljava/util/concurrent/ExecutorService;", "(Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;Ljava/util/concurrent/ExecutorService;)V", "_existingContact", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "_existingDebt", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "_saveResult", "Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult;", "contacts", "Landroidx/lifecycle/LiveData;", "", "getContacts", "()Landroidx/lifecycle/LiveData;", "existingContact", "getExistingContact", "existingDebt", "getExistingDebt", "saveResult", "getSaveResult", "loadDebt", "", "debtId", "", "save", "contactName", "", "contactPhone", "type", "Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "amount", "description", "dateCreated", "dueDate", "reminderEnabled", "", "reminderDatetime", "editDebtId", "(Ljava/lang/String;Ljava/lang/String;Lcom/huskydev/hutangpiutang/data/entity/DebtType;JLjava/lang/String;JLjava/lang/Long;ZLjava/lang/Long;Ljava/lang/Long;)V", "SaveResult", "app_debug"})
public final class AddEditDebtViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.ContactRepository contactRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService executor = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.data.entity.Debt> _existingDebt = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Debt> existingDebt = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.data.entity.Contact> _existingContact = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> existingContact = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel.SaveResult> _saveResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel.SaveResult> saveResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> contacts = null;
    
    public AddEditDebtViewModel(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.ContactRepository contactRepository, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.ExecutorService executor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Debt> getExistingDebt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> getExistingContact() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel.SaveResult> getSaveResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> getContacts() {
        return null;
    }
    
    /**
     * Load existing debt + contact for edit mode
     */
    public final void loadDebt(long debtId) {
    }
    
    /**
     * Save debt — handles both add and edit modes.
     * Reminder cancel/reschedule is done in Activity after SaveResult,
     * because it needs Context for AlarmManager.
     */
    public final void save(@org.jetbrains.annotations.NotNull()
    java.lang.String contactName, @org.jetbrains.annotations.Nullable()
    java.lang.String contactPhone, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtType type, long amount, @org.jetbrains.annotations.Nullable()
    java.lang.String description, long dateCreated, @org.jetbrains.annotations.Nullable()
    java.lang.Long dueDate, boolean reminderEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.Long reminderDatetime, @org.jetbrains.annotations.Nullable()
    java.lang.Long editDebtId) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult;", "", "()V", "Error", "Success", "Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult$Error;", "Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult$Success;", "app_debug"})
    public static abstract class SaveResult {
        
        private SaveResult() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult$Error;", "Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel.SaveResult {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel.SaveResult.Error copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult$Success;", "Lcom/huskydev/hutangpiutang/ui/adddebt/AddEditDebtViewModel$SaveResult;", "debtId", "", "debt", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "(JLcom/huskydev/hutangpiutang/data/entity/Debt;)V", "getDebt", "()Lcom/huskydev/hutangpiutang/data/entity/Debt;", "getDebtId", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel.SaveResult {
            private final long debtId = 0L;
            @org.jetbrains.annotations.NotNull()
            private final com.huskydev.hutangpiutang.data.entity.Debt debt = null;
            
            public Success(long debtId, @org.jetbrains.annotations.NotNull()
            com.huskydev.hutangpiutang.data.entity.Debt debt) {
            }
            
            public final long getDebtId() {
                return 0L;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.huskydev.hutangpiutang.data.entity.Debt getDebt() {
                return null;
            }
            
            public final long component1() {
                return 0L;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.huskydev.hutangpiutang.data.entity.Debt component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.huskydev.hutangpiutang.ui.adddebt.AddEditDebtViewModel.SaveResult.Success copy(long debtId, @org.jetbrains.annotations.NotNull()
            com.huskydev.hutangpiutang.data.entity.Debt debt) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
    }
}