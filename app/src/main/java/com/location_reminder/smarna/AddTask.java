package com.location_reminder.smarna;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import static com.location_reminder.smarna.Constants.CONNECTION_FAILURE_RESOLUTION_REQUEST;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.SystemClock;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationServices;

<<<<<<< HEAD
import com.google.android.gms.maps.model.LatLng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kitlocate.com.kl.kitlocate.class_interface.*;
import kitlocate.com.kl.kitlocate.interfaces.*;
=======
<<<<<<< HEAD
import com.google.android.gms.maps.model.LatLng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
=======
<<<<<<< HEAD
import com.parse.ParseUser;

=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
import java.sql.Time;
import java.text.DateFormat;
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
import com.parse.ParseUser;

import java.util.Calendar;

/**
 * Created by Chinmaya on 08-Oct-15.
 */
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
public class AddTask extends AppCompatActivity  implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<Status>{

    protected static final String TAG = "AddTask";
    //AlarmManager alarmMgr;
    protected GoogleApiClient mGoogleApiClient;
    // Persistent storage for geofences.
    private SimpleGeofenceStore mGeofenceStorage;

    private List<Geofence> myFences;

    private PendingIntent mGeofencePendingIntent;
    private MyPlaces myplaces;
<<<<<<< HEAD
=======
=======
public class AddTask extends AppCompatActivity {
<<<<<<< HEAD
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0

    Button voice,location;
    Button  addTask;
    Button datePicker;
    int T_year,T_month,T_day;
    static final int Dialog_Id=0;
    Button TimePicker;
    static final int Dialog_Id1=1;
    int T_Hour,T_Minute;
    EditText taskdescription,TaskDate,TaskTime;
    TaskDetails taskDetail;
    Context ctx=this;
    String Username;
    Long TaskMilliseconds=new Long(0);
    int TimePickermilliseconds=0;
<<<<<<< HEAD
=======

=======

    Button voice,location;;
    Button  addTask;
    Button datePicker;
    int T_year,T_month,T_day;
    static final int Dialog_Id=0;
    Button TimePicker;
    static final int Dialog_Id1=1;
    int T_Hour,T_Minute;
    EditText taskdescription,TaskDate,TaskTime;
    TaskDetails taskDetail;
    Context ctx=this;
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0

>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
    String taskDesc,taskLocation,taskDate,taskTime;
    EditText TaskDesc_text,Loc_Text,Time_Text,Date_Text,ShowCount;
    DatabaseOperations db;
    static final int check=111;

    Intent in;
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG,"on create called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        android.support.v7.app.ActionBar actionbar= getSupportActionBar();

        myFences = new ArrayList<Geofence>();

        buildGoogleApiClient();
<<<<<<< HEAD
        KitLocate.initKitLocate(this, "026d0172-5897-4b0e-9f87-58892f14167c");
=======
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
        // Instantiate a new geofence storage area.
        mGeofenceStorage = new SimpleGeofenceStore(this);

        //mGeofencePendingIntent = null;


        //mGeofencePendingIntent=getRequestPendingIntent();
        //alarmMgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(),AlarmManager.INTERVAL_FIFTEEN_MINUTES,mGeofencePendingIntent);
        in=getIntent();
        if(in.hasExtra("Username"))
            Username=in.getStringExtra("Username");
            db=new DatabaseOperations(ctx,Username);
//        actionbar.setLogo(R.drawable.set_location);
//        actionbar.setDisplayUseLogoEnabled(true);
//        actionbar.setDisplayShowHomeEnabled(true);
<<<<<<< HEAD
        location=(Button)findViewById(R.id.setlocation);
=======

>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        TaskDesc_text= (EditText) findViewById(R.id.taskdescription);
        Log.i("MyApp", "reached here also is");
        Loc_Text= (EditText) findViewById(R.id.location);
        Time_Text=(EditText) findViewById(R.id.settime);
        Date_Text=(EditText) findViewById(R.id.setdate2);

       // Log.i(in.getStringExtra("Operation"),"Operation Value");
       // Log.i("Passed Data",in.getStringExtra("TaskName"));
        Boolean b=in.getStringExtra("Operation").toString().equalsIgnoreCase("Edit");
        Log.i("Comparison",b.toString());
<<<<<<< HEAD

        String str=in.getStringExtra("location").toString();
//        Log.i("location",str);
=======
<<<<<<< HEAD

<<<<<<< HEAD
        String str=in.getStringExtra("location").toString();
//        Log.i("location",str);
=======
=======
        Log.i("Activity","OHHHH ITSSSS HERE IN");
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
        if(in.getStringExtra("Operation").toString().equalsIgnoreCase("Edit")) {

            TaskDetails Edittask = db.getTask(db, in.getStringExtra("TaskName").toString(),Username);
            TaskDesc_text.setText(Edittask.Taskname);
            Loc_Text.setText(str);
            Log.i("TASK TIME",Edittask.Task_Time);
            Time_Text.setText(Edittask.Task_Time);
            Date_Text.setText(Edittask.Task_Date);
            Loc_Text.setText(Edittask.Location);

        }

<<<<<<< HEAD
        if(in.getStringExtra("Operation").toString().equalsIgnoreCase("TemplateAdd")) {

           // TaskDetails Edittask = db.getTask(db, in.getStringExtra("TaskName").toString());
            TaskDesc_text.setText(in.getStringExtra("TaskName").toString());
//            Loc_Text.setText(Edittask.Location);
//            Log.i("TASK TIME",Edittask.Task_Time);
//            Time_Text.setText(Edittask.Task_Time);
//            Date_Text.setText(Edittask.Task_Date);

        }
<<<<<<< HEAD
        Log.i("Passed Data", in.getStringExtra("TaskName"));
=======
<<<<<<< HEAD
=======


=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db



>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
        Log.i("Passed Data",in.getStringExtra("TaskName"));
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0

<<<<<<< HEAD

        Button voice=(Button)findViewById(R.id.speak);
        location.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTask.this, MapActivity.class);

                startActivityForResult(intent, 1);

            }
        });
=======
        Button voice=(Button)findViewById(R.id.speak);
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db

        taskdescription=(EditText)findViewById(R.id.taskdescription);
        location.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTask.this, MapActivity.class);

                startActivity(intent);
            }
        });
        voice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now!");
                startActivityForResult(intent, check);
            }
        });


        final Calendar cal= Calendar.getInstance();
        T_year=cal.get(Calendar.YEAR);
        T_month=cal.get(Calendar.MONTH);
        T_day=cal.get(Calendar.DAY_OF_MONTH);
        shoDialog();
        showTimePickerDialog();

        Button addTask=(Button)findViewById(R.id.button);
        addTask.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                taskDetail= new TaskDetails();
                Log.v("MyApp", "reached here also is");

                taskDetail.Taskname = TaskDesc_text.getText().toString();
                taskDetail.Location= Loc_Text.getText().toString();
                taskDetail.Task_Time=Time_Text.getText().toString();
                taskDetail.Task_Date= Date_Text.getText().toString();
                taskDetail.Username=Username;
                if(TaskMilliseconds.toString() !=null)
                {

                    TaskMilliseconds=TaskMilliseconds+TimePickermilliseconds;
                    Log.i("Total Task Milliseconds",TaskMilliseconds.toString());
                }
                Log.v("MyApp", "reached here");
<<<<<<< HEAD
                if((taskDetail.Taskname.isEmpty()) || (taskDetail.Task_Time.isEmpty()) ||(taskDetail.Location.isEmpty())|| (taskDetail.Task_Date.isEmpty())) {
=======
<<<<<<< HEAD
                if((taskDetail.Taskname.isEmpty()) || (taskDetail.Task_Time.isEmpty()) ||(taskDetail.Location.isEmpty())|| (taskDetail.Task_Date.isEmpty())) {
=======
<<<<<<< HEAD
                if((taskDetail.Taskname.isEmpty()) || (taskDetail.Task_Time.isEmpty()) || (taskDetail.Task_Date.isEmpty())) {
=======
                if((taskDetail.Taskname.isEmpty()) || (taskDetail.Location.isEmpty()) || (taskDetail.Task_Time.isEmpty()) || (taskDetail.Task_Date.isEmpty())) {
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
                    Toast.makeText(getBaseContext(), "Please Enter All the Required Fields", Toast.LENGTH_LONG).show();
                    Log.v("MyApp", "Empty Fields ");
                }
                else if(!mGoogleApiClient.isConnected())
                {
                    Toast.makeText(AddTask.this, "Connection Error", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent in=getIntent();
                    if(in.getStringExtra("Operation").toString().equalsIgnoreCase("Edit"))
                        db.updateInformation(db,taskDetail,Username);
                    else
                        db.putInformation(db, taskDetail,Username);
                    Toast.makeText(getBaseContext(), "Task Saved", Toast.LENGTH_LONG).show();
                    myplaces=new MyPlaces(taskDetail.Taskname,in.getDoubleExtra("Latitude",0),in.getDoubleExtra("Longitude", 0),10, TaskMilliseconds);
                    addFence(myplaces);
<<<<<<< HEAD
                    KLLocation.addGeofence(AddTask.this, (float) in.getDoubleExtra("Latitude", 0), (float) in.getDoubleExtra("Longitude", 0), 500, KLGeofence.Type.IN, "abc");
                    KLLocation.registerGeofencing(AddTask.this,GeofenceCallbackHandler.class);
                    //KLGeofence myGeofence = new KLGeofence((float)in.getDoubleExtra("Latitude",0), (float)in.getDoubleExtra("Longitude", 0),100, KLGeofence.Type.IN);
=======
                    //monitorFences(myFences);
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
                    finish();
                    Log.e(TAG, "Add task finished");
                    Intent i = new Intent(AddTask.this,TaskListView.class);
                    startActivity(i);

                }

            }
        });

    }
    private void addFence(MyPlaces place) {
        if (place.getFenceRadius() <= 0) {
            // Nothing to monitor
            return;
        }
        Geofence geofence = new Geofence.Builder()
                .setCircularRegion(place.getLatitude(), place.getLongitude(), place.getFenceRadius())
                .setRequestId(place.getId()) // every fence must have an ID
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT) // can also have DWELL
                .setExpirationDuration(place.getExpirationDuration()) // how long do we care about this geofence?
                        //.setLoiteringDelay(60000) // 1 min.
                .build();
        myFences.add(geofence);
        mGeofenceStorage.setGeofence(taskDetail.Taskname, place);
        Log.e(TAG,"add fence called");
        mGeofencePendingIntent=getRequestPendingIntent();
        try{
            Log.e(TAG,"pending intent inside addfence called");
            PendingResult<Status> result =LocationServices.GeofencingApi.addGeofences(mGoogleApiClient, myFences, mGeofencePendingIntent);
            result.setResultCallback(this);
        }
        catch(SecurityException securityException) {
            // Catch exception generated if the app does not use ACCESS_FINE_LOCATION permission.
            logSecurityException(securityException);
        }
    }
    /*private void monitorFences(List<Geofence> fences) {
        if (fences.isEmpty()) {
            throw new RuntimeException("No fences to monitor. Call addPlaceMarker() First.");
        }
        // PRES 2
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
    }*/



    @Override
    public void onResult(Status status) {
        Log.e(TAG, "geofences onresult function called");
        if (status.isSuccess()) {

            Log.e(TAG, "status is sucess");

        }
        else {
            Log.e(TAG, "geofence not updated");
        }}


    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
        Log.i(TAG,"on start called");
    }
    @Override
    protected void onStop() {

        mGoogleApiClient.disconnect();
        super.onStop();
        Log.i(TAG, "on stop called");
    }
    @Override
    public void onConnected(Bundle connectionHint) {

        Log.i(TAG, "Connected to GoogleApiClient");
        /*mGeofencePendingIntent=getRequestPendingIntent();
        try{

                Log.e(TAG, "adding geofencing now");
                PendingResult<Status> result =LocationServices.GeofencingApi.addGeofences(mGoogleApiClient, myFences, mGeofencePendingIntent);
                result.setResultCallback(this);

        }
        catch(SecurityException securityException) {
            // Catch exception generated if the app does not use ACCESS_FINE_LOCATION permission.
            logSecurityException(securityException);
        }*/

    }
    private void logSecurityException(SecurityException securityException) {
        Log.e(TAG, "Invalid location permission. " +
                "You need to use ACCESS_FINE_LOCATION with geofences", securityException);
    }

    @Override
    public void onConnectionFailed (ConnectionResult connectionResult){
            // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(this,
                        CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                Log.e(TAG, "Exception while resolving connection error.", e);
            }
        } else {
            int errorCode = connectionResult.getErrorCode();
            Log.e(TAG, "Connection to Google Play services failed with error code " + errorCode);
        }
        //Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + connectionResult.getErrorCode());
    }

    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason.
        Log.i(TAG, "Connection suspended");

        // onConnected() will be called again automatically when the service reconnects
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
        Log.i(TAG,"buildgoogleapiclient function called");
    }

    public PendingIntent getRequestPendingIntent() {
        return createRequestPendingIntent();

    }
    private PendingIntent createRequestPendingIntent() {
        if (mGeofencePendingIntent != null) {
            return mGeofencePendingIntent;
        } else {
            Intent intent = new Intent(this, GeofenceTransitionReceiver.class);
            intent.setAction("geofence_transition_action");
            return PendingIntent.getBroadcast(this, R.id.geofence_transition_intent, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        }
    }

    public void showTimePickerDialog()
    {
        TimePicker=(Button)findViewById(R.id.TimeButton);
        TimePicker.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        showDialog(Dialog_Id1);
                    }
                }
        );
<<<<<<< HEAD
    }



    public void shoDialog()
    {
        datePicker=(Button)findViewById(R.id.DateButton);
        datePicker.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(Dialog_Id);
                    }
                }


        );


    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        if(id==Dialog_Id)
            return new DatePickerDialog(this,dpickerListener,T_year,T_month,T_day);
        if(id==Dialog_Id1)
            return  new TimePickerDialog(this,Tpclicklistener,T_Hour,T_Minute,true);
        return null;
    }

=======
    }



    public void shoDialog()
    {
        datePicker=(Button)findViewById(R.id.DateButton);
        datePicker.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(Dialog_Id);
                    }
                }


        );


    }

    @Override
    protected Dialog onCreateDialog(int id)
    {
        if(id==Dialog_Id)
            return new DatePickerDialog(this,dpickerListener,T_year,T_month,T_day);
        if(id==Dialog_Id1)
            return  new TimePickerDialog(this,Tpclicklistener,T_Hour,T_Minute,true);
        return null;
    }

>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
    private TimePickerDialog.OnTimeSetListener Tpclicklistener=
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(android.widget.TimePicker view, int hourofDay, int minute) {
                    T_Hour = hourofDay;
                    T_Minute = minute;
<<<<<<< HEAD
                    String   timeformat;
<<<<<<< HEAD
                    TimePickermilliseconds=(((hourofDay * 3600) + (minute * 60)) * 1000) ;

                    //    Toast.makeText(AddTask.this, T_Hour + ":" + T_Minute , Toast.LENGTH_LONG).show();
=======
<<<<<<< HEAD
                    TimePickermilliseconds=(((hourofDay * 3600) + (minute * 60)) * 1000) ;

                    //    Toast.makeText(AddTask.this, T_Hour + ":" + T_Minute , Toast.LENGTH_LONG).show();
=======
                //    Toast.makeText(AddTask.this, T_Hour + ":" + T_Minute , Toast.LENGTH_LONG).show();
=======
                    Toast.makeText(AddTask.this, T_Hour + ":" + T_Minute , Toast.LENGTH_LONG).show();
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
                    TaskTime= (EditText)findViewById(R.id.settime);





                    Log.i("TimePicker milliseconds","time:"+TimePickermilliseconds);
//                    cal.set(Calendar.HOUR,T_Hour);
//                    cal.set(Calendar.MINUTE, T_Minute);
//                    TaskTime.setText((int) cal.);
<<<<<<< HEAD
                    String.format("%02d", T_Hour);
                    String.format("%02d", T_Minute);

                    if(T_Hour>=0 && T_Hour<=12)
                        timeformat="A.M.";
                    else
                        timeformat="P.M.";
                    TaskTime.setText(String.format("%02d", T_Hour) + ":" +  String.format("%02d", T_Minute) +" "+timeformat);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
                    TaskTime.setText(T_Hour + ":" + T_Minute +" "+ android.text.format.DateFormat.is24HourFormat(ctx));
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db

>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
                }
            };

    private DatePickerDialog.OnDateSetListener dpickerListener= new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            T_year=year;
            T_month=monthOfYear+1;
            T_day=dayOfMonth;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
            SimpleDateFormat dateformat= new SimpleDateFormat("MMMM dd yyyy hh:mm:ss");
            Calendar cal = Calendar.getInstance();
            String currDate= dateformat.format(cal.getTime());
            Date TodaysDate= new Date();
            try {
                TodaysDate= dateformat.parse(currDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
<<<<<<< HEAD

            cal.set(year, monthOfYear, dayOfMonth,00,00,00);
            String setDate= dateformat.format(cal.getTime());
            Date taskDate= new Date();
            try {
                taskDate= dateformat.parse(setDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

           Log.i("GetDate", "Date" + taskDate.getDate());
            SimpleDateFormat dateformat2= new SimpleDateFormat("MMMM dd yyyy");
            Date date1=new Date();
            Date date2= new Date();
            try {
                String date1string= dateformat2.format(TodaysDate);
                String date2string=dateformat2.format(taskDate);
                date1= dateformat2.parse(date1string);
                date2= dateformat2.parse(date2string);
                Log.i("TODAYS DATE",date1.toString());
                Log.i("Task DATE",taskDate.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Log.i("data format", TodaysDate + "  " + taskDate);

            if(date2.compareTo(date1)<0)
            {
                Toast.makeText(getBaseContext(), "Invalid Task Date", Toast.LENGTH_LONG).show();
            }
            else {

                TaskDate = (EditText) findViewById(R.id.setdate2);
                TaskDate.setText(T_year + "/" + T_month + "/" + T_day);
                TaskMilliseconds = taskDate.getTime()- TodaysDate.getTime();

=======
=======
<<<<<<< HEAD
           // Toast.makeText(AddTask.this, T_year + "/" + T_month + "/" + T_day, Toast.LENGTH_LONG).show();
=======
            Toast.makeText(AddTask.this, T_year + "/" + T_month + "/" + T_day, Toast.LENGTH_LONG).show();
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
            TaskDate= (EditText)findViewById(R.id.setdate2);
            TaskDate.setText(T_year + "/" + T_month + "/" + T_day);
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693

            cal.set(year, monthOfYear, dayOfMonth,00,00,00);
            String setDate= dateformat.format(cal.getTime());
            Date taskDate= new Date();
            try {
                taskDate= dateformat.parse(setDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

           Log.i("GetDate", "Date" + taskDate.getDate());
            SimpleDateFormat dateformat2= new SimpleDateFormat("MMMM dd yyyy");
            Date date1=new Date();
            Date date2= new Date();
            try {
                String date1string= dateformat2.format(TodaysDate);
                String date2string=dateformat2.format(taskDate);
                date1= dateformat2.parse(date1string);
                date2= dateformat2.parse(date2string);
                Log.i("TODAYS DATE",date1.toString());
                Log.i("Task DATE",taskDate.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Log.i("data format", TodaysDate + "  " + taskDate);

            if(date2.compareTo(date1)<0)
            {
                Toast.makeText(getBaseContext(), "Invalid Task Date", Toast.LENGTH_LONG).show();
            }
            else {

                TaskDate = (EditText) findViewById(R.id.setdate2);
                TaskDate.setText(T_year + "/" + T_month + "/" + T_day);
                TaskMilliseconds = taskDate.getTime()- TodaysDate.getTime();

>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
            }
        }




    };

    String resultspeeech="";
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==check && resultCode==RESULT_OK)
        {
            ArrayList<String> speech=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            resultspeeech=speech.get(0);
            taskdescription.setText(resultspeeech);
        }
        if(requestCode==1 && resultCode==RESULT_OK){
            if(data.hasExtra("location")) {
                Loc_Text.setText(data.getExtras().getString("location"));
                Toast.makeText(this,data.getExtras().getString("location"),Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

<<<<<<< HEAD
=======
        }
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        if(id==R.id.Logout)
        {
            ParseUser.logOut();
            //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
            Intent intent = new Intent(AddTask.this, MainActivity.class);
            startActivity(intent);
            finish();

        }
        if (id == R.id.action_settings) {
            Intent i= new Intent(AddTask.this,Settings.class);
            startActivity(i);
        }
        if(id== R.id.Help){
            Intent i= new Intent(AddTask.this,Help.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

        //return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Intent in= getIntent();

        Log.i("RESUME","intent"+in);
//        String str=in.getStringExtra("location").toString();
//        Log.i("location",str);
    }




}
