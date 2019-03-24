package com.example.jovane.assignment5;

import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker mkCineplex1;
    private Marker mkCineplex2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(getApplicationContext(), "Info window clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter());


        LatLng toronto = new LatLng(43.6532, -79.3832);
        LatLng cineplex1 = new LatLng(43.776711, -79.231510);
        LatLng cineplex2 = new LatLng(43.776126, -79.231816);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cineplex1));

        mkCineplex1 = mMap.addMarker(new MarkerOptions()
                .position(cineplex1)
                .title("Cineplex in Toronto 1")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.cineplex_marker))
                .snippet("Info window"));

        mkCineplex2 = mMap.addMarker(
                new MarkerOptions()
                        .position(cineplex2)
                        .title("Cineplex in Toronto 2")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.cineplex_marker))
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cineplex1, 18));

//        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());
//        try{
//            List<Address> addresses = geocoder.getFromLocationName(
//                    "Cineplex Scarbourogh",
//                    4);
//            if (addresses.size() > 0){
//                Toast.makeText(this, "Addresses: " + addresses.size()
//                        + "|" +addresses.get(0), Toast.LENGTH_SHORT).show();
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }

    class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker) {
            View layout = getLayoutInflater().inflate(R.layout.info_windows, null);
            ImageView imgView = layout.findViewById(R.id.imgView);
            TextView txtTitle = layout.findViewById(R.id.txtTitle);
            TextView txtAddress = layout.findViewById(R.id.txtAddress);
            TextView txtPhone = layout.findViewById(R.id.txtPhone);

            if (marker.equals(mkCineplex1)) {
                imgView.setImageResource(R.drawable.cineplex_aud1);
                txtTitle.setText("Cineplex Scarbourogh 1");
            } else {
                imgView.setImageResource(R.drawable.cineplex_aud2);
                txtTitle.setText("Cineplex Scarbourogh 2");
            }
            Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
            try {
                List<Address> addresses = geocoder.getFromLocation(marker.getPosition().latitude, marker.getPosition().longitude, 1);
                if (addresses.size() > 0) {
                    txtAddress.setText(addresses.get(0).getAddressLine(0));
                    if (addresses.get(0).getPhone() != null) {
                        txtPhone.setText(addresses.get(0).getPhone());
                    } else {
                        txtPhone.setText("[Phone Not Found]");
                    }
                } else {
                    txtAddress.setText("[Address Not Found]");
                    txtPhone.setText("[Phone Not Found]");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return layout;
        }
    }
}
