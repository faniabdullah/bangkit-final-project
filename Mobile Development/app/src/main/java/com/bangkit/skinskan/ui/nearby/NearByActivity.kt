@file:Suppress("DEPRECATION")

package com.bangkit.skinskan.ui.nearby

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bangkit.skinskan.R
import com.bangkit.skinskan.databinding.ActivityDetailNearbyBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class NearByActivity : AppCompatActivity(), LocationListener {
    private lateinit var binding: ActivityDetailNearbyBinding
    var mGoogleMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNearbyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment =
            supportFragmentManager.findFragmentById(R.id.fmap) as SupportMapFragment
        fragment.getMapAsync { googleMap ->
            mGoogleMap = googleMap
            initMap()
        }

    }

    private fun initMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                115
            )
            return
        }
        if (mGoogleMap != null) {

            mGoogleMap!!.isMyLocationEnabled = true
            val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
            val criteria = Criteria()
            val provider = locationManager.getBestProvider(criteria, true)
            val location = locationManager.getLastKnownLocation(provider!!)
            if (location != null) onLocationChanged(location)
            locationManager.requestLocationUpdates(provider, 20000, 0f, this)
        }
    }

    override fun onLocationChanged(location: Location) {
        val mLatitude = location.latitude
        val mLongitude = location.longitude
        val latLng = LatLng(mLatitude, mLongitude)
        mGoogleMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mGoogleMap!!.animateCamera(CameraUpdateFactory.zoomTo(12f))
        val sb = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
                "location=" + mLatitude + "," + mLongitude +
                "&radius=20000" +
                "&types=hospital" +
                "&key=" + resources.getString(R.string.google_maps_key)
        PlacesTask().execute(sb)

    }

    @SuppressLint("StaticFieldLeak")
    private inner class PlacesTask :
        AsyncTask<String?, Int?, String?>() {

        override fun onPostExecute(result: String?) {
            ParserTask().execute(result)
        }

        override fun doInBackground(vararg url: String?): String? {
            var data: String? = null

            try {
                data = url[0]?.let { downloadUrl(it) }

                Log.e("data result Api", " error message" + data)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return data

        }

    }

    private fun downloadUrl(strUrl: String): String {
        var data = ""
        val iStream: InputStream
        val urlConnection: HttpURLConnection
        try {
            val url = URL(strUrl)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.connect()
            iStream = urlConnection.inputStream
            val br = BufferedReader(InputStreamReader(iStream))
            val sb = StringBuilder()
            var line: String?
            while (br.readLine().also { line = it } != null) {
                sb.append(line)
            }
            data = sb.toString()
            br.close()
            iStream.close()
            urlConnection.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    @SuppressLint("StaticFieldLeak")
    private inner class ParserTask :
        AsyncTask<String?, Int?, List<HashMap<String, String>>?>() {
        var jObject: JSONObject? = null

        override fun onPostExecute(list: List<HashMap<String, String>>?) {
            mGoogleMap!!.clear()
            for (i in list!!.indices) {
                val markerOptions = MarkerOptions()
                val hmPlace = list[i]
                val pinDrop =
                    BitmapDescriptorFactory.fromResource(R.drawable.ic_baseline_pin_drop_24)
                val lat = hmPlace["lat"]!!.toDouble()
                val lng = hmPlace["lng"]!!.toDouble()
                val namePlace = hmPlace["place_name"]
                val nameStreet = hmPlace["vicinity"]
                val latLng = LatLng(lat, lng)
                markerOptions.icon(pinDrop)
                markerOptions.position(latLng)
                markerOptions.title("$namePlace : $nameStreet")
                mGoogleMap!!.addMarker(markerOptions)

            }
        }

        override fun doInBackground(vararg params: String?): List<HashMap<String, String>>? {
            var places: List<HashMap<String, String>>? = null
            val parserPlace = ParserPlace()
            try {
                jObject = JSONObject(params[0].toString())
                places = parserPlace.parse(jObject!!)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return places
        }
    }

    override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {}
    override fun onProviderEnabled(s: String) {}
    override fun onProviderDisabled(s: String) {}

}