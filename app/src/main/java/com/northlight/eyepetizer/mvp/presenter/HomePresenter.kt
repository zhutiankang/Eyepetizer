package com.northlight.eyepetizer.mvp.presenter

import android.content.Context
import com.northlight.eyepetizer.mvp.contract.HomeContract
import com.northlight.eyepetizer.mvp.model.HomeModel
import com.northlight.eyepetizer.mvp.model.bean.HomeBean
import com.northlight.eyepetizer.utils.applySchedulers
import io.reactivex.Observable

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/11 11:06
 */
class HomePresenter(context: Context, view: HomeContract.View) : HomeContract.Presenter {

    var mContext: Context? = null
    var mView: HomeContract.View? = null
    private val mModel: HomeModel by lazy {
        HomeModel()
    }
    init {
        mContext = context
        mView = view
    }

    override fun start() {
        requestData()
    }

    override fun requestData() {
        //Calls the specified function [block] with `this` value as its argument and returns its result
        //两种调用方式都可以 下一种更好，更kotlin  context作为参数的时候
        //val observable: Observable<HomeBean>? = mModel.loadData(mContext!!, true, 0)
        val observable: Observable<HomeBean>? = mContext?.let { mModel.loadData(it,true,0) }

        observable?.applySchedulers()?.subscribe { homeBean: HomeBean ->
            //获取数据的时候过滤
//            homeBean.issueList?.forEach {
//                it.itemList?.filter { it.type != "video" }
//            }
            mView?.setData(homeBean)
        }
    }

    fun moreData() {
    }
}