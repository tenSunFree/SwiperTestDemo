package com.example.swipertestdemo.common.database

import androidx.room.*
import com.example.swipertestdemo.wallet.model.WalletShowsDao
import com.example.swipertestdemo.wallet.model.WalletShowsEntity

@Database(entities = [WalletShowsEntity::class], version = 1, exportSchema = false)
abstract class STDDatabase : RoomDatabase() {
    abstract val walletShowsDao: WalletShowsDao
}