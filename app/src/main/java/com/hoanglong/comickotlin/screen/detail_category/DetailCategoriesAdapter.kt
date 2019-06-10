package com.hoanglong.comickotlin.screen.detail_category

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.detail_category.ComicItem
import kotlinx.android.synthetic.main.item_new_update.view.*

class DetailCategoriesAdapter(
    private val mComicItems: MutableList<ComicItem>,
    private val mOnClickComicListener: OnClickComicListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mLayoutInflater: LayoutInflater? = null

    interface OnClickComicListener {
        fun onClickComic(comicItem: ComicItem)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(viewGroup.context)
        }
        val view = mLayoutInflater!!.inflate(R.layout.item_new_update, viewGroup, false)
        return ItemViewHolder(view, viewGroup.context, mOnClickComicListener)
    }

    override fun getItemCount(): Int {
        return mComicItems.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val comicItem = mComicItems[position]
        (viewHolder as ItemViewHolder).bindData(comicItem)
    }

    internal class ItemViewHolder(
        itemView: View,
        private val context: Context,
        private val mOnClickComicListener: OnClickComicListener
    ) : RecyclerView.ViewHolder(itemView) {

        private lateinit var mComicItem: ComicItem

        init {
            itemView.setOnClickListener {
                mOnClickComicListener.onClickComic(mComicItem)
            }
        }

        fun bindData(comicItem: ComicItem) {
            mComicItem = comicItem
            Glide.with(context).load(comicItem.urlImage).into(itemView.image_new_update)
            itemView.text_chapter.text = comicItem.chapter
            itemView.text_time_update.text = comicItem.time
            itemView.text_title_new_update.text = comicItem.title
        }

    }
}