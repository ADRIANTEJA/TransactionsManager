package com.example.transactionsmanager.common.entities

import androidx.room.PrimaryKey

class ErrorEntity(@PrimaryKey var errorName: String,
                  var errorAddress: String,
                  var date: String,
                  var header: String,
                  var smsOrigin: String)