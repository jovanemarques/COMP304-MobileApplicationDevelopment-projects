package com.example.vinay.mymap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        //satellite view
        //gMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Add a marker in Toronto and move the camera
        LatLng city = new LatLng(43, -79);
        gMap.addMarker(new MarkerOptions().position(city).title("Marker in Toronto"));

        gMap.moveCamera(CameraUpdateFactory.newLatLng(city));

        // Move the camera instantly to toronto with a zoom of 5.
        //gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(city, 5));


    }
}
