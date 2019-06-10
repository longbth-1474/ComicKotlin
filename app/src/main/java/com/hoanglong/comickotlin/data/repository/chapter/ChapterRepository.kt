package com.hoanglong.comickotlin.data.repository.chapter

import com.hoanglong.comickotlin.data.model.chapter.ChapterComic
import com.hoanglong.comickotlin.data.source.ChapterDataSourceImp
import com.hoanglong.comickotlin.data.source.ICallback

class ChapterRepository(private val chapterDataSource: ChapterDataSource) : ChapterDataSourceImp.RemoteDataSource {

    override fun getChapter(callBack: ICallback<ChapterComic>, urlChapter: String) {
        chapterDataSource.getChapter(callBack, urlChapter)
    }
}