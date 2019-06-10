package com.hoanglong.comickotlin.screen.detail_category

import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesAPI
import com.hoanglong.comickotlin.screen.base.BasePresenter

class DetailCategoriesContract {
    interface View {
        fun getDataSuccess(detailCategoriesAPI: DetailCategoriesAPI)
        fun getDataError(error: String)
        fun hideProgressBar()
    }

    interface Presenter : BasePresenter<View> {
        fun getDetailCategories(url:String,page:Int)
    }
}