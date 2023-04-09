package com.example.transactionsmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/example/transactionsmanager/TransactionApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "Companion", "app_debug"})
public class TransactionApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.transactionsmanager.TransactionApplication.Companion Companion = null;
    public static com.example.transactionsmanager.common.database.TransactionDatabase database;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Calendar actualDate = null;
    @org.jetbrains.annotations.NotNull()
    private static final kotlinx.coroutines.CoroutineScope timerScope = null;
    private static final kotlinx.coroutines.CoroutineScope applicationScope = null;
    
    public TransactionApplication() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\'\u001a\u00020#H\u0002J\u0018\u0010(\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001cJ\b\u0010*\u001a\u00020\u0013H\u0002J\u0016\u0010+\u001a\u00020\u001c2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006-"}, d2 = {"Lcom/example/transactionsmanager/TransactionApplication$Companion;", "", "()V", "actualDate", "Ljava/util/Calendar;", "getActualDate", "()Ljava/util/Calendar;", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "database", "Lcom/example/transactionsmanager/common/database/TransactionDatabase;", "getDatabase", "()Lcom/example/transactionsmanager/common/database/TransactionDatabase;", "setDatabase", "(Lcom/example/transactionsmanager/common/database/TransactionDatabase;)V", "timerScope", "getTimerScope", "()Lkotlinx/coroutines/CoroutineScope;", "assignAccount", "", "convertTransactionsToUpload", "", "Lcom/example/transactionsmanager/loginModule/model/retrofit/transactionPosting/TransactionData;", "unsentTransactions", "Lcom/example/transactionsmanager/common/entities/TransactionEntity;", "createSmsCollectorTrigger", "Landroid/os/CountDownTimer;", "filterSMS", "", "sms", "Landroid/telephony/SmsMessage;", "generateRandomString", "length", "", "isFirstTypeValid", "", "transactionEntity", "isSecondTypeValid", "transaction", "isServerReachable", "processSMS", "filterResult", "sendAndUpdateTransactions", "transactionsUploadRequest", "convertedTransactions", "app_debug"})
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
        public final kotlinx.coroutines.CoroutineScope getTimerScope() {
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
        
        @org.jetbrains.annotations.NotNull()
        public final android.os.CountDownTimer createSmsCollectorTrigger() {
            return null;
        }
        
        private final void sendAndUpdateTransactions() {
        }
        
        private final boolean isServerReachable() {
            return false;
        }
        
        private final java.lang.String transactionsUploadRequest(java.util.List<com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData> convertedTransactions) {
            return null;
        }
        
        private final java.util.List<com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData> convertTransactionsToUpload(java.util.List<com.example.transactionsmanager.common.entities.TransactionEntity> unsentTransactions) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String generateRandomString(int length) {
            return null;
        }
        
        public final void assignAccount() {
        }
    }
}