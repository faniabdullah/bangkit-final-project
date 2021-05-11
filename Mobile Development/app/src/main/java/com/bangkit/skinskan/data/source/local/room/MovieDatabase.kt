package com.bangkit.faniabdullah_jetpack.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

}