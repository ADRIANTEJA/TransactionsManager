package com.example.transactionsmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\t"}, d2 = {"Lcom/example/transactionsmanager/TransactionApplication;", "Landroid/app/Application;", "()V", "onCreate", "", "sendIntent", "actionName", "", "Companion", "app_debug"})
public final class TransactionApplication extends android.app.Application {
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
    
    public final void sendIntent(@org.jetbrains.annotations.NotNull()
    java.lang.String actionName) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0002J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018H\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\'J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020)H\u0002J\u0016\u0010.\u001a\u00020\u00132\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u0016\u00100\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018H\u0002J\u0018\u00102\u001a\u0004\u0018\u00010\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u00103\u001a\u00020\u0013J\u0019\u00104\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u00106\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u000e\u00107\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u00108\u001a\u0002052\u0006\u00109\u001a\u00020)H\u0002J\u0010\u0010:\u001a\u0002052\u0006\u00109\u001a\u00020)H\u0002J\u0011\u0010;\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010<R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2 = {"Lcom/example/transactionsmanager/TransactionApplication$Companion;", "", "()V", "actualDate", "Ljava/util/Calendar;", "getActualDate", "()Ljava/util/Calendar;", "applicationScope", "Lkotlinx/coroutines/CoroutineScope;", "database", "Lcom/example/transactionsmanager/common/database/TransactionDatabase;", "getDatabase", "()Lcom/example/transactionsmanager/common/database/TransactionDatabase;", "setDatabase", "(Lcom/example/transactionsmanager/common/database/TransactionDatabase;)V", "timerScope", "getTimerScope", "()Lkotlinx/coroutines/CoroutineScope;", "assignAccounts", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertErrorsToUpload", "", "Lcom/example/transactionsmanager/loginModule/model/retrofit/errorPosting/ErrorData;", "unsentErrors", "Lcom/example/transactionsmanager/common/entities/ErrorEntity;", "convertTransactionsToUpload", "Lcom/example/transactionsmanager/loginModule/model/retrofit/transactionPosting/TransactionData;", "unsentTransactions", "Lcom/example/transactionsmanager/common/entities/TransactionEntity;", "createSmsCollectorTrigger", "Landroid/os/CountDownTimer;", "filterSMS", "sms", "Landroid/telephony/SmsMessage;", "generateRandomString", "length", "", "isFirstTypeValid", "", "transactionEntity", "isSecondTypeValid", "transaction", "isServerReachable", "makeErrorsUploadRequest", "convertedErrors", "makeTransactionsUploadRequest", "convertedTransactions", "processSMS", "filterResult", "sendAndUpdateErrors", "", "sendAndUpdateTransactions", "startAssignAccountWorker", "switchErrorControlFlow", "canBeUploaded", "switchTransactionsControlFlow", "tokenValidity", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
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
        public final android.os.CountDownTimer createSmsCollectorTrigger(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object sendAndUpdateTransactions(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return null;
        }
        
        private final boolean isServerReachable() {
            return false;
        }
        
        private final java.lang.String makeTransactionsUploadRequest(java.util.List<com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData> convertedTransactions) {
            return null;
        }
        
        private final java.util.List<com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData> convertTransactionsToUpload(java.util.List<com.example.transactionsmanager.common.entities.TransactionEntity> unsentTransactions) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String generateRandomString(int length) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object assignAccounts(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
            return null;
        }
        
        private final java.lang.Object tokenValidity(kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object sendAndUpdateErrors(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return null;
        }
        
        private final java.lang.String makeErrorsUploadRequest(java.util.List<com.example.transactionsmanager.loginModule.model.retrofit.errorPosting.ErrorData> convertedErrors) {
            return null;
        }
        
        private final java.util.List<com.example.transactionsmanager.loginModule.model.retrofit.errorPosting.ErrorData> convertErrorsToUpload(java.util.List<com.example.transactionsmanager.common.entities.ErrorEntity> unsentErrors) {
            return null;
        }
        
        private final void switchTransactionsControlFlow(boolean canBeUploaded) {
        }
        
        private final void switchErrorControlFlow(boolean canBeUploaded) {
        }
        
        public final void startAssignAccountWorker(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
    }
}