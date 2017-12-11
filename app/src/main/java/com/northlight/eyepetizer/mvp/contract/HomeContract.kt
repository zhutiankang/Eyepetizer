package com.northlight.eyepetizer.mvp.contract

import com.northlight.eyepetizer.mvp.base.BasePresenter
import com.northlight.eyepetizer.mvp.base.BaseView
import com.northlight.eyepetizer.mvp.model.bean.HomeBean

/**
 * author : 祝天康
 * tips   : Base类抽取出相同的业务逻辑都有start setPresenter。
 *          HomeContract编写首页独有的业务逻辑 requestData() setData等等
 * date   : 2017/12/11 11:07
 */
interface HomeContract {

    interface Presenter : BasePresenter {
        fun requestData()
    }

    interface View : BaseView {
        fun setData(homeBean: HomeBean)
    }

}