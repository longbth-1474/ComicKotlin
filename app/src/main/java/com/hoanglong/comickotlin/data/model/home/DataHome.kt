package com.hoanglong.comickotlin.data.model.home

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataHome {
    @SerializedName("Home")
    @Expose
    lateinit var home: Home

    override fun toString(): String {
        return "DataHome(home=$home)"
    }

}