package com.example.swipertestdemo.wallet.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swipertestdemo.wallet.model.WalletShowsResponse
import com.example.swipertestdemo.wallet.model.WalletRepository
import com.example.swipertestdemo.common.util.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class WalletViewModel(
    private val repository: WalletRepository
) : ViewModel() {

    private val _showsStateFlow = repository.showsStateFlow
    val showsStateFlow: StateFlow<Resource<List<WalletShowsResponse>>>
        get() = _showsStateFlow

    init {
        refreshShows()
    }

    fun refreshShows() {
        viewModelScope.launch {
            repository.fetchShows()
        }
    }
}