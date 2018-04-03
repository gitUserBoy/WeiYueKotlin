package com.weiyuekotlin.ui.base

import android.os.Bundle
import android.view.View
import com.weiyuekotlin.widget.SimpleMultiStateView

/**
 * 作者: SpongeBob
 * 日期: 2018/4/3.
 * 邮箱: W_SpongeBob@163.com
 *  代码是最为耐心、最能忍耐和最令人愉快的伙伴，
在任何艰难困苦的时刻它都不会离你而去。
 */

/**
 * Activity 内流程及方法
 */
interface IBase {
    /**
     * 依赖注入
     */
    fun initInjector()

    /**
     * 初始化界面
     */
    fun getContentLayout():Int?

    /**
     * 初始化布局
     */
    fun bindView(view:View?,savedInstanceState: Bundle?)

    /**
     * 状态布局view，这个是自定义的view 设定不同状态界面
     */
    fun getStateView(): SimpleMultiStateView?
}