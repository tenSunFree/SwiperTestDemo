package com.example.swipertestdemo.common.di

import com.example.swipertestdemo.wallet.model.WalletRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val repositoryModule = module {

    single {
        WalletRepository(
            get(),
            get(),
            get(),
            get()
        )
    }
}