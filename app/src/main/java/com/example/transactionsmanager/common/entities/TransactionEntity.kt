package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "TransactionEntity")
data class TransactionEntity ( @PrimaryKey(autoGenerate = true) var id: Int,
                                var date: Long,
                                var transactionId: String? = null,
                                var beneficiary: Long,
                                var amount: Double,
                                var userName: String? = null,
                                var phoneNumber: Long? = null)
