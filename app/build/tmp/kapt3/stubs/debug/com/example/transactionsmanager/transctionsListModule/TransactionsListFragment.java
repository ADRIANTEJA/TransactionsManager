package com.example.transactionsmanager.transctionsListModule;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/transactionsmanager/transctionsListModule/TransactionsListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_accountsManagerBinding", "Lcom/example/transactionsmanager/databinding/FragmentTransactionsListBinding;", "get_accountsManagerBinding", "()Lcom/example/transactionsmanager/databinding/FragmentTransactionsListBinding;", "accountsManagerBinding", "linearLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "transactionAdapter", "Lcom/example/transactionsmanager/transctionsListModule/adapters/TransactionAdapter;", "transactionsListViewModel", "Lcom/example/transactionsmanager/transctionsListModule/viewModel/TransactionsListViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "setupRecyclerView", "setupViewModel", "app_debug"})
public final class TransactionsListFragment extends androidx.fragment.app.Fragment {
    private com.example.transactionsmanager.databinding.FragmentTransactionsListBinding accountsManagerBinding;
    private com.example.transactionsmanager.transctionsListModule.adapters.TransactionAdapter transactionAdapter;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager linearLayoutManager;
    private com.example.transactionsmanager.transctionsListModule.viewModel.TransactionsListViewModel transactionsListViewModel;
    
    public TransactionsListFragment() {
        super();
    }
    
    private final com.example.transactionsmanager.databinding.FragmentTransactionsListBinding get_accountsManagerBinding() {
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
    public void onDestroy() {
    }
    
    private final void setupViewModel() {
    }
    
    private final void setupRecyclerView() {
    }
}