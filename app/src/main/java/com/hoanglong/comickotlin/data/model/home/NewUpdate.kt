package com.hoanglong.comickotlin.data.model.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewUpdate {
    @SerializedName("urlImage")
    @Expose
    private lateinit var urlImage: String
    @SerializedName("title")
    @Expose
    private lateinit var title: String
    @SerializedName("time")
    @Expose
    private lateinit var time: String
    @SerializedName("chapter")
    @Expose
    private lateinit var chapter: String
    @SerializedName("url")
    @Expose
    private lateinit var url: String
    @SerializedName("_id")
    @Expose
    private lateinit var id: String

    override fun toString(): String {
        return "NewUpdate(urlImage='$urlImage', title='$title', time='$time', chapter='$chapter', url='$url', id='$id')"
    }
}