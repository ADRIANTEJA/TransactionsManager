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

open class TransactionsListFragment : Fragment()
{
    private var transactionsListBinding: FragmentTransactionsListBinding? = null
    private val _transactionsListBinding get() = transactionsListBinding!!

    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var transactionsListViewModel: TransactionsListViewModel

    companion object : TransactionsListFragment()
    {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        transactionsListBinding = FragmentTransactionsListBinding.inflate(inflater, container, false)

        setupViewModel()
        setupRecyclerView()
        return _transactionsListBinding.root
    }

    override fun onDestroy()
    {
        super.onDestroy()
        transactionsListBinding = null
    }

    private fun setupViewModel()
    {
        transactionsListViewModel = ViewModelProvider(this)[TransactionsListViewModel::class.java]
        transactionsListViewModel.getTransactions().observe( viewLifecycleOwner ) { transactions ->
            transactionAdapter.setTransactions(transactions)
        }
    }

    private fun setupRecyclerView()
    {
        transactionAdapter = TransactionAdapter(mutableListOf())
        linearLayoutManager = LinearLayoutManager(requireContext())

        _transactionsListBinding.transactionsList.apply()
        {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = transactionAdapter
        }
    }
}