package com.example.transactionsmanager.common.database

import androidx.room.*
import com.example.transactionsmanager.common.entities.ErrorEntity

@Dao
interface ErrorDAO
{
    @Query("SELECT * FROM ErrorEntity")
    fun getAllErrors() : MutableList<ErrorEntity>

    @Insert
    fun addError(errorEntity: ErrorEntity)

    @Delete
    fun deleteError(errorEntity: ErrorEntity)
}