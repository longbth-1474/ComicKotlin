package com.hoanglong.comickotlin.data.model.detail_category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicsCategory(
    @SerializedName("url")
    @Expose
    private var url: String,
    @SerializedName("_id")
    @Expose
    private var id: String,
    @SerializedName("comics")
    @Expose var comics: MutableList<ComicItem>
)