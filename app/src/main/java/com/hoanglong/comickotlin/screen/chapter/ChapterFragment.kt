package com.hoanglong.comickotlin.screen.chapter

import android.os.Bundle
import android.view.View
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.chapter.ChapterComic
import com.hoanglong.comickotlin.data.model.comic.Chapter
import com.hoanglong.comickotlin.data.model.comic.ComicDetail
import com.hoanglong.comickotlin.data.repository.chapter.ChapterDataSource
import com.hoanglong.comickotlin.data.repository.chapter.ChapterRepository
import com.hoanglong.comickotlin.screen.base.BaseFragment
import com.hoanglong.comickotlin.utils.Utils
import kotlinx.android.synthetic.main.fragment_chapter.*
import java.util.ArrayList

class ChapterFragment : BaseFragment(), View.OnClickListener, ChapterContract.View {

    private lateinit var mChapterPresenter: ChapterPresenter
    private lateinit var mComic: ComicDetail
    private lateinit var mChapter: Chapter
    private var mPosition: Int = 0

    companion object {
        val TAG = ChapterFragment::class.simpleName
        private const val BUNDLE_CHAPTER = "BUNDLE_CHAPTER"
        private const val BUNDLE_POSITION = "BUNDLE_POSITION"
        private const val BUNDLE_LIST = "BUNDLE_LIST"

        fun newInstance(chapter: Chapter, comicDetail: ComicDetail, position: Int): ChapterFragment {
            val bundle = Bundle()
            bundle.putParcelable(BUNDLE_CHAPTER, chapter)
            bundle.putParcelable(BUNDLE_LIST, comicDetail)
            bundle.putInt(BUNDLE_POSITION, position)
            val fragment = ChapterFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments == null) return
        mChapter = arguments!!.getParcelable(BUNDLE_CHAPTER)!!
        mComic = arguments!!.getParcelable(BUNDLE_LIST)!!
        mPosition = arguments!!.getInt(BUNDLE_POSITION)
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_chapter
    }

    override fun initComponent(view: View) {
        ic_back.setOnClickListener(this)
        next_chap.setOnClickListener(this)
        previous_chap.setOnClickListener(this)
    }

    override fun initData(saveInstanceState: Bundle?) {
        val chapterDataSource = ChapterDataSource()
        val chapterRepository = ChapterRepository(chapterDataSource)
        mChapterPresenter = ChapterPresenter(chapterRepository)
        mChapterPresenter.setView(this)
        mChapterPresenter.getChapter(mChapter.urlChapter)
        text_title_chapter.text = mComic.title + " - " + mComic.chapters[mPosition].titleChapter
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ic_back -> if (fragmentManager != null) {
                fragmentManager!!.popBackStack()
            }
            R.id.previous_chap -> {

            }
            R.id.next_chap -> {

            }
        }
    }

    override fun getChapterSuccess(chapterComic: ChapterComic) {
        val images = ArrayList<String>()
        for (chapter in chapterComic.chapter.chapters) {
            val image = chapter.image
            val imageFormat = String.format(getString(R.string.image_html), image, image)
            images.add(imageFormat)
        }
        val temp = images.joinToString("")
        val html = String.format(getString(R.string.web_view), temp)
        webView_comic.settings.javaScriptEnabled = true
        webView_comic.loadDataWithBaseURL("", html, "text/html", "UTF-8", "")
    }

    override fun getChapterError(error: String) {
        Utils.toast(context, error)
    }

    override fun hideProgressbar() {
        progress_chap.visibility = View.GONE
        webView_comic.visibility = View.VISIBLE
    }


}
