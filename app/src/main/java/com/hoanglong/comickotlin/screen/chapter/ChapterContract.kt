package com.hoanglong.comickotlin.screen.chapter

import com.hoanglong.comickotlin.data.model.chapter.ChapterComic
import com.hoanglong.comickotlin.screen.base.BasePresenter

class ChapterContract {
    interface View {
        fun getChapterSuccess(chapterComic: ChapterComic)
        fun getChapterError(error: String)
        fun hideProgressbar()
    }

    interface Presenter : BasePresenter<View> {
        fun getChapter(urlChapter: String)
    }
}