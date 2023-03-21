package com.example.transactionsmanager.transctionsListModule.viewModel

import android.telephony.SmsMessage
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.common.utils.Constants

class TransactionsListViewModel : ViewModel()
{
    private var transactions: MutableLiveData<List<TransactionEntity>>

    init
    {
        transactions = MutableLiveData()
        loadTransactions()
    }

    fun getTransactions(): LiveData<List<TransactionEntity>> { return transactions }

    private fun loadTransactions()
    {

    }

    /*private fun getTransactionsTest(): MutableList<Transaction>
    {
        transactionsTest.apply()
        {
            for (i in 0 until 20)
            {
                add(
                    Transaction(Constants.accountIdHeaderText + "0000111122223333",
                        Constants.transactionsIdHeaderText + "AY3004JQST999",
                        Constants.dateHeaderText + "12/31/23 5:30 PM",
                        Constants.amountHeaderText + "300 CUP")
                )
            }
        }
        return transactionsTest
    }

    private fun registerTransaction()
    {
        transactionsTest.add(Transaction("12060010201002", "iahwdawhdoa", "23/03/4 5:30 PM", "400 CUP"))
    }*/
}