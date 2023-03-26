package com.example.transactionsmanager.loginModule

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.transactionsmanager.loginModule.model.retrofit.LoginService
import com.example.transactionsmanager.R
import com.example.transactionsmanager.TransactionApplication
import com.example.transactionsmanager.databinding.LoginFragmentBinding
import com.example.transactionsmanager.loginModule.model.Constants
import com.example.transactionsmanager.loginModule.model.retrofit.LoginResponse
import com.example.transactionsmanager.loginModule.model.retrofit.UserData
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class LoginFragment: Fragment()
{
    private var loginBinding: LoginFragmentBinding? = null
    private val _loginBinding get() = loginBinding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        loginBinding = LoginFragmentBinding.inflate(inflater, container, false)
        return _loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        //val loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        _loginBinding.loginButton.setOnClickListener { login(view) }

        //here remenber to implement the condition login automatically provided the token sent to the server is right or else call login funtion again
    }

    override fun onDestroy()
    {
        loginBinding = null
        super.onDestroy()
    }

    private fun login(view: View)
    {
        val userName = _loginBinding.userField.text.toString()
        val address = _loginBinding.addressField.text.toString()
        val password = _loginBinding.passwordField.text.toString()

        if(!isInputDataValid(userName, address, password)) return

        if(isOnline(requireContext()))
        {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(LoginService::class.java)
            service.login(UserData(userName, password)).enqueue(
                object : Callback<LoginResponse>
                {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>)
                    {
                        MainActivity.navigateUI(view)
                    }
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable)
                    {
                        _loginBinding.errorLabel.text = getString(R.string.error_400)
                    }
                }
            )
        } else { return }
        return
    }

    private fun isInputDataValid(userFieldInput: String, addressFieldInput: String, passwordFieldInput: String): Boolean
    {
        var checker = 0
        ArrayList<String>().apply()
        {
            add(userFieldInput)
            add(addressFieldInput)
            add(passwordFieldInput)
            for (i in 0 until this.size)
            {
                when
                {
                    ((i == 0) && (this[i] == ""))  ->
                    {
                        _loginBinding.userFieldTemplate.apply()
                        {
                            inputFieldsEventHandling(this)
                            checker++
                        }
                    }
                    ((i == 1) && (this[i] == ""))  ->
                    {
                        _loginBinding.addressFieldTemplate.apply()
                        {
                            inputFieldsEventHandling(this)
                        }
                        checker++
                    }
                    ((i == 2) && (this[i] == "")) ->
                    {
                        _loginBinding.passwordFieldTemplate.apply()
                        {
                            inputFieldsEventHandling(this)
                        }
                        checker++
                    }
                    else -> {}
                }
            }
            inputFieldsRestoring(_loginBinding.userFieldTemplate, userFieldInput)
            inputFieldsRestoring(_loginBinding.addressFieldTemplate, addressFieldInput)
            inputFieldsRestoring(_loginBinding.passwordFieldTemplate, passwordFieldInput)
            return checker == 0
        }
    }

    private fun isOnline(context: Context): Boolean
    {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if(connectivityManager.activeNetwork != null) return true
        else
        {
            Snackbar.make(_loginBinding.loginButton,"", Snackbar.LENGTH_SHORT).apply()
            {
                setAction(" ") {} // so the SnackBar creates the view otherwise it won't
                val noConnectionWarning = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
                noConnectionWarning.text = getString(R.string.no_connection_message)
                noConnectionWarning.width = _loginBinding.loginFragment.width
                noConnectionWarning.textAlignment = View.TEXT_ALIGNMENT_CENTER
                noConnectionWarning.setTextColor(
                    ContextCompat.getColor(context,
                    R.color.fromvpn_error_color
                ))
                noConnectionWarning.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_no_connection, 0, 0, 0)
                show()
                setBackgroundTint(
                    ContextCompat.getColor(context,
                    R.color.fromvpn_secondary_background_color
                ))
            }
            MainActivity.hideKeyboard(context, this.requireView())

            return false
        }
    }

    private fun inputFieldsEventHandling(field: TextInputLayout)
    {
        field.apply()
        {
            setBoxStrokeColorStateList(
                ContextCompat.getColorStateList(context,
                R.color.input_field_on_error_color_selector
            )!!)
            helperText = getString(R.string.field_required_warning)
            setHelperTextColor(
                ContextCompat.getColorStateList(context,
                R.color.input_field_on_error_color_selector
            ))
        }
    }

    private  fun inputFieldsRestoring(field: TextInputLayout, fieldText: String)
    {
        if(fieldText != "")
        {
            field.apply()
            {
                setBoxStrokeColorStateList(
                    ContextCompat.getColorStateList(context,
                    R.color.input_field_color_selector
                )!!)
                helperText = ""
                setHelperTextColor(
                    ContextCompat.getColorStateList(context,
                    R.color.input_field_color_selector
                ))
            }
        }
    }
}


