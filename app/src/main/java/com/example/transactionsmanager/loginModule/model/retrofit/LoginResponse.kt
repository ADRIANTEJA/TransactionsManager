package com.example.transactionsmanager.loginModule.model.retrofit

data class LoginResponse(val token: String) : SuccessfulResponse(token)
{

}