package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ErrorEntity(@PrimaryKey(autoGenerate = true) var id: Int,
                        var date: String,
                        var errorAddress: String,
                        var errorName: String,
                        var header: String,
                        var smsOrigin: String)