package com.location_reminder.smarna;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.IntentService;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chinmaya on 17-Oct-15.
 */
public class MapActivity extends FragmentActivity implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener,LocationListener,OnMapReadyCallback, GoogleMap.OnMarkerClickListener,GoogleMap.OnMarkerDragListener{

    private static LatLng fromPosition = null;
    private static LatLng toPosition=null;
    private static String latitude="";
    private  static String longitude="";
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private GoogleApiClient mGoogleApiClien;
    public static final String TAG= MapActivity.class.getSimpleName();
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST=9000;
    private LocationRequest mLocationRequest;
    Geocoder geocoder;
    StringBuilder strReturnedAddress=new StringBuilder("Address\n");
    Button setLocation,currentLocButton;
    List<Address> address;
    TextView Currentlocation,getLocation;
    double longt = 0,latt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        setUpMapIfNeeded();



        mGoogleApiClien = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        mLocationRequest = LocationRequest.create().create().setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY).setInterval(10 * 1000).setFastestInterval(1 * 1000);
        setLocation = (Button) findViewById(R.id.set_locButton);
//
        getLocation = (TextView) findViewById(R.id.set_location);
        setLocation.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //  Log.i(TAG, strReturnedAddress.toString());

                ArrayList<Address> adrrs1 = null;
                try {
                    if (getLocation.getText() != "") {
                        adrrs1 = (ArrayList<Address>) geocoder.getFromLocationName(getLocation.getText().toString(), 50);
                    } else {
                        Toast.makeText(MapActivity.this, "Please specify a location", Toast.LENGTH_LONG).show();
                    }

                } catch (IOException e) {
                    Log.i("ERROR", "*********ERROR OCCURED***********");
                    e.printStackTrace();
                }

                latt = adrrs1.get(0).getLatitude();
                longt = adrrs1.get(0).getLongitude();
                final LatLng latlng = new LatLng(latt, longt);
                MarkerOptions options = new MarkerOptions().position(latlng).title("I am here");
                Log.i("SetMarker", "latln" + latlng);
                mMap.clear();
                mMap.addMarker(options);
        // handleSetLocation();

                //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latt, longt), 12.0f));

            }


        });


        currentLocButton = (Button) findViewById(R.id.my_locButton);

        currentLocButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Location location= LocationServices.FusedLocationApi.getLastLocation((mGoogleApiClien));
                handleNewLocation(location);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            public  void onClick(View v){
              boolean Valid=  dataIsValid();
                if(Valid==true)
                {
                    onBackPressed();

                }
                else
                {
                    Toast.makeText(MapActivity.this, "Please try again", Toast.LENGTH_LONG).show();
                }


            }
        });

    }



    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mGoogleApiClien.connect();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
//            if (mMap != null) {
//
//                setUpMap();
//            }
        }
    }
    @Override
    protected  void onPause(){
        super.onPause();
        if(mGoogleApiClien.isConnected()){
            mGoogleApiClien.disconnect();
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */


/*
    private void setUpMap() {
       // mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }*/

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Location service connected");
        Location location= LocationServices.FusedLocationApi.getLastLocation((mGoogleApiClien));
        if(location== null)
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClien,mLocationRequest,this);
        else
            handleNewLocation(location);


    }

    private void handleSetLocation(Location location)
    {
        Log.d(TAG, location.toString());
        double currentLatitude=location.getLatitude();
        double currentLongitude=location.getLongitude();
        LatLng latlng= new LatLng(currentLatitude,currentLongitude);
        mMap.clear();
        MarkerOptions options= new MarkerOptions().position(latlng).title("I am here");
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        options.draggable(true);
        geocoder= new Geocoder(this, Locale.getDefault());
        try {
            address = geocoder.getFromLocation(currentLatitude, currentLongitude, 1);
            if (address != null) {
                Address returnAddress = address.get(0);
              strReturnedAddress = new StringBuilder("Address\n");
                for (int i = 0; i < returnAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnAddress.getAddressLine(i)).append("\n");
                }
                Currentlocation = (TextView) findViewById(R.id.mylocation);
                Currentlocation.setText(strReturnedAddress.toString());
                // Toast.makeText(this,strReturnedAddress.toString(),Toast.LENGTH_LONG).show();

                mMap.setOnMarkerDragListener(this);

            }
        }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    private void handleNewLocation(Location location)
    {
        Log.d(TAG, location.toString());
        latt =location.getLatitude();
        longt =location.getLongitude();
        LatLng latlng= new LatLng(latt,longt);
        mMap.clear();
        MarkerOptions options= new MarkerOptions().position(latlng).title("I am here");
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latt, longt), 12.0f));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        options.draggable(true);
        geocoder= new Geocoder(this, Locale.getDefault());
        try {
            address = geocoder.getFromLocation(latt,longt,1);
            if(address != null)
                {
          Address returnAddress= address.get(0);

                    //strReturnedAddress= new StringBuilder("Address\n");
                    strReturnedAddress= new StringBuilder("");
    for(int i=0 ;i<returnAddress.getMaxAddressLineIndex();i++)
    {
     strReturnedAddress.append(returnAddress.getAddressLine(i)).append("\n");
    }
    Currentlocation= (TextView) findViewById(R.id.mylocation);
    Currentlocation.setText(strReturnedAddress.toString());
   // Toast.makeText(this,strReturnedAddress.toString(),Toast.LENGTH_LONG).show();

    mMap.setOnMarkerDragListener(this);
}



        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG,"Cannot set address value");
        }
        mMap.addMarker(options);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
    }


    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended.Please reconnect");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if(connectionResult.hasResolution())
        {
            try {
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
            }
            catch (IntentSender.SendIntentException e) {
                e.printStackTrace();

            }
        }
        else {
            Log.i(TAG,"Location service failed with error code"+connectionResult.getErrorCode());
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        handleNewLocation(location);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setOnMarkerDragListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {
        fromPosition = marker.getPosition();
        Log.d(getClass().getSimpleName(), "Drag start at: " + fromPosition);

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

        fromPosition = marker.getPosition();
        Log.d(getClass().getSimpleName(), "Drag start at: " + fromPosition);
        try {
            latt=fromPosition.latitude;
            longt=fromPosition.longitude;
            address = geocoder.getFromLocation(fromPosition.latitude, fromPosition.longitude, 1);
            if (address != null) {
                Address returnAddress = address.get(0);

               strReturnedAddress = new StringBuilder("");
                for (int i = 0; i < returnAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnAddress.getAddressLine(i)).append("\n");
                }
                Toast.makeText(this, strReturnedAddress.toString(), Toast.LENGTH_LONG).show();
                getLocation.setText(strReturnedAddress.toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public  void onBackPressed() {
//        Log.i("BackPressed","maker"+ strReturnedAddress.toString());
        Intent data = new Intent();
        if (getLocation.getText() != null)

            geocoder = new Geocoder(this, Locale.getDefault());
        try {
            address = geocoder.getFromLocation(latt, longt, 1);
            if (address != null) {
                Address returnAddress = address.get(0);
                strReturnedAddress = new StringBuilder("");
      for (int i = 0; i < returnAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnAddress.getAddressLine(i)).append("\n");
                }
                Log.i("FINAL LOCATION SENT IS:",strReturnedAddress.toString());
                data.putExtra("location", strReturnedAddress.toString());
            } else
                data.putExtra("location", "location1");
            data.putExtra("lattitude", latt);
            data.putExtra("longitude", longt);
            setResult(MapActivity.RESULT_OK, data);
//        NamedGeofence namedGeofence= new NamedGeofence();
//        namedGeofence.id="1";
//        namedGeofence.latitude=latt;
//        namedGeofence.longitude=longt;
//        namedGeofence.name="Geofence1";
            super.onBackPressed();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean dataIsValid() {
        boolean validData = true;

        String name = strReturnedAddress.toString();
        String latitudeString = String.valueOf(latt);
        String longitudeString = String.valueOf(longt);
       // String radiusString = getViewHolder().radiusEditText.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(latitudeString)
                || TextUtils.isEmpty(longitudeString)) {
            validData = false;
        } else {
            double latitude = Double.parseDouble(latitudeString);
            double longitude = Double.parseDouble(longitudeString);
          //  float radius = Float.parseFloat(radiusString);
            if ((latitude < Constants.Geometry.MinLatitude || latitude > Constants.Geometry.MaxLatitude)
                    || (longitude < Constants.Geometry.MinLongitude || longitude > Constants.Geometry.MaxLongitude)
                   ) {
                validData = false;
            }
        }

        return validData;
    }


}







