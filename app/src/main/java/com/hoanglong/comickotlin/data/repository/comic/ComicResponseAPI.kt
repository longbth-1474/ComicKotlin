package com.hoanglong.comickotlin.data.repository.comic

import com.hoanglong.comickotlin.data.model.comic.ComicAPI
import com.hoanglong.comickotlin.data.model.comic.ComicBody
import com.hoanglong.comickotlin.data.model.comic.ComicDetail
import com.hoanglong.comickotlin.data.source.ICallback
import com.hoanglong.comickotlin.service.BaseService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComicResponseAPI(private val callBack: ICallback<ComicDetail>, private val urlComic: String) {

    fun getComicDetail() {
        val comicBody = ComicBody(url = urlComic)
        val call = BaseService.getService().getComicDetail(comicBody)
        call.enqueue(object : Callback<ComicAPI> {
            override fun onResponse(call: Call<ComicAPI>, response: Response<ComicAPI>) {
                if (response.body() == null) return
                callBack.getDataSuccess(response.body()!!.comic)
            }

            override fun onFailure(call: Call<ComicAPI>, t: Throwable) {
                callBack.getDataError(t.message!!)
            }
        })
    }
}