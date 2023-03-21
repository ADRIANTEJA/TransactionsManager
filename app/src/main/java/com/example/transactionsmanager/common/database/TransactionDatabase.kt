package com.example.transactionsmanager.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.transactionsmanager.common.entities.ErrorEntity
import com.example.transactionsmanager.common.entities.TransactionEntity

@Database(entities = [TransactionEntity::class, ErrorEntity::class], version = 1)
abstract class TransactionDatabase : RoomDatabase()
{
    abstract fun transactionDAO() : TransactionDAO
    abstract fun errorDAO() : ErrorDAO
}