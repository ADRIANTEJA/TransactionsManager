package com.example.transactionsmanager.transctionsListModule.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.transactionsmanager.R
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.databinding.TransactionItemBinding

class TransactionAdapter(private var transactions: MutableList<TransactionEntity>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>()
{
    private lateinit var context: Context

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
            binding.phoneNumberData.text = transaction.beneficiary.toString()
            binding.transactionIdData.text = transaction.transactionId
            binding.dateData.text = transaction.date.toString()
            binding.amountData.text = transaction.amount.toString()
        }
    }

    fun setTransactions(transactions: List<TransactionEntity>)
    {
        this.transactions = transactions as MutableList<TransactionEntity>
        //notifyDataSetChanged()
    }

}