package com.bangkit.skinskan.ui.analytics

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bangkit.skinskan.BuildConfig
import com.bangkit.skinskan.databinding.FragmentAnalitycsBinding
import com.bangkit.skinskan.ui.detail.DetailResultActivity
import com.bangkit.skinskan.utils.ViewModelFactory
import com.bumptech.glide.Glide
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Logger
import kotlin.collections.HashMap


class AnalyticsFragment : Fragment() {
    private lateinit var homeViewModel: AnalyticsViewModel
    private var _binding: FragmentAnalitycsBinding? = null
    private val binding get() = _binding as FragmentAnalitycsBinding

    private var fileUri: Uri? = null

    private var mediaPath: String? = null
    private var mImageFileLocation = ""
    private var postPath: String? = null


    companion object {
        const val SHOWCASE_ID = "SHOWCASE_ID_1"
        const val REQUEST_TAKE_PHOTO = 0
        const val REQUEST_PICK_PHOTO = 2
        const val CAMERA_PIC_REQUEST = 1111

        private val TAG = AnalyticsFragment::class.java.simpleName

        const val CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100

        const val MEDIA_TYPE_IMAGE = 1
        private const val IMAGE_DIRECTORY_NAME = "Android File Upload"

        private fun getOutputMediaFile(type: Int): File? {
            // External sdcard location
            val mediaStorageDir = File(
                Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME
            )
            if (!mediaStorageDir.exists()) {
                if (!mediaStorageDir.mkdirs()) {
                    Log.d(
                        TAG, "Oops! Failed create "
                                + IMAGE_DIRECTORY_NAME + " directory"
                    )
                    return null
                }
            }

            val timeStamp = SimpleDateFormat(
                "yyyyMMdd_HHmmss",
                Locale.getDefault()
            ).format(Date())
            val mediaFile: File
            if (type == MEDIA_TYPE_IMAGE) {
                mediaFile = File(
                    mediaStorageDir.path + File.separator
                            + "IMG_" + ".jpg"
                )
            } else {
                return null
            }

            return mediaFile
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAnalitycsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.camBtn.setOnClickListener {
            captureImage()
        }

        binding.uploadBtn.setOnClickListener {
            val galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(galleryIntent, REQUEST_PICK_PHOTO)
        }

        binding.buttonProcess.setOnClickListener {
            uploadFile()
        }

        showCaseAnalitycs()
    }

    private fun showCaseAnalitycs() {
        val config = ShowcaseConfig()
        config.delay = 500
        val sequence = MaterialShowcaseSequence(activity, SHOWCASE_ID)

        sequence.setConfig(config)

        sequence.addSequenceItem(
            binding.takeImageShowCase,
            "This is for get picture from camera to analityc", "GOT IT"
        )

        sequence.addSequenceItem(
            binding.choseImageShowCase,
            "This is for choose picture from gallery to analityc ", "GOT IT"
        )


        sequence.addSequenceItem(
            binding.processShowCase,
            "This is for process image ", "GOT IT"
        )

        sequence.start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TAKE_PHOTO || requestCode == REQUEST_PICK_PHOTO) {
            if (data != null) {
                val selectedImage = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

                val cursor = context?.contentResolver?.query(
                    selectedImage!!,
                    filePathColumn,
                    null,
                    null,
                    null
                )
                assert(cursor != null)
                cursor!!.moveToFirst()

                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                mediaPath = cursor.getString(columnIndex)
                binding.imageAnalitics.setImageBitmap(BitmapFactory.decodeFile(mediaPath))
                cursor.close()


                postPath = mediaPath
            }


        } else if (requestCode == CAMERA_PIC_REQUEST) {
            if (Build.VERSION.SDK_INT > 21) {

                Glide.with(this).load(mImageFileLocation).into(binding.imageAnalitics)
                postPath = mImageFileLocation

            } else {
                Glide.with(this).load(fileUri).into(binding.imageAnalitics)
                postPath = fileUri!!.path

            }

        }
    }

    @Throws(IOException::class)
    internal fun createImageFile(): File {
        Logger.getAnonymousLogger().info("Generating the image - method started")

        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmSS").format(Date())
        val imageFileName = "IMAGE_" + timeStamp
        val storageDirectory =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/photo_saving_app")
        Logger.getAnonymousLogger().info("Storage directory set")

        if (!storageDirectory.exists()) storageDirectory.mkdir()
        val image = File(storageDirectory, imageFileName + ".jpg")

        Logger.getAnonymousLogger().info("File name and path set")

        mImageFileLocation = image.absolutePath
        return image
    }


    fun captureImage() {
        if (Build.VERSION.SDK_INT > 21) { //use this if Lollipop_Mr1 (API 22) or above
            val callCameraApplicationIntent = Intent()
            callCameraApplicationIntent.action = MediaStore.ACTION_IMAGE_CAPTURE

            var photoFile: File? = null

            try {
                photoFile = createImageFile()
            } catch (e: IOException) {
                Log.e("hello error found", " ms = " + e.message)
                Logger.getAnonymousLogger().info("Exception error in generating the file")
                e.printStackTrace()
            }
            val outputUri = FileProvider.getUriForFile(
                requireActivity(),
                BuildConfig.APPLICATION_ID + ".provider",
                photoFile!!
            )
            callCameraApplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri)

            callCameraApplicationIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)

            Logger.getAnonymousLogger().info("Calling the camera App by intent")

            startActivityForResult(callCameraApplicationIntent, CAMERA_PIC_REQUEST)
        } else {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE)

            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri)

            startActivityForResult(intent, CAMERA_PIC_REQUEST)
        }


    }

    fun getOutputMediaFileUri(type: Int): Uri {
        return Uri.fromFile(getOutputMediaFile(type))
    }


    private fun uploadFile() {
        if (postPath == null || postPath == "") {
            Toast.makeText(activity, "image null ", Toast.LENGTH_SHORT).show()
            return
        } else {
            loadingAnimation(true)
            val map = HashMap<String, RequestBody>()
            val file = File(postPath!!)
            val requestBody = file.asRequestBody("*/*".toMediaTypeOrNull())
            map["file\"; filename=\"" + file.name + "\""] = requestBody

            val factory = ViewModelFactory.getInstance(requireContext())
            homeViewModel = ViewModelProvider(this, factory)[AnalyticsViewModel::class.java]

            activity?.let {
                homeViewModel.getPrediction(map).observe(it, { prediction ->
                    val intent = Intent(activity, DetailResultActivity::class.java)
                    Toast.makeText(activity, "prediction $prediction", Toast.LENGTH_SHORT).show()
                    intent.putExtra(
                        DetailResultActivity.RESULT_PREDICTION,
                        prediction.prediction.toString()
                    )
                    startActivity(intent)
                    loadingAnimation(false)
                })
            }
        }
    }


    private fun loadingAnimation(state: Boolean) {
        if (state) {
            binding.imageAnalitics.visibility = View.GONE
            binding.uploadBtn.visibility = View.GONE
            binding.buttonProcess.visibility = View.GONE
            binding.camBtn.visibility = View.GONE
            binding.cardView2.visibility = View.GONE
            binding.animationLoading.visibility = View.VISIBLE
        } else {
            binding.imageAnalitics.visibility = View.VISIBLE
            binding.uploadBtn.visibility = View.VISIBLE
            binding.buttonProcess.visibility = View.VISIBLE
            binding.camBtn.visibility = View.VISIBLE
            binding.cardView2.visibility = View.VISIBLE
            binding.animationLoading.visibility = View.GONE
        }
    }
}