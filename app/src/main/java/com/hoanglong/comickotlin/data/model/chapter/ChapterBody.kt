package com.hoanglong.comickotlin.data.model.chapter

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChapterBody (
    @SerializedName("urlChapter")
    @Expose
    private var url: String
)