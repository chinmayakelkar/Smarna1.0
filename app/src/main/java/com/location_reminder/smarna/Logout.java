package com.location_reminder.smarna;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Chinmaya on 03-Oct-15.
 */
public class Logout extends AppCompatActivity implements View.OnClickListener{

   Button blogout;
    TextView tv2,tv3;
    UserLocalStore userlocalstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);
    blogout=(Button)findViewById(R.id.blogout);
        blogout.setOnClickListener(this);
        displayuserdetails();
        userlocalstore=new UserLocalStore(this);
}
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.blogout:
            userlocalstore.ClearUserData();
                userlocalstore.SetUserLoggedin(false);
        }

    }
    private void displayuserdetails(){
        User user=userlocalstore.getLoggedInUser();
        tv3.setText(user.emailid);
        tv2.setText(user.username);
    }
}