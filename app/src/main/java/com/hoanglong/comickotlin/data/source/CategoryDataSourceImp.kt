package com.hoanglong.comickotlin.data.source

import com.hoanglong.comickotlin.data.model.category.Category

interface CategoryDataSourceImp {
    interface RemoteDataSource {
        fun getCategory(callback: ICallback<List<Category>>)
    }
}