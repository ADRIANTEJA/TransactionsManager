package com.example.transactionsmanager.transctionsListModule.receivers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/example/transactionsmanager/transctionsListModule/receivers/BootCompletedEventReciever;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "SMSReaderService", "app_debug"})
public final class BootCompletedEventReciever extends android.content.BroadcastReceiver {
    
    public BootCompletedEventReciever() {
        super();
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/transactionsmanager/transctionsListModule/receivers/BootCompletedEventReciever$SMSReaderService;", "Landroid/app/Service;", "()V", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "smsCollectorTimer", "Landroid/os/CountDownTimer;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "", "onStartCommand", "", "flags", "startId", "SMSReciever", "app_debug"})
    public static final class SMSReaderService extends android.app.Service {
        private final kotlinx.coroutines.CoroutineScope serviceScope = null;
        private android.os.CountDownTimer smsCollectorTimer;
        
        public SMSReaderService() {
            super();
        }
        
        @java.lang.Override()
        public int onStartCommand(@org.jetbrains.annotations.Nullable()
        android.content.Intent intent, int flags, int startId) {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
        android.content.Intent intent) {
            return null;
        }
        
        @java.lang.Override()
        public void onDestroy() {
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/example/transactionsmanager/transctionsListModule/receivers/BootCompletedEventReciever$SMSReaderService$SMSReciever;", "Landroid/content/BroadcastReceiver;", "(Lcom/example/transactionsmanager/transctionsListModule/receivers/BootCompletedEventReciever$SMSReaderService;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"})
        public final class SMSReciever extends android.content.BroadcastReceiver {
            
            public SMSReciever() {
                super();
            }
            
            @java.lang.Override()
            public void onReceive(@org.jetbrains.annotations.Nullable()
            android.content.Context context, @org.jetbrains.annotations.Nullable()
            android.content.Intent intent) {
            }
        }
    }
}