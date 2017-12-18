package com.northlight.eyepetizer.holder

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.mvp.model.bean.FindBean
import com.northlight.eyepetizer.utils.ImageLoadUtils

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/18 09:43
 */
class FindViewHolder(itemView: View?, var context: Context) : RecyclerView.ViewHolder(itemView) {

    private var tv_title: TextView? = null
    private var iv_photo: ImageView? = null

    init {
        tv_title = itemView?.findViewById(R.id.tv_title)
        iv_photo = itemView?.findViewById(R.id.iv_photo)

        tv_title?.typeface = Typeface.createFromAsset(context.assets,
                "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF")
    }

    fun bindHolder(bean:FindBean?){
        ImageLoadUtils.display(context,iv_photo, bean?.bgPicture!!)
        tv_title?.text = bean.name

        itemView.setOnClickListener {
            // TODO 点击跳转事件
        }
    }
}