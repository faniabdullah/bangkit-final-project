package com.bangkit.skinskan.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
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
        title = getString(R.string.title_detail)

        val prediction = intent.getStringExtra(RESULT_PREDICTION)
        if (prediction == "1") {
            binding.resultDanger.visibility = View.VISIBLE
            binding.resultSub.visibility = View.GONE
        } else {
            binding.resultDanger.visibility = View.GONE
            binding.resultSub.visibility = View.VISIBLE
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