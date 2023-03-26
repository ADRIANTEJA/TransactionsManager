package com.example.transactionsmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/example/transactionsmanager/TransactionApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public final class TransactionApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.transactionsmanager.TransactionApplication.Companion Companion = null;
    public static com.example.transactionsmanager.common.database.TransactionDatabase database;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Calendar actualDate = null;
    
    public TransactionApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/example/transactionsmanager/TransactionApplication$Companion;", "", "()V", "actualDate", "Ljava/util/Calendar;", "getActualDate", "()Ljava/util/Calendar;", "database", "Lcom/example/transactionsmanager/common/database/TransactionDatabase;", "getDatabase", "()Lcom/example/transactionsmanager/common/database/TransactionDatabase;", "setDatabase", "(Lcom/example/transactionsmanager/common/database/TransactionDatabase;)V", "filterSMS", "", "sms", "Landroid/telephony/SmsMessage;", "isFirstTypeValid", "", "transactionEntity", "Lcom/example/transactionsmanager/common/entities/TransactionEntity;", "isSecondTypeValid", "transaction", "processSMS", "filterResult", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.transactionsmanager.common.database.TransactionDatabase getDatabase() {
            return null;
        }
        
        public final void setDatabase(@org.jetbrains.annotations.NotNull()
        com.example.transactionsmanager.common.database.TransactionDatabase p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Calendar getActualDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String filterSMS(@org.jetbrains.annotations.NotNull()
        android.telephony.SmsMessage sms) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.example.transactionsmanager.common.entities.TransactionEntity processSMS(@org.jetbrains.annotations.NotNull()
        android.telephony.SmsMessage sms, @org.jetbrains.annotations.NotNull()
        java.lang.String filterResult) {
            return null;
        }
        
        private final boolean isFirstTypeValid(com.example.transactionsmanager.common.entities.TransactionEntity transactionEntity, android.telephony.SmsMessage sms) {
            return false;
        }
        
        private final boolean isSecondTypeValid(com.example.transactionsmanager.common.entities.TransactionEntity transaction, android.telephony.SmsMessage sms) {
            return false;
        }
    }
}