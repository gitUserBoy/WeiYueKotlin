package com.weiyuekotlin.ui.base

import android.view.View

/**
 * 作者: SpongeBob
 * 日期: 2018/4/3.
 * 邮箱: W_SpongeBob@163.com
 *  代码是最为耐心、最能忍耐和最令人愉快的伙伴，
在任何艰难困苦的时刻它都不会离你而去。
 */
class BaseActivity<T:BaseContract.BasePresenter>:SupportActivity(),BaseContract.BaseView{
    private var mPresenter:T? = null
    override fun attachView(view: View) {
    }

    override fun detachView() {
    }
}