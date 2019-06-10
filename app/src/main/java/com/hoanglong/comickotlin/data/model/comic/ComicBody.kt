package com.hoanglong.comickotlin.data.model.comic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicBody(
    @SerializedName("url")
    @Expose
    private var url: String
)