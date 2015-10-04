package com.location_reminder.smarna;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements OnClickListener{
    EditText etusername, etemailid ,etpassword;
    Button bregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        etusername=(EditText)findViewById(R.id.username);
        etemailid=(EditText)findViewById(R.id.emailid);
        etpassword=(EditText)findViewById(R.id.password);
        bregister=(Button)findViewById(R.id.bregister);
        bregister.setOnClickListener(this);
        Button bregister;
        TextView signinScreen = (TextView) findViewById(R.id.signin_link);

        // Listening to Login Screen link
        signinScreen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bregister:
                String username=etusername.getText().toString();
                String password=etpassword.getText().toString();
                String emailid=etemailid.getText().toString();
                User registeredData=new User(username,emailid,password);
                break;
            case R.id.signin_link:
                finish();
        }
    }
}
