package com.hoanglong.comickotlin.data.source

import com.hoanglong.comickotlin.data.model.home.Home

interface HomeDataSourceImp {
    interface RemoteDataSource{
        fun getHome(callback : ICallback<Home>)
    }
}