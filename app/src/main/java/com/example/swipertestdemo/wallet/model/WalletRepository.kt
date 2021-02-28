package com.example.swipertestdemo.wallet.model

import android.content.Context
import android.util.Log
import com.example.swipertestdemo.R
import com.example.swipertestdemo.common.network.WalletService
import com.example.swipertestdemo.common.util.Resource
import com.example.swipertestdemo.common.util.CoroutineContextProvider
import com.example.swipertestdemo.common.util.isNetworkAvailable
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
class WalletRepository(
    private val dao: WalletShowsDao,
    private val api: WalletService,
    private val context: Context,
    private val contextProvider: CoroutineContextProvider
) {

    private val _showsStateFlow = MutableStateFlow<Resource<List<WalletShowsResponse>>>(Resource.loading())
    val showsStateFlow: StateFlow<Resource<List<WalletShowsResponse>>>
        get() = _showsStateFlow

    suspend fun fetchShows() {
        _showsStateFlow.value = Resource.loading()
        dao.getShows().let { showsFromDb ->
            flow {
                if (showsFromDb.isEmpty()) {
                    if (context.isNetworkAvailable()) {
                        emit(Resource.success(getShowsFromRemoteDataSource()))
                    } else {
                        emit(Resource.error(context.getString(R.string.failed_network_msg)))
                    }
                } else {
                    emit(Resource.success(showsFromDb.asDomainModel()))
                    try {
                        emit(Resource.success(getShowsFromRemoteDataSource()))
                    } catch (err: Exception) {
                        Log.e("Exception", err.toString())
                    }
                }
            }
        }.flowOn(contextProvider.io)
            .catch {
                _showsStateFlow.value = Resource.error(context.getString(R.string.failed_loading_msg))
            }.collect {
                _showsStateFlow.value = it
            }
    }

    private suspend fun getShowsFromRemoteDataSource(): List<WalletShowsResponse> {
        val list = api.fetchShowList()
        dao.insertAll(*list.asDatabaseModel())
        return list
    }
}