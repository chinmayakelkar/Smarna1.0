package com.location_reminder.smarna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kl.kitlocate.class_interface.KLGeofence;
import com.kl.kitlocate.interfaces.KLApplication;
import com.kl.kitlocate.interfaces.KLLocation;
import com.kl.kitlocate.interfaces.KitLocate;
import com.parse.ParseUser;

/**
 * Created by Chinmaya on 10-Oct-15.
 */

public class WelcomeActivity extends AppCompatActivity {
    Button blogin;
<<<<<<< HEAD
    //TextView bregister;
=======
    TextView bregister;
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getstarted);
<<<<<<< HEAD
        KitLocate.initKitLocate(this, "026d0172-5897-4b0e-9f87-58892f14167c");
        KLLocation.addGeofence(this, 29.6192480f,-82.3768000f,500, KLGeofence.Type.IN, "abc");
        KLLocation.registerGeofencing(this, GeofenceCallbackHandler.class);
        blogin=(Button)findViewById(R.id.blogin);

=======

        blogin=(Button)findViewById(R.id.blogin);
<<<<<<< HEAD

=======
<<<<<<< HEAD
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
        //bregister=(TextView)findViewById(R.id.bregister);
=======
        bregister=(TextView)findViewById(R.id.bregister);
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            KitLocate.setUniqueUserID(this, currentUser.getUsername());
            Intent intent = new Intent(WelcomeActivity.this, TaskListView.class);
            startActivity(intent);
            finish();
        }
        blogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    @Override
    protected void onStop() {
        super.onStop();
        KLApplication.onActivityStop(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        KLApplication.onActivityStart(this);
    }

}
