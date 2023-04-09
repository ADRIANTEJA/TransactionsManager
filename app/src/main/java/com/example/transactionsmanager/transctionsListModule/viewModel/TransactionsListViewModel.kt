package com.example.transactionsmanager.transctionsListModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.transctionsListModule.model.TransactionRepository

class TransactionsListViewModel : ViewModel()
{
    private var transactions: MutableLiveData<List<TransactionEntity>> = MutableLiveData()
    private var repository: TransactionRepository = TransactionRepository()

    init { loadTransactions() }

    fun getTransactions(): LiveData<List<TransactionEntity>> { return transactions }

    private fun loadTransactions()
    {
        repository.getTransactionsCallback(object : TransactionRepository.TransactionsCallback
        {
            override fun getTransactionsCallback(transactions: MutableList<TransactionEntity>)
            {
                this@TransactionsListViewModel.transactions.value = transactions
            }
        })
    }

    override fun onCleared()
    {
        super.onCleared()
        repository.closeCoroutine()
    }

}