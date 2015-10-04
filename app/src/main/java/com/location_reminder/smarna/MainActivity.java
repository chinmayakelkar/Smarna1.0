package com.location_reminder.smarna;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button blogin;
    EditText etemail, etpassword;
    UserLocalStore userlocalstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etemail=(EditText)findViewById(R.id.Email);
        etpassword=(EditText)findViewById(R.id.password);
        blogin=(Button)findViewById(R.id.blogin);

        blogin.setOnClickListener(this);
        TextView registerScreen = (TextView) findViewById(R.id.register_link);
        registerScreen.setOnClickListener(this);
        userlocalstore=new UserLocalStore(this);

    }
    @Override
    protected void onStart(){
        super.onStart();
        if (authenticate()==true){
            Intent i = new Intent(getApplicationContext(), Logout.class);
            startActivity(i);
        }
    }
    private boolean authenticate(){
        return userlocalstore.CheckUserLoggedIn();
    }
    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.blogin:
                User user=new User(null,null);
                userlocalstore.SetUserLoggedin(true);
                userlocalstore.StoreUserData(user);

                break;
            case R.id.register_link:
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);

    }
}
}

