package com.hoanglong.comickotlin.screen.profile

import android.os.Bundle
import android.view.View
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.screen.base.BaseFragment

class ProfileFragment : BaseFragment() {

    companion object {
        val TAG = ProfileFragment::class.simpleName
    }

    override fun getLayoutResources(): Int {
        return R.layout.fragment_profile
    }

    override fun initComponent(view: View) {
    }

    override fun initData(saveInstanceState: Bundle?) {
    }

}
