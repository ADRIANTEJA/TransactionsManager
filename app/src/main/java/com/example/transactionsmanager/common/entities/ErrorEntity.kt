package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ErrorEntity(@PrimaryKey var errorName: String,
                  var errorAddress: String,
                  var date: String,
                  var header: String,
                  var smsOrigin: String)