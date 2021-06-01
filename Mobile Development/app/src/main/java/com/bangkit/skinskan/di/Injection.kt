package com.bangkit.skinskan.di

import android.content.Context
import com.bangkit.skinskan.data.SkinScanRepository
import com.bangkit.skinskan.data.source.remote.RemoteDataSource
import com.bangkit.skinskan.utils.jsonHelper

object Injection {
    fun provideSkinScanRepository(context: Context): SkinScanRepository {
        val remoteDataSource = RemoteDataSource.getInstance(jsonHelper(context))
        return SkinScanRepository.getInstance(remoteDataSource)
    }
}