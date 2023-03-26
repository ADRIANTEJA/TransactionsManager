package com.example.transactionsmanager.common.utils

object ErrorNames 
{
    const val SMS_STRUCTURE_CHANGED = "this can happen when the sms structure is changed by etecsa and it looses the range index of where to take the account number"
    const val SMS_SIZE_CHANGED = "the size of the sms changed which could mean a change or error in the sms structure" // remeber to crate an exception for size changes
}