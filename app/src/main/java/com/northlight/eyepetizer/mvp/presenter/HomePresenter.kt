package com.northlight.eyepetizer.mvp.presenter

import com.northlight.eyepetizer.mvp.contract.HomeContract

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 11:06
 */
class HomePresenter : HomeContract.Presenter {
    override fun start() {
        requestData()
    }

    override fun requestData() {
    }
}