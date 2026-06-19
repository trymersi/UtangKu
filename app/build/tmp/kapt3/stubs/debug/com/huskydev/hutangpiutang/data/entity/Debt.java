package com.huskydev.hutangpiutang.data.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0014J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0010H\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0006H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\t\u00105\u001a\u00020\u000eH\u00c6\u0003J\u0096\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u00102\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020;H\u00d6\u0001J\t\u0010<\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016\u00a8\u0006="}, d2 = {"Lcom/huskydev/hutangpiutang/data/entity/Debt;", "", "id", "", "contactId", "type", "Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "originalAmount", "remainingAmount", "description", "", "dateCreated", "dueDate", "status", "Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;", "reminderEnabled", "", "reminderDatetime", "createdAt", "updatedAt", "(JJLcom/huskydev/hutangpiutang/data/entity/DebtType;JJLjava/lang/String;JLjava/lang/Long;Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;ZLjava/lang/Long;JJ)V", "getContactId", "()J", "getCreatedAt", "getDateCreated", "getDescription", "()Ljava/lang/String;", "getDueDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "getOriginalAmount", "getRemainingAmount", "getReminderDatetime", "getReminderEnabled", "()Z", "getStatus", "()Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;", "getType", "()Lcom/huskydev/hutangpiutang/data/entity/DebtType;", "getUpdatedAt", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JJLcom/huskydev/hutangpiutang/data/entity/DebtType;JJLjava/lang/String;JLjava/lang/Long;Lcom/huskydev/hutangpiutang/data/entity/DebtStatus;ZLjava/lang/Long;JJ)Lcom/huskydev/hutangpiutang/data/entity/Debt;", "equals", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "debts", foreignKeys = {@androidx.room.ForeignKey(entity = com.huskydev.hutangpiutang.data.entity.Contact.class, parentColumns = {"id"}, childColumns = {"contactId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"contactId"}), @androidx.room.Index(value = {"status"}), @androidx.room.Index(value = {"dueDate"})})
public final class Debt {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    private final long contactId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.entity.DebtType type = null;
    private final long originalAmount = 0L;
    private final long remainingAmount = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String description = null;
    private final long dateCreated = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long dueDate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.huskydev.hutangpiutang.data.entity.DebtStatus status = null;
    private final boolean reminderEnabled = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long reminderDatetime = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    
    public Debt(long id, long contactId, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtType type, long originalAmount, long remainingAmount, @org.jetbrains.annotations.Nullable()
    java.lang.String description, long dateCreated, @org.jetbrains.annotations.Nullable()
    java.lang.Long dueDate, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtStatus status, boolean reminderEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.Long reminderDatetime, long createdAt, long updatedAt) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long getContactId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.entity.DebtType getType() {
        return null;
    }
    
    public final long getOriginalAmount() {
        return 0L;
    }
    
    public final long getRemainingAmount() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final long getDateCreated() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getDueDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.entity.DebtStatus getStatus() {
        return null;
    }
    
    public final boolean getReminderEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getReminderDatetime() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component11() {
        return null;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.entity.DebtType component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    public final long component7() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.entity.DebtStatus component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.huskydev.hutangpiutang.data.entity.Debt copy(long id, long contactId, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtType type, long originalAmount, long remainingAmount, @org.jetbrains.annotations.Nullable()
    java.lang.String description, long dateCreated, @org.jetbrains.annotations.Nullable()
    java.lang.Long dueDate, @org.jetbrains.annotations.NotNull()
    com.huskydev.hutangpiutang.data.entity.DebtStatus status, boolean reminderEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.Long reminderDatetime, long createdAt, long updatedAt) {
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