package com.northlight.eyepetizer.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/6 10:58
 */
object NetworkUtils {

    fun isNetConneted(context: Context): Boolean {
        val connectManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectManager.activeNetworkInfo
        return if (networkInfo == null) {
            false
        } else {
            networkInfo.isAvailable && networkInfo.isConnected
        }
    }

    fun isNetworkConnected(context: Context, typeMobile: Int): Boolean {
        if (!isNetConneted(context)) {
            return false
        }
        val connectManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectManager.getNetworkInfo(typeMobile)
        return if (networkInfo == null) {
            false
        } else {
            networkInfo.isAvailable && networkInfo.isConnected
        }
    }

    fun isPhoneNetConnected(context: Context): Boolean {
        val typeMobile = ConnectivityManager.TYPE_MOBILE
        return isNetworkConnected(context, typeMobile)
    }

    fun isWifiNetConnected(context: Context): Boolean {
        val typeMobile = ConnectivityManager.TYPE_WIFI
        return isNetworkConnected(context, typeMobile)
    }
}