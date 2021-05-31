package com.bangkit.skinskan.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.skinskan.data.SkinScanRepository
import com.bangkit.skinskan.di.Injection
import com.bangkit.skinskan.ui.analytics.AnalyticsViewModel
import com.bangkit.skinskan.ui.nearby.NearByViewModel

class ViewModelFactory private constructor(private val mSkinScanRepository: SkinScanRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideSkinScanRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(NearByViewModel::class.java) -> {
                NearByViewModel(mSkinScanRepository) as T
            }
            modelClass.isAssignableFrom(AnalyticsViewModel::class.java) -> {
                AnalyticsViewModel(mSkinScanRepository) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}