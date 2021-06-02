package com.bangkit.skinskan.ui.article

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.skinskan.data.source.local.entity.ArticleEntity
import com.bangkit.skinskan.databinding.FragmentArticlesBinding
import com.bangkit.skinskan.utils.ViewModelFactory

class ArticlesFragment : Fragment() {

    private var _binding: FragmentArticlesBinding? = null
    private lateinit var adapter: ArticleAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentArticlesBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val articleViewModel =
            ViewModelProvider(this, factory)[ArticlesViewModel::class.java]

        adapter = ArticleAdapter()

        articleViewModel.resultArticle().observe(viewLifecycleOwner, { articles ->
            adapter.setList(articles)
            adapter.notifyDataSetChanged()
            adapter.setOnItemClickCallback(object : ArticleAdapter.OnItemClickCallback {
                override fun onItemClicked(data: ArticleEntity) {
                    showDetailFragment(data)
                }
            })
        })

        binding.apply {
            rvArticle.layoutManager = LinearLayoutManager(context)
            rvArticle.setHasFixedSize(true)
            rvArticle.adapter = adapter
        }
    }

    private fun showDetailFragment(data: ArticleEntity) {
        val intent = Intent(activity, DetailArticle::class.java)
        intent.putExtra(DetailArticle.EXTRA_DATA, data)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}