package com.location_reminder.smarna;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.parse.ParseUser;

import java.sql.Time;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Chinmaya on 08-Oct-15.
 */
public class AddTask extends AppCompatActivity {

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

    String taskDesc,taskLocation,taskDate,taskTime;
    EditText TaskDesc_text,Loc_Text,Time_Text,Date_Text,ShowCount;
    DatabaseOperations db=new DatabaseOperations(ctx);
    static final int check=111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        android.support.v7.app.ActionBar actionbar= getSupportActionBar();
//        actionbar.setLogo(R.drawable.set_location);
//        actionbar.setDisplayUseLogoEnabled(true);
//        actionbar.setDisplayShowHomeEnabled(true);
        location=(Button)findViewById(R.id.setlocation);
        TaskDesc_text= (EditText) findViewById(R.id.taskdescription);
        Log.i("MyApp", "reached here also is");
        Loc_Text= (EditText) findViewById(R.id.location);
        Time_Text=(EditText) findViewById(R.id.settime);
        Date_Text=(EditText) findViewById(R.id.setdate2);
        Intent in=getIntent();
        Log.i(in.getStringExtra("Operation"),"Operation Value");
        Log.i("Passed Data",in.getStringExtra("TaskName"));
        Boolean b=in.getStringExtra("Operation").toString().equalsIgnoreCase("Edit");
        Log.i("Comparison",b.toString());

        if(in.getStringExtra("Operation").toString().equalsIgnoreCase("Edit")) {

            TaskDetails Edittask = db.getTask(db, in.getStringExtra("TaskName").toString());
            TaskDesc_text.setText(Edittask.Taskname);
            Loc_Text.setText(Edittask.Location);
            Log.i("TASK TIME",Edittask.Task_Time);
            Time_Text.setText(Edittask.Task_Time);
            Date_Text.setText(Edittask.Task_Date);

        }

        if(in.getStringExtra("Operation").toString().equalsIgnoreCase("TemplateAdd")) {

           // TaskDetails Edittask = db.getTask(db, in.getStringExtra("TaskName").toString());
            TaskDesc_text.setText(in.getStringExtra("TaskName").toString());
//            Loc_Text.setText(Edittask.Location);
//            Log.i("TASK TIME",Edittask.Task_Time);
//            Time_Text.setText(Edittask.Task_Time);
//            Date_Text.setText(Edittask.Task_Date);

        }





        Log.i("Passed Data",in.getStringExtra("TaskName"));


        Button voice=(Button)findViewById(R.id.speak);
        location.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTask.this, MapActivity.class);

                startActivity(intent);
            }
        });

        taskdescription=(EditText)findViewById(R.id.taskdescription);
        voice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now!");
                startActivityForResult(intent,check);
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
                Log.v("MyApp", "reached here");
                if((taskDetail.Taskname.isEmpty()) || (taskDetail.Task_Time.isEmpty()) || (taskDetail.Task_Date.isEmpty())) {
                    Toast.makeText(getBaseContext(), "Please Enter All the Required Fields", Toast.LENGTH_LONG).show();
                    Log.v("MyApp", "Empty Fields ");
                }
                else {
                    Intent in=getIntent();
                    if(in.getStringExtra("Operation").toString().equalsIgnoreCase("Edit"))
                        db.updateInformation(db,taskDetail);
                    else
                        db.putInformation(db, taskDetail);
                    Toast.makeText(getBaseContext(), "Task Saved", Toast.LENGTH_LONG).show();
                    finish();
                    Intent i= new Intent(AddTask.this,TaskListView.class);
                    startActivity(i);

                }
                //            finish();
            }
        });

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

    private TimePickerDialog.OnTimeSetListener Tpclicklistener=
            new TimePickerDialog.OnTimeSetListener() {
                public void onTimeSet(android.widget.TimePicker view, int hourofDay, int minute) {
                    T_Hour = hourofDay;
                    T_Minute = minute;
                    String   timeformat;
                //    Toast.makeText(AddTask.this, T_Hour + ":" + T_Minute , Toast.LENGTH_LONG).show();
                    TaskTime= (EditText)findViewById(R.id.settime);
                Calendar cal= Calendar.getInstance();

//                    cal.set(Calendar.HOUR,T_Hour);
//                    cal.set(Calendar.MINUTE, T_Minute);
//                    TaskTime.setText((int) cal.);
                    String.format("%02d", T_Hour);
                    String.format("%02d", T_Minute);
                    if(T_Hour>=0 && T_Hour<=12)
                        timeformat="A.M";
                    else
                    timeformat="P.M";
                    TaskTime.setText(String.format("%02d", T_Hour) + ":" +  String.format("%02d", T_Minute) +" "+timeformat);

                }
            };

    private DatePickerDialog.OnDateSetListener dpickerListener= new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            T_year=year;
            T_month=monthOfYear+1;
            T_day=dayOfMonth;
           // Toast.makeText(AddTask.this, T_year + "/" + T_month + "/" + T_day, Toast.LENGTH_LONG).show();
            TaskDate= (EditText)findViewById(R.id.setdate2);
            TaskDate.setText(T_year + "/" + T_month + "/" + T_day);

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
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

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
}
