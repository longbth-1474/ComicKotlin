package com.hoanglong.comickotlin.data.model.detail_category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicItem(
    @SerializedName("urlImage")
    @Expose var urlImage: String,
    @SerializedName("title")
    @Expose var title: String,
    @SerializedName("time")
    @Expose var time: String,
    @SerializedName("chapter")
    @Expose var chapter: String,
    @SerializedName("url")
    @Expose var url: String,
    @SerializedName("warning")
    @Expose
    private var warning: Int,
    @SerializedName("_id")
    @Expose var id: String
)
