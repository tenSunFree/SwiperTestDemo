package com.example.swipertestdemo.common.di

import com.example.swipertestdemo.common.util.CoroutineContextProvider
import org.koin.dsl.module

val ContextProviderModule = module {
    single { CoroutineContextProvider() }
}