package com.example.swipertestdemo.scan

import com.example.swipertestdemo.common.base.BaseFragment
import com.example.swipertestdemo.R
import com.example.swipertestdemo.databinding.FragmentScanBinding

class ScanFragment : BaseFragment<FragmentScanBinding>(R.layout.fragment_scan) {

    companion object {
        @JvmStatic
        fun newInstance() = ScanFragment()
    }
}
