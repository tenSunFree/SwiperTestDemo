package com.example.swipertestdemo.common.di

import androidx.room.Room
import com.example.swipertestdemo.R
import com.example.swipertestdemo.common.database.STDDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room
            .databaseBuilder(
                androidApplication(), STDDatabase::class.java,
                androidApplication().getString(R.string.database)
            )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<STDDatabase>().walletShowsDao }
}