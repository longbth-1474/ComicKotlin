package com.hoanglong.comickotlin.data.source

interface ICallback<T> {
    fun getDataSuccess(data: T)
    fun getDataError(error: String)
}