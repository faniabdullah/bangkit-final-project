package com.bangkit.skinskan.di

import com.bangkit.skinskan.data.SkinScanRepository
import com.bangkit.skinskan.data.source.remote.RemoteDataSource

object Injection {
    fun provideSkinScanRepository(): SkinScanRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return SkinScanRepository.getInstance(remoteDataSource)
    }
}