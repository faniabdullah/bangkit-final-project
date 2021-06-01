package com.bangkit.skinskan.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "tb_article")
@Parcelize
data class ArticleEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "author")
    val author: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "content")
    val description: String,

    @ColumnInfo(name = "date")
    val release_date: String,

    @ColumnInfo(name = "imgPath")
    val imgPath: String
) : Parcelable