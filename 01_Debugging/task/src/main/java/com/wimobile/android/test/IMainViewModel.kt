package com.wimobile.android.test

import androidx.lifecycle.LiveData

interface IMainViewModel {
    val data: LiveData<String>
    fun setData(value: String)
}