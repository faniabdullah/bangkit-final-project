package com.bangkit.skinskan.ui.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinskan.R
import com.bangkit.skinskan.databinding.ActivityArticleDetailBinding

class DetailArticle : AppCompatActivity() {
    lateinit var binding: ActivityArticleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}