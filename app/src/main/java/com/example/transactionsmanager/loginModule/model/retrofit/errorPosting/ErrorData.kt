package com.example.transactionsmanager.loginModule.model.retrofit.errorPosting

import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingData
import com.google.gson.annotations.SerializedName

data class ErrorData(@SerializedName(NetworkingData.ERROR_NAME) val errorName: String,
                     @SerializedName(NetworkingData.ERROR_ADDRESS) val errorAddress: String,
                     @SerializedName(NetworkingData.SMS_ORIGIN) val smsOrigin: String,
                     @SerializedName(NetworkingData.ERROR_DATE) val errorDate: String,
                     @SerializedName(NetworkingData.HEADER) val header: String)