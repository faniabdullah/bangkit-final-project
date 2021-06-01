package com.bangkit.skinskan.utils

import com.bangkit.skinskan.data.source.local.entity.ArticleEntity

object DataArticle {
    fun generateDummyArticle(): List<ArticleEntity> {
        val listArticle = ArrayList<ArticleEntity>()
        for (i in 1..10) {
            listArticle.add(
                ArticleEntity(
                    "1",
                    "INDOZONE",
                    "Skin Cancer",
                    "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"",
                    "12-02-2021",
                    "https://cdn.ayobandung.com/upload/bank_image/medium/catat-6-tampilan-kuku-ini-bisa-tunjukan-masalah-kesehatan.jpg"
                )
            )
        }
        return listArticle
    }
}