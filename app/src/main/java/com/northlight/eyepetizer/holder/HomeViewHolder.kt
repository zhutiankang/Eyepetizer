package com.northlight.eyepetizer.holder

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.mvp.model.bean.HomeBean
import com.northlight.eyepetizer.utils.ImageLoadUtils

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 16:50
 */
class HomeViewHolder(itemView: View?, var context: Context) :
        RecyclerView.ViewHolder(itemView) {

    private var tv_title: TextView? = null
    private var tv_detail: TextView? = null
    private var iv_photo: ImageView? = null
    private var iv_user: ImageView? = null

    init {
        iv_photo = itemView?.findViewById(R.id.iv_photo)
        iv_user = itemView?.findViewById(R.id.iv_user)
        tv_detail = itemView?.findViewById(R.id.tv_detail)
        tv_title = itemView?.findViewById(R.id.tv_title)

        tv_title?.typeface = Typeface.createFromAsset(context.assets,
                "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF")
    }

    @SuppressLint("SetTextI18n")
    fun bindHolder(bean: HomeBean.IssueListBean.ItemListBean?) {
        tv_title?.text = bean?.data?.title

        val category = bean?.data?.category
        val minute = bean?.data?.duration?.div(60) as Long
        val second = bean.data?.duration?.minus((minute.times(60))) as Long
        val realMinute: String
        val realSecond: String
        realMinute = if (minute < 10) {
            "0" + minute
        } else {
            minute.toString()
        }
        realSecond = if (second < 10) {
            "0" + second
        } else {
            second.toString()
        }
        tv_detail?.text = "发布于 $category / $realMinute:$realSecond"

        val photo = bean.data?.cover?.feed
        ImageLoadUtils.display(context, iv_photo, photo as String)


        val author = bean.data?.author
        if (author != null) {
            ImageLoadUtils.display(context, iv_user, author.icon)
        } else {
            iv_user?.visibility = View.GONE
        }

//        val playUrl = bean.data?.playUrl
        itemView.setOnClickListener {
            //跳转视频详情页
        }
//        val time = bean?.data?.releaseTime
//        val calendar: Calendar = Calendar.getInstance()
//        calendar.time = Date(time!!)
//        val releaseIndex: Int = calendar.get(Calendar.DAY_OF_WEEK)
//
//        calendar.time = Date()
//        val currentIndex = calendar.get(Calendar.DAY_OF_WEEK)
//        val index = currentIndex - releaseIndex
//        if (index == 0){
//            tv_time?.text = "今天"
//        }else{
//            tv_time?.text = "$index 天前"
//        }
    }

}