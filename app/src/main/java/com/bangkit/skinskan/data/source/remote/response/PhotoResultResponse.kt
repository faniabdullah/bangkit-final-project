package com.bangkit.skinskan.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PhotoResultResponse (
    @SerializedName("photoId")
    var photoId: String
)