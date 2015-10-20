package com.location_reminder.smarna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;

import java.util.HashMap;

/**
 * Created by Chinmaya on 03-Oct-15.
 */
public class Logout extends AppCompatActivity {

    Button blogout,addtask;
    TextView tv2, tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        blogout = (Button) findViewById(R.id.blogout);
        addtask=(Button)findViewById(R.id.addtask);

        ParseUser currentUser= ParseUser.getCurrentUser();
        String struser=currentUser.getUsername().toString();
        String email=currentUser.getEmail().toString();
        tv2.setText("Your are logged in as "+ struser);
        tv3.setText("Your email id is "+ email);
        blogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //logoutUser();
                ParseUser.logOut();
                //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent intent = new Intent(Logout.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        addtask.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //logoutUser();

                //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent intent = new Intent(Logout.this, AddTask.class);
                startActivity(intent);
                finish();
            }
        });
    }

}

