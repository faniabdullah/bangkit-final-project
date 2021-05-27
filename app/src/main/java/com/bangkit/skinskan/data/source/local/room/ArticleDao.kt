@file:Suppress("AndroidUnresolvedRoomSqlReference")

package com.bangkit.faniabdullah_jetpack.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.data.source.local.entity.PhotoEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM tb_article")
    fun getListArticle(): DataSource.Factory<Int, ArticleEntity>

    @Transaction
    @Query("SELECT * FROM tb_article WHERE id= :id")
    fun getArticleById(id: String): LiveData<ArticleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: List<ArticleEntity>)

    @Update
    fun updateArticle(article: ArticleEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photo: List<PhotoEntity>)



}