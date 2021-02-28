package com.example.swipertestdemo.main.view

import com.example.swipertestdemo.common.base.BaseActivity
import com.example.swipertestdemo.R
import com.example.swipertestdemo.common.util.show
import com.example.swipertestdemo.databinding.ActivityMainBinding
import com.example.swipertestdemo.main.model.MainModel

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    override fun initView() {
        binding.viewPager.adapter =
            MainFragmentStateAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.isUserInputEnabled = false
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_phone -> binding.viewPager.show(MainModel.PHONE)
                R.id.item_chat -> binding.viewPager.show(MainModel.CHAT)
                R.id.item_scan -> binding.viewPager.show(MainModel.SCAN)
                R.id.item_explore -> binding.viewPager.show(MainModel.EXPLORE)
                R.id.item_wallet -> binding.viewPager.show(MainModel.WALLET)
                else -> throw RuntimeException()
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}