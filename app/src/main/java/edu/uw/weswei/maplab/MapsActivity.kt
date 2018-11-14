package edu.uw.weswei.maplab

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val w1 = LatLng(47.65389023156545, -122.30820754473393)
        val w2 = LatLng(47.65359030917829, -122.30796614592259)
        val w3 = LatLng(47.65398056929629, -122.30790177290623)
        val w4 = LatLng(47.65371316915964, -122.30754772131627)
        val w5 = LatLng(47.65403115835732, -122.30763891642277)
        val polyLineOptions: PolylineOptions = PolylineOptions().add(w1).add(w2).add(w3).add(w4).add(w5)
                .color(Color.MAGENTA)

        // Add a marker on Drumheller Fountain
        val fountain = LatLng(47.6538, -122.3078)
        mMap.addMarker(MarkerOptions().position(fountain)
                .title("This is Drumheller Fountain!")
                .snippet("Home to ducks that migrate here for UW spirit")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)))
        mMap.addPolyline(polyLineOptions)
    }
}
