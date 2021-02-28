package com.example.swipertestdemo.explore

import com.example.swipertestdemo.R
import com.example.swipertestdemo.common.base.BaseFragment
import com.example.swipertestdemo.databinding.FragmentExploreBinding

class ExploreFragment : BaseFragment<FragmentExploreBinding>(R.layout.fragment_explore) {

    companion object {
        @JvmStatic
        fun newInstance() = ExploreFragment()
    }
}
