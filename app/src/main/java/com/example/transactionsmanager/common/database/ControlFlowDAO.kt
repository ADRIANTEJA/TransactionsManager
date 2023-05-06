package com.example.transactionsmanager.common.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ControlFlowDAO
{
    @Query("UPDATE ControlFlowEntity SET canUploadTransactions = :canUploadTransactions WHERE id = :id")
    fun updateUploadTransactionsControlFlow(id: Int, canUploadTransactions: Boolean)

    @Query("UPDATE ControlFlowEntity SET canUploadErrors = :canUploadErrors WHERE id = :id")
    fun updateUploadErrorsControlFlow(id: Int, canUploadErrors: Boolean)

    @Query("UPDATE ControlFlowEntity SET canAssignAccounts = :canAssignAccounts WHERE id = :id")
    fun updateAssignAccountsControlFlow(id: Int, canAssignAccounts: Boolean)

    @Query("SELECT canUploadTransactions FROM ControlFlowEntity WHERE id = :id")
    fun getUploadTransactionsControlFlow(id: Int): Boolean

    @Query("SELECT canUploadErrors FROM ControlFlowEntity WHERE id = :id")
    fun getUploadErrorsControlFlow(id: Int): Boolean

    @Query("SELECT canAssignAccounts FROM ControlFlowEntity WHERE id = :id")
    fun getAssignAccountsControlFlow(id: Int): Boolean
}