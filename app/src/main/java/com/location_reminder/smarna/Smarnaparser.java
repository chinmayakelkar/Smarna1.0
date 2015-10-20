package com.location_reminder.smarna;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;

/**
 * Created by Chinmaya on 08-Oct-15.
 */
public class Smarnaparser extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(PUser.class);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "JwsGVlZa8qrHwfknR9PJ5C9PhzlaF4Rs4htyi0ga", "U9iAU7cbHx6E8aSImcmz76wKurEz6rYosXqZZTgE");
        //ParseACL.setDefaultACL(new ParseACL(), true);
        //ParseACL defauAcl=new ParseACL();
        //ParseACL.setDefaultACL(defauAcl, true);
    }
}
