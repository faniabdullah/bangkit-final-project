package com.bangkit.skinskan.ui.detail

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinskan.databinding.ActivityDetailBinding
import com.bangkit.skinskan.ui.detail.detail_result.DetailResultActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle: Bundle = intent.extras!!
        val resId: Bitmap = bundle.get("image") as Bitmap
        binding.resultIV.setImageBitmap(resId)
        binding.processBtn.setOnClickListener {
            val intent = Intent(this, DetailResultActivity::class.java)
            startActivity(intent)
        }
    }


}