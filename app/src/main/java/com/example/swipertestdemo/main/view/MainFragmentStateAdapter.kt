package com.example.swipertestdemo.main.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.swipertestdemo.chat.ChatFragment
import com.example.swipertestdemo.explore.ExploreFragment
import com.example.swipertestdemo.phone.PhoneFragment
import com.example.swipertestdemo.scan.ScanFragment
import com.example.swipertestdemo.wallet.view.WalletFragment

class MainFragmentStateAdapter(
    fragmentManager: FragmentManager, lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object {
        private const val COUNT = 5
    }

    init {
        for (i in 0 until COUNT) createFragment(i)
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PhoneFragment.newInstance()
            1 -> ChatFragment.newInstance()
            2 -> ScanFragment.newInstance()
            3 -> ExploreFragment.newInstance()
            4 -> WalletFragment.newInstance()
            else -> throw RuntimeException("$position")
        }
    }

    override fun getItemCount(): Int {
        return COUNT
    }
}