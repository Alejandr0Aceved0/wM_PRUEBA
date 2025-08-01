package com.wimobile.android.test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(), IMainViewModel {

    // Se creó una variable privada mutable para almacenar los datos y observar el cambio de la bateria,
    // usando un valor privado como observable y un valor publico para retornar

    private val _data = MutableLiveData<String>()

    override val data: LiveData<String>
        get() = _data

    override fun setData(value: String) {
        _data.value = value
    }

}