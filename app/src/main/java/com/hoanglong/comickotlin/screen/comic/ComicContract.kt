package com.hoanglong.comickotlin.screen.comic

import com.hoanglong.comickotlin.data.model.comic.ComicDetail
import com.hoanglong.comickotlin.screen.base.BasePresenter

class ComicContract {
    interface View {
        fun getDataComicSuccess(comicDetail: ComicDetail)
        fun hideProgressBar()
        fun getDataComicError(error: String)
    }

    interface Presenter : BasePresenter<View> {
        fun getComicDetail(url: String)
    }
}