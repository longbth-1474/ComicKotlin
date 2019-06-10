package com.hoanglong.comickotlin.screen.category

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.category.Category
import com.hoanglong.comickotlin.data.repository.category.CategoryDataSource
import com.hoanglong.comickotlin.data.repository.category.CategoryRepository
import com.hoanglong.comickotlin.screen.base.BaseFragment
import com.hoanglong.comickotlin.screen.detail_category.DetailCategoryActivity
import com.hoanglong.comickotlin.utils.SimpleDividerItemDecoration
import com.hoanglong.comickotlin.utils.Utils
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseFragment(), CategoryContract.View, CategoryAdapter.OnClickCategoriesListener {

    companion object {
        val TAG = CategoryFragment::class.simpleName
    }

    override fun getCategoriesSuccess(categories: List<Category>) {
        val adapter = CategoryAdapter(categories, this)
        recycler_category.setHasFixedSize(true)
        recycler_category.addItemDecoration(SimpleDividerItemDecoration(context!!))
        recycler_category.adapter = adapter
    }

    override fun getCategoriesError(error: String) {
        Utils.toast(context = context, message = error)
    }

    override fun hideProgressbar() {
        progress_category.visibility = View.GONE
    }

    override fun initData(saveInstanceState: Bundle?) {
        val categoryDataSource = CategoryDataSource()
        val categoryRepository = CategoryRepository(categoryDataSource)
        val categoryPresenter = CategoryPresenter(categoryRepository)
        categoryPresenter.setView(this)
        categoryPresenter.getCategory()
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_category
    }

    override fun initComponent(view: View) {
    }

    override fun onClickCategory(category: Category) {
        val intent = Intent(activity,DetailCategoryActivity::class.java)
        intent.putExtra(DetailCategoryActivity.BUNDLE_CATEGORY,category)
        startActivity(intent)
    }
}
