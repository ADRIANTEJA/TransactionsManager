package com.example.transactionsmanager.common.database

import androidx.room.*
import com.example.transactionsmanager.common.entities.TransactionEntity

@Dao
interface TransactionDAO
{
    @Query("SELECT * FROM TransactionEntity")
    fun getAllTransactions() : MutableList<TransactionEntity>

    @Query("DELETE FROM TransactionEntity")
    fun deleteAll()

    @Insert
    fun addTransaction(transactionEntity: TransactionEntity)

    @Update
     fun updateTransaction(transactionEntity: TransactionEntity)

    @Delete
    fun removeTransaction(transactionEntity: TransactionEntity)
}