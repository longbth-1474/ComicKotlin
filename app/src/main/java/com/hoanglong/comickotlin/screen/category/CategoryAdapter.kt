package com.hoanglong.comickotlin.screen.category

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.category.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(private val categories: List<Category>,
                      private val mOnClickCategoriesListener: OnClickCategoriesListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    interface OnClickCategoriesListener {
        fun onClickCategory(category: Category)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): CategoryViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_category, viewGroup, false)
        return CategoryViewHolder(view,mOnClickCategoriesListener)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(categoryViewHolder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        categoryViewHolder.bindData(category)
    }

    class CategoryViewHolder(itemView: View,
                             onClickCategoriesListener: OnClickCategoriesListener) : RecyclerView.ViewHolder(itemView) {

        private var mCategory: Category? = null

        init {
            itemView.setOnClickListener{
                onClickCategoriesListener.onClickCategory(mCategory!!)
            }
        }

        fun bindData(category: Category) {
            mCategory = category
            itemView.text_category.text =  category.title
        }

    }
}