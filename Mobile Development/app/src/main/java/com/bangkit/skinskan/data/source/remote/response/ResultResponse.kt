package com.bangkit.skinskan.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class ResultResponse(
    @field:SerializedName("prediction")
    val predictionResult: Int? = null,
)