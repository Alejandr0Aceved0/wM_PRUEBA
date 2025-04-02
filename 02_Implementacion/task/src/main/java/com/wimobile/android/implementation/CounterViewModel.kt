package com.wimobile.android.implementation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel(), ICounterViewModel {
    // TODO: Implementar LiveData y lógica de contador

    override val counter: LiveData<Int>
        get() = TODO("Not yet implemented")

    override fun increment() {
        TODO("Not yet implemented")
    }
}