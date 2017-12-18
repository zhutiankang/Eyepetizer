package com.northlight.eyepetizer.mvp.contract

import com.northlight.eyepetizer.mvp.base.BasePresenter
import com.northlight.eyepetizer.mvp.base.BaseView
import com.northlight.eyepetizer.mvp.model.bean.FindBean

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/14 09:47
 */
interface FindContract{
    interface Presenter : BasePresenter {
        fun requestData()
    }

    interface View : BaseView {
        fun setData(beans: MutableList<FindBean>)
    }
}