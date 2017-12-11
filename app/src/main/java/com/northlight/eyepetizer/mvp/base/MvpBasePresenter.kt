package com.northlight.eyepetizer.mvp.base

import java.lang.ref.WeakReference

/**
 * author : 祝天康
 * tips   : 复杂写法 用弱引用 attachView
 * date   : 2017/12/11 19:35
 */
abstract class MvpBasePresenter<T : BaseView> : BasePresenter {
    private var viewRef: WeakReference<T>? = null

    fun attachView(view: T) {
        viewRef = WeakReference(view)
    }

    fun detachView() {
        viewRef?.clear()
        viewRef = null
    }

    fun getView(): T? {
        return viewRef?.get()
    }

}