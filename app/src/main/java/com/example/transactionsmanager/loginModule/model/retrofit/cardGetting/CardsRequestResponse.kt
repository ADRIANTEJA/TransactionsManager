package com.example.transactionsmanager.loginModule.model.retrofit.cardGetting

data class CardsRequestResponse(val id: Int,
                                val name: String,
                                val cardNumber: String,
                                val phoneNumber: String,
                                val hide: Boolean,
                                val lastUpdated: String)