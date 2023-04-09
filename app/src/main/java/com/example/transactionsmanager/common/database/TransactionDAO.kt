package com.example.transactionsmanager.common.database

import androidx.room.*
import com.example.transactionsmanager.common.entities.TransactionEntity

@Dao
interface TransactionDAO
{
    @Query("SELECT * FROM TransactionEntity")
    fun getAllTransactions(): MutableList<TransactionEntity>

    @Query("SELECT * FROM TransactionEntity WHERE sent = 0")
    fun getUnsentTransactions(): MutableList<TransactionEntity>

    @Insert
    fun addTransaction(transactionEntity: TransactionEntity)

    @Update
    fun updateTransactions(transactions: MutableList<TransactionEntity>)
}