package com.hoanglong.comickotlin.data.repository.category

import com.hoanglong.comickotlin.data.model.category.Category
import com.hoanglong.comickotlin.data.source.CategoryDataSourceImp
import com.hoanglong.comickotlin.data.source.ICallback

class CategoryDataSource : CategoryDataSourceImp.RemoteDataSource {

    override fun getCategory(callback: ICallback<List<Category>>) {
        CategoryResponseAPI(callback).getCategory()
    }

}