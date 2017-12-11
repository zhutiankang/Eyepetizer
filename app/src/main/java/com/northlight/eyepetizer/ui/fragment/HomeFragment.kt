package com.northlight.eyepetizer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.adpater.HomeAdapter
import com.northlight.eyepetizer.mvp.contract.HomeContract
import com.northlight.eyepetizer.mvp.model.bean.HomeBean
import com.northlight.eyepetizer.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * author : 祝天康
 * tips   : Kotlin java 无缝连接 直接可以混合开发
 * date   : 2017/12/7 10:33
 */

class HomeFragment : BaseFragment<HomePresenter>(), HomeContract.View {

    override fun getPresenter(): HomePresenter {
        return HomePresenter(context, this)
    }


    private var mAdapter: HomeAdapter? = null
    private var mList = ArrayList<HomeBean.IssueListBean.ItemListBean>()

    override fun setData(homeBean: HomeBean) {
        //return 语句可为null 不能用? 只能用!! 平时情况调用两者都可用
        //map映射集合 flatMap展开铺平集合 直接可以用里面的元素 适用于集合嵌套集合
        homeBean.issueList!!
                .flatMap { it.itemList!! }
                .filter { it.type.equals("video") }
                .forEach { mList.add(it) }
        mAdapter?.list = mList
        mAdapter?.notifyDataSetChanged()
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        mPresenter?.start()
        rv_home.layoutManager = LinearLayoutManager(context)
        mAdapter = HomeAdapter(context, mList)
        rv_home.adapter = mAdapter
    }
}
