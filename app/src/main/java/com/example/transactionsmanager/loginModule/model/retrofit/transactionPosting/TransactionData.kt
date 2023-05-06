package com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting

import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingData
import com.google.gson.annotations.SerializedName
import java.util.*

data class TransactionData(@SerializedName(NetworkingData.TRANSACTION_ID) val transactionId: String,
                           @SerializedName(NetworkingData.BENEFICIARY) val beneficiary: String,
                           @SerializedName(NetworkingData.TRANSACTION_DATE) val date: Date,
                           @SerializedName(NetworkingData.PHONE_NUMBER) val phoneNumber: String? = null,
                           @SerializedName(NetworkingData.AMOUNT) val amount: Double)