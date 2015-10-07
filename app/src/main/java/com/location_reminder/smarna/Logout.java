package com.location_reminder.smarna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Chinmaya on 03-Oct-15.
 */
public class Logout extends AppCompatActivity {

    Button blogout;
    TextView tv2, tv3;
    private SQLiteHandler db;
    private SessionManager session;

    //UserLocalStore userlocalstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        blogout = (Button) findViewById(R.id.blogout);
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");

        // Displaying the user details on the screen
        tv2.setText(name);
        tv3.setText(email);

        blogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
        //blogout.setOnClickListener(this);
        //displayuserdetails();
        //userlocalstore=new UserLocalStore(this);
    }
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(Logout.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

   /* @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.blogout:
            //userlocalstore.ClearUserData();
                //userlocalstore.SetUserLoggedin(false);
                startActivity(new Intent(Logout.this,MainActivity.class));
        }

    }
    private void displayuserdetails(){
        User user=userlocalstore.getLoggedInUser();
        tv3.setText(user.emailid);
        tv2.setText(user.username);
    }*/
