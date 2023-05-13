package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ControlFlowEntity")
data class ControlFlowEntity(@PrimaryKey val id: Int,
                             val canUploadTransactions: Boolean = true,
                             val canUploadErrors: Boolean = true,
                             val canAssignAccounts: Boolean = true,
                             val canProcessSMS: Boolean = true)
