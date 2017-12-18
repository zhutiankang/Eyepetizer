package com.northlight.eyepetizer.adpater

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.holder.FindViewHolder
import com.northlight.eyepetizer.mvp.model.bean.FindBean

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 12:17
 */
class FindAdapter(var context: Context,
                  var list: MutableList<FindBean>?) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var inflater: LayoutInflater? = null

    init {
        this.inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as FindViewHolder).bindHolder(list?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return FindViewHolder(inflater?.
                inflate(R.layout.item_find, parent, false), context)
    }


}