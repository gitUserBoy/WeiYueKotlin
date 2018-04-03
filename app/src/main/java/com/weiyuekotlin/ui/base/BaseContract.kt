package com.weiyuekotlin.ui.base

import android.view.View
import com.trello.rxlifecycle2.LifecycleTransformer

/**
 * 作者: SpongeBob
 * 日期: 2018/4/3.
 * 邮箱: W_SpongeBob@163.com
 *  代码是最为耐心、最能忍耐和最令人愉快的伙伴，
在任何艰难困苦的时刻它都不会离你而去。
 */
interface BaseContract<T>{
    //View
    interface BaseView{
        /**
         * 绑定View 主要是Fragment
         */
        fun attachView(view:View)

        /**
         * 解绑View
         */
        fun detachView()
    }
    //有关View 的处理
    interface BasePresenter{
        /**
         * 显示加载页面
         */
        fun showLoad()

         /**
         * 显示内容页面
         */
        fun showSuccess()

         /** 显示错误页面
         *
          */
        fun showError()

         /** 显示无网络页面
         */

        fun showNoNet()
         /** 加载重试页面
         */
        fun showReLoad()

        /*
         * 因为RxAndroid需要更Activity生命周期绑定，所以抽出来
         */

        fun <T>bindToLifecycle():LifecycleTransformer<T>

    }
}