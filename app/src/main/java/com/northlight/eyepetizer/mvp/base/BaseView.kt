package com.northlight.eyepetizer.mvp.base

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 11:04
 */
interface BaseView<in T> {

    fun setPresenter(presenter: T)
}