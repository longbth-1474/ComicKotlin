package com.hoanglong.comickotlin.screen.comic

import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.bumptech.glide.Glide
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.comic.Chapter
import com.hoanglong.comickotlin.data.model.comic.ComicDetail
import com.hoanglong.comickotlin.data.model.home.Comic
import com.hoanglong.comickotlin.data.repository.comic.ComicDataSource
import com.hoanglong.comickotlin.data.repository.comic.ComicRepository
import com.hoanglong.comickotlin.screen.base.BaseFragment
import com.hoanglong.comickotlin.screen.chapter.ChapterFragment
import com.hoanglong.comickotlin.utils.FragTrans
import com.hoanglong.comickotlin.utils.SimpleDividerItemDecoration
import com.hoanglong.comickotlin.utils.Utils
import kotlinx.android.synthetic.main.fragment_comic.*

class ComicFragment : BaseFragment(), View.OnClickListener,
    ComicContract.View, ComicAdapter.OnClickComicListener, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var mComic: Comic
    private lateinit var mComicPresenter: ComicPresenter
    private lateinit var mComicDetail: ComicDetail

    companion object {
        val TAG = ComicFragment::class.simpleName
        private const val BUNDLE_COMIC = "BUNDLE_COMIC"

        fun newInstance(comic: Comic): ComicFragment {
            val bundle = Bundle()
            bundle.putParcelable(BUNDLE_COMIC, comic)
            val fragment = ComicFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments == null) {
            return
        }
        mComic = arguments!!.getParcelable(BUNDLE_COMIC)!!
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_comic
    }

    override fun initComponent(view: View) {
        ic_back.setOnClickListener(this)
        relative_start_read.setOnClickListener(this)
        ic_star.setOnClickListener(this)
        swipe_comic.setOnRefreshListener(this)
    }

    override fun initData(saveInstanceState: Bundle?) {
        text_title_comic.text = mComic.title
        val comicDataSource = ComicDataSource()
        val comicRepository = ComicRepository(comicDataSource)
        mComicPresenter = ComicPresenter(comicRepository)
        mComicPresenter.setView(this)
        mComicPresenter.getComicDetail(mComic.url)
    }

    override fun getDataComicSuccess(comicDetail: ComicDetail) {
        mComicDetail = comicDetail
        text_title_comic.text = comicDetail.title
        text_other_name.text = String.format(getString(R.string.title_other_name), comicDetail.titleOther)
        text_author.text = String.format(getString(R.string.title_author), comicDetail.author)
        text_status.text = String.format(getString(R.string.title_status), comicDetail.status)
        text_viewer.text = String.format(getString(R.string.title_viewer), comicDetail.viewer)
        text_content.text = comicDetail.content
        text_type_comic.text = String.format(getString(R.string.title_type), comicDetail.type)
        text_time_update.text = comicDetail.timeUpdate
        Glide.with(context!!).load(mComic.urlImage).into(image_comic)

        val chapterAdapter = ComicAdapter(comicDetail.chapters, this)
        recycler_new_chapter.addItemDecoration(SimpleDividerItemDecoration(context!!))
        recycler_new_chapter.adapter = chapterAdapter
    }

    override fun hideProgressBar() {
        progress_comic.visibility = View.GONE
        constraint_comic.visibility = View.VISIBLE
    }

    override fun getDataComicError(error: String) {
        Utils.toast(context, error)
    }

    override fun onClickComic(chapter: Chapter, position: Int) {
        if (fragmentManager != null) {
            FragTrans.addFragment(
                fragmentManager!!,
                ChapterFragment.newInstance(chapter, mComicDetail, position),
                R.id.container,
                ChapterFragment.TAG!!, true, -1, -1
            )
        }
    }

    override fun onRefresh() {
        Handler().postDelayed({
            swipe_comic.isRefreshing = false
            constraint_comic.visibility = View.GONE
            progress_comic.visibility = View.VISIBLE
            mComicPresenter.getComicDetail(mComic.url)
        }, 1000)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.ic_back -> if (fragmentManager != null) {
                fragmentManager!!.popBackStack()
            }
            R.id.relative_start_read -> {
            }
            R.id.ic_star -> {
            }
        }
    }

}