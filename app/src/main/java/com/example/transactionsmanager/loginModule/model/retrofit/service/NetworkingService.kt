package com.example.transactionsmanager.loginModule.model.retrofit.service

import com.example.transactionsmanager.loginModule.model.retrofit.cardGetting.CardsRequestResponse
import com.example.transactionsmanager.loginModule.model.retrofit.errorPosting.ErrorData
import com.example.transactionsmanager.loginModule.model.retrofit.login.LoginResponse
import com.example.transactionsmanager.loginModule.model.retrofit.login.UserData
import com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData
import com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.validTokenResponse.TokenData
import retrofit2.Call
import retrofit2.http.*

interface NetworkingService
{
    @Headers("Content-Type: application/jason", "User-Agent: Transactions Manager")
    @POST(NetworkingData.API_PATH + NetworkingData.POST_TRANSACTIONS)
    fun uploadTransactions(@Body transactions: MutableList<TransactionData>,
                                   @Header("token") token: String): Call<Void>

    @POST(NetworkingData.API_PATH + NetworkingData.POST_ERRORS)
    fun uploadErrors(@Body Errors: MutableList<ErrorData>,
                             @Header("token") token: String): Call<Void>

    @POST(NetworkingData.API_PATH + NetworkingData.REFRESH_TOKEN)
    fun validateToken(@Body token: TokenData): Call<Void>

    @GET(NetworkingData.API_PATH + NetworkingData.GET_CARD)
    fun getCards(@Header("token") token: String): Call<List<CardsRequestResponse>>

    @Headers("Accept: application/json")
    @POST(NetworkingData.API_PATH + NetworkingData.LOGIN_PATH)
    fun login(@Body userData: UserData): Call<LoginResponse>
}