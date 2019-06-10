package com.hoanglong.comickotlin.data.model.category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataCategory(
    @SerializedName("_id")
    @Expose
    var id: String,
    @SerializedName("urlComic")
    @Expose
    var urlComic: String,
    @SerializedName("categories")
    @Expose
    var categories: List<Category>
)