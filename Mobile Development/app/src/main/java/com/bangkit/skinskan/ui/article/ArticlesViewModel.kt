package com.bangkit.skinskan.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bangkit.skinskan.data.SkinScanRepository
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.utils.DataArticle

class ArticlesViewModel(private val skinScanRepository: SkinScanRepository) : ViewModel() {


    fun resultArticle(): LiveData<List<ArticleEntity>> = skinScanRepository.getAllArticles()

}