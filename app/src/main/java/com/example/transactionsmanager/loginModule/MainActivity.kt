package com.example.transactionsmanager.loginModule

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import com.example.transactionsmanager.TransactionApplication
import com.example.transactionsmanager.common.workers.AssignAccountWorker
import com.example.transactionsmanager.databinding.ActivityMainBinding
import com.example.transactionsmanager.transctionsListModule.receivers.BootCompletedEventReciever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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

        lifecycleScope.launch() // CHANGE THREADING
        {
            withContext(Dispatchers.IO)
            {
                if (TransactionApplication.database.CredentialsDAO().getLogged(1))
                {
                    //TransactionApplication.database.clearAllTables()
                    //TransactionApplication.startAssignAccountWorker(applicationContext)
                }
            }
        }

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    fun hideKeyboard(context: Context, view: View)
    {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}