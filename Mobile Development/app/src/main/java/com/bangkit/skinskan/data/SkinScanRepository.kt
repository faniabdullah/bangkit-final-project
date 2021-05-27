package com.bangkit.skinskan.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bangkit.skinskan.data.source.local.entity.MapsEntity
import com.bangkit.skinskan.data.source.remote.RemoteDataSource
import com.bangkit.skinskan.data.source.remote.response.ResultsItem

class SkinScanRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    ISkinScanRepository {
    companion object {
        @Volatile
        private var instance: SkinScanRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): SkinScanRepository =
            instance ?: synchronized(this) {
                instance ?: SkinScanRepository(remoteDataSource).apply {
                    instance = this
                }
            }
    }

    override fun getHospitalNearBy(latitude: String, longitude: String): LiveData<List<MapsEntity>> {
        val movieResult = MutableLiveData<List<MapsEntity>>()
        remoteDataSource.getHospitalNearBy(
            latitude = latitude, longitude = longitude,
            callback = object : RemoteDataSource.LoadHospitalNearBy {

                override fun onMapsHospitalReceived(hospitalResponse: List<ResultsItem?>) {
                    val tvShowList = ArrayList<MapsEntity>()
                    for (response in hospitalResponse) {
                        if (response != null) {
                            val hospital = response.geometry?.location?.let {
                                MapsEntity(
                                    namePlace = response.name.toString(),
                                    latitude = it.lat,
                                    lng = it.lng,
                                    nameStreet = response.vicinity.toString(),
                                    id = "1"
                                )
                            }
                            if (hospital != null) {
                                tvShowList.add(hospital)
                            }
                        }
                    }
                    movieResult.postValue(tvShowList)
                }
            })

        return movieResult
    }
}