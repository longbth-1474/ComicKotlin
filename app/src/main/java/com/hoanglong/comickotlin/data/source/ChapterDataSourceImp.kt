package com.hoanglong.comickotlin.data.source

import com.hoanglong.comickotlin.data.model.chapter.ChapterComic

interface ChapterDataSourceImp {
    interface RemoteDataSource {
        fun getChapter(callBack: ICallback<ChapterComic>, urlChapter: String)
    }
}