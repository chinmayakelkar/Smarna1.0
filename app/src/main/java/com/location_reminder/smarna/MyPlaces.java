package com.location_reminder.smarna;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Chinmaya on 06-Nov-15.
 */
public class MyPlaces {
    private final String id;
    private final double mLatitude;
    private final double mLongitude;
    private long mExpirationDuration;
    private final float fenceRadius;


    public MyPlaces(String id,double mLatitude, double mLongitude,float fenceRadius, long mExpirationDuration) {
        this.id = id;
        this.mExpirationDuration=mExpirationDuration;
        this.mLatitude=mLatitude;
        this.mLongitude=mLongitude;
        //this.coordinates = coordinates;
        this.fenceRadius = fenceRadius;
    }

    public String getId() {
        return id;
    }


    public float getFenceRadius() {
        return fenceRadius;
    }

    public double getLatitude() {
        return mLatitude;
    }
    public double getLongitude() {
        return mLongitude;
    }
    public long getExpirationDuration() {
        return mExpirationDuration;
    }
}
