package com.syarif.dicodingandroidcourse

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _counterValue = MutableLiveData<Int>(0)
    val counterValue get() = _counterValue

    fun addCounter() {
        _counterValue.value = _counterValue.value?.plus(1)
        if (_counterValue.value!! >33) _counterValue.value = 0;
    }
}