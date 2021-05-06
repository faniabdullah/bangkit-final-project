package com.bangkit.skinskan.ui.analytics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnalyticsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Analytics Fragment"
    }
    val text: LiveData<String> = _text
}