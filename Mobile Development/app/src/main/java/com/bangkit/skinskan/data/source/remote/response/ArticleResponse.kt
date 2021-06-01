package com.bangkit.skinskan.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleResponse (
    val id: String,
    val author: String,
    val title: String,
    val description: String,
    val release_date: String,
    val imgPath: String
):Parcelable