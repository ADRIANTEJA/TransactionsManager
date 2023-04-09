package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "CardEntity")
data class CardEntity(@PrimaryKey (autoGenerate = true) var id: Int,
                      var cardNumber: Long)