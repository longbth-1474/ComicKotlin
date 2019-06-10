package com.hoanglong.comickotlin.data.model.chapter

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ChapterComic(
    @SerializedName("Chapter")
    @Expose var chapter: ChapterAPI
)