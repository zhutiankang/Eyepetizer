package com.northlight.eyepetizer.ui

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.TextView
import com.northlight.eyepetizer.R
import com.northlight.eyepetizer.utils.newIntent
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/12/6 10:44
 */
class SplashActivity : AppCompatActivity() {

    private lateinit var tv_name : TextView
    private lateinit var tv_intro : TextView
    private lateinit var image_bg : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置全屏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        initView()
    }

    private fun initView() {
        tv_name = tv_name_english
        tv_intro = tv_intro_english
        image_bg = iv_icon_splash

        val font :Typeface = Typeface.createFromAsset(this.assets,"fonts/Lobster-1.4.otf")
        tv_name.typeface = font
        tv_intro.typeface = font

        val alphaAnimation = AlphaAnimation(0.1f,1.0f)
        alphaAnimation.duration = 1000

        val scaleAnimation = ScaleAnimation(0.1f,1.0f,0.1f,1.0f,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f)
        scaleAnimation.duration = 1000

        val animationSet = AnimationSet(true)
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(scaleAnimation)
        animationSet.duration = 1000

        image_bg.startAnimation(animationSet)
        animationSet.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                newIntent<MainActivity>()
            }

            override fun onAnimationStart(p0: Animation?) {
            }
        })


    }
}