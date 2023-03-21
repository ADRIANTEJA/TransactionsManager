package com.example.transactionsmanager.transctionsListModule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.transactionsmanager.transctionsListModule.adapters.TransactionAdapter
import com.example.transactionsmanager.databinding.FragmentTransactionsListBinding
import com.example.transactionsmanager.transctionsListModule.viewModel.TransactionsListViewModel

class TransactionsListFragment : Fragment()
{
    private var accountsManagerBinding: FragmentTransactionsListBinding? = null
    private val _accountsManagerBinding get() = accountsManagerBinding!!
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var transactionsListViewModel: TransactionsListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        accountsManagerBinding = FragmentTransactionsListBinding.inflate(inflater, container, false)
        //transactionAdapter = TransactionAdapter()
        linearLayoutManager = LinearLayoutManager(requireContext())

        _accountsManagerBinding.transactionsList.apply()
        {
            layoutManager = linearLayoutManager
            adapter = transactionAdapter
        }
        return _accountsManagerBinding.root
    }

    override fun onDestroy()
    {
        super.onDestroy()
        accountsManagerBinding = null
    }

    private fun setupViewModel()
    {
        transactionsListViewModel = ViewModelProvider(this)[TransactionsListViewModel::class.java]
        //transactionsListViewModel.getTransactions().observe( this, { transactions -> transactionAdapter.set })
    }

    private fun setupRecyclerView()
    {
        transactionAdapter = TransactionAdapter(mutableListOf())
    }
}