package com.hoanglong.comickotlin.screen.category

import com.hoanglong.comickotlin.data.model.category.Category
import com.hoanglong.comickotlin.screen.base.BasePresenter

class CategoryContract {
    interface View {
        fun getCategoriesSuccess(categories: List<Category>)
        fun getCategoriesError(error: String)
        fun hideProgressbar()
    }

    interface Presenter : BasePresenter<View> {
        fun getCategory()
    }
}