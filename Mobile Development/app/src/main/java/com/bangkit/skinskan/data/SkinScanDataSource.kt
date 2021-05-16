package com.bangkit.skinskan.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.vo.Resource

interface SkinScanDataSource {

    fun getAllArticles(): LiveData<Resource<PagedList<ArticleEntity>>>

    fun getArticlesDetail(id: String): LiveData<ArticleEntity>

}