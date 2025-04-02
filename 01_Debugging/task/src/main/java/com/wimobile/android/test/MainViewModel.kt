package com.wimobile.android.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(), IMainViewModel {

    override val data: LiveData<String>
        get() = TODO("Not yet implemented")

    override fun setData(value: String) {
        TODO("Not yet implemented")
    }

}