package com.bangkit.skinskan.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MapsEntity(
    val id: String,
    val latitude: Double,
    val lng: Double,
    val namePlace: String,
    val nameStreet: String,
) : Parcelable