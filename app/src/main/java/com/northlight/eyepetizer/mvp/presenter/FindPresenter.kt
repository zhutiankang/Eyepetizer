package com.northlight.eyepetizer.mvp.presenter

import android.content.Context
import com.northlight.eyepetizer.mvp.contract.FindContract
import com.northlight.eyepetizer.mvp.model.FindModel
import com.northlight.eyepetizer.mvp.model.bean.FindBean
import com.northlight.eyepetizer.utils.applySchedulers
import io.reactivex.Observable

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/14 09:47
 */
class FindPresenter(private var mContext: Context, private var mView: FindContract.View) :
        FindContract.Presenter{

    private val mModel: FindModel by lazy {
        FindModel()
    }

    override fun start() {
        requestData()
    }

    override fun requestData() {
        val observable: Observable<MutableList<FindBean>>? = mContext.let {mModel.loadData(it)}
        observable?.applySchedulers()?.subscribe { beans : MutableList<FindBean> ->
            mView.setData(beans)
        }
    }

}