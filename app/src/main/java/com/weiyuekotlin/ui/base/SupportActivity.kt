package com.weiyuekotlin.ui.base

import android.os.Bundle
import android.view.MotionEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import me.yokeyword.fragmentation.*
import me.yokeyword.fragmentation.anim.FragmentAnimator

/**
 * 作者: SpongeBob
 * 日期: 2018/4/3.
 * 邮箱: W_SpongeBob@163.com
 *  代码是最为耐心、最能忍耐和最令人愉快的伙伴，
在任何艰难困苦的时刻它都不会离你而去。
 */
open class SupportActivity : RxAppCompatActivity(), ISupportActivity {
    private var mDelegate = SupportActivityDelegate(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDelegate.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        mDelegate.onPostCreate(savedInstanceState)
        super.onPostCreate(savedInstanceState)
    }

    override fun onDestroy() {
        mDelegate.onDestroy()
        super.onDestroy()

    }

    /**
     * yokeyword Fragment 设定一个获取fragment的提取类。
     */
    fun<T:ISupportFragment> findFragment(fragmentClass:Class<T>):T = SupportHelper.findFragment(supportFragmentManager,fragmentClass)




    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean=mDelegate.dispatchTouchEvent(ev)||super.dispatchTouchEvent(ev)


    override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator?) {
        mDelegate.fragmentAnimator = fragmentAnimator
    }

    override fun onBackPressed() {
        mDelegate.onBackPressed()
    }

    override fun getFragmentAnimator(): FragmentAnimator = mDelegate.fragmentAnimator

    override fun onBackPressedSupport() = mDelegate.onBackPressedSupport()

    override fun extraTransaction(): ExtraTransaction = mDelegate.extraTransaction()

    override fun onCreateFragmentAnimator(): FragmentAnimator = mDelegate.onCreateFragmentAnimator()

    override fun getSupportDelegate(): SupportActivityDelegate = mDelegate

}