package com.bangkit.skinskan.ui.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.databinding.ActivityArticleDetailBinding
import com.bumptech.glide.Glide

class DetailArticle : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    lateinit var binding: ActivityArticleDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
        title = "Detail Artikel"

        val detailArticle = intent.getParcelableExtra<ArticleEntity>(EXTRA_DATA)
        populateDataArticle(detailArticle)


    }

    private fun populateDataArticle(article: ArticleEntity?){
        article?.let {
            binding.titleArticle.text = article.title
            binding.tvAuthor.text = article.author
            binding.timeArticle.text = article.release_date
            binding.tvContent.text = article.description

            Glide.with(this)
                .load(article.imgPath)
                .into(binding.imageView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}