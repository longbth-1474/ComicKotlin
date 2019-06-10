package com.hoanglong.comickotlin.screen.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {
    protected abstract fun getLayoutResources(): Int

    protected abstract fun initComponent(view: View)

    protected abstract fun initData(saveInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = null
        if (container != null) {
            view = LayoutInflater.from(container.context).inflate(getLayoutResources(), container, false)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent(view)
        initData(savedInstanceState)
    }
}