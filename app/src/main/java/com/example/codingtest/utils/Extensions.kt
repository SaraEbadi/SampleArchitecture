package com.example.codingtest.utils

import android.view.LayoutInflater
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

inline fun <T : ViewBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(layoutInflater)
}

fun ImageView.glide(url: String?, @DrawableRes placeHolder : Int? = null) {
    val request =
        Glide.with(this.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
    placeHolder?.let { request.error(it) }
    request.into(this)
}