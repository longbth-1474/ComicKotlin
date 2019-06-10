package com.hoanglong.comickotlin.data.source

import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesAPI

interface DetailCategoriesDataSourceImp {
    interface RemoteDataSource {
        fun getDetailCategory(iCallback: ICallback<DetailCategoriesAPI>, url: String, page: Int)
    }
}