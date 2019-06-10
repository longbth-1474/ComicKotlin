package com.hoanglong.comickotlin.screen.home

import android.os.Bundle
import android.view.View
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.data.model.home.Home
import com.hoanglong.comickotlin.data.model.home.Proposal
import com.hoanglong.comickotlin.data.repository.home.HomeDataSource
import com.hoanglong.comickotlin.data.repository.home.HomeRepository
import com.hoanglong.comickotlin.screen.base.BaseFragment
import com.hoanglong.comickotlin.utils.Utils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), HomeContract.View, View.OnClickListener, TopReadAdapter.OnClickTopReadListener {

    private lateinit var mHomePresenter: HomePresenter

    companion object {
        val TAG = HomeFragment::class.simpleName
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_home
    }

    override fun initComponent(view: View) {
        relative_search.setOnClickListener(this)
        constraint_top_read.setOnClickListener(this)
        constraint_new_update.setOnClickListener(this)
    }

    override fun initData(saveInstanceState: Bundle?) {
        val mHomeDataSource = HomeDataSource()
        val mHomeRepository = HomeRepository(mHomeDataSource)
        mHomePresenter = HomePresenter(mHomeRepository)
        mHomePresenter.setView(this)
        mHomePresenter.getDataHome()
    }

    override fun getDataHomeSuccess(home: Home) {
        initData(home)
    }

    private fun initData(home: Home) {
        recycler_top_read.adapter = TopReadAdapter(home.proposal, this)
    }

    override fun hideProgressBar() {
        progress_home.visibility = View.GONE
    }

    override fun getDataHomeError(error: String) {
        Utils.toast(context, error)
    }

    override fun onClickUpdate(proposal: Proposal) {
    }

    override fun onClick(v: View?) {
    }
}