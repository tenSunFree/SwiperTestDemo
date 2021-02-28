package com.example.swipertestdemo.wallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.swipertestdemo.common.base.BaseFragment
import com.example.swipertestdemo.R
import com.example.swipertestdemo.databinding.FragmentWalletBinding

class WalletFragment : BaseFragment<FragmentWalletBinding>(
    R.layout.fragment_wallet
) {

    companion object {
        @JvmStatic
        fun newInstance() = WalletFragment()

        const val PAGE_LIMIT = 5
    }

    private val list = arrayListOf<Fragment>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (list.isNotEmpty()) list.clear()
        list.add(WalletChildFragment.newInstance())
        list.add(WalletChildFragment.newInstance())
        list.add(WalletChildFragment.newInstance())
        list.add(WalletChildFragment.newInstance())
        binding.viewPager.adapter = WalletFragmentAdapter(
            list, childFragmentManager, lifecycle
        )
        binding.viewPager.offscreenPageLimit = PAGE_LIMIT
    }
}
