package com.huskydev.hutangpiutang.ui.contact;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001.B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u000bJ\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00110\u00172\u0006\u0010+\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\'2\u0006\u0010+\u001a\u00020\rJ\u0006\u0010-\u001a\u00020\'R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00110\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00110\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/contact/ContactViewModel;", "Landroidx/lifecycle/ViewModel;", "contactRepository", "Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;", "debtRepository", "Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;", "executor", "Ljava/util/concurrent/ExecutorService;", "(Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;Lcom/huskydev/hutangpiutang/data/repository/DebtRepository;Ljava/util/concurrent/ExecutorService;)V", "_contactDetails", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "_contactNetBalance", "", "_contactNetType", "Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "_contactWithNetBalance", "", "Lcom/huskydev/hutangpiutang/ui/contact/ContactViewModel$ContactWithNetBalance;", "_deleteResult", "", "_deletedDebtIds", "allContacts", "Landroidx/lifecycle/LiveData;", "getAllContacts", "()Landroidx/lifecycle/LiveData;", "contactDetails", "getContactDetails", "contactNetBalance", "getContactNetBalance", "contactNetType", "getContactNetType", "contactWithNetBalance", "getContactWithNetBalance", "deleteResult", "getDeleteResult", "deletedDebtIds", "getDeletedDebtIds", "deleteContact", "", "contact", "getDebtsByContact", "Lcom/huskydev/hutangpiutang/data/entity/Debt;", "contactId", "loadContactDetails", "loadContactsWithBalances", "ContactWithNetBalance", "app_debug"})
public final class ContactViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.ContactRepository contactRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService executor = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> allContacts = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.huskydev.hutangpiutang.ui.contact.ContactViewModel.ContactWithNetBalance>> _contactWithNetBalance = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.ui.contact.ContactViewModel.ContactWithNetBalance>> contactWithNetBalance = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.data.entity.Contact> _contactDetails = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> contactDetails = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _contactNetBalance = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> contactNetBalance = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.huskydev.hutangpiutang.data.entity.DebtType> _contactNetType = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.DebtType> contactNetType = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _deleteResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> deleteResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.Long>> _deletedDebtIds = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.Long>> deletedDebtIds = null;
    
    public ContactViewModel(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.ContactRepository contactRepository, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.repository.DebtRepository debtRepository, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.ExecutorService executor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> getAllContacts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.ui.contact.ContactViewModel.ContactWithNetBalance>> getContactWithNetBalance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> getContactDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getContactNetBalance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.DebtType> getContactNetType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getDeleteResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Debt>> getDebtsByContact(long contactId) {
        return null;
    }
    
    /**
     * Load all contacts and calculate their net balances.
     * We don't use MediatorLiveData because doing DB queries for each contact on UI thread is bad.
     */
    public final void loadContactsWithBalances() {
    }
    
    public final void loadContactDetails(long contactId) {
    }
    
    public final void deleteContact(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.Long>> getDeletedDebtIds() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/huskydev/hutangpiutang/ui/contact/ContactViewModel$ContactWithNetBalance;", "", "contact", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "netBalance", "", "type", "Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "(Lcom/huskydev/hutangpiutang/data/entity/Contact;JLcom/huskydev/hutangpiutang/data/entity/DebtType;)V", "getContact", "()Lcom/huskydev/hutangpiutang/data/entity/Contact;", "getNetBalance", "()J", "getType", "()Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ContactWithNetBalance {
        @org.jetbrains.annotations.NotNull()
        private final com.huskydev.hutangpiutang.data.entity.Contact contact = null;
        private final long netBalance = 0L;
        @org.jetbrains.annotations.Nullable()
        private final com.huskydev.hutangpiutang.data.entity.DebtType type = null;
        
        public ContactWithNetBalance(@org.jetbrains.annotations.NotNull()
        com.huskydev.hutangpiutang.data.entity.Contact contact, long netBalance, @org.jetbrains.annotations.Nullable()
        com.huskydev.hutangpiutang.data.entity.DebtType type) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.huskydev.hutangpiutang.data.entity.Contact getContact() {
            return null;
        }
        
        public final long getNetBalance() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.huskydev.hutangpiutang.data.entity.DebtType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.huskydev.hutangpiutang.data.entity.Contact component1() {
            return null;
        }
        
        public final long component2() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.huskydev.hutangpiutang.data.entity.DebtType component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.huskydev.hutangpiutang.ui.contact.ContactViewModel.ContactWithNetBalance copy(@org.jetbrains.annotations.NotNull()
        com.huskydev.hutangpiutang.data.entity.Contact contact, long netBalance, @org.jetbrains.annotations.Nullable()
        com.huskydev.hutangpiutang.data.entity.DebtType type) {
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