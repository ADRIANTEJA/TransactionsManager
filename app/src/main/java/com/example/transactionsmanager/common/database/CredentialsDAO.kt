package com.example.transactionsmanager.common.database

import androidx.room.*
import com.example.transactionsmanager.common.entities.CredentialsEntity

@Dao
interface CredentialsDAO
{
    @Query("SELECT * FROM CredentialsEntity")
    fun getCredentials() : MutableList<CredentialsEntity>

    @Query("SELECT baseUrl FROM CredentialsEntity WHERE id = :userId")
    fun getBaseUrl(userId: Int): String

    @Query("SELECT logged FROM CredentialsEntity WHERE id = :userId")
    fun getLogged(userId: Int): Boolean

    @Query("UPDATE CredentialsEntity SET logged = :loggedState WHERE id = :userId")
    fun updateLoggedState(userId: Int, loggedState: Boolean)

    @Query("SELECT token FROM CredentialsEntity Where id = :userId")
    fun getToken(userId: Int): String

    @Update
    fun updateCredentials(credentials: CredentialsEntity)

    @Insert
    fun insertCredentials(credentials: CredentialsEntity)
}