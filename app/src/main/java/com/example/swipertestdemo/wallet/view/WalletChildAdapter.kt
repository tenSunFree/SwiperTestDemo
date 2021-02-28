package com.example.swipertestdemo.wallet.view

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.swipertestdemo.wallet.model.WalletShowsResponse
import com.example.swipertestdemo.common.util.layoutInflater
import com.example.swipertestdemo.databinding.ItemWalletChildBinding

class WalletChildAdapter : ListAdapter<
        WalletShowsResponse, WalletChildAdapter.ViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<WalletShowsResponse>() {
        override fun areItemsTheSame(
            oldItem: WalletShowsResponse,
            newItem: WalletShowsResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: WalletShowsResponse,
            newItem: WalletShowsResponse
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemWalletChildBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WalletShowsResponse) {
            with(binding) {
                response = item
                executePendingBindings()
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemWalletChildBinding.inflate(
                    parent.context.layoutInflater,
                    parent,
                    false
                )
                return ViewHolder(binding)
            }
        }
    }
}