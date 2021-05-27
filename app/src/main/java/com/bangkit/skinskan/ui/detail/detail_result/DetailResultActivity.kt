package com.bangkit.skinskan.ui.detail.detail_result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinskan.databinding.ActivityDetailResultBinding
import com.bangkit.skinskan.ui.nearby.NearByActivity

class DetailResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.seeMoretBtn.setOnClickListener{
            val intent = Intent(this, NearByActivity::class.java)
            startActivity(intent)
        }
    }
}