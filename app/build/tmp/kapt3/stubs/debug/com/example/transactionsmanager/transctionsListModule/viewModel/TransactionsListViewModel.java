package com.example.transactionsmanager.transctionsListModule.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\nJ\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/transactionsmanager/transctionsListModule/viewModel/TransactionsListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "repository", "Lcom/example/transactionsmanager/transctionsListModule/model/TransactionRepository;", "transactions", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/example/transactionsmanager/common/entities/TransactionEntity;", "getTransactions", "Landroidx/lifecycle/LiveData;", "loadTransactions", "", "onCleared", "app_debug"})
public final class TransactionsListViewModel extends androidx.lifecycle.ViewModel {
    private androidx.lifecycle.MutableLiveData<java.util.List<com.example.transactionsmanager.common.entities.TransactionEntity>> transactions;
    private com.example.transactionsmanager.transctionsListModule.model.TransactionRepository repository;
    
    public TransactionsListViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.transactionsmanager.common.entities.TransactionEntity>> getTransactions() {
        return null;
    }
    
    private final void loadTransactions() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}