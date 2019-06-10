package com.hoanglong.comickotlin.data.source

import com.hoanglong.comickotlin.data.model.comic.ComicDetail

interface ComicDataSourceImp {
    interface RemoteDataSource {
        fun getComicDetail(callBack: ICallback<ComicDetail>, urlComic: String)
    }
}