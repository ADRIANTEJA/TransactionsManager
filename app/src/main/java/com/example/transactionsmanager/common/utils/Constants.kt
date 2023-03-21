package com.example.transactionsmanager.common.utils

object Constants
{
    //Transfermovil SMS filters
    const val TRANSFERMOVIL_ID = "PAGOxMOVIL"
    const val FIRST_TYPE_FILTER = "Se ha realizado una transferencia a la cuenta"
    const val SECOND_TYPE_FILTER = "El titular del telefono"
    const val COMMON_FILTER = "Nro. Transaccion"
    const val BENEFICIARY_SEARCH_FILTER = "cuenta "
    const val PHONE_NUMBER_SEARCH_FILTER = "El titular del telefono " //it is not the same as SECOND_TYPE_FILTER as this have a space at the end
    const val AMOUNT_SEARCH_FILTER = "de "
    const val TRANSACTION_ID_SEARCH_FILTER = "Nro. Transaccion"
}