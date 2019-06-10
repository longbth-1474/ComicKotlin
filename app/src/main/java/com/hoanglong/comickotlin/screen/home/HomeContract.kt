package com.hoanglong.comickotlin.screen.home

import com.hoanglong.comickotlin.data.model.home.Home
import com.hoanglong.comickotlin.screen.base.BasePresenter

class HomeContract {
    interface View {
        fun getDataHomeSuccess(home: Home)
        fun hideProgressBar()
        fun getDataHomeError(error: String)
    }

    interface Presenter : BasePresenter<View> {
        fun getDataHome()
    }
}