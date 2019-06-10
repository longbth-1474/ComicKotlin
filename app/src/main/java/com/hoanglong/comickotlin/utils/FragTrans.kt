package com.hoanglong.comickotlin.utils

import android.support.annotation.AnimRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

class FragTrans {
    companion object {
        fun addFragment(fragmentManager: FragmentManager, fragment: Fragment, res: Int, tag: String?) {
            if (tag != null) {
                addFragment(fragmentManager, fragment, res, tag, false, -1, -1)
            }
        }

        fun addFragment(
            fragmentManager: FragmentManager, fragment: Fragment, res: Int, tag: String,
            isAddToBackStack: Boolean, @AnimRes animIn: Int, @AnimRes animOut: Int
        ) {
            val currentFragment = fragmentManager.findFragmentByTag(tag)
            val transaction = fragmentManager.beginTransaction()
            if (currentFragment != null) {
                showFragment(fragmentManager, transaction, fragment)
                return
            }
            transaction.add(res, fragment, tag)
            if (isAddToBackStack) {
                transaction.addToBackStack(null)
            }
            if (animIn != -1 && animOut != -1) {
                transaction.setCustomAnimations(animIn, animOut)
            }
            transaction.commit()
        }

        private fun showFragment(
            fragmentManager: FragmentManager,
            transaction: FragmentTransaction,
            fragment: Fragment
        ) {
            for (i in 0 until fragmentManager.fragments.size) {
                transaction.hide(fragmentManager.fragments[i])
            }
            transaction.show(fragment).commit()
        }
    }
}