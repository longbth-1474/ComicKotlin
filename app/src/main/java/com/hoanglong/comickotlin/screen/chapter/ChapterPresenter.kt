package com.hoanglong.comickotlin.screen.chapter

import com.hoanglong.comickotlin.data.model.chapter.ChapterComic
import com.hoanglong.comickotlin.data.repository.chapter.ChapterRepository
import com.hoanglong.comickotlin.data.source.ICallback

class ChapterPresenter(private val chapterRepository: ChapterRepository) : ChapterContract.Presenter {

    private lateinit var mView: ChapterContract.View

    override fun getChapter(urlChapter: String) {
        chapterRepository.getChapter(object : ICallback<ChapterComic> {
            override fun getDataSuccess(data: ChapterComic) {
                mView.getChapterSuccess(data)
                mView.hideProgressbar()
            }

            override fun getDataError(error: String) {
                mView.getChapterError(error)
                mView.hideProgressbar()
            }

        }, urlChapter = urlChapter)
    }

    override fun setView(view: ChapterContract.View) {
        mView = view
    }
}