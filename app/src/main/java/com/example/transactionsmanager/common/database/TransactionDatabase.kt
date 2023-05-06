package com.example.transactionsmanager.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.transactionsmanager.common.entities.*

@Database(entities = [TransactionEntity::class,
                      ErrorEntity::class,
                      CredentialsEntity::class,
                      CardEntity::class,
                      ControlFlowEntity::class], version = 13)
abstract class TransactionDatabase : RoomDatabase()
{
    abstract fun transactionDAO() : TransactionDAO

    abstract fun errorDAO() : ErrorDAO

    abstract fun CredentialsDAO() : CredentialsDAO

    abstract fun CardDAO() : CardDAO

    abstract fun ControlFlowDAO() : ControlFlowDAO
}