package com.huskydev.hutangpiutang.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\'J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\u0014\u001a\u00020\bH\'J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/huskydev/hutangpiutang/data/dao/ContactDao;", "", "delete", "", "contact", "Lcom/huskydev/hutangpiutang/data/entity/Contact;", "findByName", "name", "", "getAll", "Landroidx/lifecycle/LiveData;", "", "getAllSync", "getById", "id", "", "getByIdLive", "getByIdSync", "insert", "searchByName", "query", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface ContactDao {
    
    @androidx.room.Query(value = "SELECT * FROM contacts ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM contacts ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.huskydev.hutangpiutang.data.entity.Contact> getAllSync();
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract com.huskydev.hutangpiutang.data.entity.Contact getById(long id);
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract com.huskydev.hutangpiutang.data.entity.Contact getByIdSync(long id);
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.huskydev.hutangpiutang.data.entity.Contact> getByIdLive(long id);
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE name LIKE \'%\' || :query || \'%\' ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.huskydev.hutangpiutang.data.entity.Contact>> searchByName(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT * FROM contacts WHERE name = :name LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract com.huskydev.hutangpiutang.data.entity.Contact findByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @androidx.room.Insert()
    public abstract long insert(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.Contact contact);
}