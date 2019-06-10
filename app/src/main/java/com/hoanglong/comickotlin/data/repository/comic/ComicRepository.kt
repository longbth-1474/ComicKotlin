package com.hoanglong.comickotlin.data.repository.comic

import com.hoanglong.comickotlin.data.model.comic.ComicDetail
import com.hoanglong.comickotlin.data.source.ComicDataSourceImp
import com.hoanglong.comickotlin.data.source.ICallback

class ComicRepository(private val comicDataSource: ComicDataSource) : ComicDataSourceImp.RemoteDataSource {
    override fun getComicDetail(callBack: ICallback<ComicDetail>, urlComic: String) {
        comicDataSource.getComicDetail(callBack, urlComic)
    }

}