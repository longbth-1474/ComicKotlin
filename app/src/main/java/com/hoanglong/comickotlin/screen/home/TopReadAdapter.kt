package com.hoanglong.comickotlin.screen.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.home.Proposal
import kotlinx.android.synthetic.main.item_top_read.view.*

class TopReadAdapter(private val comics: List<Proposal>, private val mOnClickTopReadListener: OnClickTopReadListener) :
    RecyclerView.Adapter<TopReadAdapter.TopReadViewHolder>() {

    interface OnClickTopReadListener {
        fun onClickUpdate(proposal: Proposal)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TopReadViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_top_read, viewGroup, false)
        return TopReadViewHolder(view, mOnClickTopReadListener, viewGroup.context)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    override fun onBindViewHolder(topReadViewHolder: TopReadViewHolder, position: Int) {
        val comic = comics[position]
        topReadViewHolder.bindData(comic)
    }


    class TopReadViewHolder(
        itemView: View,
        private var mOnClickTopReadListener: OnClickTopReadListener,
        private var context: Context
    ) : RecyclerView.ViewHolder(itemView) {

        private lateinit var mComic: Proposal

        init {
            itemView.setOnClickListener {
                mOnClickTopReadListener.onClickUpdate(mComic)
            }
        }

        fun bindData(comic: Proposal) {
            mComic = comic
            Glide.with(context).load(comic.urlImage).into(itemView.image_top_read)
            itemView.text_title_top_read.text = comic.title
            itemView.text_recent_chapter.text = comic.chapter
        }

    }
}