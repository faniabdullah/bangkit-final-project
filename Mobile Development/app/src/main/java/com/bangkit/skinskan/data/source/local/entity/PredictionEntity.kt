package com.bangkit.skinskan.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PredictionEntity(
    val prediction: Int,
) : Parcelable