package com.huskydev.hutangpiutang.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u0011J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0012J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00120\u00112\u0006\u0010\u001d\u001a\u00020\u000fJ \u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\fJ\u000e\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/huskydev/hutangpiutang/data/repository/ContactRepository;", "", "contactDao", "Lcom/huskydev/hutangpiutang/data/dao/ContactDao;", "executor", "Ljava/util/concurrent/ExecutorService;", "(Lcom/huskydev/hutangpiutang/data/dao/ContactDao;Ljava/util/concurrent/ExecutorService;)V", "delete", "", "contact", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "callback", "Lkotlin/Function0;", "findByName", "name", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "getAllSync", "getById", "id", "", "getByIdLive", "getByIdSync", "insert", "Lkotlin/Function1;", "insertSync", "searchByName", "query", "update", "updateSync", "app_debug"})
public final class ContactRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.dao.ContactDao contactDao = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.ExecutorService executor = null;
    
    public ContactRepository(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.dao.ContactDao contactDao, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.ExecutorService executor) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.huskydev.hutangpiutang.data.entity.Contact getById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> getByIdLive(long id) {
        return null;
    }
    
    /**
     * Blocking read by id — call ONLY from executor thread
     */
    @org.jetbrains.annotations.Nullable()
    public final com.huskydev.hutangpiutang.data.entity.Contact getByIdSync(long id) {
        return null;
    }
    
    /**
     * Blocking read all — call ONLY from executor thread
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.huskydev.hutangpiutang.data.entity.Contact> getAllSync() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> searchByName(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.huskydev.hutangpiutang.data.entity.Contact findByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> callback) {
    }
    
    /**
     * Blocking insert — call ONLY from executor thread
     */
    public final long insertSync(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact) {
        return 0L;
    }
    
    public final void update(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
    
    /**
     * Blocking update — call ONLY from executor thread
     */
    public final void updateSync(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
}