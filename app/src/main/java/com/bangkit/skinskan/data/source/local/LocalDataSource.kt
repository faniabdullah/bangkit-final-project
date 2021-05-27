package com.bangkit.skinskan.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.bangkit.faniabdullah_jetpack.data.source.local.room.ArticleDao
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.data.source.local.entity.PhotoEntity

class LocalDataSource private constructor(private val mArticleDao: ArticleDao){

        companion object{
            private var INSTANCE : LocalDataSource? = null

            fun getInstance(articleDao: ArticleDao): LocalDataSource =
                INSTANCE ?: LocalDataSource(articleDao)
        }

    fun getAllArticles():DataSource.Factory<Int, ArticleEntity> = mArticleDao.getListArticle()

    fun getArticlesById(id: String): LiveData<ArticleEntity> =
        mArticleDao.getArticleById(id)

    fun insertArticles(article: List<ArticleEntity>) = mArticleDao.insertArticle(article)

    fun updateArticles(article: ArticleEntity){
        mArticleDao.updateArticle(article)
    }

    fun insertPhoto(photo: List<PhotoEntity>) = mArticleDao.insertPhotos(photo)

}