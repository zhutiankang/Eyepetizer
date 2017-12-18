package com.northlight.eyepetizer.ui.fragment

import android.support.v7.widget.GridLayoutManager
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.adpater.FindAdapter
import com.northlight.eyepetizer.mvp.contract.FindContract
import com.northlight.eyepetizer.mvp.model.bean.FindBean
import com.northlight.eyepetizer.mvp.presenter.FindPresenter
import kotlinx.android.synthetic.main.fragment_find.*

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/7 10:37
 */
class FindFragment : BaseFragment<FindPresenter>(), FindContract.View {

    private var mAdapter: FindAdapter? = null
    private var mList : MutableList<FindBean>? = null


    override fun setData(beans: MutableList<FindBean>) {
        mList = beans
        mAdapter?.list = mList
        mAdapter?.notifyDataSetChanged()
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_find
    }

    override fun initView() {
        mPresenter?.start()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rlv_find.layoutManager = GridLayoutManager(context,2)
        mAdapter = FindAdapter(context,mList)
        rlv_find.adapter = mAdapter
    }

    override fun getPresenter(): FindPresenter {
        return FindPresenter(context,this)
    }

}