package com.example.transactionsmanager.loginModule

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import androidx.work.BackoffPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.transactionsmanager.TransactionApplication
import com.example.transactionsmanager.common.workers.AssignAccountWorker
import com.example.transactionsmanager.databinding.ActivityMainBinding
import com.example.transactionsmanager.transctionsListModule.TransactionsListFragmentDirections
import com.example.transactionsmanager.transctionsListModule.receivers.BootCompletedEventReciever
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

open class MainActivity : AppCompatActivity()
{
    private lateinit var mainBinding: ActivityMainBinding

    companion object : MainActivity()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS), 111)
        }

        val intent = Intent(this, BootCompletedEventReciever.SMSReaderService::class.java)
        startService(intent)

        //remember to check everything is fine with this
        /*val assignAccountWorkRequest = PeriodicWorkRequestBuilder<AssignAccountWorker>(1, TimeUnit.HOURS)
            .setBackoffCriteria(BackoffPolicy.LINEAR, 1, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(this).enqueue(assignAccountWorkRequest)*/

        val date = TransactionApplication.actualDate.time // this is an example of using date remove later
        val dateFormat = SimpleDateFormat("dd/MM/yy h:m a", Locale.US)
        val formattedDate = dateFormat.format(date)
        println(formattedDate)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    fun hideKeyboard(context: Context, view: View)
    {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}