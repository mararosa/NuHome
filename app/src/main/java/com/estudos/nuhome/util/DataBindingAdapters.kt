package com.estudos.nuhome.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingAdapters {

    @BindingAdapter("nuIcon")
    @JvmStatic
    fun setImageResource(imageView: ImageView, resource: Int) {
        imageView.setImageResource(resource);
    }
}