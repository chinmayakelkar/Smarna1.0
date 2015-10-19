package com.location_reminder.smarna;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Chinmaya on 17-Oct-15.
 */
public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener,GoogleMap.OnMarkerDragListener{
    private static LatLng fromPosition = null;
    private static LatLng toPosition=null;
    private static String latitude="";
    private  static String longitude="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setMyLocationEnabled(true);
        LatLng martson = new LatLng(29.648319,-82.34431899999998);
        googleMap.addMarker(new MarkerOptions().position(martson).title("Marker Location").draggable(true));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(martson));
        googleMap.setOnMarkerDragListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.i("MapActivity", "onMarkerClick");
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        fromPosition = marker.getPosition();
        Log.d(getClass().getSimpleName(), "Drag start at: " + fromPosition);
        Toast.makeText(
                getApplicationContext(),
                "Drag the marker to your task location", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        toPosition = marker.getPosition();
        double dlat=marker.getPosition().latitude;
        double dlong=marker.getPosition().longitude;
        latitude=String.valueOf(dlat);
        longitude=String.valueOf(dlong);
        Toast.makeText(
                getApplicationContext(),
                "Now you are at"+ " Lat: "+ toPosition.latitude +" Long: "+ toPosition.longitude, Toast.LENGTH_LONG).show();
    }
}
