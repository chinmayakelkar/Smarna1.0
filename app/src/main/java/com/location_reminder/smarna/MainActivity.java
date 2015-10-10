package com.location_reminder.smarna;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.parse.LogInCallback;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button blogin;

    EditText etemail, etpassword;

   // private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etemail = (EditText) findViewById(R.id.Email);
        etpassword = (EditText) findViewById(R.id.password);
        blogin = (Button) findViewById(R.id.blogin);

        blogin.setOnClickListener(this);

        TextView registerScreen = (TextView) findViewById(R.id.register_link);
        registerScreen.setOnClickListener(this);
        
        ParseUser currentUser = ParseUser.getCurrentUser();
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        if (currentUser != null) {
            Intent intent = new Intent(MainActivity.this, Logout.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    public void onClick(final View v) {
        switch (v.getId()){
            case R.id.blogin: {
                v.setEnabled(false);

                String email = etemail.getText().toString();
                String password = etpassword.getText().toString();
                ParseUser.logInInBackground(email, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            Intent intent = new Intent(MainActivity.this, Logout.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // Signup failed. Look at the ParseException to see what happened.
                            switch (e.getCode()) {
                                case ParseException.USERNAME_TAKEN:
                                    Toast.makeText(getApplicationContext(), "An account with this email id already exists!", Toast.LENGTH_SHORT).show();
                                    break;
                                case ParseException.EMAIL_MISSING:
                                    Toast.makeText(getApplicationContext(), "Please enter your email!", Toast.LENGTH_SHORT).show();
                                    break;
                                case ParseException.PASSWORD_MISSING:
                                    Toast.makeText(getApplicationContext(), "Pleas enter your password!", Toast.LENGTH_SHORT).show();
                                    break;
                                case ParseException.OBJECT_NOT_FOUND:
                                    Toast.makeText(getApplicationContext(), "Sorry incorrect combination of Email and Password!.... Please try again", Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    Toast.makeText(getApplicationContext(), "An error occured in Login...Please try again", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            v.setEnabled(true);
                        }

                    }
                });


            }
            break;
            case R.id.register_link:
            {
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }


        }

    }

}