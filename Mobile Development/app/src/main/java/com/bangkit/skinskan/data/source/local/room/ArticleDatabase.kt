package com.bangkit.skinskan.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun movieDao(): ArticleDao

}