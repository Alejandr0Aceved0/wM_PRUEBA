package com.wimobile.android.implementation

import androidx.lifecycle.LiveData

interface ICounterViewModel {
    val counter: LiveData<Int>
    fun increment()
}