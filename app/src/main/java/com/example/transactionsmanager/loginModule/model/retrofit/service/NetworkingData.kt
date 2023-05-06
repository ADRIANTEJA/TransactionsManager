package com.example.transactionsmanager.loginModule.model.retrofit.service

object NetworkingData
{
    const val URL_BASE = "https://"
    const val API_PATH = "/adm"
    const val LOGIN_PATH = "/login/"
    const val REFRESH_TOKEN = "/refresh-token/"
    const val GET_CARD = "/billing/cards/"
    const val POST_TRANSACTIONS = "/billing/payments/"
    const val POST_ERRORS = "/logs/billing-errors-device/"

    // login data keys
    const val USER_NAME = "username"
    const val PASSWORD = "password"
    const val DEVICE_ID = "deviceId"

    // transactions data keys
    const val TRANSACTION_ID = "transfer_id"
    const val BENEFICIARY = "card_number"
    const val TRANSACTION_DATE = "date"
    const val PHONE_NUMBER = "phone_number"
    const val AMOUNT = "amount"

    // errors data keys
    const val ERROR_NAME = "errorName"
    const val ERROR_ADDRESS = "errorAddress"
    const val SMS_ORIGIN = "smsOrigin"
    const val ERROR_DATE = "date"
    const val HEADER = "header"

    // others
    const val VALIDATION_TOKEN = "validationToken"
}