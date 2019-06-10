package com.hoanglong.comickotlin.data.repository.home

import com.hoanglong.comickotlin.data.model.home.Home
import com.hoanglong.comickotlin.data.source.HomeDataSourceImp
import com.hoanglong.comickotlin.data.source.ICallback

class HomeDataSource : HomeDataSourceImp.RemoteDataSource {

    override fun getHome(callback: ICallback<Home>) {
        HomeResponseAPI(callback).getDataHome()
    }
}