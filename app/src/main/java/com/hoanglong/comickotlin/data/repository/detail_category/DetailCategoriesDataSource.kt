package com.hoanglong.comickotlin.data.repository.detail_category

import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesAPI
import com.hoanglong.comickotlin.data.source.DetailCategoriesDataSourceImp
import com.hoanglong.comickotlin.data.source.ICallback

class DetailCategoriesDataSource : DetailCategoriesDataSourceImp.RemoteDataSource {

    override fun getDetailCategory(iCallback: ICallback<DetailCategoriesAPI>, url: String, page: Int) {
        DetailCategoriesResponseAPI(iCallback).getDetailCategory(url, page)
    }
}