package com.example.studytoutiao.ui.main.presenter

import com.example.studytoutiao.mvp.presenter.BasePresenter
import com.example.studytoutiao.ui.main.view.MainView

class MainPresenter : BasePresenter<MainView>() {

    fun getTest(str:String){
        getBaseView()!!.setData(str);
    }
}