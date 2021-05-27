package com.bangkit.skinskan.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ResultResponse (
    @SerializedName("id")
    var id: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("release_date")
    var release_date: String
)