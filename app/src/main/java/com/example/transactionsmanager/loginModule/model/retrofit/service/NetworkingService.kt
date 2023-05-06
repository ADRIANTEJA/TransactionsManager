package com.example.transactionsmanager.loginModule.model.retrofit.service

import com.example.transactionsmanager.loginModule.model.retrofit.cardGetting.GetCardsResponse
import com.example.transactionsmanager.loginModule.model.retrofit.errorPosting.ErrorData
import com.example.transactionsmanager.loginModule.model.retrofit.login.LoginResponse
import com.example.transactionsmanager.loginModule.model.retrofit.login.UserData
import com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData
import com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.validTokenResponse.TokenData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NetworkingService
{
    @Headers("Content-Type: application/jason", "User-Agent: Transactions Manager")
    @POST(NetworkingData.API_PATH + NetworkingData.POST_TRANSACTIONS)
    suspend fun uploadTransactions(@Body transactions: MutableList<TransactionData>): Call<Void>

    @POST(NetworkingData.API_PATH + NetworkingData.POST_ERRORS)
    suspend fun uploadErrors(@Body Errors: MutableList<ErrorData>): Call<Void>

    @POST(NetworkingData.API_PATH + NetworkingData.REFRESH_TOKEN)
    suspend fun validateToken(@Body token: TokenData): Call<Void>

    @GET(NetworkingData.API_PATH + NetworkingData.GET_CARD)
    suspend fun getCards(): Call<GetCardsResponse>

    @Headers("Accept: application/json")
    @POST(NetworkingData.API_PATH + NetworkingData.LOGIN_PATH)
    fun login(@Body userData: UserData): Call<LoginResponse>
}