package com.example.application

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingComponents {


    @JvmStatic
    @BindingAdapter("setImageFromUrl")
    fun setImageFromUrl(imageView: ImageView, image: Int) {
        imageView.setImageResource(image);
    }

}