package com.example.swipertestdemo.phone

import com.example.swipertestdemo.R
import com.example.swipertestdemo.common.base.BaseFragment
import com.example.swipertestdemo.databinding.FragmentPhoneBinding

class PhoneFragment : BaseFragment<FragmentPhoneBinding>(R.layout.fragment_phone) {

    companion object {
        @JvmStatic
        fun newInstance() = PhoneFragment()
    }
}
