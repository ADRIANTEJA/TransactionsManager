package com.example.transactionsmanager.transctionsListModule.model

import com.example.transactionsmanager.TransactionApplication
import com.example.transactionsmanager.common.entities.TransactionEntity
import kotlinx.coroutines.*

class TransactionRepository()
{
    private val transactionRepositoryScope = CoroutineScope(Dispatchers.Main + Job())

    interface TransactionsCallback
    {
        fun getTransactionsCallback(transactions: MutableList<TransactionEntity>)
    }

    fun getTransactionsCallback(callback: TransactionsCallback)
    {
        transactionRepositoryScope.launch()
        {
            withContext(Dispatchers.IO)
            {
                val transactionsList = TransactionApplication.database.transactionDAO().getAllTransactions()
                withContext(Dispatchers.Main)
                {
                    callback.getTransactionsCallback(transactionsList)
                }
            }
        }
    }

    fun closeCoroutine()
    {
        this.transactionRepositoryScope.cancel()
    }
}