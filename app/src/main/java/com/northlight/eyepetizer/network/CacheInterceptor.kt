package com.northlight.eyepetizer.network

import android.content.Context
import android.util.Log
import com.northlight.eyepetizer.utils.NetworkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/8 09:16
 */
class CacheInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        var request = chain?.request()
        if (NetworkUtils.isNetConneted(context)){
            val response = chain?.proceed(request)
            // read from cache for 60 s
            val maxAge = 60
            val cacheControl = request?.cacheControl().toString()
            Log.e("CacheInterceptor","6s load cache" + cacheControl)
            return response?.newBuilder()
                    ?.removeHeader("Pragma")
                    ?.removeHeader("Cache-Control")
                    ?.header("Cache-Control", "public, max-age=" + maxAge)
                    ?.build()
        }else{
            Log.e("CacheInterceptor", " no network load cahe")
            request = request?.newBuilder()?.cacheControl(CacheControl.FORCE_CACHE)?.build()
            val response = chain?.proceed(request)
            //set cahe times is 3 days
            val maxStale = 60 * 60 * 24 * 3
            return response?.newBuilder()
                    ?.removeHeader("Pragma")
                    ?.removeHeader("Cache-Control")
                    ?.header("Cache-Control",
                            "public, only-if-cached, max-stale=" + maxStale)
                    ?.build()
        }
    }
}