package com.example.swipertestdemo.common.di

import com.example.swipertestdemo.wallet.viewModel.WalletViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val viewModelModule = module {

    viewModel { WalletViewModel(get()) }
}