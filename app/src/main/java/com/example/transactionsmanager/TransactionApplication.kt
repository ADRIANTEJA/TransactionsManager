package com.example.transactionsmanager

import android.app.Application
import android.os.CountDownTimer
import android.telephony.SmsMessage
import android.util.Log
import androidx.room.Room
import com.example.transactionsmanager.common.database.TransactionDatabase
import com.example.transactionsmanager.common.entities.CardEntity
import com.example.transactionsmanager.common.entities.ErrorEntity
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.common.utils.*
import com.example.transactionsmanager.common.utils.exceptions.InvalidSmsTypeException
import com.example.transactionsmanager.common.utils.exceptions.SmsSizeChangedException
import com.example.transactionsmanager.loginModule.model.retrofit.cardGetting.GetCardResponse
import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingData
import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingService
import com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.Exception
import java.net.InetAddress
import java.util.*

open class TransactionApplication : Application()
{
    companion object
    {
        lateinit var database: TransactionDatabase
        val actualDate: Calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Havana")) //this in milliseconds since 1994
        val timerScope = CoroutineScope(Job())
        private val applicationScope = CoroutineScope(SupervisorJob())

        //this function filters the incoming sms so if it isn't from Transfermovil or not the kind of sms desired it will be ignored
        fun filterSMS(sms: SmsMessage): String
        {
            return if ( sms.originatingAddress == "6505551212" )
            {
                when {
                    sms.displayMessageBody.contains(Filters.TRANSFER_TO_ACCOUNT_PATTERN) -> "first type"

                    sms.displayMessageBody.contains(Filters.PHONE_NUMBER_PATTERN) &&
                            sms.displayMessageBody.contains(Filters.TRANSFER_TO_ACCOUNT_SECOND_PATTERN) -> "second type"

                    else -> "none"
                }
            }
            else "none"
        }

        //this function recieves the filterSMS function and process or ignores the sms in base to filterSMS return value
        fun processSMS(sms: SmsMessage, filterResult: String): TransactionEntity?
        {
            val transaction = TransactionEntity(0,1, false,"ID", 1, 0.0, null)

            when (filterResult)
            {
                "first type" ->
                {
                    if (!isFirstTypeValid(transaction, sms)) return null
                }
                "second type" ->
                {
                    if (!isSecondTypeValid(transaction, sms)) return null
                }
                else -> return null
            }
            return transaction
        }

        private fun isFirstTypeValid(transactionEntity: TransactionEntity, sms: SmsMessage): Boolean
        {
            try
            {
                if (sms.displayMessageBody.length != 110) throw SmsSizeChangedException(ErrorDescriptions.SMS_SIZE_CHANGED)
                if (sms.displayMessageBody.subSequence(46, 62).startsWith("0")) throw java.lang.NumberFormatException()

                transactionEntity.apply()
                {
                    beneficiary = sms.displayMessageBody.subSequence(46, 62).toString().toLong()
                    transactionId = sms.displayMessageBody.subSequence(97, 110).toString()
                    date = actualDate.time.time

                    for (i in 66 until sms.displayMessageBody.length)// this iterates through the sms starting from the amount first character and
                    {
                        if (sms.displayMessageBody[i].toString() == " ")
                        {
                            amount = sms.displayMessageBody.subSequence(66, i).toString().toDouble()
                            break
                        }
                    }
                }
            }
            catch (e: Exception)
            {
                when (e)
                {
                    is java.lang.NumberFormatException, is java.lang.IndexOutOfBoundsException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processFirstType",
                            "sms structure changed",
                            ErrorDescriptions.SMS_STRUCTURE_CHANGED,
                            sms.originatingAddress.toString() )
                        database.errorDAO().addError(error)
                        return false
                    }
                    is SmsSizeChangedException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processFirstType",
                            "sms size changed",
                            ErrorDescriptions.SMS_SIZE_CHANGED,
                            sms.originatingAddress.toString())
                        database.errorDAO().addError(error)
                        return false
                    }
                }
            }
            return true
        }
        //Manages the sms in case is a second type of sms(invalid) by creating an error with corresponding data and registering it

        private fun isSecondTypeValid(transaction: TransactionEntity, sms: SmsMessage): Boolean
        {
            try
            {
                if (sms.displayMessageBody.length != 143 &&
                    sms.displayMessageBody.length != 129) throw SmsSizeChangedException(ErrorDescriptions.SMS_SIZE_CHANGED)
                if (sms.displayMessageBody.subSequence(81, 97).startsWith("0")) throw java.lang.NumberFormatException()

                when (sms.displayMessageBody.length)
                {
                    143 ->
                    {
                        transaction.apply()
                        {
                            beneficiary = sms.displayMessageBody.subSequence(81, 97).toString().toLong()
                            phoneNumber = sms.displayMessageBody.subSequence(24, 34).toString().toLong()
                            transactionId = sms.displayMessageBody.subSequence(130, sms.displayMessageBody.length).toString()

                            date = actualDate.time.time

                            for (i in 101 until sms.displayMessageBody.length)
                            {
                                if (sms.displayMessageBody[i].toString() == " ")
                                {
                                    amount = sms.displayMessageBody.subSequence(101, i).toString().toDouble()
                                    break
                                }
                            }
                        }
                    }
                    129 -> {
                        Log.d("test", "test")
                        throw InvalidSmsTypeException(ErrorDescriptions.INVALID_TYPE_SMS)
                    }
                }
            }
            catch (e: Exception)
            {
                when (e)
                {
                    is java.lang.NumberFormatException, is java.lang.IndexOutOfBoundsException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processSecondType",
                            "sms structure changed",
                            ErrorDescriptions.SMS_STRUCTURE_CHANGED,
                            sms.originatingAddress.toString() )
                        database.errorDAO().addError(error)
                        return false
                    }
                    is InvalidSmsTypeException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processSecondType",
                            "invalid sms type",
                            ErrorDescriptions.INVALID_TYPE_SMS,
                            sms.originatingAddress.toString() )
                        database.errorDAO().addError(error)
                        return false
                    }
                    is SmsSizeChangedException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processSecondType",
                            "sms size changed",
                            ErrorDescriptions.SMS_SIZE_CHANGED,
                            sms.originatingAddress.toString())
                        database.errorDAO().addError(error)
                        return false
                    }
                }
            }
            return true
        }

        fun createSmsCollectorTrigger() : CountDownTimer
        {
            return object : CountDownTimer(20000, 20000) // remember to set to 1 min
            {
                override fun onTick(millisUntilFinished: Long) { }

                override fun onFinish()
                {
                    timerScope.launch()
                    {
                        withContext(Dispatchers.IO)
                        {
                            sendAndUpdateTransactions()
                        }
                    }
                }
            }
        }

        private fun sendAndUpdateTransactions()
        {
            if(isServerReachable())
            {
                val unsentTransactions: MutableList<TransactionEntity> = database.transactionDAO().getUnsentTransactions()

                when(transactionsUploadRequest(convertTransactionsToUpload(unsentTransactions)))
                {
                    "401" ->
                    {

                    }
                }

                unsentTransactions.forEach{ it.sent = true }
                database.transactionDAO().updateTransactions(unsentTransactions)
            }
            else { sendAndUpdateTransactions() }
        }

        private fun isServerReachable(): Boolean
        {
            val serverAddress = InetAddress.getByName("api.from-services.com")
            return serverAddress.isReachable(3000)
        }

        private fun transactionsUploadRequest(convertedTransactions: MutableList<TransactionData>): String
        {
            var responseCode = "noResponse"
            val retrofit = Retrofit.Builder()
                .baseUrl(NetworkingData.URL_BASE + database.CredentialsDAO().getBaseUrl(1))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(NetworkingService::class.java)

            applicationScope.launch()
            {
                withContext(Dispatchers.IO)
                {
                    service.uploadTransactions(convertedTransactions).enqueue(
                        object : Callback<Void>
                        {
                            override fun onResponse(call: Call<Void>, response: Response<Void>)
                            {
                                when(response.code())
                                {
                                    401 -> responseCode = "401"
                                    403 -> responseCode = "403"
                                    in 500..599 -> responseCode= "500+"
                                }
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable)
                            {
                                when(t)
                                {
                                    is IOException -> { responseCode = "noConnection" }
                                    is HttpException -> { responseCode = "serverError" }
                                }
                            }
                        }
                    )
                }
            }
            return responseCode
        }

        private fun convertTransactionsToUpload(unsentTransactions: MutableList<TransactionEntity>): MutableList<TransactionData>
        {
            val convertedTransactions: MutableList<TransactionData> = mutableListOf()

            for (i in 0 until unsentTransactions.size)
            {
                convertedTransactions.add(TransactionData(unsentTransactions[i].transactionId,
                                                          unsentTransactions[i].beneficiary,
                                                          Date(unsentTransactions[i].date),
                                                          unsentTransactions[i].phoneNumber,
                                                          unsentTransactions[i].amount))
            }

            return convertedTransactions
        }

        fun generateRandomString(length: Int): String
        {
            val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
            return (1..length)
                .map { allowedChars.random() }
                .joinToString("")
        }

        fun assignAccount()
        {
            applicationScope.launch()
            {
                withContext(Dispatchers.IO)
                {
                    val retrofit = Retrofit.Builder()
                        .baseUrl(NetworkingData.URL_BASE + database.CredentialsDAO().getBaseUrl(1))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    val service = retrofit.create(NetworkingService::class.java)
                    service.getCards().enqueue(
                        object : Callback<GetCardResponse>
                        {
                            override fun onResponse(call: Call<GetCardResponse>, response: Response<GetCardResponse>)
                            {
                                when(response.code())
                                {
                                    200 ->
                                    {
                                        val cards = listOf<String>(*response.body()!!.cardsList.toTypedArray())

                                        for (i in cards.indices)
                                        {
                                            val card = database.CardDAO().findByCardNumber(cards[i].toLong())
                                            if (card != null) { continue }
                                            else
                                            {
                                                database.CardDAO().deleteAllCards()
                                                for (j in cards.indices) { database.CardDAO().addCard(CardEntity(0, cards[j].toLong())) }
                                                break
                                            }
                                        }
                                    }
                                    403 ->
                                    {

                                    }
                                }
                            }

                            override fun onFailure(call: Call<GetCardResponse>, t: Throwable)
                            {

                            }
                        }
                    )
                }
            }
        }
    }
    override fun onCreate()
    {
        super.onCreate()
        database = Room.databaseBuilder(this, TransactionDatabase::class.java, "TransactionDatabase").fallbackToDestructiveMigration().build()
    }
}