package com.location_reminder.smarna;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Chinmaya on 06-Oct-15.
 */
    public class AppController extends Application {

        public static final String TAG = AppController.class.getSimpleName();

        private RequestQueue mRequestQueue;
        private Context myContext;

        private static AppController mInstance;
        public AppController(Context context){
        myContext = context;
        mRequestQueue = getRequestQueue();
    }

        @Override
        public void onCreate() {
            super.onCreate();
            mInstance = this;
        }

        public static synchronized AppController getInstance(Context context) {
            if(mInstance==null){
                mInstance = new AppController(context);
            }
            return mInstance;
        }

        public RequestQueue getRequestQueue() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(myContext.getApplicationContext());
            }

            return mRequestQueue;
        }

        public <T> void addToRequestQueue(Request<T> req, String tag) {
            req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
            getRequestQueue().add(req);
        }

        public <T> void addToRequestQueue(Request<T> req) {
            req.setTag(TAG);
            getRequestQueue().add(req);
        }

        public void cancelPendingRequests(Object tag) {
            if (mRequestQueue != null) {
                mRequestQueue.cancelAll(tag);
            }
        }
    }

