package com.location_reminder.smarna;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.parse.ParseUser;

public class TaskTemplate extends AppCompatActivity {

    GridView grid;
    Context ctx;
    DatabaseOperations db;
    String username;
    String[] task_template = {
            "Buy groceries",
            "Meet someone",
            "Submit documents",
            "Take out cash",
            "Print Docs",
            "Visit the library",
            "Go shopping",
            "Refuel vehical",
            "Custom Task"
    };
    int[] imageId = {
            R.drawable.shopping_basket,
            R.drawable.person,
            R.drawable.description,
            R.drawable.local_atm,
            R.drawable.local_printshop,
            R.drawable.local_library,
            R.drawable.local_mall,
            R.drawable.gas_station,
            R.drawable.ic_c

    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GridView gridView = new GridView(this);
        gridView.setNumColumns(3);
        setContentView(gridView);
        ImageAdapter adapt = new ImageAdapter(TaskTemplate.this, task_template, imageId);
        gridView.setAdapter(adapt);
        Intent intent=getIntent();
        if(intent.hasExtra("Username"))
        username=intent.getStringExtra("Username");
        db=new DatabaseOperations(ctx,username);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                        Intent i= new Intent(TaskTemplate.this,AddTask.class);
                if(position == 8) {
                    i.putExtra("TaskName", "");
                    i.putExtra("Operation", "");
                    i.putExtra("location","");
                    i.putExtra("Username",username);
                    startActivity(i);
                }
                else
                i.putExtra("TaskName",task_template[+position]);
                i.putExtra("Operation", "TemplateAdd");
                i.putExtra("location","");
                i.putExtra("Username",username);
                        startActivity(i);




                Toast.makeText(TaskTemplate.this, "You selected" + task_template[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_task_list_view,menu);
        //  getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent i= new Intent(TaskTemplate.this,Settings.class);
            startActivity(i);
        }
        if(id== R.id.Help){
            Intent i= new Intent(TaskTemplate.this,Help.class);
            startActivity(i);
        }
        if(id== R.id.Logout){

            ParseUser.logOut();
            //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
            Intent intent = new Intent(TaskTemplate.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
