package com.bangkit.skinskan.ui.detail.detail_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailResultViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is articles Fragment"
    }
    val text: LiveData<String> = _text
}