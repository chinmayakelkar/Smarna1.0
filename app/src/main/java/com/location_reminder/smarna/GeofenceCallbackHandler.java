package com.location_reminder.smarna;

import android.content.Context;

import com.kl.kitlocate.class_interface.KLGeofence;
import com.kl.kitlocate.class_interface.KLLocalNotification;
import com.kl.kitlocate.utilities.interfaces.IKLGeofenceResponse;

import java.util.ArrayList;

/**
 * Created by Chinmaya on 08-Nov-15.
 */
public class GeofenceCallbackHandler implements IKLGeofenceResponse {
    @Override
    public void geofenceInArm(Context context, ArrayList<KLGeofence> arrayList) {

    }

    @Override
    public void geofenceOutArm(Context context, ArrayList<KLGeofence> arrayList) {

    }

    @Override
    public void geofenceIn(Context context, ArrayList<KLGeofence> arrayList) {
        new KLLocalNotification(context,"This should work now",R.mipmap.homeicon2).setDefaultSound(true).setContentTitle("Smarna").send();

    }

    @Override
    public void geofenceOut(Context context, ArrayList<KLGeofence> arrayList) {

    }
}
