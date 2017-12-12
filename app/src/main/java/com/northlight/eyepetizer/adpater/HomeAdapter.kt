package com.northlight.eyepetizer.adpater

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.holder.HomeViewHolder
import com.northlight.eyepetizer.mvp.model.bean.HomeBean

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 12:17
 */
class HomeAdapter(var context: Context,
                  private var list: MutableList<HomeBean.IssueListBean.ItemListBean>?) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var inflater: LayoutInflater? = null

    init {
        this.inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as HomeViewHolder).bindHolder(list?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(inflater?.
                inflate(R.layout.item_home, parent, false), context)
    }


}