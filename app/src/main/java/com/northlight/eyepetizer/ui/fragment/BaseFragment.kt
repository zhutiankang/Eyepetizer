package com.northlight.eyepetizer.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/7 10:12
 */
abstract class BaseFragment : Fragment() {

    var rootView: View? = null


    abstract fun getLayoutResources(): Int
    abstract fun initView()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater?.inflate(getLayoutResources(), container, false)
        }
        initView()
        return rootView
    }
}