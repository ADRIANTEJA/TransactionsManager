package com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.validTokenResponse

import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingData
import com.google.gson.annotations.SerializedName

data class TokenData(@SerializedName(NetworkingData.VALIDATION_TOKEN)val token: String)