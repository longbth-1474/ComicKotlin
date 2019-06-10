package com.hoanglong.comickotlin.data.model.comic

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Chapter() : Parcelable {
    @SerializedName("titleChapter")
    @Expose
    lateinit var titleChapter: String
    @SerializedName("timeChapter")
    @Expose
    lateinit var timeChapter: String
    @SerializedName("urlChapter")
    @Expose
    lateinit var urlChapter: String
    @SerializedName("_id")
    @Expose
    private lateinit var id: String

    constructor(parcel: Parcel) : this() {
        titleChapter = parcel.readString()!!
        timeChapter = parcel.readString()!!
        urlChapter = parcel.readString()!!
        id = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titleChapter)
        parcel.writeString(timeChapter)
        parcel.writeString(urlChapter)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Chapter> {
        override fun createFromParcel(parcel: Parcel): Chapter {
            return Chapter(parcel)
        }

        override fun newArray(size: Int): Array<Chapter?> {
            return arrayOfNulls(size)
        }
    }
}