package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "TransactionEntity")
data class TransactionEntity ( @PrimaryKey var beneficiary: Long,
                                var transactionId: String? = null,
                                var date: Long,
                                var amount: Double,
                                var userName: String? = null,
                                var phoneNumber: Int? = null)
