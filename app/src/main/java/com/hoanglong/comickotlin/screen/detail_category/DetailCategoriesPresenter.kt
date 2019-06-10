package com.hoanglong.comickotlin.screen.detail_category

import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesAPI
import com.hoanglong.comickotlin.data.repository.detail_category.DetailCategoriesRepository
import com.hoanglong.comickotlin.data.source.ICallback

class DetailCategoriesPresenter(private val detailCategoriesRepository: DetailCategoriesRepository) :
    DetailCategoriesContract.Presenter {

    override fun getDetailCategories(url: String, page: Int) {
        detailCategoriesRepository.getDetailCategory(object : ICallback<DetailCategoriesAPI> {
            override fun getDataSuccess(data: DetailCategoriesAPI) {
                mView.getDataSuccess(data)
                mView.hideProgressBar()
            }

            override fun getDataError(error: String) {
                mView.getDataError(error)
                mView.hideProgressBar()
            }

        }, url, page)
    }

    private lateinit var mView: DetailCategoriesContract.View

    override fun setView(view: DetailCategoriesContract.View) {
        mView = view
    }
}