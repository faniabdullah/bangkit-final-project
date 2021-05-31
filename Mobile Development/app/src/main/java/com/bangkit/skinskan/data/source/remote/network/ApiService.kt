package com.bangkit.skinskan.data.source.remote.network

import com.bangkit.skinskan.BuildConfig
import com.bangkit.skinskan.data.source.remote.response.ResponseMaps
import com.bangkit.skinskan.data.source.remote.response.ResultResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("place/nearbysearch/json")
    fun getHospitalNearBye(
        @Query("location") location: String,
        @Query("radius") radius: String = "2000",
        @Query("types") types: String = "hospital",
        @Query("key") key: String = BuildConfig.MAPS_TOKEN,
    ): Call<ResponseMaps>

    @Multipart
    @POST("/")
    fun getPrediction(
        @PartMap map: Map<String?, RequestBody?>?
    ): Call<ResultResponse>
}