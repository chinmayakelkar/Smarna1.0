package com.location_reminder.smarna;

/**
 * Created by Chinmaya on 05-Nov-15.
 */
public final class Constants {
    private Constants() {
    }

    public static final String PACKAGE_NAME = "com.location_reminder.smarna";
    public final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;

    public static final String SHARED_PREFERENCES_NAME = PACKAGE_NAME + ".SHARED_PREFERENCES_NAME";

    public static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";
    public static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;
    // Keys for flattened geofences stored in SharedPreferences.
    public static final String KEY_LATITUDE = "com.location_reminder.smarna.KEY_LATITUDE";
    public static final String KEY_LONGITUDE = "com.location_reminder.smarna.KEY_LONGITUDE";
    public static final String KEY_RADIUS = "com.location_reminder.smarna.KEY_RADIUS";
    public static final String KEY_EXPIRATION_DURATION =
            "com.location_reminder.smarna.KEY_EXPIRATION_DURATION";
    public static final String KEY_TRANSITION_TYPE =
            "com.location_reminder.smarna.KEY_TRANSITION_TYPE";
    // The prefix for flattened geofence keys.
    public static final String KEY_PREFIX = "com.location_reminder.smarna.KEY";

    // Invalid values, used to test geofence storage when retrieving geofences.
    public static final long INVALID_LONG_VALUE = -999l;
    public static final float INVALID_FLOAT_VALUE = -999.0f;
    public static final int INVALID_INT_VALUE = -999;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    public static final float GEOFENCE_RADIUS_IN_METERS = 1609;

    public static class Geometry {
        public static double MinLatitude = -90.0;
        public static double MaxLatitude = 90.0;
        public static double MinLongitude = -180.0;
        public static double MaxLongitude = 180.0;
        public static double MinRadius = 0.01; // kilometers
        public static double MaxRadius = 20.0; // kilometers
    }
}
