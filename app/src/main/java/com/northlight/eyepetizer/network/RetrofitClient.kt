package com.northlight.eyepetizer.network

import android.content.Context
import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/8 09:10
 */
class RetrofitClient private constructor(context: Context) {
    var httpCacheDirectory: File? = null
    var cache: Cache? = null

    var okHttpClient: OkHttpClient? = null
    var retrofit: Retrofit? = null

    val TIME_OUT: Long = 20

    init {
        //缓存地址
        if (httpCacheDirectory == null) {
            httpCacheDirectory = File(context.cacheDir, "app_cache")
        }
        try {
            if (cache == null) {
                cache = Cache(httpCacheDirectory, 10 * 1024 * 1024)
            }
        } catch (e: Exception) {
            Log.e("OKHttp", "Could not create http cache", e)
        }

        //okhttp创建
        okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(
                        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(cache)
                .addInterceptor(CacheInterceptor(context))
                .addNetworkInterceptor(CacheInterceptor(context))
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build()

        //创建retrofit
        retrofit = Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    companion object {
        @Volatile
        var instance: RetrofitClient? = null

        fun getInstance(context: Context): RetrofitClient {
            if (instance == null){
                synchronized(RetrofitClient::class){
                    if (instance == null){
                        instance = RetrofitClient(context)
                    }
                }
            }
            return instance!!
        }
    }

    fun <T> create(service: Class<T>?): T? {
        if (service == null) {
            throw RuntimeException("Api Service is null!")
        }
        return retrofit?.create(service)
    }
}