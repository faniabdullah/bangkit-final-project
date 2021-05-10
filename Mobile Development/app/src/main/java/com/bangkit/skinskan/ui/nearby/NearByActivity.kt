package com.bangkit.skinskan.ui.nearby

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinskan.databinding.ActivityDetailNearbyBinding

class NearByActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailNearbyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNearbyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}