package com.example.swipertestdemo.chat

import com.example.swipertestdemo.common.base.BaseFragment
import com.example.swipertestdemo.R
import com.example.swipertestdemo.databinding.FragmentChatBinding

class ChatFragment : BaseFragment<FragmentChatBinding>(R.layout.fragment_chat) {

    companion object {
        @JvmStatic
        fun newInstance() = ChatFragment()
    }
}
