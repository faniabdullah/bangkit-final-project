package com.bangkit.skinskan.ui.nearby

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.skinskan.data.SkinScanRepository
import com.bangkit.skinskan.data.source.local.entity.MapsEntity

class NearByViewModel(private val mSkinScanRepository: SkinScanRepository) : ViewModel() {

    fun getHospitalNearBy(latitude: String, longitude: String): LiveData<List<MapsEntity>> =
        mSkinScanRepository.getHospitalNearBy(latitude, longitude)
}