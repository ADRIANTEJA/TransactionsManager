package com.example.transactionsmanager.loginModule.model.retrofit

import com.example.transactionsmanager.loginModule.model.Constants
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService
{
    @Headers("Content-Type: application/json")
    @POST(Constants.API_PATH + Constants.LOGIN_PATH)
    fun login(@Body data: UserData): Call<LoginResponse>
}