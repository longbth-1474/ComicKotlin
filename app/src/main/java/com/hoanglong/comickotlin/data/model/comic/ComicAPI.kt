package com.hoanglong.comickotlin.data.model.comic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ComicAPI(
    @SerializedName("Comic")
    @Expose var comic: ComicDetail
)