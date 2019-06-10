package com.hoanglong.comickotlin.data.repository.detail_category

import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesAPI
import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesBody
import com.hoanglong.comickotlin.data.source.ICallback
import com.hoanglong.comickotlin.service.BaseService
import retrofit2.Call
import retrofit2.Response

class DetailCategoriesResponseAPI(private val callback: ICallback<DetailCategoriesAPI>) {
    fun getDetailCategory(url: String, page: Int) {

        val detailCategoryBody = DetailCategoriesBody(url, page)
        val call = BaseService.getService().getDetailCategory(detailCategoryBody)

        call.enqueue(object : retrofit2.Callback<DetailCategoriesAPI> {
            override fun onFailure(call: Call<DetailCategoriesAPI>, t: Throwable) {
                callback.getDataError(t.message.toString())
            }

            override fun onResponse(call: Call<DetailCategoriesAPI>, response: Response<DetailCategoriesAPI>) {
                callback.getDataSuccess(response.body()!!)
            }

        })
    }
}