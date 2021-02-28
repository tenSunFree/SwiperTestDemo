package com.example.swipertestdemo.wallet.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WalletShowsDao {

    @Query("SELECT * FROM WalletShowsEntity")
    suspend fun getShows(): List<WalletShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg shows: WalletShowsEntity)
}