package com.example.swipertestdemo.common.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun bindLoadImage(view: AppCompatImageView, url: String) {
    Glide.with(view.context).load(url).into(view)
}