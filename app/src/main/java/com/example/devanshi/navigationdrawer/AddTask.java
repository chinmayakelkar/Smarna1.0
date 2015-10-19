package com.example.devanshi.navigationdrawer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

public class AddTask extends AppCompatActivity {

    ImageButton datePicker;
    int T_year,T_month,T_day;
    static final int Dialog_Id=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final Calendar cal= Calendar.getInstance();
        T_year=cal.get(Calendar.YEAR);
        T_month=cal.get(Calendar.MONTH);
        T_day=cal.get(Calendar.DAY_OF_MONTH);
        shoDialog();
    }


    public void shoDialog()
    {
        datePicker=(ImageButton)findViewById(R.id.imageButton);
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
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener= new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

             T_year=year;
             T_month=monthOfYear+1;
             T_day=dayOfMonth;
             Toast.makeText(AddTask.this, T_year + "/" + T_month + "/" + T_day, Toast.LENGTH_LONG).show();

        }

    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_task, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
