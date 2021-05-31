package com.bangkit.skinskan.data

import androidx.lifecycle.LiveData
import com.bangkit.skinskan.data.source.local.entity.MapsEntity
import com.bangkit.skinskan.data.source.local.entity.PredictionEntity
import okhttp3.RequestBody


interface ISkinScanRepository {
    fun getHospitalNearBy(latitude: String, longitude: String): LiveData<List<MapsEntity>>
    fun getPrediction(hashMap: HashMap<String?, RequestBody?>?): LiveData<PredictionEntity>
}