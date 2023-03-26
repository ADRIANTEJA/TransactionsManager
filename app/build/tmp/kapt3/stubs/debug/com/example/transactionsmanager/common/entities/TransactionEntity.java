package com.example.transactionsmanager.common.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "TransactionEntity")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\rJ\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJZ\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010/J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\u0003H\u00d6\u0001J\t\u00104\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$\u00a8\u00065"}, d2 = {"Lcom/example/transactionsmanager/common/entities/TransactionEntity;", "", "id", "", "date", "", "transactionId", "", "beneficiary", "amount", "", "userName", "phoneNumber", "(IJLjava/lang/String;JDLjava/lang/String;Ljava/lang/Long;)V", "getAmount", "()D", "setAmount", "(D)V", "getBeneficiary", "()J", "setBeneficiary", "(J)V", "getDate", "setDate", "getId", "()I", "setId", "(I)V", "getPhoneNumber", "()Ljava/lang/Long;", "setPhoneNumber", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTransactionId", "()Ljava/lang/String;", "setTransactionId", "(Ljava/lang/String;)V", "getUserName", "setUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(IJLjava/lang/String;JDLjava/lang/String;Ljava/lang/Long;)Lcom/example/transactionsmanager/common/entities/TransactionEntity;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class TransactionEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    private long date;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String transactionId;
    private long beneficiary;
    private double amount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String userName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long phoneNumber;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.transactionsmanager.common.entities.TransactionEntity copy(int id, long date, @org.jetbrains.annotations.Nullable()
    java.lang.String transactionId, long beneficiary, double amount, @org.jetbrains.annotations.Nullable()
    java.lang.String userName, @org.jetbrains.annotations.Nullable()
    java.lang.Long phoneNumber) {
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
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public TransactionEntity(int id, long date, @org.jetbrains.annotations.Nullable()
    java.lang.String transactionId, long beneficiary, double amount, @org.jetbrains.annotations.Nullable()
    java.lang.String userName, @org.jetbrains.annotations.Nullable()
    java.lang.Long phoneNumber) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final long component2() {
        return 0L;
    }
    
    public final long getDate() {
        return 0L;
    }
    
    public final void setDate(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransactionId() {
        return null;
    }
    
    public final void setTransactionId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long getBeneficiary() {
        return 0L;
    }
    
    public final void setBeneficiary(long p0) {
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double getAmount() {
        return 0.0;
    }
    
    public final void setAmount(double p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.Nullable()
    java.lang.Long p0) {
    }
}