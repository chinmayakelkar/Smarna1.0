package com.location_reminder.smarna;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity{
    Button blogin;
    private static final String TAG = RegisterActivity.class.getSimpleName();
    EditText etemail, etpassword;
    //UserLocalStore userlocalstore;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etemail=(EditText)findViewById(R.id.Email);
        etpassword=(EditText)findViewById(R.id.password);
        blogin=(Button)findViewById(R.id.blogin);

        //blogin.setOnClickListener(this);
        TextView registerScreen = (TextView) findViewById(R.id.register_link);
        //registerScreen.setOnClickListener(this);
        //userlocalstore=new UserLocalStore(this);
        // SQLite database handler
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        db = new SQLiteHandler(getApplicationContext());

        // Session manager
        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(MainActivity.this, Logout.class);
            startActivity(intent);
            finish();


    }
        blogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = etemail.getText().toString().trim();
                String password = etpassword.getText().toString().trim();

                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    // login user
                    checkLogin(email, password);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter email id and password!", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),
                        RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    /**
     * function to verify login details in mysql db
     * */
    private void checkLogin(final String email, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest strReq = new StringRequest(Method.POST,
                AppConfig.URL_LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Login Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");

                    // Check for error node in json
                    if (!error) {
                        // user successfully logged in
                        // Create login session
                        session.setLogin(true);

                        // Now store the user in SQLite
                        String uid = jObj.getString("uid");

                        JSONObject user = jObj.getJSONObject("user");
                        String name = user.getString("name");
                        String email = user.getString("email");

                        // Inserting row in users table
                        db.addUser(name, email, uid);

                        // Launch main activity
                        Intent intent = new Intent(MainActivity.this,
                                Logout.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Error in login. Get the error message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance(this).addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }}

    /*@Override
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
                String email=etemail.getText().toString();
                String password=etpassword.getText().toString();
                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    User user=new User(email,password);
                    authenticateuser(user);
                }
                else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter email and password", Toast.LENGTH_LONG)
                            .show();
                }

                break;
            case R.id.register_link:
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
                finish();

    }
}
    private void  authenticateuser(User user)
    {
        //check network connection
        ServerRequests serverRequests=new ServerRequests(this);
        serverRequests.FetchUserDatabgd(user, new GetUserCallBack() {
            @Override
            public void complete(User returnedUser) {
                if(returnedUser== null)
                {
                   // startActivity(new Intent(MainActivity.this,Logout.class));

                    //use toast
                    showErrorMessage();
                }
                else
                {
                    logUserin(returnedUser);
                }
            }
        });
    }

    //use toasr
    private void showErrorMessage()
    {
        AlertDialog.Builder dialogbuilder= new AlertDialog.Builder(MainActivity.this);
        dialogbuilder.setMessage("Incorrect email or password");
        dialogbuilder.setPositiveButton("Ok", null);
        dialogbuilder.show();
    }

    private void logUserin(User returnedUser)
    {
        userlocalstore.StoreUserData(returnedUser);
        userlocalstore.SetUserLoggedin(true);

        //connect from here to home page

        startActivity(new Intent(this, Logout.class));

    }*/


