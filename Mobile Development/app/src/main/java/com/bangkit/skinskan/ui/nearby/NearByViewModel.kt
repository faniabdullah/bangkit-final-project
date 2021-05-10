package com.bangkit.skinskan.ui.nearby

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NearByViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is articles Fragment"
    }
    val text: LiveData<String> = _text
}