package com.example.studytoutiao.ui.main.activity

import android.util.Log
import com.example.studytaotiao.R
import com.example.studytoutiao.base.BaseActivity
import com.example.studytoutiao.ui.main.presenter.MainPresenter
import com.example.studytoutiao.ui.main.view.MainView
import kotlinx.android.synthetic.main.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainView, MainPresenter>(),MainView {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun init() {
        btn_test.setOnClickListener {
            getPresenter()!!.getTest("test")
        }
    }

    override fun initData() {
    }

    override fun createPresenter() = MainPresenter()

    override fun <T> setData(data: T) {
        Log.e("test","=========> $data")
    }

    override fun setError(err: String) {
    }
}