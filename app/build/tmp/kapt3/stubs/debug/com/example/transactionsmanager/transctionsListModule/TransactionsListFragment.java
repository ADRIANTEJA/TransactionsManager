package com.example.transactionsmanager.transctionsListModule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/example/transactionsmanager/transctionsListModule/TransactionsListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_transactionsListBinding", "Lcom/example/transactionsmanager/databinding/FragmentTransactionsListBinding;", "get_transactionsListBinding", "()Lcom/example/transactionsmanager/databinding/FragmentTransactionsListBinding;", "backToLoginReciever", "Landroid/content/BroadcastReceiver;", "linearLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "transactionAdapter", "Lcom/example/transactionsmanager/transctionsListModule/adapters/TransactionAdapter;", "transactionsListBinding", "transactionsListViewModel", "Lcom/example/transactionsmanager/loginModule/model/retrofit/cardGetting/viewModel/TransactionsListViewModel;", "callEventBusyNotification", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStop", "onViewCreated", "view", "setupMenu", "context", "Landroid/content/Context;", "setupRecyclerView", "setupViewModel", "Companion", "app_debug"})
public class TransactionsListFragment extends androidx.fragment.app.Fragment {
    private com.example.transactionsmanager.databinding.FragmentTransactionsListBinding transactionsListBinding;
    private com.example.transactionsmanager.transctionsListModule.adapters.TransactionAdapter transactionAdapter;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager linearLayoutManager;
    private com.example.transactionsmanager.loginModule.model.retrofit.cardGetting.viewModel.TransactionsListViewModel transactionsListViewModel;
    private final android.content.BroadcastReceiver backToLoginReciever = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.transactionsmanager.transctionsListModule.TransactionsListFragment.Companion Companion = null;
    
    public TransactionsListFragment() {
        super();
    }
    
    private final com.example.transactionsmanager.databinding.FragmentTransactionsListBinding get_transactionsListBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void setupViewModel() {
    }
    
    private final void setupRecyclerView() {
    }
    
    private final void setupMenu(android.view.View view, android.content.Context context) {
    }
    
    private final void callEventBusyNotification() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/transactionsmanager/transctionsListModule/TransactionsListFragment$Companion;", "Lcom/example/transactionsmanager/transctionsListModule/TransactionsListFragment;", "()V", "goToLogin", "", "view", "Landroid/view/View;", "app_debug"})
    public static final class Companion extends com.example.transactionsmanager.transctionsListModule.TransactionsListFragment {
        
        private Companion() {
            super();
        }
        
        public final void goToLogin(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
        }
    }
}