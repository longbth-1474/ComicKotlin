package com.hoanglong.comickotlin.data.model.comic

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ComicDetail() : Parcelable {
    @SerializedName("_id")
    @Expose
    private lateinit var id: String
    @SerializedName("url")
    @Expose
    private lateinit var url: String
    @SerializedName("image")
    @Expose
    private lateinit var image: String
    @SerializedName("title")
    @Expose
    lateinit var title: String
    @SerializedName("titleOther")
    @Expose
    lateinit var titleOther: String
    @SerializedName("timeUpdate")
    @Expose
    lateinit var timeUpdate: String
    @SerializedName("author")
    @Expose
    lateinit var author: String
    @SerializedName("type")
    @Expose
    lateinit var type: String
    @SerializedName("status")
    @Expose
    lateinit var status: String
    @SerializedName("viewer")
    @Expose
    lateinit var viewer: String
    @SerializedName("content")
    @Expose
    lateinit var content: String
    @SerializedName("chapters")
    @Expose
    lateinit var chapters: MutableList<Chapter>

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()!!
        url = parcel.readString()!!
        image = parcel.readString()!!
        title = parcel.readString()!!
        titleOther = parcel.readString()!!
        timeUpdate = parcel.readString()!!
        author = parcel.readString()!!
        type = parcel.readString()!!
        status = parcel.readString()!!
        viewer = parcel.readString()!!
        content = parcel.readString()!!
        chapters = parcel.createTypedArrayList(Chapter)!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(url)
        parcel.writeString(image)
        parcel.writeString(title)
        parcel.writeString(titleOther)
        parcel.writeString(timeUpdate)
        parcel.writeString(author)
        parcel.writeString(type)
        parcel.writeString(status)
        parcel.writeString(viewer)
        parcel.writeString(content)
        parcel.writeTypedList(chapters)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ComicDetail> {
        override fun createFromParcel(parcel: Parcel): ComicDetail {
            return ComicDetail(parcel)
        }

        override fun newArray(size: Int): Array<ComicDetail?> {
            return arrayOfNulls(size)
        }
    }
}