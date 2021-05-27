package com.bangkit.skinskan.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "tb_photo")
@Parcelize
data class PhotoEntity (

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "photoId")
    val photoId: String

) : Parcelable