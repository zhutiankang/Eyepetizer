package com.northlight.eyepetizer.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.northlight.eyepetizer.R

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 16:20
 */
class ImageLoadUtils {

    companion object {
        fun display(context: Context,imageView:ImageView?,url:String){
            if (imageView == null){
                throw IllegalArgumentException("argument error imageView is null")
            }
            Glide.with(context)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_image_loading)
                    .error(R.mipmap.ic_empty_picture)
                    .crossFade()
                    .into(imageView)
        }
    }
}