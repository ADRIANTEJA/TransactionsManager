package com.example.transactionsmanager

import android.app.Application
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.telephony.SmsMessage
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.room.OnConflictStrategy
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.*
import com.example.transactionsmanager.common.database.TransactionDatabase
import com.example.transactionsmanager.common.entities.CardEntity
import com.example.transactionsmanager.common.entities.ErrorEntity
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.common.utils.*
import com.example.transactionsmanager.common.utils.exceptions.InvalidSmsTypeException
import com.example.transactionsmanager.common.utils.exceptions.SmsSizeChangedException
import com.example.transactionsmanager.common.workers.AssignAccountWorker
import com.example.transactionsmanager.loginModule.model.retrofit.cardGetting.CardsRequestResponse
import com.example.transactionsmanager.loginModule.model.retrofit.errorPosting.ErrorData
import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingData
import com.example.transactionsmanager.loginModule.model.retrofit.service.NetworkingService
import com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.TransactionData
import com.example.transactionsmanager.loginModule.model.retrofit.transactionPosting.validTokenResponse.TokenData
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.Exception
import java.net.InetAddress
import java.net.SocketTimeoutException
import java.util.*
import java.util.concurrent.TimeUnit

class TransactionApplication : Application()
{
    companion object
    {
        lateinit var database: TransactionDatabase
        private val actualDate: Calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Havana")) //this in milliseconds since 1994
        val timerScope = CoroutineScope(Job())
        private val applicationScope = CoroutineScope(SupervisorJob())
        private val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

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
            val transaction = TransactionEntity(0,1, false,"ID", "1", 0.0, null)

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
                    beneficiary = sms.displayMessageBody.subSequence(46, 62).toString()
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
                            sms.originatingAddress.toString(),
                            false)
                        database.errorDAO().addError(error)
                        return false
                    }
                    is SmsSizeChangedException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processFirstType",
                            "sms size changed",
                            ErrorDescriptions.SMS_SIZE_CHANGED,
                            sms.originatingAddress.toString(),
                            false)
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
                            beneficiary = sms.displayMessageBody.subSequence(81, 97).toString()
                            phoneNumber = sms.displayMessageBody.subSequence(24, 34).toString()
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
                            sms.originatingAddress.toString(),
                            false)
                        database.errorDAO().addError(error)
                        return false
                    }
                    is InvalidSmsTypeException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processSecondType",
                            "invalid sms type",
                            ErrorDescriptions.INVALID_TYPE_SMS,
                            sms.originatingAddress.toString(),
                            false)
                        database.errorDAO().addError(error)
                        return false
                    }
                    is SmsSizeChangedException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processSecondType",
                            "sms size changed",
                            ErrorDescriptions.SMS_SIZE_CHANGED,
                            sms.originatingAddress.toString(),
                            false)
                        database.errorDAO().addError(error)
                        return false
                    }
                }
            }
            return true
        }

        fun createSmsCollectorTrigger(context: Context) : CountDownTimer
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
                            if (database.ControlFlowDAO().getUploadTransactionsControlFlow(1)) { sendAndUpdateTransactions(context) }
                            if (database.ControlFlowDAO().getUploadErrorsControlFlow(1)) { sendAndUpdateErrors(context) }
                        }
                    }
                }
            }
        }

        suspend fun sendAndUpdateTransactions(context: Context) // remember
        {
            switchTransactionsControlFlow(false)

            if(isServerReachable())
            {
                val unsentTransactions: MutableList<TransactionEntity> = database.transactionDAO().getUnsentTransactions()

                when(makeTransactionsUploadRequest(convertTransactionsToUpload(unsentTransactions)))
                {
                    "200" ->
                    {
                        unsentTransactions.forEach { it.sent = true }
                        database.transactionDAO().updateTransactions(unsentTransactions)
                    }

                    "403" ->
                    {
                        while(true)
                        {
                            when(tokenValidity())
                            {
                                "isNotValid" ->
                                {
                                    val transactionApplication = context as TransactionApplication
                                    transactionApplication.sendIntent("go-back-to-login")
                                    break
                                }
                                "isValid" ->
                                {
                                    sendAndUpdateTransactions(context)
                                    break
                                }
                                else -> delay(60000)
                            }
                        }
                    }

                    else ->
                    {
                        switchTransactionsControlFlow(true)
                        return
                    }
                }
            }
            else { sendAndUpdateTransactions(context) }

            switchTransactionsControlFlow(true)
        }

        private fun isServerReachable(): Boolean
        {
            val serverAddress = InetAddress.getByName("api.from-services.com")
            return serverAddress.isReachable(3000)
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        private suspend fun makeTransactionsUploadRequest(convertedTransactions: MutableList<TransactionData>): String
        {
            var responseCode = "noResponse"

            val retrofit = Retrofit.Builder()
                .baseUrl(NetworkingData.URL_BASE + database.CredentialsDAO().getBaseUrl(1))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(NetworkingService::class.java)

            try
            {
                val response = suspendCancellableCoroutine<Response<Void>>
                { continuation ->
                    service.uploadTransactions(convertedTransactions, database.CredentialsDAO().getToken(1)).enqueue(
                        object : Callback<Void>
                        {
                            override fun onResponse(call: Call<Void>, response: Response<Void>)
                            {
                                continuation.resume(response) {}
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable)
                            {
                                continuation.resumeWith(Result.failure(t))
                            }
                        }
                    )
                }
                when (response.code())
                {
                    200 -> responseCode = "200"
                    403 -> responseCode = "403"
                }
            }
            catch (e: Exception) { Log.d("exception", e.message.toString()) }

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

        @OptIn(ExperimentalCoroutinesApi::class)
        suspend fun assignAccounts(): String
        {
            var responseCode = "noResponse" // this variable is to control the success of the request(no connection errors etc) it doesn't matter if it takes back to login

            val cards: MutableList<CardsRequestResponse>
            val retrofit = Retrofit.Builder()
                .baseUrl(NetworkingData.URL_BASE + database.CredentialsDAO().getBaseUrl(1))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(NetworkingService::class.java)

            try
            {
                val response = suspendCancellableCoroutine<Response<List<CardsRequestResponse>>>
                { continuation ->
                    service.getCards(database.CredentialsDAO().getToken(1)).enqueue(
                        object: Callback<List<CardsRequestResponse>>
                        {
                            override fun onResponse(call: Call<List<CardsRequestResponse>>, response: Response<List<CardsRequestResponse>>)
                            {
                                continuation.resume(response) { }
                            }

                            override fun onFailure(call: Call<List<CardsRequestResponse>>, t: Throwable)
                            {
                                continuation.resumeWith(Result.failure(t)) // JSON ARRAY PROBLEM
                            }
                        }
                    )
                }
                Log.d("response Code", response.code().toString())
                when(response.code())
                {
                    200 ->
                    {
                        Log.d("response", "successful")
                        cards = response.body()?.toMutableList() ?: mutableListOf()
                        for (i in cards.indices)
                        {
                            val card = database.CardDAO().getByCardNumber(cards[i].cardNumber.toLong())
                            if (card != null) { continue }
                            else
                            {
                                database.CardDAO().deleteAllCards()
                                for (j in cards.indices) { database.CardDAO().addCard(CardEntity(0, cards[j].cardNumber.toLong())) }
                                break
                            }
                        }
                        responseCode = "successful"
                    }
                    403 ->
                    {
                        Log.d("response", "403")
                        if (tokenValidity() == "isNotValid") { responseCode = "invalidToken" }
                        else if (tokenValidity() == "notChecked") { responseCode = "tokenNotChecked" }
                    }
                }
            }
            catch (e: Exception)
            {
                Log.d("Exception", e.message.toString())
                when(e)
                {
                    is IOException -> { responseCode = "noInternetConnection"}
                    is HttpException -> { responseCode = "serverError" }
                }
            }

            return responseCode
        }

        private suspend fun tokenValidity(): String
        {
            var validity = "isNotValid"
            applicationScope.launch()
            {
                withContext(Dispatchers.IO)
                {
                    val retrofit = Retrofit.Builder()
                        .baseUrl(NetworkingData.URL_BASE + database.CredentialsDAO().getBaseUrl(1))
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build()

                    val service = retrofit.create(NetworkingService::class.java)

                    try
                    {
                        service.validateToken(TokenData(database.CredentialsDAO().getToken(1))).enqueue(
                            object : Callback<Void>
                            {
                                override fun onResponse(call: Call<Void>, response: Response<Void>)
                                {
                                    when(response.code())
                                    {
                                        200 -> { validity = "isValid" }
                                        403 -> { database.CredentialsDAO().updateLoggedState(1, false) }
                                    }
                                }

                                override fun onFailure(call: Call<Void>, t: Throwable)
                                {
                                    when(t)
                                    {
                                        is IOException -> validity = "notChecked"
                                        is HttpException -> validity = "notChecked"
                                    }
                                }
                            }
                        )
                    }
                    catch (e: SocketTimeoutException) { validity = "notChecked" }
                }
            }
            return validity
        }

        suspend fun sendAndUpdateErrors(context: Context)
        {
            switchErrorControlFlow(false)

            if (isServerReachable())
            {
                val unsentErrors: MutableList<ErrorEntity> = database.errorDAO().getUnsentErrors()

                when(makeErrorsUploadRequest(convertErrorsToUpload(unsentErrors)))
                {
                    "200" ->
                    {
                        unsentErrors.forEach { it.sent = true }
                        database.errorDAO().updateErrors(unsentErrors)
                    }

                    "403" ->
                    {
                        while(true)
                        {
                            when(tokenValidity())
                            {
                                "isNotValid" ->
                                {
                                    val transactionApplication = context as TransactionApplication
                                    transactionApplication.sendIntent("go-back-to-login")
                                    break
                                }
                                "isValid" ->
                                {
                                    sendAndUpdateErrors(context)
                                    break
                                }
                                else -> delay(60000)
                            }
                        }
                    }

                    else ->
                    {
                        switchErrorControlFlow(true)
                        return
                    }
                }

            }
            else { sendAndUpdateErrors(context) }

            switchErrorControlFlow(true)
        }

        private fun makeErrorsUploadRequest(convertedErrors: MutableList<ErrorData>): String
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
                    service.uploadErrors(convertedErrors, database.CredentialsDAO().getToken(1)).enqueue(
                        object : Callback<Void>
                        {
                            override fun onResponse(call: Call<Void>, response: Response<Void>)
                            {
                                when(response.code())
                                {
                                    200 -> responseCode = "200"
                                    403 -> responseCode = "403"
                                }
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) { }
                        }
                    )
                }
            }
            return responseCode
        }

        private fun convertErrorsToUpload(unsentErrors: MutableList<ErrorEntity>): MutableList<ErrorData>
        {
            val convertedErrors: MutableList<ErrorData> = mutableListOf()

            for (i in 0 until unsentErrors.size)
            {
                convertedErrors.add(ErrorData(unsentErrors[i].errorName,
                                              unsentErrors[i].errorAddress,
                                              unsentErrors[i].smsOrigin,
                                              unsentErrors[i].date,
                                              unsentErrors[i].header))
            }

            return convertedErrors
        }

        private fun switchTransactionsControlFlow(canBeUploaded: Boolean)
        {
            applicationScope.launch()
            {
                withContext(Dispatchers.IO)
                {
                    database.ControlFlowDAO().updateUploadTransactionsControlFlow(1, canBeUploaded)
                }
            }
        }

        private fun switchErrorControlFlow(canBeUploaded: Boolean)
        {
            applicationScope.launch()
            {
                withContext(Dispatchers.IO)
                {
                    database.ControlFlowDAO().updateUploadErrorsControlFlow(1, canBeUploaded)
                }
            }
        }

        fun startAssignAccountWorker(context: Context)
        {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val assignOneTimeAccountWorkRequest = OneTimeWorkRequest.Builder(AssignAccountWorker::class.java)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniqueWork("testWorker",
                 ExistingWorkPolicy.KEEP,
                 assignOneTimeAccountWorkRequest)

            /*val assignPeriodicAccountWorkRequest = PeriodicWorkRequest.Builder(AssignAccountWorker::class.java, 15, TimeUnit.MINUTES)
                .setBackoffCriteria(BackoffPolicy.LINEAR, 1, TimeUnit.MINUTES)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork("assignAccountsWorker",
                ExistingPeriodicWorkPolicy.KEEP,
                assignPeriodicAccountWorkRequest)*/
        }
    }

    fun sendIntent(actionName: String)
    {
        applicationScope.launch()
        {
            val intent = Intent(actionName)
            LocalBroadcastManager.getInstance(this@TransactionApplication).sendBroadcast(intent)
        }
    }

    override fun onCreate()
    {
        super.onCreate()
        database = Room.databaseBuilder(this, TransactionDatabase::class.java, "TransactionDatabase")
            .addCallback(
                object : RoomDatabase.Callback()
                {
                    override fun onCreate(db: SupportSQLiteDatabase)
                    {
                        super.onCreate(db)
                        val defaultControlFlowEntity = ContentValues()

                        defaultControlFlowEntity.apply() //DataBAse issue
                        {
                            put("id", 1)
                            put("canUploadTransaction", true)
                            put("canUploadErrors", true)
                            put("canAssignAccounts", true)
                            put("canProcessSMS", false)
                        }

                        db.insert("ControlFlowEntity", OnConflictStrategy.IGNORE, defaultControlFlowEntity)
                    }
                }
            )
            .fallbackToDestructiveMigration()
            .build()
    }
}