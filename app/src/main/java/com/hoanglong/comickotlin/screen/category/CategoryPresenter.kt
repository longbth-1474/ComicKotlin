package com.hoanglong.comickotlin.screen.category

import com.hoanglong.comickotlin.data.model.category.Category
import com.hoanglong.comickotlin.data.repository.category.CategoryRepository
import com.hoanglong.comickotlin.data.source.ICallback

class CategoryPresenter(private val mCategoryRepository: CategoryRepository) : CategoryContract.Presenter {
    private lateinit var mView: CategoryContract.View

    override fun getCategory() {
        mCategoryRepository.getCategory(object : ICallback<List<Category>> {
            override fun getDataSuccess(data: List<Category>) {
                mView.hideProgressbar()
                mView.getCategoriesSuccess(data)
            }

            override fun getDataError(error: String) {
                mView.getCategoriesError(error)
                mView.hideProgressbar()
            }

        })
    }

    override fun setView(view: CategoryContract.View) {
        mView = view
    }

}