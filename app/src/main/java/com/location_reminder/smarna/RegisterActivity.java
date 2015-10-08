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


import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    EditText etusername, etemailid, etpassword;
    Button btregister;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        etusername = (EditText) findViewById(R.id.username);
        etemailid = (EditText) findViewById(R.id.emailid);
        etpassword = (EditText) findViewById(R.id.password);
        btregister = (Button) findViewById(R.id.bregister);

        Button bregister;
        TextView signinScreen = (TextView) findViewById(R.id.signin_link);


        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        btregister.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View view) {
                String name = etusername.getText().toString().trim();
                String email = etemailid.getText().toString().trim();
                String password = etpassword.getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                    ParseUser user = new ParseUser();
                    user.setUsername(name);
                    user.setPassword(password);
                    user.setEmail(email);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong
                                switch(e.getCode()){
                                    case ParseException.USERNAME_TAKEN:
                                        Toast.makeText(getApplicationContext(), "An account with this email id already exists!", Toast.LENGTH_SHORT).show();
                                        break;
                                    case ParseException.USERNAME_MISSING:
                                        Toast.makeText(getApplicationContext(), "Please enter your email!", Toast.LENGTH_SHORT).show();
                                        break;
                                    case ParseException.PASSWORD_MISSING:
                                        Toast.makeText(getApplicationContext(), "Pleas enter your password!", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        Toast.makeText(getApplicationContext(), "An error occured in Registration...Please try again", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                                //view.setEnabled(true);
                            }
                        }
                });
                }
                else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        // Link to Login Screen
        signinScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}

