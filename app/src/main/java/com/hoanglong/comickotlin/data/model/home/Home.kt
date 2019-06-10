package com.hoanglong.comickotlin.data.model.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Home {
    @SerializedName("_id")
    @Expose
    private lateinit var id: String
    @SerializedName("urlHome")
    @Expose
    private lateinit var urlHome: String
    @SerializedName("newUpdate")
    @Expose
    private lateinit var newUpdate: List<NewUpdate>
    @SerializedName("proposal")
    @Expose
    lateinit var proposal: MutableList<Proposal>

    override fun toString(): String {
        return "Home(id='$id', urlHome='$urlHome', newUpdate=$newUpdate, proposal=$proposal)"
    }
}