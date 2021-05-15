package com.bangkit.skinskan.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity()
@Parcelize
data class ArticleEntity(
    @PrimaryKey
    @NonNull
    val id: String,
    val title: String,
    val description: String,
    val release_date: String,
) : Parcelable