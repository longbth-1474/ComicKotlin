package com.hoanglong.comickotlin.data.model.home

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Comic() : Parcelable {
    @SerializedName("urlImage")
    @Expose
    lateinit var urlImage: String
    @SerializedName("title")
    @Expose
    lateinit var title: String
    @SerializedName("time")
    @Expose
    lateinit var time: String
    @SerializedName("chapter")
    @Expose
    lateinit var chapter: String
    @SerializedName("url")
    @Expose
    lateinit var url: String
    @SerializedName("_id")
    @Expose
    lateinit var id: String

    constructor(parcel: Parcel) : this() {
        urlImage = parcel.readString()!!
        title = parcel.readString()!!
        time = parcel.readString()!!
        chapter = parcel.readString()!!
        url = parcel.readString()!!
        id = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(urlImage)
        parcel.writeString(title)
        parcel.writeString(time)
        parcel.writeString(chapter)
        parcel.writeString(url)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comic> {
        override fun createFromParcel(parcel: Parcel): Comic {
            return Comic(parcel)
        }

        override fun newArray(size: Int): Array<Comic?> {
            return arrayOfNulls(size)
        }
    }
}