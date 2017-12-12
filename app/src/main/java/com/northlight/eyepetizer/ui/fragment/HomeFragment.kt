package com.northlight.eyepetizer.ui.fragment

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.adpater.HomeAdapter
import com.northlight.eyepetizer.mvp.contract.HomeContract
import com.northlight.eyepetizer.mvp.model.bean.HomeBean
import com.northlight.eyepetizer.mvp.presenter.HomePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.regex.Pattern

/**
 * author : 祝天康
 * tips   : Kotlin java 无缝连接 直接可以混合开发
 * date   : 2017/12/7 10:33
 */

class HomeFragment : BaseFragment<HomePresenter>(), HomeContract.View,
        SwipeRefreshLayout.OnRefreshListener {


    private var mAdapter: HomeAdapter? = null
    private var mList = ArrayList<HomeBean.IssueListBean.ItemListBean>()

    //页数 分页加载
    private var data: String? = null
    //必要 下拉刷新 清空原来的集合标志
    private var mIsRefresh: Boolean = false
    override fun setData(homeBean: HomeBean) {
        //获取data页数
        val regEx = "[^0-9]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(homeBean.nextPageUrl)
        data = m.replaceAll("")
                .subSequence(1, m.replaceAll("").length - 1).toString()

        //下拉刷新 清空原来集合
        if (mIsRefresh){
            mIsRefresh = false
            //关闭旋转框
            srl_home.isRefreshing = false
            if (mList.size > 0){
                mList.clear()
            }
        }

        //return 语句可为null 不能用? 只能用!! 平时情况调用两者都可用
        //map映射集合 flatMap展开铺平集合 直接可以用里面的元素 适用于集合嵌套集合
        homeBean.issueList!!
                .flatMap { it.itemList!! }
                .filter { it.type.equals("video") }
                .forEach { mList.add(it) }

        mAdapter?.notifyDataSetChanged()
    }

    override fun getPresenter(): HomePresenter {
        return HomePresenter(context, this)
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        mPresenter?.start()
        initRefreshLayout()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_home.layoutManager = LinearLayoutManager(context)
        mAdapter = HomeAdapter(context, mList)
        rv_home.adapter = mAdapter

        //上拉加载
        rv_home.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                val layoutManager = rv_home.layoutManager as LinearLayoutManager
                val lastPostion = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPostion == mList.size - 1){
                    if (data != null){
                        mPresenter?.moreData(data)
                    }
                }
            }
        })
    }

    private fun initRefreshLayout() {
        srl_home.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        )
        srl_home.setProgressViewOffset(true,120,300)
        //默认srl_home.isRefreshing = true 开启下拉刷新  = false关闭旋转框
        srl_home.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        if (!mIsRefresh){
            mIsRefresh = true
            mPresenter?.start()
        }
    }
}
