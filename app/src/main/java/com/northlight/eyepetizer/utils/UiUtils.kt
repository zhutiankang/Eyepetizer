package com.northlight.eyepetizer.utils

import android.content.Context

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/7 10:41
 */
object UiUtils {

    fun dip2px(context: Context, dipValue: Float): Float {
        val scale: Float = context.resources.displayMetrics.density
        return dipValue * scale + 0.5f
    }

    fun px2dip(context: Context, pxValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}