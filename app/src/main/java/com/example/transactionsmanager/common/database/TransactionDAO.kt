package com.example.transactionsmanager.common.database

import androidx.room.*
import com.example.transactionsmanager.common.entities.TransactionEntity

@Dao
interface TransactionDAO
{
    @Query("SELECT * FROM TransactionEntity")
    fun getAllTransactions() : MutableList<TransactionEntity>

    @Insert
    fun addTransactions(transactionEntity: TransactionEntity)

    @Update
    fun updateTransactions(transactionEntity: TransactionEntity)

    @Delete
    fun removeTransactions(transactionEntity: TransactionEntity)
}