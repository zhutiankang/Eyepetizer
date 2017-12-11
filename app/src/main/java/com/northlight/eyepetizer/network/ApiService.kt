package com.northlight.eyepetizer.network

import com.northlight.eyepetizer.mvp.model.bean.HomeBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/8 11:20
 */
interface ApiService {

    companion object {
        val BASE_URL = "http://baobab.kaiyanapp.com/api/"
    }

    //获取首页第一页数据
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getHomeData(): Observable<HomeBean>

    //获取首页第一页之后的数据  ?date=1499043600000&num=2
    @GET("v2/feed")
    fun getHomeMoreData(@Query("date") date: String,
                        @Query("num") num: String): Observable<HomeBean>
}