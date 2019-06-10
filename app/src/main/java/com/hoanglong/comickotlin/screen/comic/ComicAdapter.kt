package com.hoanglong.comickotlin.screen.comic

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.comic.Chapter
import kotlinx.android.synthetic.main.item_chapter.view.*

class ComicAdapter(private val chapters: MutableList<Chapter>, private val onClickComicListener: OnClickComicListener) :
    RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    interface OnClickComicListener {
        fun onClickComic(chapter: Chapter, position: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ComicViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_chapter, viewGroup, false)
        return ComicViewHolder(view, onClickComicListener)
    }

    override fun getItemCount(): Int {
        return chapters.size
    }

    override fun onBindViewHolder(comicViewHolder: ComicViewHolder, position: Int) {
        val chapter = chapters[position]
        comicViewHolder.bindData(chapter, position)
    }

    class ComicViewHolder(
        itemView: View,
        private val onClickComicListener: OnClickComicListener
    ) : RecyclerView.ViewHolder(itemView) {

        private lateinit var mChapter: Chapter
        private var mPosition: Int = 0

        init {
            itemView.setOnClickListener {
                onClickComicListener.onClickComic(mChapter, mPosition)
            }
        }

        fun bindData(chapter: Chapter, position: Int) {
            mChapter = chapter
            mPosition = position
            itemView.text_chapter.text = chapter.titleChapter
            itemView.text_time_chapter_update.text = chapter.timeChapter
        }

    }
}