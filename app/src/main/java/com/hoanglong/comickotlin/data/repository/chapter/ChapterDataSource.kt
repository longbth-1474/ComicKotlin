package com.hoanglong.comickotlin.data.repository.chapter

import com.hoanglong.comickotlin.data.model.chapter.ChapterComic
import com.hoanglong.comickotlin.data.source.ChapterDataSourceImp
import com.hoanglong.comickotlin.data.source.ICallback

class ChapterDataSource : ChapterDataSourceImp.RemoteDataSource {
    override fun getChapter(callBack: ICallback<ChapterComic>, urlChapter: String) {
        ChapterResponseAPI(callback = callBack, url = urlChapter).getChapterComic()
    }
}