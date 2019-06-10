package com.hoanglong.comickotlin.screen.detail_category

import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.category.Category
import com.hoanglong.comickotlin.data.model.detail_category.ComicItem
import com.hoanglong.comickotlin.data.model.detail_category.DetailCategoriesAPI
import com.hoanglong.comickotlin.data.model.home.Comic
import com.hoanglong.comickotlin.data.repository.detail_category.DetailCategoriesDataSource
import com.hoanglong.comickotlin.data.repository.detail_category.DetailCategoriesRepository
import com.hoanglong.comickotlin.screen.base.BaseActivity
import com.hoanglong.comickotlin.screen.comic.ComicFragment
import com.hoanglong.comickotlin.utils.FragTrans
import com.hoanglong.comickotlin.utils.Utils
import kotlinx.android.synthetic.main.activity_detail_category.*

class DetailCategoryActivity : BaseActivity(), DetailCategoriesContract.View,
    DetailCategoriesAdapter.OnClickComicListener {

    private lateinit var mCategory: Category
    private var mPage: Int = 1

    companion object {
        const val BUNDLE_CATEGORY = "BUNDLE_CATEGORY"
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_detail_category
    }

    override fun initComponent() {
        setSupportActionBar(toolbar)
        val drawable = ContextCompat.getDrawable(applicationContext, R.drawable.ic_filter)
        toolbar.overflowIcon = drawable
        mCategory = intent.getParcelableExtra(BUNDLE_CATEGORY)
    }

    override fun initData() {
        val dataSource = DetailCategoriesDataSource()
        val repository = DetailCategoriesRepository(dataSource)
        val presenter = DetailCategoriesPresenter(repository)
        presenter.setView(this)
        presenter.getDetailCategories(mCategory.url!!, mPage)
        text_title.text = String.format(
            getString(R.string.title_detail_category), mCategory.title
        )
    }

    override fun getDataSuccess(detailCategoriesAPI: DetailCategoriesAPI) {
        val detailCategoriesAdapter =
            DetailCategoriesAdapter(detailCategoriesAPI.comicsCategory.comics, this)
        recycler_content_category.setHasFixedSize(true)
        recycler_content_category.adapter = detailCategoriesAdapter
    }

    override fun getDataError(error: String) {
        Utils.toast(context = this, message = error)
    }

    override fun hideProgressBar() {
        progress_detail.visibility = View.GONE
    }

    override fun onClickComic(comicItem: ComicItem) {
        val comic = Comic()
        comic.urlImage = comicItem.urlImage
        comic.title = comicItem.title
        comic.time = comicItem.time
        comic.chapter = comicItem.chapter
        comic.url = comicItem.url
        comic.id = comicItem.id

        FragTrans.addFragment(
            supportFragmentManager,
            ComicFragment.newInstance(comic),
            R.id.container, ComicFragment.TAG!!, true, -1, -1
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_date_update) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

