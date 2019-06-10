package com.hoanglong.comickotlin.data.repository.category

import com.hoanglong.comickotlin.data.model.category.Category
import com.hoanglong.comickotlin.data.model.category.DataCategory
import com.hoanglong.comickotlin.data.source.ICallback
import com.hoanglong.comickotlin.service.BaseService
import retrofit2.Call
import retrofit2.Response

class CategoryResponseAPI(val mCallback: ICallback<List<Category>>) {
    fun getCategory() {

        val call: Call<DataCategory> = BaseService.getService().getCategory()
        call.enqueue(object : retrofit2.Callback<DataCategory> {
            override fun onFailure(call: Call<DataCategory>, t: Throwable) {
                mCallback.getDataError(t.message.toString())
            }

            override fun onResponse(call: Call<DataCategory>, response: Response<DataCategory>) {
                if (response.isSuccessful) {
                    val category = response.body()?.categories ?: return
                    mCallback.getDataSuccess(category)
                }
            }

        })
    }
}