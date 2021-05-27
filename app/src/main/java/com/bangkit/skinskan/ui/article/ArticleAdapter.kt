package com.bangkit.skinskan.ui.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.skinskan.R
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.databinding.ItemRowArticlesBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlin.random.Random


class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    private val list = ArrayList<ArticleEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ArticleEntity)
    }

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowArticlesBinding.bind(itemView)
        private val mThumbIds = arrayOf<Int>(
            R.drawable.avatar_1 , R.drawable.avatar_2,
            R.drawable.avatar_3, R.drawable.avatar_10,
            R.drawable.avatar_12, R.drawable.avatar_6,
            R.drawable.avatar_4, R.drawable.avatar_5,
            R.drawable.avatar_13, R.drawable.avatar_2
        )
        var indexToGetImageFrom = Random.nextInt(0,9)
        fun bind(article: ArticleEntity) {
            binding.apply {

                titleArticle.text = article.title
                subArtcile.text = article.description
                timeArticle.text = article.release_date
                Glide.with(itemView)
                    .load(mThumbIds[indexToGetImageFrom])
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView)
            }
            itemView.setOnClickListener { onItemClickCallback.onItemClicked(article) }
        }
    }

    fun setList(article: List<ArticleEntity>) {
        list.clear()
        list.addAll(article)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_articles, parent, false)
        return ArticleViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}