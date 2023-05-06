package com.example.transactionsmanager.transctionsListModule.receivers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder
import android.provider.Telephony
import androidx.core.app.NotificationCompat
import com.example.transactionsmanager.R
import com.example.transactionsmanager.TransactionApplication
import kotlinx.coroutines.*

class BootCompletedEventReciever : BroadcastReceiver()
{
    companion object
    {
        private fun makeNotification(string: String, context: Context)// this is not needed remember to delete on launch
        {
            val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val notificationChannel = NotificationChannel("test1", "test2", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)

            val notificationBuilder = NotificationCompat.Builder(context, "test1")
                .setContentText(string)
                .setContentTitle("jajaja")
                .setSubText("jefbefb")
                .setSmallIcon(R.drawable.ic_launcher_background)
            notificationManager.notify(1234, notificationBuilder.build())
        }
    }
    // this gets the incoming sms, process and storages them in the database
    class SMSReaderService : Service()
    {
        private val serviceScope = CoroutineScope(Job())
        private var smsCollectorTimer = TransactionApplication.createSmsCollectorTrigger(this)

        inner class SMSReciever: BroadcastReceiver()
        {
            override fun onReceive(context: Context?, intent: Intent?)
            {
                if (!intent?.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) return
                val extractMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                extractMessages.forEach { smsMessage ->
                    makeNotification(smsMessage.displayMessageBody, applicationContext)// REMEMBER TO DELETE THIS
                    serviceScope.launch()
                    {
                        withContext(Dispatchers.IO)
                        {
                            if (TransactionApplication.processSMS(smsMessage, TransactionApplication.filterSMS(smsMessage)) != null)
                            {
                                TransactionApplication.database.transactionDAO().addTransaction(TransactionApplication.processSMS(smsMessage, TransactionApplication.filterSMS(smsMessage))!!)
                                smsCollectorTimer.cancel()
                                smsCollectorTimer.start()
                            }
                        }
                    }
                }
            }
        }

        // this makes sure the reciever is always working in the background even after device reboots
        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
        {
            val broadCastReceiver = SMSReciever()
            val notificationManager: NotificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notificationChannel = NotificationChannel("test1", "test2", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)

            val notification = NotificationCompat.Builder(this, "test1")
                .setContentTitle("SMS Reciever")
                .setContentText("Recibiendo...")
                .setSmallIcon(R.drawable.fromvpn_notification_icon)
                .build()
            registerReceiver(broadCastReceiver, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
            startForeground(1, notification)

            return START_STICKY
        }

        override fun onBind(intent: Intent?): IBinder? { return null }

        override fun onDestroy()
        {
            super.onDestroy()
            serviceScope.cancel()
        }
    }

    override fun onReceive(context: Context?, intent: Intent?)
    {
        if (intent?.action.equals("android.intent.action.BOOT_COMPLETED")) context?.startService(Intent(context, SMSReaderService::class.java))
    }
}