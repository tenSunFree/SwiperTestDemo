@file:Suppress("unused")

package com.example.swipertestdemo.common

import android.app.Application
import com.example.swipertestdemo.common.di.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

@ExperimentalCoroutinesApi
class STDApplication : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        initKoin(repositoryModule, viewModelModule)
    }

    private fun initKoin(
        repositoryModule: Module,
        viewModelModule: Module
    ) {
        startKoin {
            androidContext(this@STDApplication)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(ContextProviderModule)
        }
    }
}