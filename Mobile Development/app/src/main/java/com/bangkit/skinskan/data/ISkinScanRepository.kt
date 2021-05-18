package com.bangkit.skinskan.data

import androidx.lifecycle.LiveData
import com.bangkit.skinskan.data.source.local.entity.MapsEntity


interface ISkinScanRepository {
    fun getHospitalNearBy(latitude : String , longitude : String): LiveData<List<MapsEntity>>
}