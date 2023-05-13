package com.example.transactionsmanager.transctionsListModule

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.transactionsmanager.R
import com.example.transactionsmanager.TransactionApplication
import com.example.transactionsmanager.transctionsListModule.adapters.TransactionAdapter
import com.example.transactionsmanager.databinding.FragmentTransactionsListBinding
import com.example.transactionsmanager.loginModule.model.retrofit.cardGetting.viewModel.TransactionsListViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class TransactionsListFragment : Fragment()
{
    private var transactionsListBinding: FragmentTransactionsListBinding? = null
    private val _transactionsListBinding get() = transactionsListBinding!!

    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var transactionsListViewModel: TransactionsListViewModel
    private val backToLoginReciever = object : BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent?) { goToLogin(requireView()) }
    }

    companion object : TransactionsListFragment()
    {
        fun goToLogin(view: View)
        {
            val action = TransactionsListFragmentDirections.actionTransactionsListToAccountsManagerFragment()
            view.findNavController().navigate(action)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        transactionsListBinding = FragmentTransactionsListBinding.inflate(inflater, container, false)

        setupViewModel()
        setupRecyclerView()
        return _transactionsListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        setupMenu(view, requireContext())
        LocalBroadcastManager.getInstance(requireContext())
            .registerReceiver(backToLoginReciever, IntentFilter("go-back-to-login"))
    }

    override fun onStop()
    {
        super.onStop()
        LocalBroadcastManager.getInstance(requireContext())
            .unregisterReceiver(backToLoginReciever)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        transactionsListBinding = null
    }

    private fun setupViewModel()
    {
        transactionsListViewModel = ViewModelProvider(this)[TransactionsListViewModel::class.java]
        transactionsListViewModel.getTransactions().observe( viewLifecycleOwner ) { transactions ->
            transactionAdapter.setTransactions(transactions)
        }
    }

    private fun setupRecyclerView()
    {
        transactionAdapter = TransactionAdapter(mutableListOf())
        linearLayoutManager = LinearLayoutManager(requireContext())

        _transactionsListBinding.transactionsList.apply()
        {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = transactionAdapter
        }
    }

    private fun setupMenu(view: View, context: Context)
    {
        _transactionsListBinding.bottomMenu.setOnItemReselectedListener()
        {
            when(it.itemId)
           {
                R.id.log_out_button ->
                {
                    lifecycleScope.launch()
                    {
                        withContext(Dispatchers.IO)
                        {
                            TransactionApplication.database.CredentialsDAO().updateLoggedState(1, false)
                            withContext(Dispatchers.Main) { goToLogin(view) }
                        }
                    }
                }
                R.id.update_cards_button ->
                {
                    lifecycleScope.launch()
                    {
                        withContext(Dispatchers.IO)
                        {
                            Log.d("assign flow listener", TransactionApplication.database.ControlFlowDAO().getAssignAccountsControlFlow(1).toString())
                            if (TransactionApplication.database.ControlFlowDAO().getAssignAccountsControlFlow(1))
                            {
                                TransactionApplication.assignAccounts()
                            }
                            else { callEventBusyNotification() }
                        }
                    }
                }
                R.id.upload_transactions_button ->
                {
                    lifecycleScope.launch()
                    {
                        withContext(Dispatchers.IO)
                        {
                            if (TransactionApplication.database.ControlFlowDAO().getUploadTransactionsControlFlow(1))
                            {
                                TransactionApplication.sendAndUpdateTransactions(context)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun callEventBusyNotification()
    {
        Snackbar.make(_transactionsListBinding.root,"", Snackbar.LENGTH_SHORT).apply()
        {
            setAction(" ") {} // so the SnackBar creates the view otherwise it won't
            val eventBusyWarning = view.findViewById<TextView>(com.google.android.material.R.id.snackbar_action)
            eventBusyWarning.text = getString(R.string.event_busy_message)
            eventBusyWarning.width = _transactionsListBinding.root.width
            eventBusyWarning.textAlignment = View.TEXT_ALIGNMENT_CENTER
            eventBusyWarning.setTextColor(
                ContextCompat.getColor(context,
                    R.color.fromvpn_error_color
                ))
            eventBusyWarning.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_event_busy, 0, 0, 0)
            show()
            setBackgroundTint(
                ContextCompat.getColor(context,
                    R.color.fromvpn_secondary_background_color
                ))
        }
    }
}