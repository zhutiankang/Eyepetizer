package com.northlight.eyepetizer.ui.fragment

import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.mvp.contract.HomeContract
import com.northlight.eyepetizer.mvp.model.bean.HomeBean
import com.northlight.eyepetizer.mvp.presenter.HomePresenter

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/7 10:40
 */
class MineFragment : BaseFragment<HomePresenter>(), HomeContract.View {
    override fun setData(homeBean: HomeBean) {
    }

    override fun getPresenter(): HomePresenter {
        return HomePresenter(context, this)
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_mine
    }

    override fun initView() {
    }
}