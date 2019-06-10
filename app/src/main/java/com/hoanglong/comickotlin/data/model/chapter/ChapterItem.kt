package com.hoanglong.comickotlin.data.model.chapter

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChapterItem(
    @SerializedName("image")
    @Expose var image: String,
    @SerializedName("_id")
    @Expose
    private var id: String
)