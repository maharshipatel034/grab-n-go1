package com.example.decarpooling
//AIzaSyCXYBV2zvJznVBAfjvsqkYnBUL72Kx4-eM

import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.decarpooling.databinding.ActivityMapselectplaceBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext
import com.google.maps.model.DirectionsResult
import com.google.maps.model.TravelMode
import java.io.IOException

class Mapselectplace : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapselectplaceBinding

    private var latLng1: LatLng? = null
    private var latLng2: LatLng? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapselectplaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeMap()

        val buttonclick1 = findViewById<Button>(R.id.button1)
        buttonclick1.setOnClickListener {
            val location1 = findViewById<EditText>(R.id.textPickup)
            val location2 = findViewById<EditText>(R.id.textDestination)

            if (location1 != null && location2 != null) {
                latLng1 = getLatLngForPlace(location1.text.toString())
                latLng2 = getLatLngForPlace(location2.text.toString())

                if (latLng1 != null && latLng2 != null) {
                    setupMap()
                }
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Gujarat and move the camera
        val gujarat = LatLng(23.033863, 72.585022)
        mMap.addMarker(MarkerOptions().position(gujarat).title("Marker in Gujarat"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gujarat, 11f))
    }

    private fun initializeMap() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setupMap() {
        mMap.clear() // Clear any existing markers or polylines

        mMap.addMarker(MarkerOptions().position(latLng1!!).title("Marker 1"))
        mMap.addMarker(MarkerOptions().position(latLng2!!).title("Marker 2"))

        val directionsResult = getDirections(latLng1!!, latLng2!!)

        if (directionsResult != null) {
            val points = directionsResult.routes[0].overviewPolyline.decodePath().map { latLng ->
                com.google.android.gms.maps.model.LatLng(latLng.lat, latLng.lng)
            }

            val polylineOptions = PolylineOptions().addAll(points).color(Color.RED)
            mMap.addPolyline(polylineOptions)
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2!!, 11f))
    }

    private fun getDirections(origin: LatLng, destination: LatLng): DirectionsResult? {
        val apiKey = "AIzaSyCXYBV2zvJznVBAfjvsqkYnBUL72Kx4-eM" // Replace with your Google Maps API key
        val geoApiContext = GeoApiContext.Builder()
            .apiKey(apiKey)
            .build()

        return try {
            DirectionsApi.newRequest(geoApiContext)
                .mode(TravelMode.DRIVING)
                .origin(origin.toString())
                .destination(destination.toString())
                .await()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun getLatLngForPlace(placeName: String): LatLng? {
        val geocoder = Geocoder(applicationContext)
        var addresses: List<Address>? = null

        try {
            // Geocode the place name to get the addresses
            addresses = geocoder.getFromLocationName(placeName, 1)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (addresses != null && addresses.isNotEmpty()) {
            val address = addresses[0]
            val latitude = address.latitude
            val longitude = address.longitude
            return LatLng(latitude, longitude)
        }

        return null
    }
}

//package com.example.decarpooling

//
//import android.graphics.Color
//import android.location.Address
//import android.location.Geocoder
//import android.os.Bundle
//import android.widget.EditText
//import androidx.appcompat.app.AppCompatActivity
//import com.example.decarpooling.databinding.ActivityMapselectplaceBinding
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//import com.google.android.gms.maps.model.PolylineOptions
//import com.google.maps.DirectionsApi
//import com.google.maps.GeoApiContext
//import com.google.maps.model.DirectionsResult
//import com.google.maps.model.TravelMode
//import java.io.IOException
//
//class Mapselectplace : AppCompatActivity(), OnMapReadyCallback {
//
//    private lateinit var mMap: GoogleMap
//    private lateinit var binding: ActivityMapselectplaceBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMapselectplaceBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//
//
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//        val location1 = findViewById<EditText>(R.id.textPickup)
//        val location2 = findViewById<EditText>(R.id.textDestination)
//
//        if (location1 != null && location2 != null) {
//            val latLng = getLatLngForPlace(location1.text.toString())
//            if (latLng != null) {
//                val latitude = latLng.latitude
//                val longitude = latLng.longitude
//            }
//            val latLng1 = getLatLngForPlace(location2.text.toString())
//            if (latLng1 != null) {
//                val latitude1 = latLng1.latitude
//                val longitude1 = latLng1.longitude
//            }
//            if (latLng1 != null && latLng != null) {
//                mMap.addMarker(MarkerOptions().position(latLng).title("Marker 1"))
//                mMap.addMarker(MarkerOptions().position(latLng1).title("Marker 2"))
//
//                val directionsResult = getDirections(latLng, latLng1)
//
//                if (directionsResult != null) {
//                    val points = directionsResult.routes[0].overviewPolyline.decodePath().map { latLng ->
//                        com.google.android.gms.maps.model.LatLng(latLng.lat, latLng.lng)
//                    }
//
//                    val polylineOptions = PolylineOptions().addAll(points).color(Color.RED)
//                    mMap.addPolyline(polylineOptions)
//                }
//
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 11f))
//            }
//        }
//        // Add a marker in Gujarat and move the camera
//        val gujarat = LatLng(23.033863, 72.585022)
//        mMap.addMarker(MarkerOptions().position(gujarat).title("Marker in Gujarat"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gujarat, 11f))
//    }
//
//    private fun getDirections(origin: LatLng, destination: LatLng): DirectionsResult? {
//        val apiKey = "AIzaSyCXYBV2zvJznVBAfjvsqkYnBUL72Kx4-eM" // Replace with your Google Maps API key
//        val geoApiContext = GeoApiContext.Builder()
//            .apiKey(apiKey)
//            .build()
//
//        return try {
//            DirectionsApi.newRequest(geoApiContext)
//                .mode(TravelMode.DRIVING)
//                .origin(origin.toString())
//                .destination(destination.toString())
//                .await()
//        } catch (e: Exception) {
//            e.printStackTrace()
//            null
//        }
//    }
//
//    private fun getLatLngForPlace(placeName: String): LatLng? {
//        val geocoder = Geocoder(applicationContext)
//        var addresses: List<Address>? = null
//
//        try {
//            // Geocode the place name to get the addresses
//            addresses = geocoder.getFromLocationName(placeName, 1)
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//
//        if (addresses != null && addresses.isNotEmpty()) {
//            val address = addresses[0]
//            val latitude = address.latitude
//            val longitude = address.longitude
//            return LatLng(latitude, longitude)
//        }
//
//        return null
//    }
//}

//class Mapselectplace : AppCompatActivity(), OnMapReadyCallback {
//
//    private lateinit var mMap: GoogleMap
//    private lateinit var binding: ActivityMapselectplaceBinding
//
//    private var pickupPlace: String = ""
//    private var destinationPlace: String = ""
//
//    private val placesArray: ArrayList<String> = ArrayList()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMapselectplaceBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//
//        binding.button.setOnClickListener {
//            pickupPlace = binding.textPickup.text.toString()
//            destinationPlace = binding.textDestination.text.toString()
//
//            placesArray.add(pickupPlace)
//            placesArray.add(destinationPlace)
//
//            showLocationsOnMap()
//        }
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        val gujarat = LatLng(23.033863, 72.585022)
//        mMap.addMarker(MarkerOptions().position(gujarat).title("Marker in Gujarat"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gujarat, 11f))
//    }
//
//
//    private fun showLocationsOnMap() {
//        mMap.clear() // Clear existing markers and polylines on the map
//
//        if (placesArray.size >= 2) {
//            val pickupPlace = placesArray[0]
//            val destinationPlace = placesArray[1]
//
//            val pickupLatLng = getLatLngForPlace(pickupPlace)
//            val destinationLatLng = getLatLngForPlace(destinationPlace)
//
//            if (pickupLatLng != null && destinationLatLng != null) {
//                mMap.addMarker(MarkerOptions().position(pickupLatLng).title(pickupPlace))
//                mMap.addMarker(MarkerOptions().position(destinationLatLng).title(destinationPlace))
//
//                val polylineOptions = PolylineOptions()
//                    .add(pickupLatLng, destinationLatLng)
//                    .width(5f)
//                    .color(Color.RED)
//                mMap.addPolyline(polylineOptions)
//
//                val boundsBuilder = LatLngBounds.builder()
//                    .include(pickupLatLng)
//                    .include(destinationLatLng)
//                val bounds = boundsBuilder.build()
//
//                val padding = 100 // Adjust the padding as desired
//                val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
//                mMap.animateCamera(cameraUpdate)
//            }
//        }
//    }
//
//
//
//
//    private fun getLatLngForPlace(place: String): LatLng? {
//        // Implement geocoding or use an API to get the latitude and longitude for the place
//        // Return a LatLng object with the coordinates
//
//        // For demonstration purposes, we'll assume fixed coordinates for the places
//        return when (place) {
//            "Gandhinagar" -> LatLng(23.2156, 72.6369)
//            "Ahmedabad" -> LatLng(23.0225, 72.5714)
//            else -> null
//        }
//    }
//}

//package com.example.decarpooling
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.example.decarpooling.databinding.ActivityMapselectplaceBinding
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.MarkerOptions
//
//class Mapselectplace : AppCompatActivity(), OnMapReadyCallback {
//
//    private lateinit var mMap: GoogleMap
//    private lateinit var binding: ActivityMapselectplaceBinding
//
//    private var pickupPlace: String = ""
//    private var destinationPlace: String = ""
//
//    private val placesArray: ArrayList<String> = ArrayList()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMapselectplaceBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//
//        binding.button.setOnClickListener {
//            pickupPlace = binding.textPickup.text.toString()
//            destinationPlace = binding.textDestination.text.toString()
//
//            placesArray.add(pickupPlace)
//            placesArray.add(destinationPlace)
//
//            showLocationsOnMap()
//        }
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        val gujarat = LatLng(23.033863, 72.585022)
//        mMap.addMarker(MarkerOptions().position(gujarat).title("Marker in Gujarat"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gujarat, 11f))
//    }
//
//    private fun showLocationsOnMap() {
//        mMap.clear() // Clear existing markers on the map
//
//        for (place in placesArray) {
//            // You can geocode the place to get its latitude and longitude
//            // Here, for demonstration purposes, we'll assume fixed coordinates for the places
//            val latLng = getLatLngForPlace(place)
//
//            if (latLng != null) {
//                mMap.addMarker(MarkerOptions().position(latLng).title(place))
//            }
//        }
//    }
//
//    private fun getLatLngForPlace(place: String): LatLng? {
//        // Implement geocoding or use an API to get the latitude and longitude for the place
//        // Return a LatLng object with the coordinates
//
//        // For demonstration purposes, we'll assume fixed coordinates for the places
//        return when (place) {
//            "Gandhinagar" -> LatLng(23.2156, 72.6369)
//            "Ahmedabad" -> LatLng(23.0225, 72.5714)
//            else -> null
//        }
//    }
//}
//
//
////class Mapselectplace : AppCompatActivity(), OnMapReadyCallback {
////
////    private lateinit var mMap: GoogleMap
////    private lateinit var binding: ActivityMapselectplaceBinding
////
////    private var pickupPlace: String = ""
////    private var destinationPlace: String = ""
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////
////        binding = ActivityMapselectplaceBinding.inflate(layoutInflater)
////        setContentView(binding.root)
////
////        val mapFragment = supportFragmentManager
////            .findFragmentById(R.id.map) as SupportMapFragment
////        mapFragment.getMapAsync(this)
////
////        binding.button.setOnClickListener {
////            pickupPlace = binding.textPickup.text.toString()
////            destinationPlace = binding.textDestination.text.toString()
////
////            // Here you can add the pickupPlace and destinationPlace values to an array or perform any other desired operations.
////            // For example, you can create an array and add the values as follows:
////            val placesArray = arrayOf(pickupPlace, destinationPlace)
////
////            // Print the array for demonstration
////            for (place in placesArray) {
////                println(place)
////            }
////        }
////    }
////
////    override fun onMapReady(googleMap: GoogleMap) {
////        mMap = googleMap
////
////        val gujarat = LatLng(23.033863, 72.585022)
////        mMap.addMarker(MarkerOptions().position(gujarat).title("Marker in Gujarat"))
////        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gujarat, 11f))
////    }
////}
//
//
////class Mapselectplace : AppCompatActivity(), OnMapReadyCallback {
////
////    private lateinit var mMap: GoogleMap
////    private lateinit var binding: ActivityMapselectplaceBinding
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////
////        binding = ActivityMapselectplaceBinding.inflate(layoutInflater)
////        setContentView(binding.root)
////
////        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
////        val mapFragment = supportFragmentManager
////            .findFragmentById(R.id.map) as SupportMapFragment
////        mapFragment.getMapAsync(this)
////    }
//
//    /**
//     * Manipulates the map once available.
//     * This callback is triggered when the map is ready to be used.
//     * This is where we can add markers or lines, add listeners or move the camera. In this case,
//     * we just add a marker near Sydney, Australia.
//     * If Google Play services is not installed on the device, the user will be prompted to install
//     * it inside the SupportMapFragment. This method will only be triggered once the user has
//     * installed Google Play services and returned to the app.
//     */
////    override fun onMapReady(googleMap: GoogleMap) {
////        mMap = googleMap
////
////        // Add a marker in Sydney and move the camera22.6708° N, 71.5724° E
////        val Gujarat = LatLng(23.033863, 72.585022)
////        mMap.addMarker(MarkerOptions().position(Gujarat).title("Marker in Gujarat"))
////        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Gujarat,11f))
////    }
////}