package com.example.swipertestdemo.common.util

import android.view.View
import androidx.viewpager2.widget.ViewPager2

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun ViewPager2.show(position: Int){
    this.setCurrentItem(position, false)
}