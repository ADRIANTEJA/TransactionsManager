package com.example.transactionsmanager.common.workers

import android.content.Context
import androidx.compose.runtime.DisposableEffect
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.transactionsmanager.TransactionApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AssignAccountWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params)
{
    override suspend fun doWork(): Result
    {
        withContext(Dispatchers.IO)
        {
            TransactionApplication.database.ControlFlowDAO().updateAssignAccountsControlFlow(1, false)
        }
        when(TransactionApplication.assignAccounts(applicationContext))
        {
            "successful" -> return Result.success()
            "noInternetConnection" -> return Result.retry()
            "serverError" -> return Result.retry()
            "tokenNotChecked" -> return Result.retry()
            "invalidToken" ->
            {
                val transactionApplication = applicationContext as TransactionApplication
                transactionApplication.sendIntent("go-back-to-login")
            }
        }
        withContext(Dispatchers.IO)
        {
            TransactionApplication.database.ControlFlowDAO().updateAssignAccountsControlFlow(1, true)
        }
        return Result.failure()
    }
}
