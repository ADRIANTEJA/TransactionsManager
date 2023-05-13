package com.example.transactionsmanager.common.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.transactionsmanager.TransactionApplication
import com.example.transactionsmanager.common.entities.ControlFlowEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AssignAccountWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params)
{
    override suspend fun doWork(): Result
    {
        withContext(Dispatchers.IO)
        {
            Log.d("accountsControlFlow", TransactionApplication.database.ControlFlowDAO().getAssignAccountsControlFlow(1).toString())
            TransactionApplication.database.ControlFlowDAO().updateAssignAccountsControlFlow(1, false)

            if (TransactionApplication.database.CardDAO().getAllCards().isEmpty())
            {
                TransactionApplication.database.ControlFlowDAO().updateProcessSMSControlFlow(1, false)
            }
            else
            {
                TransactionApplication.database.ControlFlowDAO().updateProcessSMSControlFlow(1, true)
            }
            Log.d("working", "one time")
        }
        when (TransactionApplication.assignAccounts())
        {
            "successful" ->
            {
                switchAssignAccountsControlFlow(true)
                Log.d("cards", TransactionApplication.database.CardDAO().getAllCards().toString())
                return Result.success()
            }
            "tokenNotChecked" ->
            {
                switchAssignAccountsControlFlow(true)
                return Result.retry()
            }
            "invalidToken" ->
            {
                Log.d("invalid Token", "true")
                switchAssignAccountsControlFlow(true)
                val transactionApplication = applicationContext as TransactionApplication
                transactionApplication.sendIntent("go-back-to-login")
            }
        }
        Log.d("accountsControlFlow", TransactionApplication.database.ControlFlowDAO().getAssignAccountsControlFlow(1).toString())
        switchAssignAccountsControlFlow(true)
        Log.d("accountsControlFlow", TransactionApplication.database.ControlFlowDAO().getAssignAccountsControlFlow(1).toString())
        return Result.failure()
    }

    private suspend fun switchAssignAccountsControlFlow(canBeAssigned: Boolean)
    {
        Log.d("outside withContext", "happens")
        withContext(Dispatchers.IO)
        {
            Log.d("inside withContext", "happens")
            TransactionApplication.database.ControlFlowDAO().updateAssignAccountsControlFlow(1, canBeAssigned)
        }
    }
}
