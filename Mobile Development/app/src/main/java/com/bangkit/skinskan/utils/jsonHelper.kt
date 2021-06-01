package com.bangkit.skinskan.utils

import android.content.Context
import com.bangkit.skinskan.data.source.remote.response.ArticleResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class jsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        }catch (ex: IOException){
            ex.printStackTrace()
            null
        }
    }

    fun loadArticle(): List<ArticleResponse> {
        val list = ArrayList<ArticleResponse>()
        try {

            val responseObject = JSONObject(parsingFileToString("daftarArticle.json").toString())
            val listArray = responseObject.getJSONArray("article")
            for (i in 0 until listArray.length()){
                val article = listArray.getJSONObject(i)

                val id = article.getString("id")
                val author = article.getString("author")
                val title = article.getString("title")
                val release_date = article.getString("date")
                val description = article.getString("content")
                val imgPath = article.getString("imgUrl")

                val articleResponse = ArticleResponse(id, author, title, description, release_date, imgPath)
                list.add(articleResponse)
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        return list
    }

}