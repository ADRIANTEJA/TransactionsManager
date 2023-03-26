package com.example.transactionsmanager

import android.app.Application
import android.telephony.SmsMessage
import android.util.Log
import androidx.room.Room
import com.example.transactionsmanager.common.database.TransactionDatabase
import com.example.transactionsmanager.common.entities.ErrorEntity
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.common.utils.Constants
import com.example.transactionsmanager.common.utils.ErrorNames
import com.example.transactionsmanager.common.utils.SmsSizeChangedException
import java.lang.Exception
import java.util.*

class TransactionApplication : Application()
{
    companion object
    {
        lateinit var database: TransactionDatabase
        val actualDate: Calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Havana")) //this in miliseconds since 1994

        //this function filters the incoming sms so if it isn't from Transfermovil or not the kind of sms desired it will be ignored
        fun filterSMS(sms: SmsMessage): String
        {
            return if ( sms.originatingAddress == "6505551212" )
            {
                when
                {
                    sms.displayMessageBody.contains(Constants.FIRST_TYPE_FILTER) -> "first type"
                    sms.displayMessageBody.contains(Constants.SECOND_TYPE_FILTER) -> "second type"
                    else -> "none"
                }
            }
            else "none"
        }

        //this function recieves the filterSMS function and process or ignores the sms in base to filterSMS return value
        fun processSMS(sms: SmsMessage, filterResult: String): TransactionEntity?
        {
            val transaction = TransactionEntity(0,1, null, 1, 0.0, null, null)

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
                if (sms.displayMessageBody.length != 110) throw SmsSizeChangedException(ErrorNames.SMS_SIZE_CHANGED)

                transactionEntity.apply()
                {
                    beneficiary = sms.displayMessageBody.subSequence(46, 62).toString().toLong()
                    transactionId = sms.displayMessageBody.subSequence(97, 110).toString()
                    date = actualDate.time.time
                    Log.d("date", date.toString())

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
                            ErrorNames.SMS_STRUCTURE_CHANGED,
                            sms.originatingAddress.toString() )
                        database.errorDAO().addError(error)
                        return false
                    }
                    is SmsSizeChangedException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processFirstType",
                            "sms size changed",
                            ErrorNames.SMS_SIZE_CHANGED,
                            sms.originatingAddress.toString())
                        database.errorDAO().addError(error)
                        return false
                    }
                }
            }
            return true
        }

        private fun isSecondTypeValid(transaction: TransactionEntity, sms: SmsMessage): Boolean
        {
            try
            {
                if (sms.displayMessageBody.length != 129) throw SmsSizeChangedException(ErrorNames.SMS_SIZE_CHANGED)

                transaction.apply()
                {
                    beneficiary = sms.displayMessageBody.subSequence(81, 97).toString().toLong()
                    phoneNumber = sms.displayMessageBody.subSequence(24, 34).toString().toLong()
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
            catch (e: Exception)
            {
                when (e)
                {
                    is java.lang.NumberFormatException, is java.lang.IndexOutOfBoundsException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processSecondType",
                            "sms structure changed",
                            ErrorNames.SMS_STRUCTURE_CHANGED,
                            sms.originatingAddress.toString() )
                        database.errorDAO().addError(error)
                        return false
                    }
                    is SmsSizeChangedException ->
                    {
                        val error = ErrorEntity(0, actualDate.time.toString(),
                            "TransactionApplication.processSecondType",
                            "sms size changed",
                            ErrorNames.SMS_SIZE_CHANGED,
                            sms.originatingAddress.toString())
                        database.errorDAO().addError(error)
                        return false
                    }
                }
            }
            return true
        }
    }
    override fun onCreate()
    {
        super.onCreate()
        database = Room.databaseBuilder(this, TransactionDatabase::class.java, "TransactionDatabase").fallbackToDestructiveMigration().build()
    }
}