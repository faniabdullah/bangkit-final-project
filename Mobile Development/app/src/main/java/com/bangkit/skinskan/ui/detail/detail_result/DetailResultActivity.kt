package com.bangkit.skinskan.ui.detail.detail_result

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinskan.R
import com.bangkit.skinskan.databinding.ActivityDetailResultBinding
import com.bangkit.skinskan.ui.nearby.NearByActivity

class DetailResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailResultBinding

    companion object {
        const val RESULT_PREDICTION = "result_prediction"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailResultBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)
        title = "Detail Result"
        val prediction = intent.getStringExtra(RESULT_PREDICTION)
        if (prediction == "1") {
            binding.resultNumber.text = "1"
            binding.resultSub.text = getString(R.string.malignant)
        } else {
            binding.resultSub.text = getString(R.string.benign)
            binding.resultNumber.text = prediction
        }

        binding.seeMoretBtn.setOnClickListener {
            val intent = Intent(this, NearByActivity::class.java)
            intent.putExtra(NearByActivity.RESULT_PREDICTION , prediction)
            startActivity(intent)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}