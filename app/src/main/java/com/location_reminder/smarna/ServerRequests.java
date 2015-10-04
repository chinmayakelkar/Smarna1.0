package com.location_reminder.smarna;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Chinmaya on 03-Oct-15.
 */
public class ServerRequests {
    ProgressDialog progressDialog;
    public static final int Connection_Timeout=1000*15;
    public static final String Server_Address="http://smarna.net16.net/";

    public ServerRequests(Context context)
    {
        progressDialog=new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading");
        progressDialog.setTitle("Please wait....");
    }
    public void StoreUserDatabgd(User user,GetUserCallBack userCallBack)
    {
        progressDialog.show();
        new StoreUserDataAsyncTask(user, userCallBack).execute();

    }
    public void FetchUserDatabgd(User user, GetUserCallBack callBack)
    {
        progressDialog.show();
    }
    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void>{
        User user;
        GetUserCallBack userCallBack;
        public StoreUserDataAsyncTask(User user, GetUserCallBack userCallBack)
        {
            this.user=user;
            this.userCallBack=userCallBack;
        }

        @Override
        protected Void doInBackground(Void... params) {
            URL url = null;
            try {
                url = new URL(Server_Address);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("username", user.username)
                        .appendQueryParameter("emailid", user.emailid)
                        .appendQueryParameter("password", user.password);
                String query = builder.build().getEncodedQuery();


            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        return null;
        }


        @Override
        protected void onPostExecute(Void aVoid)
        {
            progressDialog.dismiss();
            userCallBack.complete(null);
            super.onPostExecute(aVoid);
        }
    }
}
