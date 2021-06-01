package com.bangkit.skinskan.data.source

import androidx.lifecycle.LiveData
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity

interface ArticleDataSource {
    fun getAllArticles(): LiveData<List<ArticleEntity>>
}