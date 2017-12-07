package com.northlight.eyepetizer.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/6 10:45
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRadioButton()
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
        when(v?.id){
            R.id.rb_find -> {
                showToast("点击find")
                rb_find.isChecked = true
                rb_find.setTextColor(resources.getColor(R.color.black))
            }
            R.id.rb_home -> {
                rb_home.isChecked = true
                rb_home.setTextColor(resources.getColor(R.color.black))
            }
            R.id.rb_hot -> {
                rb_hot.isChecked = true
                rb_hot.setTextColor(resources.getColor(R.color.black))
            }
            R.id.rb_mine -> {
                rb_mine.isChecked = true
                rb_mine.setTextColor(resources.getColor(R.color.black))
            }
        }
    }

    private fun clearState(){
        rg_root.clearCheck()
        rb_home.setTextColor(resources.getColor(R.color.gray))
        rb_find.setTextColor(resources.getColor(R.color.gray))
        rb_hot.setTextColor(resources.getColor(R.color.gray))
        rb_mine.setTextColor(resources.getColor(R.color.gray))
    }

}