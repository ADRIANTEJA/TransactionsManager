package com.example.transactionsmanager

import android.app.Application
import android.telephony.SmsMessage
import androidx.room.Room
import com.example.transactionsmanager.common.database.TransactionDatabase
import com.example.transactionsmanager.common.entities.ErrorEntity
import com.example.transactionsmanager.common.entities.TransactionEntity
import com.example.transactionsmanager.common.utils.Constants
import com.example.transactionsmanager.common.utils.ErrorNames
import java.util.*

class TransactionApplication : Application()
{
    companion object
    {
        lateinit var database: TransactionDatabase
        var actualDate = Calendar.getInstance(TimeZone.getTimeZone("America/Havana")) //this in miliseconds since 1994

        //this function filters the incoming sms so if it isn't from Transfermovil or not the kind of sms desired be ignored
        fun filterSMS(sms: SmsMessage): String
        {
            if ( sms.originatingAddress == Constants.TRANSFERMOVIL_ID )
            {
                return when
                {
                    sms.displayMessageBody.contains(Constants.FIRST_TYPE_FILTER) -> "first type"
                    sms.displayMessageBody.contains(Constants.SECOND_TYPE_FILTER) -> "second type"
                    else -> "none"
                }
            }
            else return "none"
        }

        //this function recieves the filterSMS function and process or ignores the sms in base to filterSMS return value
        fun processSMS(sms: SmsMessage, filterResult: String): TransactionEntity
        {
            var transaction = TransactionEntity(1, null, 1, 0.0, null, null)

            when (filterResult)
            {
                "first type" ->
                {
                    processFirstType(transaction, sms)
                }
                "second type" ->
                {
                    transaction.apply()
                    {
                        beneficiary = sms.displayMessageBody.subSequence(81, 97).toString().toLong()
                        phoneNumber = sms.displayMessageBody.subSequence(24, 34).toString().toInt()
                        date = actualDate.time.time

                        for (i in 101 until sms.displayMessageBody.length)
                        {
                            if (sms.displayMessageBody[i].toString() == "")
                            {
                                amount = sms.displayMessageBody.subSequence(101, i).toString().toDouble()
                                break
                            }
                        }
                    }
                }
            }
            return transaction
        }

        private fun processFirstType(transactionEntity: TransactionEntity, sms: SmsMessage)
        {
            try
            {
                transactionEntity.apply()
                {
                    beneficiary = sms.displayMessageBody.subSequence(49, 61).toString().toLong()
                    transactionId = sms.displayMessageBody.subSequence(97, 110).toString()
                    date = actualDate.time.time

                    for (i in 66 until sms.displayMessageBody.length)// this iterates through the sms starting from the amount first character and
                    {
                        if (sms.displayMessageBody[i].toString() == "")
                        {
                            amount = sms.displayMessageBody.subSequence(66, i).toString().toDouble()
                            break
                        }
                    }
                }
            }
            catch (e: java.lang.NumberFormatException)
            {
                val error = ErrorEntity("sms structure changed",
                                       "TransactionApplication.processFirstType",
                                                  actualDate.time.toString(),
                                                  ErrorNames.SMS_STRUCTURE_CHANGED,
                                                  sms.originatingAddress.toString() )

                database.errorDAO().addError(error)
            }
            catch (e: java.lang.IndexOutOfBoundsException)
            {
                val error = ErrorEntity("sms structure changed",
                                       "TransactionApplication.processFirstType",
                                                  actualDate.time.toString(),
                                                  ErrorNames.SMS_STRUCTURE_CHANGED,
                                                  sms.originatingAddress.toString() )

                database.errorDAO().addError(error)
            }
        }


    }

    override fun onCreate()
    {
        super.onCreate()

        database = Room.databaseBuilder(this, TransactionDatabase::class.java, "TransactionDatabase").build()
    }

    // remenber to implemet some validation functions for erros and build up the error log stuff(in the companion object)


}