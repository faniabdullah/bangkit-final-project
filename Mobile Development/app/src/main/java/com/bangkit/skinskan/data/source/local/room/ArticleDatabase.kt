package com.bangkit.faniabdullah_jetpack.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.data.source.local.entity.PhotoEntity

@Database(entities = [ArticleEntity::class, PhotoEntity::class], version = 1, exportSchema = false)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun movieDao(): ArticleDao

    companion object{
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(context: Context): ArticleDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                ArticleDatabase::class.java,
                "SkinSkan.db").build()
            }
    }

}