package com.example.studytoutiao.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studytoutiao.mvp.presenter.BasePresenter
import com.example.studytoutiao.mvp.view.BaseView

abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        if (mPresenter == null) {
            mPresenter = createPresenter() as P
        }
        mPresenter!!.bindView(this as V)
        init()
        initData()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun init()
    protected abstract fun initData()
    protected abstract fun createPresenter():P

    fun getPresenter() = mPresenter

    override fun onDestroy() {
        super.onDestroy()
        mPresenter!!.unBindView()
    }
}