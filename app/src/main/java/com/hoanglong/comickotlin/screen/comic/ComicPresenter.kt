package com.hoanglong.comickotlin.screen.comic

import com.hoanglong.comickotlin.data.model.comic.ComicDetail
import com.hoanglong.comickotlin.data.repository.comic.ComicRepository
import com.hoanglong.comickotlin.data.source.ICallback

class ComicPresenter(private val comicRepository: ComicRepository) : ComicContract.Presenter {

    private lateinit var mView : ComicContract.View

    override fun getComicDetail(url: String) {
        comicRepository.getComicDetail(object : ICallback<ComicDetail> {
            override fun getDataSuccess(data: ComicDetail) {
                mView.getDataComicSuccess(data)
                mView.hideProgressBar()
            }

            override fun getDataError(error: String) {
                mView.getDataComicError(error)
                mView.hideProgressBar()
            }
        }, url)
    }

    override fun setView(view: ComicContract.View) {
        mView = view
    }

}