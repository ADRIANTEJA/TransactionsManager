package com.example.transactionsmanager.loginModule.model.retrofit.login

import com.example.transactionsmanager.loginModule.model.retrofit.login.SuccessfulLoginResponse

data class LoginResponse(val token: String) : SuccessfulLoginResponse(token)