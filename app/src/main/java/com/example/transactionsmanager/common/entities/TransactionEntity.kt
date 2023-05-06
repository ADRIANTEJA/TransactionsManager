package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "TransactionEntity")
data class TransactionEntity ( @PrimaryKey(autoGenerate = true) var id: Int,
                                var date: Long,
                                var sent: Boolean = false,
                                var transactionId: String,
                                var beneficiary: String,
                                var amount: Double,
                                var phoneNumber: String? = null)
