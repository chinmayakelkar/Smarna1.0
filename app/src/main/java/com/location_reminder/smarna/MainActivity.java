package com.location_reminder.smarna;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;

import com.kl.kitlocate.interfaces.KitLocate;
import com.parse.LogInCallback;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button blogin;
    TextView fgpassword;
    EditText etemail, etpassword;

    // private ProgressDialog pDialog;
    private String emailid="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etemail = (EditText) findViewById(R.id.Username);
        //etemail.setHintTextColor(Color.GRAY);

        etpassword = (EditText) findViewById(R.id.password);
        etpassword.setHintTextColor(Color.GRAY);
        blogin = (Button) findViewById(R.id.blogin);

        blogin.setOnClickListener(this);
        TextView fgpassword=(TextView)findViewById(R.id.fgpassword);
        fgpassword.setPaintFlags(fgpassword.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        fgpassword.setOnClickListener(this);
        TextView registerScreen = (TextView) findViewById(R.id.register_link);
        registerScreen.setPaintFlags(registerScreen.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        registerScreen.setOnClickListener(this);

        //ParseUser currentUser = ParseUser.getCurrentUser();
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
        /*if (currentUser != null) {
            Intent intent = new Intent(MainActivity.this, Logout.class);
            startActivity(intent);
            finish();
        }*/
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

                            Intent intent = new Intent(MainActivity.this, TaskListView.class);
                            ParseUser currentUser=ParseUser.getCurrentUser();
<<<<<<< HEAD
                            KitLocate.setUniqueUserID(MainActivity.this, currentUser.getUsername());
=======
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
                            String strUser=currentUser.getUsername().toString();
                            intent.putExtra("Username",strUser);
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
            break;
            case R.id.fgpassword:
            {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Reset Password");
                alertDialog.setMessage("Please enter your email address");

                // Set up the input
                final EditText input = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                alertDialog.setView(input);
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                        // User pressed OK button. Write Logic Here
                        emailid = input.getText().toString();
                        ParseUser.requestPasswordResetInBackground(emailid, new RequestPasswordResetCallback() {
                            public void done(ParseException e) {
                                if (e == null) {
                                    dialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "An email was successfully sent with reset instructions", Toast.LENGTH_LONG).show();
                                    // Something went wrong. Look at the ParseException to see what's up.

                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "Sorry no account with this email address exits", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
            break;
        }

    }

}