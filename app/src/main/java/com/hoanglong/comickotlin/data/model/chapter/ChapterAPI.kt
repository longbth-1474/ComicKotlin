package com.hoanglong.comickotlin.data.model.chapter

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChapterAPI(
    @SerializedName("_id")
    @Expose
    private var id: String,
    @SerializedName("urlChapter")
    @Expose
    private var urlChapter: String,
    @SerializedName("chapters")
    @Expose var chapters: MutableList<ChapterItem>
)