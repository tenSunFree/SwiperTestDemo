package com.example.swipertestdemo.wallet.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.swipertestdemo.common.base.BaseFragment
import com.example.swipertestdemo.R
import com.example.swipertestdemo.common.util.Resource
import com.example.swipertestdemo.common.util.hide
import com.example.swipertestdemo.common.util.show
import com.example.swipertestdemo.databinding.FragmentWalletChildBinding
import com.example.swipertestdemo.wallet.viewModel.WalletViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.getViewModel

class WalletChildFragment : BaseFragment<FragmentWalletChildBinding>(
    R.layout.fragment_wallet_child
) {

    companion object {
        @JvmStatic
        fun newInstance() = WalletChildFragment()
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = getViewModel<WalletViewModel>()
        val adapter = WalletChildAdapter()
        binding.recyclerView.adapter = adapter
        binding.button.setOnClickListener {
            viewModel.refreshShows()
        }
        requireActivity().lifecycleScope.launch {
            viewModel.showsStateFlow.collect { resource ->
                when (resource.status) {
                    Resource.Status.SUCCESS -> {
                        binding.progressBar.hide()
                        binding.linearLayout.hide()
                        adapter.submitList(resource.data)
                    }
                    Resource.Status.LOADING -> {
                        binding.progressBar.show()
                        binding.linearLayout.hide()
                    }
                    Resource.Status.ERROR -> {
                        binding.progressBar.hide()
                        binding.linearLayout.show()
                        binding.textView.text = resource.message
                    }
                }
            }
        }
    }
}
