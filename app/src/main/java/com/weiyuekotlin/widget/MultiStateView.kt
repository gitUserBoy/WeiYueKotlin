package com.weiyuekotlin.widget

import android.content.Context
import android.util.AttributeSet
import android.util.SparseArray
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

/**
 * 作者: SpongeBob
 * 日期: 2018/4/3.
 * 邮箱: W_SpongeBob@163.com
 * 代码是最为耐心、最能忍耐和最令人愉快的伙伴，在任何艰难困苦的时刻它都不会离你而去。
 */
open class MultiStateView : FrameLayout {
    private val TAG = MultiStateView::class.java.simpleName

    val STATE_CONTENT = 10001
    val STATE_LOADING = 10002
    val STATE_EMPTY = 10003
    val STATE_FAIL = 10004
    val STATE_NONET = 10005

    private var mCurrentState: Int = STATE_CONTENT

    private var mStateViewArray: SparseArray<View> = SparseArray()

    private var mLayoutIdArray: SparseIntArray = SparseIntArray()

    private var mContentView: View? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)


    //添加view，添加当前view的校验
    override fun addView(child: View?) {
        super.addView(child)
    }

    override fun addView(child: View?, index: Int) {
        super.addView(child, index)
    }

    override fun addView(child: View?, width: Int, height: Int) {
        super.addView(child, width, height)
    }

    override fun addView(child: View?, params: ViewGroup.LayoutParams?) {
        super.addView(child, params)
    }

    override fun addView(child: View?, index: Int, params: ViewGroup.LayoutParams?) {
        super.addView(child, index, params)
    }

    /**
     * 改变视图状态
     */
    fun setCurrentState(state: Int){

        if (mCurrentState == state || getCurrentView() == null) return

        //判断视图状态
        getCurrentView()!!.visibility = View.GONE
        mCurrentState = state
        var view = getStateView(state)
        if (view != null){
            view.visibility = View.VISIBLE
        }else{
            var resId = mLayoutIdArray.get(state)
            if (resId == 0) return
           var inflateView = LayoutInflater.from(context).inflate(resId,null,false)

            inflateView.visibility = View.VISIBLE
            addView(inflateView)
            mStateViewArray.put(state,inflateView)

            if (state == STATE_FAIL){

            }

        }
    }

    /**
     * 获取当前状态
     */
    fun getCurrtentView(): Int = mCurrentState


    /**
     * 根据状态获取对应View
     */
    fun getStateView(state: Int): View? {
        return mStateViewArray.get(state)
    }

    /**
     * 获取当前状态view
     */
    fun getCurrentView():View?{
        if (mCurrentState == -1) return null

        var view = getStateView(mCurrentState)
        if (view == null && mCurrentState == STATE_CONTENT){
            throw NullPointerException("content is null")
        }else if (view == null){
            throw NullPointerException("content is null state-"+mCurrentState)
        }
        return view
    }

    fun addViewLayoutIdRes(status:Int,resLayoutId:Int){
        mLayoutIdArray.put(status,resLayoutId)
    }

    /**
     * 设置当前view给mContentView
     */
    fun vaildContentView(view: View) {
        if (isVaildContentView(view)) {
            mContentView = view
            mStateViewArray.put(STATE_CONTENT, view)
        } else if (mCurrentState != STATE_CONTENT) {
            mContentView!!.visibility = View.GONE
        }
    }

    fun isVaildContentView(view: View): Boolean {
        if (mContentView == null) {
            for (i in 0 until mStateViewArray.size()) {
                if (mStateViewArray.indexOfValue(view) != -1) return false
            }
        }
        return false
    }

}