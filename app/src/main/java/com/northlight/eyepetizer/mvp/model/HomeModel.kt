package com.northlight.eyepetizer.mvp.model

import android.content.Context
import com.northlight.eyepetizer.mvp.model.bean.HomeBean
import com.northlight.eyepetizer.network.ApiService
import com.northlight.eyepetizer.network.RetrofitClient
import io.reactivex.Observable

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 11:08
 */
class HomeModel {

    fun loadData(context: Context, isFirst: Boolean, data: String?): Observable<HomeBean>? {
        val retrofitClient = RetrofitClient.getInstance(context)
        val apiService = retrofitClient.create(ApiService::class.java)

        return when (isFirst) {
            true -> apiService?.getHomeData()

            false -> apiService?.getHomeMoreData(data.toString(), "2")
        }
    }
}