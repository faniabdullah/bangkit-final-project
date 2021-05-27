@file:Suppress("DEPRECATION")

package com.bangkit.skinskan.ui.nearby

import android.Manifest
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.bangkit.skinskan.R
import com.bangkit.skinskan.data.source.local.entity.MapsEntity
import com.bangkit.skinskan.databinding.ActivityDetailNearbyBinding
import com.bangkit.skinskan.utils.ViewModelFactory
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class NearByActivity : AppCompatActivity(), LocationListener {
    private lateinit var binding: ActivityDetailNearbyBinding
    var mGoogleMap: GoogleMap? = null
    private lateinit var nearByViewModel: NearByViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNearbyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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
//        val sb = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" +
//                "location=" + mLatitude + "," + mLongitude +
//                "&radius=20000" +
//                "&types=hospital" +
//                "&key=" + resources.getString(R.string.google_maps_key)
        setObserber(mLatitude, mLongitude)
    }

    private fun setObserber(mLatitude: Double, mLongitude: Double) {
        val factory = ViewModelFactory.getInstance()
        nearByViewModel = ViewModelProvider(this, factory)[NearByViewModel::class.java]

        nearByViewModel.getHospitalNearBy(mLatitude.toString(), mLongitude.toString())
            .observe(this, {
                    displayMarker(it)
            })
    }

    private fun displayMarker(data: List<MapsEntity>) {
        mGoogleMap!!.clear()

        Log.e("data","MARKER")
        for (response in data) {
            val markerOptions = MarkerOptions()
            val pinDrop =
                BitmapDescriptorFactory.fromResource(R.drawable.ic_pin)
            val lat = response.latitude
            val lng = response.lng
            val namePlace = response.namePlace
            val nameStreet = response.nameStreet
            val latLng = LatLng(lat, lng)
            markerOptions.icon(pinDrop)
            markerOptions.position(latLng)
            markerOptions.title("$namePlace : $nameStreet")
            mGoogleMap!!.addMarker(markerOptions)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}