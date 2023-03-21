package com.example.transactionsmanager.loginModule.model.retrofit

import com.example.transactionsmanager.loginModule.model.Constants
import com.google.gson.annotations.SerializedName

class UserData(@SerializedName(Constants.USER_NAME)  val userName: String,
               @SerializedName(Constants.PASSWORD)  val password: String)
