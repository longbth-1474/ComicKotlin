package com.hoanglong.comickotlin.data.repository.chapter

import com.hoanglong.comickotlin.data.model.chapter.ChapterBody
import com.hoanglong.comickotlin.data.model.chapter.ChapterComic
import com.hoanglong.comickotlin.data.source.ICallback
import com.hoanglong.comickotlin.service.BaseService
import retrofit2.Call
import retrofit2.Response

class ChapterResponseAPI(private val callback: ICallback<ChapterComic>, private val url: String) {

    fun getChapterComic() {
        val chapterBody = ChapterBody(url = url)
        val call = BaseService.getService().getChapter(chapterBody)
        call.enqueue(object : retrofit2.Callback<ChapterComic>{
            override fun onFailure(call: Call<ChapterComic>, t: Throwable) {
                callback.getDataError(error = t.message.toString())
            }

            override fun onResponse(call: Call<ChapterComic>, response: Response<ChapterComic>) {
                callback.getDataSuccess(response.body()!!)
            }

        })
    }

}