package com.example.transactionsmanager.loginModule.model.retrofit.login

import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingData
import com.google.gson.annotations.SerializedName

data class UserData(@SerializedName(NetworkingData.USER_NAME)  val userName: String,
                    @SerializedName(NetworkingData.PASSWORD)  val password: String,
                    @SerializedName(NetworkingData.DEVICE_ID) val deviceId: String)
