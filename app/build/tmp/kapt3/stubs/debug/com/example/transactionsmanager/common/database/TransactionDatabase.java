package com.example.transactionsmanager.common.database;

import java.lang.System;

@androidx.room.Database(entities = {com.example.transactionsmanager.common.entities.TransactionEntity.class, com.example.transactionsmanager.common.entities.ErrorEntity.class, com.example.transactionsmanager.common.entities.CredentialsEntity.class, com.example.transactionsmanager.common.entities.CardEntity.class, com.example.transactionsmanager.common.entities.ControlFlowEntity.class}, version = 13)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/example/transactionsmanager/common/database/TransactionDatabase;", "Landroidx/room/RoomDatabase;", "()V", "CardDAO", "Lcom/example/transactionsmanager/common/database/CardDAO;", "ControlFlowDAO", "Lcom/example/transactionsmanager/common/database/ControlFlowDAO;", "CredentialsDAO", "Lcom/example/transactionsmanager/common/database/CredentialsDAO;", "errorDAO", "Lcom/example/transactionsmanager/common/database/ErrorDAO;", "transactionDAO", "Lcom/example/transactionsmanager/common/database/TransactionDAO;", "app_debug"})
public abstract class TransactionDatabase extends androidx.room.RoomDatabase {
    
    public TransactionDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.transactionsmanager.common.database.TransactionDAO transactionDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.transactionsmanager.common.database.ErrorDAO errorDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.transactionsmanager.common.database.CredentialsDAO CredentialsDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.transactionsmanager.common.database.CardDAO CardDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.transactionsmanager.common.database.ControlFlowDAO ControlFlowDAO();
}