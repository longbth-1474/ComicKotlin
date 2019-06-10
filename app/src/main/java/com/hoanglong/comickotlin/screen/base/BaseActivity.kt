package com.hoanglong.comickotlin.screen.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    protected abstract fun getLayoutResource(): Int
    protected abstract fun initComponent()
    protected abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        initComponent()
        initData()
    }
}