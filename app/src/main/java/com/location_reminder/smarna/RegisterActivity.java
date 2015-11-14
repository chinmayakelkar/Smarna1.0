package com.location_reminder.smarna;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    Context ctx=this;
    EditText etusername, etemailid, etpassword;
    Button btregister;
    DatabaseOperations db= new DatabaseOperations(ctx);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        etusername = (EditText) findViewById(R.id.username);
        etemailid = (EditText) findViewById(R.id.emailid);
        etpassword = (EditText) findViewById(R.id.password);
        //etusername.setHint(Html.fromHtml("<font color='#7B7B7B'>Username</font> "));
        //etusername.setHintTextColor(Color.GRAY);
        //etemailid.setHintTextColor(Color.GRAY);
        //etpassword.setHintTextColor(Color.GRAY);
        btregister = (Button) findViewById(R.id.bregister);


        TextView signinScreen = (TextView) findViewById(R.id.signin_link);
        signinScreen.setPaintFlags(signinScreen.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        //final String emailid= etemailid.getText().toString().trim();


        //pDialog = new ProgressDialog(this);
        //pDialog.setCancelable(false);
        /*etemailid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!(emailValidator(emailid)))
                {
                    Toast.makeText(getApplicationContext(), "Pleae enter a valid email address!", Toast.LENGTH_SHORT).show();
            }
            }
        });*/
        btregister.setOnClickListener(new View.OnClickListener() {
            public void onClick( final View view) {
                view.setEnabled(false);
                final String name = etusername.getText().toString().trim();
                String email = etemailid.getText().toString().trim();
                String password = etpassword.getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                    ParseUser user = new ParseUser();
                    user.setUsername(name);//to enable login by email
                    user.setPassword(password);
                    user.setEmail(email);
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0

                                db.createUserTable(db,name);
                                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
=======
                                Intent intent = new Intent(RegisterActivity.this,TaskListView.class);
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
                                startActivity(intent);
                                finish();
                            } else {
                                // Sign up didn't succeed. Look at the ParseException
                                // to figure out what went wrong
                                switch(e.getCode()){
                                    case ParseException.USERNAME_TAKEN:
                                        Toast.makeText(getApplicationContext(), "An account with this username already exists!", Toast.LENGTH_SHORT).show();
                                        break;
                                    case ParseException.EMAIL_MISSING:
                                        Toast.makeText(getApplicationContext(), "Please enter your email!", Toast.LENGTH_SHORT).show();
                                        break;
                                    case ParseException.EMAIL_TAKEN:
                                        Toast.makeText(getApplicationContext(), "An account with this email already exits!", Toast.LENGTH_SHORT).show();
                                        break;
                                    case ParseException.PASSWORD_MISSING:
                                        Toast.makeText(getApplicationContext(), "Pleas enter your password!", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        Toast.makeText(getApplicationContext(), "Please enter a valid email address!", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                                view.setEnabled(true);
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
                ParseUser currentUser=ParseUser.getCurrentUser();

              String Username=currentUser.getUsername().toString();
db.createUserTable(db,Username);

                Intent i = new Intent(getApplicationContext(),
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
    /*public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }*/
}

