package com.hoanglong.comickotlin.service

import com.hoanglong.comickotlin.data.model.category.DataCategory
import com.hoanglong.comickotlin.data.model.chapter.ChapterBody
import com.hoanglong.comickotlin.data.model.chapter.ChapterComic
import com.hoanglong.comickotlin.data.model.comic.ComicAPI
import com.hoanglong.comickotlin.data.model.comic.ComicBody
import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesAPI
import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesBody
import com.hoanglong.comickotlin.data.model.home.DataHome
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IApiService {
    @GET("/home")
    fun getDataHome(): Call<DataHome>

    @GET("/categoryComic")
    fun getCategory(): Call<DataCategory>

    @POST("/contentCategory")
    fun getDetailCategory(@Body detailCategoryBody: DetailCategoriesBody): Call<DetailCategoriesAPI>

    @POST("/detailComic")
    fun getComicDetail(@Body comicBody: ComicBody): Call<ComicAPI>

    @POST("/chapter")
    fun getChapter(@Body chapterBody: ChapterBody): Call<ChapterComic>
}