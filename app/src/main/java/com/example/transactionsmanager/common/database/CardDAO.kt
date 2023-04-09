package com.example.transactionsmanager.common.database

import androidx.room.*
import com.example.transactionsmanager.common.entities.CardEntity

@Dao
interface CardDAO
{
    @Query("SELECT * FROM CardEntity")
    fun getAllCards() : MutableList<CardEntity>

    @Insert
    fun addCard(card: CardEntity)

    @Query("DELETE FROM CardEntity")
    fun deleteAllCards()

    @Query("SELECT * FROM CardEntity WHERE cardNumber = :cardNumber")
    fun findByCardNumber(cardNumber: Long): CardEntity?
}