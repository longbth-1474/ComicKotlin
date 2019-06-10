package com.hoanglong.comickotlin.data.repository.home

import com.hoanglong.comickotlin.data.model.home.DataHome
import com.hoanglong.comickotlin.data.model.home.Home
import com.hoanglong.comickotlin.data.source.ICallback
import com.hoanglong.comickotlin.service.BaseService
import retrofit2.Call
import retrofit2.Response

class HomeResponseAPI(val mHomeCallback: ICallback<Home>) {

    fun getDataHome() {
        val call: Call<DataHome> = BaseService.getService().getDataHome()
        call.enqueue(object : retrofit2.Callback<DataHome> {
            override fun onResponse(call: Call<DataHome>, response: Response<DataHome>) {
                if (response.isSuccessful) {
                    val home = response.body()?.home
                    if (home != null) {
                        mHomeCallback.getDataSuccess(home)
                    }
                } else {
                    mHomeCallback.getDataError(response.message())
                }
            }

            override fun onFailure(call: Call<DataHome>, t: Throwable) {
                mHomeCallback.getDataError(t.message!!)
            }
        })
    }

}