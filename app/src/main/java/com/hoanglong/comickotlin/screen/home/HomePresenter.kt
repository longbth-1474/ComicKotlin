package com.hoanglong.comickotlin.screen.home

import com.hoanglong.comickotlin.data.model.home.Home
import com.hoanglong.comickotlin.data.repository.home.HomeRepository
import com.hoanglong.comickotlin.data.source.ICallback

class HomePresenter(private val homeRepository: HomeRepository) : HomeContract.Presenter {

    private lateinit var mView: HomeContract.View

    override fun getDataHome() {
        homeRepository.getHome(object : ICallback<Home> {
            override fun getDataSuccess(data: Home) {
                mView.getDataHomeSuccess(home = data)
                mView.hideProgressBar()
            }

            override fun getDataError(error: String) {
                mView.getDataHomeError(error = error)
                mView.hideProgressBar()
            }
        })
    }

    override fun setView(view: HomeContract.View) {
        mView = view
    }
}