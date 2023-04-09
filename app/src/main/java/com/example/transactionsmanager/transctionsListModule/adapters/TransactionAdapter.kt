package com.example.transactionsmanager.transctionsListModule.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.transactionsmanager.R
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.databinding.TransactionItemBinding
import com.example.transactionsmanager.transctionsListModule.model.TransactionsDataHeaders
import java.text.SimpleDateFormat
import java.util.*

class TransactionAdapter(private var transactions: MutableList<TransactionEntity>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>()
{
    private lateinit var context: Context
    private val dateFormat = SimpleDateFormat("dd/MM/yy h:m a", Locale.US)

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val binding = TransactionItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.transaction_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = transactions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val transaction = transactions[position]

        with(holder)
        {
            if (transaction.phoneNumber != null) (TransactionsDataHeaders.PHONE_NUMBER_HEADER_TEXT + transaction.phoneNumber.toString()).also { binding.phoneNumberData.text = it }
            (TransactionsDataHeaders.BENEFICIARY_ID_HEADER_TEXT + transaction.beneficiary.toString()).also { binding.beneficiaryData.text = it }
            (TransactionsDataHeaders.TRANSACTIONS_ID_HEADER_TEXT + transaction.transactionId).also { binding.transactionIdData.text = it }
            (TransactionsDataHeaders.DATE_HEADER_TEXT + dateFormat.format(transaction.date).toString()).also { binding.dateData.text = it }
            (TransactionsDataHeaders.AMOUNT_HEADER_TEXT + transaction.amount.toString()).also { binding.amountData.text = it }
        }
    }

    fun setTransactions(transactions: List<TransactionEntity>)
    {
        this.transactions = transactions as MutableList<TransactionEntity>
        notifyItemInserted(itemCount - 1)
    }

}