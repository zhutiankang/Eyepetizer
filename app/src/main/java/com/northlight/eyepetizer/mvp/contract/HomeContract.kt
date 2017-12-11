package com.northlight.eyepetizer.mvp.contract

import com.northlight.eyepetizer.mvp.base.BasePresenter
import com.northlight.eyepetizer.mvp.base.BaseView
import com.northlight.eyepetizer.mvp.model.bean.HomeBean

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 11:07
 */
interface HomeContract{

    interface Presenter : BasePresenter{
        fun requestData()
    }

    interface View : BaseView<Presenter>{
        fun setData(list: MutableList<HomeBean>)
    }

}