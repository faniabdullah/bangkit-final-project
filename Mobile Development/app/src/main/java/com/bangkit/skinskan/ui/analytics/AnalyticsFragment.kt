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

        /**
         * returning image / video
         */
        private fun getOutputMediaFile(type: Int): File? {
            // External sdcard location
            val mediaStorageDir = File(
                Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME
            )

            // Create the storage directory if it does not exist
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
            binding.camBtn,
            "This is for get picture from camera to analityc", "GOT IT"
        )

        sequence.addSequenceItem(
            binding.uploadBtn,
            "This is for choose picture from gallery to analityc ", "GOT IT"
        )
        sequence.start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_TAKE_PHOTO || requestCode == REQUEST_PICK_PHOTO) {
            if (data != null) {
                // Get the Image from data
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
                // Set the Image in ImageView for Previewing the Media
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

        // Here we create a "non-collision file name", alternatively said, "an unique filename" using the "timeStamp" functionality
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmSS").format(Date())
        val imageFileName = "IMAGE_" + timeStamp
        // Here we specify the environment location and the exact path where we want to save the so-created file
        val storageDirectory =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/photo_saving_app")
        Logger.getAnonymousLogger().info("Storage directory set")

        // Then we create the storage directory if does not exists
        if (!storageDirectory.exists()) storageDirectory.mkdir()

        // Here we create the file using a prefix, a suffix and a directory
        val image = File(storageDirectory, imageFileName + ".jpg")
        // File image = File.createTempFile(imageFileName, ".jpg", storageDirectory);

        // Here the location is saved into the string mImageFileLocation
        Logger.getAnonymousLogger().info("File name and path set")

        mImageFileLocation = image.absolutePath
        // fileUri = Uri.parse(mImageFileLocation);
        // The file is returned to the previous intent across the camera application
        return image
    }


    fun captureImage() {
        if (Build.VERSION.SDK_INT > 21) { //use this if Lollipop_Mr1 (API 22) or above
            val callCameraApplicationIntent = Intent()
            callCameraApplicationIntent.action = MediaStore.ACTION_IMAGE_CAPTURE

            // We give some instruction to the intent to save the image
            var photoFile: File? = null

            try {
                // If the createImageFile will be successful, the photo file will have the address of the file
                photoFile = createImageFile()
                // Here we call the function that will try to catch the exception made by the throw function
            } catch (e: IOException) {
                Log.e("hello error found", " ms = " + e.message)
                Logger.getAnonymousLogger().info("Exception error in generating the file")
                e.printStackTrace()
            }

            // Here we add an extra file to the intent to put the address on to. For this purpose we use the FileProvider, declared in the AndroidManifest.
            val outputUri = FileProvider.getUriForFile(
                requireActivity(),
                BuildConfig.APPLICATION_ID + ".provider",
                photoFile!!
            )
            callCameraApplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri)

            // The following is a new line with a trying attempt
            callCameraApplicationIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_READ_URI_PERMISSION)

            Logger.getAnonymousLogger().info("Calling the camera App by intent")

            // The following strings calls the camera app and wait for his file in return.
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
            Log.e("postPatah null", "null ")
            return
        } else {
            val map = HashMap<String, RequestBody>()
            val file = File(postPath!!)
            val requestBody = file.asRequestBody("*/*".toMediaTypeOrNull())
            map["file\"; filename=\"" + file.name + "\""] = requestBody

            val factory = ViewModelFactory.getInstance()
            homeViewModel = ViewModelProvider(this, factory)[AnalyticsViewModel::class.java]


            activity?.let {
                homeViewModel.getPrediction(map).observe(it, { prediction ->
                    Toast.makeText(activity, "prediction $prediction", Toast.LENGTH_SHORT).show()
                })
            }

        }
    }
}