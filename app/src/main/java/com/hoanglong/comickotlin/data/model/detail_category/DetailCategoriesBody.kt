package com.hoanglong.comickotlin.data.model.detail_category

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailCategoriesBody(
    @SerializedName("url")
    @Expose
    var url: String,
    @SerializedName("page")
    @Expose
    var page: Int
)