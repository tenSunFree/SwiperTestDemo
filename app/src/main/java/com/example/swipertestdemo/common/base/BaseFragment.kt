package com.example.swipertestdemo.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open class BaseFragment<VDB : ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : Fragment() {

    lateinit var binding: VDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater, layoutId, container, false
        ) as VDB
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        return binding.root
    }
}