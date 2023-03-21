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

class BootCompletedEventReciever : BroadcastReceiver()
{
    companion object
    {
        private fun makeNotification(string: String, context: Context)
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

    class SMSReaderService : Service()
    {

        inner class SMSReciever: BroadcastReceiver()
        {
            override fun onReceive(context: Context?, intent: Intent?)
            {
                if (!intent?.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) return
                val extractMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                extractMessages.forEach { smsMessage -> makeNotification(smsMessage.displayMessageBody, applicationContext)
                    println(smsMessage.displayMessageBody)}
            }
        }

        override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
        {
            println("test")
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
    }

    override fun onReceive(context: Context?, intent: Intent?)
    {
        if (intent?.action.equals("android.intent.action.BOOT_COMPLETED")) context?.startService(Intent(context, SMSReaderService::class.java))
    }
}