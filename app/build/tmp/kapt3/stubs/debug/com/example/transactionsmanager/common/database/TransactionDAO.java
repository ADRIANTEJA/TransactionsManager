package com.example.transactionsmanager.common.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/transactionsmanager/common/database/TransactionDAO;", "", "addTransaction", "", "transactionEntity", "Lcom/example/transactionsmanager/common/entities/TransactionEntity;", "deleteAll", "getAllTransactions", "", "removeTransaction", "updateTransaction", "app_debug"})
public abstract interface TransactionDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM TransactionEntity")
    public abstract java.util.List<com.example.transactionsmanager.common.entities.TransactionEntity> getAllTransactions();
    
    @androidx.room.Query(value = "DELETE FROM TransactionEntity")
    public abstract void deleteAll();
    
    @androidx.room.Insert()
    public abstract void addTransaction(@org.jetbrains.annotations.NotNull()
    com.example.transactionsmanager.common.entities.TransactionEntity transactionEntity);
    
    @androidx.room.Update()
    public abstract void updateTransaction(@org.jetbrains.annotations.NotNull()
    com.example.transactionsmanager.common.entities.TransactionEntity transactionEntity);
    
    @androidx.room.Delete()
    public abstract void removeTransaction(@org.jetbrains.annotations.NotNull()
    com.example.transactionsmanager.common.entities.TransactionEntity transactionEntity);
}