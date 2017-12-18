package com.northlight.eyepetizer.mvp.model

import android.content.Context
import com.northlight.eyepetizer.mvp.model.bean.FindBean
import com.northlight.eyepetizer.network.ApiService
import com.northlight.eyepetizer.network.RetrofitClient
import io.reactivex.Observable

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/14 09:43
 */
class FindModel {

    fun loadData(context: Context): Observable<MutableList<FindBean>>? {
        val retrofitClient = RetrofitClient.getInstance(context)
        val apiService = retrofitClient.create(ApiService::class.java)
        return apiService?.getFindData()
    }
}