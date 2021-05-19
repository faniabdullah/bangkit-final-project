package com.bangkit.skinskan.ui.analytics

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bangkit.skinskan.databinding.FragmentAnalitycsBinding
import com.bangkit.skinskan.ui.detail.DetailActivity
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.*


class AnalyticsFragment : Fragment() {

    private lateinit var homeViewModel: AnalyticsViewModel
    private var _binding: FragmentAnalitycsBinding? = null

    private val binding get() = _binding as FragmentAnalitycsBinding

    companion object {
        const val REQUEST_IMAGE_CAPTURE = 1
        const val SELECT_PICTURE = 2
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(AnalyticsViewModel::class.java)

        _binding = FragmentAnalitycsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.camBtn.setOnClickListener {
            val camIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camIntent, REQUEST_IMAGE_CAPTURE)
        }

        binding.uploadBtn.setOnClickListener {
            val uploadIntent =
                Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(
                Intent.createChooser(uploadIntent, "Select Picture"),
                SELECT_PICTURE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra("image", imageBitmap)
            val resultCode = imageBitmap.toBase64String()
            Log.e("result image as String", "= $resultCode")
            startActivity(intent)
        } else if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.getParcelable<Bitmap>("data")
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra("image", imageBitmap)
            startActivity(intent)
        }
    }


    fun Context.assetsToBitmap(fileName: String): Bitmap? {
        return try {
            val stream = assets.open(fileName)
            BitmapFactory.decodeStream(stream)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun Bitmap.toBase64String(): String {
        ByteArrayOutputStream().apply {
            compress(Bitmap.CompressFormat.JPEG, 90, this)
            val b: ByteArray = toByteArray()
            Log.e("result image as Array", "= " + Arrays.toString(b))
            return Base64.encodeToString(toByteArray(), Base64.DEFAULT)
        }
    }

    fun Bitmap.ToBase64Array(): ByteArray {
        ByteArrayOutputStream().apply {
            compress(Bitmap.CompressFormat.JPEG, 90, this)
            return toByteArray()
        }
    }

    fun String.toBitmap(): Bitmap? {
        Base64.decode(this, Base64.DEFAULT).apply {
            return BitmapFactory.decodeByteArray(this, 0, size)
        }
    }
}