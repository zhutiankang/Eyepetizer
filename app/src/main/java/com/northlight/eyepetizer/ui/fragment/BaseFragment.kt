package com.northlight.eyepetizer.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.northlight.eyepetizer.mvp.base.BasePresenter

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/7 10:12
 */
abstract class BaseFragment<T : BasePresenter> : Fragment() {

    var rootView: View? = null
    protected var mPresenter: T? = null

    abstract fun getLayoutResources(): Int
    abstract fun initView()
    abstract fun getPresenter(): T

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater?.inflate(getLayoutResources(), container, false)
            mPresenter = getPresenter()
        }
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
}