package com.bangkit.skinskan.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.utils.DataArticle

class ArticlesViewModel : ViewModel() {


    val resultArticle: List<ArticleEntity> = DataArticle.generateDummyArticle()
}