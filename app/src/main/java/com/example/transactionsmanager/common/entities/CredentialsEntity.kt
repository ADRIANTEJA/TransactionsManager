package com.example.transactionsmanager.common.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CredentialsEntity")
data class CredentialsEntity (@PrimaryKey var id: Int,
                                var userName: String,
                                var token: String,
                                var logged: Boolean = false,
                                var instanceId: String,
                                var baseUrl: String)