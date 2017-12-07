package com.northlight.eyepetizer.ui

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.gyf.barlibrary.ImmersionBar
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.ui.fragment.FindFragment
import com.northlight.eyepetizer.ui.fragment.HomeFragment
import com.northlight.eyepetizer.ui.fragment.HotFragment
import com.northlight.eyepetizer.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/6 10:45
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var homeFragment: HomeFragment? = null
    private var findFragment: FindFragment? = null
    private var hotFragment: HotFragment? = null
    private var mineFragment: MineFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImmersionBar.with(this)
                .transparentBar()              //全屏显示
                .barAlpha(0.3f)     //状态栏透明度
                .fitsSystemWindows(true) //解决状态栏与导航栏toolbar重叠问题 true不重叠
                .init()
        setRadioButton()
        initToolBar()
        initFragments(savedInstanceState)
    }

    private fun initFragments(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            homeFragment = HomeFragment()
            findFragment = FindFragment()
            hotFragment = HotFragment()
            mineFragment = MineFragment()
            val fragmentTrans = supportFragmentManager.beginTransaction()
            fragmentTrans.add(R.id.fl_content, homeFragment)
            fragmentTrans.add(R.id.fl_content, findFragment)
            fragmentTrans.add(R.id.fl_content, hotFragment)
            fragmentTrans.add(R.id.fl_content, mineFragment)
            fragmentTrans.commit()
        } else {
            //异常情况
            val mFragments: List<Fragment> = supportFragmentManager.fragments
            for (item in mFragments) {
                if (item is HomeFragment) {
                    homeFragment = item
                }
                if (item is FindFragment) {
                    findFragment = item
                }
                if (item is HotFragment) {
                    hotFragment = item
                }
                if (item is MineFragment) {
                    mineFragment = item
                }
            }
        }
        supportFragmentManager.beginTransaction()
                .show(homeFragment)
                .hide(findFragment)
                .hide(hotFragment)
                .hide(mineFragment)
                .commit()
    }

    private fun initToolBar() {
        val today = getToday()
        tv_bar_title.text = today
        tv_bar_title.typeface = Typeface.createFromAsset(this.assets, "fonts/Lobster-1.4.otf")
        iv_search.setOnClickListener {
            if (rb_mine.isChecked) {
                //点击设置
            } else {
                //点击搜索
            }
        }
    }

    private fun getToday(): String {
        val list = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
        val date = Date()
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = date
        //要进行减1 index从1开始
        var index: Int = calendar.get(Calendar.DAY_OF_WEEK) - 1
        if (index < 0) {
            index = 0
        }
        return list[index]
    }

    private fun setRadioButton() {
        rb_home.isChecked = true
        rb_home.setTextColor(resources.getColor(R.color.black))
        rb_home.setOnClickListener(this)
        rb_find.setOnClickListener(this)
        rb_hot.setOnClickListener(this)
        rb_mine.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        clearState()
        when (v?.id) {
            R.id.rb_find -> {
                rb_find.isChecked = true
                rb_find.setTextColor(resources.getColor(R.color.black))

                supportFragmentManager.beginTransaction()
                        .show(findFragment)
                        .hide(homeFragment)
                        .hide(hotFragment)
                        .hide(mineFragment)
                        .commit()
                tv_bar_title.text = "Discover"
                tv_bar_title.visibility = View.VISIBLE
                iv_search.setImageResource(R.mipmap.icon_search)
            }
            R.id.rb_home -> {
                rb_home.isChecked = true
                rb_home.setTextColor(resources.getColor(R.color.black))

                supportFragmentManager.beginTransaction()
                        .show(homeFragment)
                        .hide(findFragment)
                        .hide(hotFragment)
                        .hide(mineFragment)
                        .commit()
                tv_bar_title.text = getToday()
                tv_bar_title.visibility = View.VISIBLE
                iv_search.setImageResource(R.mipmap.icon_search)
            }
            R.id.rb_hot -> {
                rb_hot.isChecked = true
                rb_hot.setTextColor(resources.getColor(R.color.black))

                supportFragmentManager.beginTransaction()
                        .show(hotFragment)
                        .hide(findFragment)
                        .hide(homeFragment)
                        .hide(mineFragment)
                        .commit()
                tv_bar_title.text = "Ranking"
                tv_bar_title.visibility = View.VISIBLE
                iv_search.setImageResource(R.mipmap.icon_search)
            }
            R.id.rb_mine -> {
                rb_mine.isChecked = true
                rb_mine.setTextColor(resources.getColor(R.color.black))

                supportFragmentManager.beginTransaction()
                        .show(mineFragment)
                        .hide(findFragment)
                        .hide(hotFragment)
                        .hide(homeFragment)
                        .commit()
                tv_bar_title.visibility = View.INVISIBLE
                iv_search.setImageResource(R.mipmap.icon_setting)
            }
        }
    }

    private fun clearState() {
        rg_root.clearCheck()
        rb_home.setTextColor(resources.getColor(R.color.gray))
        rb_find.setTextColor(resources.getColor(R.color.gray))
        rb_hot.setTextColor(resources.getColor(R.color.gray))
        rb_mine.setTextColor(resources.getColor(R.color.gray))
    }

}