package com.bangkit.skinskan.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticlesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is articles Fragment"
    }
    val text: LiveData<String> = _text
}