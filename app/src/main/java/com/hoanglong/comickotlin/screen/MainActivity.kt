package com.hoanglong.comickotlin.screen

import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import com.hoanglong.comickotlin.R
import com.hoanglong.comickotlin.screen.base.BaseActivity
import com.hoanglong.comickotlin.screen.category.CategoryFragment
import com.hoanglong.comickotlin.screen.home.HomeFragment
import com.hoanglong.comickotlin.screen.profile.ProfileFragment
import com.hoanglong.comickotlin.utils.FragTrans
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initComponent() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun initData() {

    }

    private val mOnNavigationItemSelectedListener
            = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                var fragment: Fragment? = supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
                if (fragment == null) {
                    fragment = HomeFragment()
                }
                FragTrans.addFragment(
                    fragmentManager = supportFragmentManager,
                    fragment = fragment,
                    res = R.id.container,
                    tag = HomeFragment.TAG
                )
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_category -> {
                var fragment: Fragment? = supportFragmentManager.findFragmentByTag(CategoryFragment.TAG)
                if (fragment == null) {
                    fragment = CategoryFragment()
                }
                FragTrans.addFragment(
                    fragmentManager = supportFragmentManager,
                    fragment = fragment,
                    res = R.id.container,
                    tag = CategoryFragment.TAG
                )
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                var fragment: Fragment? = supportFragmentManager.findFragmentByTag(ProfileFragment.TAG)
                if (fragment == null) {
                    fragment = ProfileFragment()
                }
                FragTrans.addFragment(
                    fragmentManager = supportFragmentManager,
                    fragment = fragment,
                    res = R.id.container,
                    tag = ProfileFragment.TAG
                )
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}
