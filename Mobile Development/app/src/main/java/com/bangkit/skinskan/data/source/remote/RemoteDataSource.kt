package com.bangkit.skinskan.data.source.remote

import android.util.Log
import com.bangkit.skinskan.data.source.remote.network.ApiConfig
import com.bangkit.skinskan.data.source.remote.response.ResponseMaps
import com.bangkit.skinskan.data.source.remote.response.ResultResponse
import com.bangkit.skinskan.data.source.remote.response.ResultsItem
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor() {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply {
                    instance = this
                }
            }
    }

    fun getHospitalNearBy(
        callback: LoadHospitalNearBy,
        latitude: String,
        longitude: String
    ) {
        val location = "$latitude,$longitude"
        ApiConfig.getApiService().getHospitalNearBye(
            location
        )
            .enqueue(object : Callback<ResponseMaps> {
                override fun onResponse(
                    call: Call<ResponseMaps>,
                    response: Response<ResponseMaps>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onMapsHospitalReceived(it) }
                    }
                }

                override fun onFailure(call: Call<ResponseMaps>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                }
            })
    }

    fun getPrediction(
        callback: LoadPredictionCancer,
        map: HashMap<String, RequestBody>
    ) {
        ApiConfig.getApiServiceImageUploader().getPrediction(map)
            .enqueue(object : Callback<ResultResponse> {
                override fun onResponse(
                    call: Call<ResultResponse>,
                    response: Response<ResultResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback.onPredictionReceived(it) }
                    }
                }

                override fun onFailure(call: Call<ResultResponse>, t: Throwable) {
                    Log.e("Failure", "${t.message}")
                }
            })
    }

    interface LoadHospitalNearBy {
        fun onMapsHospitalReceived(hospitalResponse: List<ResultsItem?>)
    }

    interface LoadPredictionCancer {
        fun onPredictionReceived(resultResponse: ResultResponse)
    }


}