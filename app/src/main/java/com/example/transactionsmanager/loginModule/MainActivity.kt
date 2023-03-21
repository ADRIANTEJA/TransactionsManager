package com.example.transactionsmanager.loginModule

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import com.example.transactionsmanager.databinding.ActivityMainBinding
import com.example.transactionsmanager.transctionsListModule.receivers.BootCompletedEventReciever

open class MainActivity : AppCompatActivity()
{
    private lateinit var mainBinding: ActivityMainBinding

    companion object : MainActivity()
    {
        fun navigateUI(view: View)
        {
            val action = LoginFragmentDirections.actionLoginFragmentToAccountsManagerFragment()
            view.findNavController().navigate(action)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS), 111)
        }

        val intent = Intent(this, BootCompletedEventReciever.SMSReaderService::class.java)
        startService(intent)

        val test = "El titular del telefono 5358137588 le ha realizado una transferencia a la cuenta 9224069994689855 de 200.00 CUP. Nro. Transaccion"

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
    }

    fun hideKeyboard(context: Context, view: View)
    {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}