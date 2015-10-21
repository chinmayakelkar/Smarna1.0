package com.location_reminder.smarna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        blogin=(Button)findViewById(R.id.blogin);
<<<<<<< HEAD
        //bregister=(TextView)findViewById(R.id.bregister);
=======
        bregister=(TextView)findViewById(R.id.bregister);
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
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
       /* bregister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });*/
    }

}
