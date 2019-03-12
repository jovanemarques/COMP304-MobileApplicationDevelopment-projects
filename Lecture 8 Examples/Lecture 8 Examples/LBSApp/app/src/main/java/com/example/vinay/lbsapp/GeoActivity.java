package com.example.vinay.lbsapp;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class GeoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        final EditText name = (EditText) findViewById(R.id.placename);
        final Geocoder coder = new Geocoder(getApplicationContext());
        final TextView results = (TextView) findViewById(R.id.result);
        final Button mapButton = (Button)findViewById(R.id.map);

        Button geocode = (Button) findViewById(R.id.geocode);
        geocode.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String placeName = name.getText().toString();
                try {
                    //using geocoder object getting maximum 3 addresses for given place name / address
                    List<Address> geocodeResults = coder.getFromLocationName(placeName, 3);
                    Iterator<Address> locations = geocodeResults.iterator();

                    String locInfo = "Results:\n";
                    double latitude = 43.6426f;
                    double longitude = -79.3871f;
                    while (locations.hasNext()) {
                        Address loc = locations.next();
                        locInfo += String.format("Location: %f, %f\n", loc.getLatitude(), loc.getLongitude());

                        //using an address object getting latitude and longitute values for the given address
                        latitude = loc.getLatitude();
                        longitude = loc.getLongitude();

                        // using an address object, getting address information
                        String pName = loc.getLocality();
                        String featureName = loc.getFeatureName();
                        String country = loc.getCountryName();
                        String road = loc.getThoroughfare();

                        //string concatenation
                        locInfo += String.format("\n[%s][%s][%s][%s]", pName, featureName, road, country);

                        int addIdx = loc.getMaxAddressLineIndex();
                        for (int idx = 0; idx <= addIdx; idx++){
                            String addLine = loc.getAddressLine(idx);
                            locInfo += String.format("\nLine %d: %s", idx, addLine); }

                    }
                    //print the address information with a text view
                    results.setText(locInfo);

                    final String geoURI = String.format("geo:%f,%f", latitude, longitude);

                    //code to load google map for a given address
                    mapButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Uri geo = Uri.parse(geoURI);
                            Intent geoMap = new Intent(Intent.ACTION_VIEW, geo);
                            startActivity(geoMap);
                        }

                    });
                    mapButton.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    Log.e("GeoAddress", "Failed to get location info", e);
                }

            }

        });

    }
}
