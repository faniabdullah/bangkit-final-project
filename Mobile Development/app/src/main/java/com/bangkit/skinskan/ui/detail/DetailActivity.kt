package com.bangkit.skinskan.ui.detail

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.skinskan.databinding.ActivityDetailBinding
import com.bangkit.skinskan.ui.detail.detail_result.DetailResultActivity
import com.google.android.gms.auth.api.signin.internal.Storage
import com.google.android.gms.tasks.Task
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageMetadata
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.util.*

class DetailActivity : AppCompatActivity() {

    // [START storage_field_declaration]
    lateinit var storage: FirebaseStorage
    // [END storage_field_declaration]

    private lateinit var binding: ActivityDetailBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)


        // [START storage_field_initialization]
        storage = Firebase.storage("gs://skinscanproject-capstone.appspot.com")
        // [END storage_field_initialization]


        val bundle: Bundle = intent.extras!!
        val resId: Bitmap = bundle.get("image") as Bitmap
        binding.resultIV.setImageBitmap(resId)
        binding.processBtn.setOnClickListener {

            val storageRef = storage.reference
            val currentDateTime = LocalDateTime.now()

            val imagesRef: StorageReference = storageRef.child(currentDateTime.toString())

            val photoRef = storageRef.child("image/skinskan.jpg")

            imagesRef.name == photoRef.name
            imagesRef.path == photoRef.path

            binding.resultIV.isDrawingCacheEnabled = true
            binding.resultIV.buildDrawingCache()
            val bitmap = (binding.resultIV.drawable as BitmapDrawable).bitmap
            val baos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val data = baos.toByteArray()

            var uploadTask = imagesRef.putBytes(data)

            binding.progressBar.visibility = View.VISIBLE
            binding.processBtn.isEnabled = false
            uploadTask.addOnFailureListener {
                Log.d("Up", "Upload Failed")
            }.addOnSuccessListener { taskSnapshot ->
                Log.d("Up", "Upload Memory Success")
            }

            val intent = Intent(this, DetailResultActivity::class.java)
            startActivity(intent)

        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}