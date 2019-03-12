package com.example.vinay.gpsapp;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GpsActivity extends AppCompatActivity {
    LocationManager location = null;
    Location lastLocation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        // location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        final Button start = (Button)findViewById(R.id.start);
        final Button stop = (Button)findViewById(R.id.stop);
        //final Button show = (Button)findViewById(R.id.show_map);
        final TextView status = (TextView)findViewById(R.id.status);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(GpsActivity.this, "Starting....", Toast.LENGTH_SHORT).show();
                Iterator<String> providers = location.getAllProviders().iterator();


                while(providers.hasNext()) {
                    Log.v("Location", providers.next());

                }

                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.NO_REQUIREMENT);
                criteria.setPowerRequirement(Criteria.NO_REQUIREMENT);

                String best = location.getBestProvider(criteria, true);
                // String best = providers.next();

                status.setText("Best provider: " + best);

                //location.requestLocationUpdates(best, 1000L, 0.f, GpsActivity.this);


                start.setVisibility(View.GONE);
                stop.setVisibility(View.VISIBLE);
                // show.setVisibility(View.VISIBLE);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                stop.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
            }
        });

    }

        String locationProvider = LocationManager.GPS_PROVIDER;
        //lastLocation  = location.getLastKnownLocation(locationProvider);

    public void onLocationChanged(Location location) {
        String locInfo = String.format("Current loc = (%f, %f) @ (%f meters up)", location.getLatitude(), location.getLongitude(), location.getAltitude() );

        if (lastLocation != null) {
            float distance = location.distanceTo(lastLocation);
            locInfo += String.format("\n Distance from last = %f meters", distance);
            //Toast.makeText(GPSActivity.this, locInfo, Toast.LENGTH_SHORT).show();

        }
    lastLocation = location;

    Geocoder coder = new Geocoder(this);
        try {
        Iterator<Address> addresses = coder.getFromLocation(location.getLatitude(), location.getLongitude(), 3).iterator();
        if (addresses != null) {
            while (addresses.hasNext()) {
                Address namedLoc = addresses.next();
                String placeName = namedLoc.getLocality();
                String featureName = namedLoc.getFeatureName();
                String country = namedLoc.getCountryName();
                String road = namedLoc.getThoroughfare();
                locInfo += String.format("\n[%s][%s][%s][%s]", placeName, featureName, road, country);
                int addIdx = namedLoc.getMaxAddressLineIndex();
                for (int idx = 0; idx <= addIdx; idx++){
                    String addLine = namedLoc.getAddressLine(idx);
                    locInfo += String.format("\nLine %d: %s", idx, addLine);
                }
            }
        }
    } catch (IOException e) {
        Log.e("GPS", "Failed to get address", e);
    }



    TextView status = (TextView)findViewById(R.id.status);
        status.setText(locInfo);


    final String geoURI = String.format("geo: %f,%f", location.getLatitude(), location.getLongitude());

    Button show = (Button) findViewById(R.id.show_map);
        show.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse(geoURI));
            startActivity(map);
        }
    });
        show.setVisibility(View.VISIBLE);

}

    public void onProviderDisabled(String provider) {
        Log.v("GPS", "Provider disabled "+ provider);

    }

    public void onProviderEnabled(String provider) {
        Log.v("GPS", "Provider enabled "+ provider);

    }


    private static final Map<Integer, String> providerStatusMap = new HashMap<Integer, String>() {
        {
            put(LocationProvider.AVAILABLE, "Available");
            put(LocationProvider.OUT_OF_SERVICE, "Out of Service");
            put(LocationProvider.TEMPORARILY_UNAVAILABLE, "Temporarily Unavailable");
            put(-1, "Not Reported");
        }
    };
    public void onStatusChanged(String provider, int status, Bundle extras) {
        int satellites = extras.getInt("satellites", -1);

        String statusInfo = String.format("Provider: %s, status: %s, satellites: %d", provider, providerStatusMap.get(status), satellites);
        Log.v("GPS", statusInfo);
        TextView statusText = (TextView)findViewById(R.id.status);
        statusText.setText(statusInfo);

    }
}
