package com.example.swipertestdemo.common.network

import com.example.swipertestdemo.wallet.model.WalletShowsResponse
import retrofit2.http.GET

interface WalletService {

    @GET("shows")
    suspend fun fetchShowList(): List<WalletShowsResponse>
}