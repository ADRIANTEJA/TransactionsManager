package com.example.transactionsmanager.common.database;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\b\u0010\u0006\u001a\u00020\u0003H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/transactionsmanager/common/database/ErrorDAO;", "", "addError", "", "errorEntity", "Lcom/example/transactionsmanager/common/entities/ErrorEntity;", "deleteAll", "deleteError", "getAllErrors", "", "getUnsentErrors", "updateErrors", "errors", "app_debug"})
public abstract interface ErrorDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ErrorEntity")
    public abstract java.util.List<com.example.transactionsmanager.common.entities.ErrorEntity> getAllErrors();
    
    @androidx.room.Query(value = "DELETE FROM ErrorEntity")
    public abstract void deleteAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM ErrorEntity WHERE sent = 0")
    public abstract java.util.List<com.example.transactionsmanager.common.entities.ErrorEntity> getUnsentErrors();
    
    @androidx.room.Update()
    public abstract void updateErrors(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.transactionsmanager.common.entities.ErrorEntity> errors);
    
    @androidx.room.Insert()
    public abstract void addError(@org.jetbrains.annotations.NotNull()
    com.example.transactionsmanager.common.entities.ErrorEntity errorEntity);
    
    @androidx.room.Delete()
    public abstract void deleteError(@org.jetbrains.annotations.NotNull()
    com.example.transactionsmanager.common.entities.ErrorEntity errorEntity);
}