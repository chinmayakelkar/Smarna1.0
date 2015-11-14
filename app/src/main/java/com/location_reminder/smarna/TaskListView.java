package com.location_reminder.smarna;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

<<<<<<< HEAD
import com.parse.ParseUser;

=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TaskListView extends AppCompatActivity {
    Context ctx=this;
    DatabaseOperations db= new DatabaseOperations(ctx);
    TaskDetails taskDetails;
    String Username;
    ParseUser currentUser;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list_view);

        Intent in=getIntent();
        if (in.hasExtra("Username")) {
            Log.i("Username", in.getStringExtra("Username").toString());

            Username=in.getStringExtra("Username").toString();
        }
        else
        {
            currentUser=ParseUser.getCurrentUser();

            Username=currentUser.getUsername().toString();
        }
      // db= new DatabaseOperations(ctx);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            public  void onClick(View v){
              //  finish();
<<<<<<< HEAD
                Intent i= new Intent(TaskListView.this,TaskTemplate.class);
=======
                Intent i= new Intent(TaskListView.this,AddTask.class);
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
                i.putExtra("TaskName","NAME");
                i.putExtra("Operation","ADD");
                i.putExtra("Username",Username);
                startActivity(i);
            }
        });

        ExpandableListView elv=(ExpandableListView) findViewById(R.id.expandableListView);
        final ArrayList<Task> task=getData();
        CustomAdapter adapter=new CustomAdapter(this, task);
        elv.setAdapter(adapter);

        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

               if(task.get(groupPosition).task_option.get(childPosition)=="Edit")
               {
                   Intent i= new Intent(TaskListView.this,AddTask.class);
                   i.putExtra("TaskName",task.get(groupPosition).Name);
                   i.putExtra("location","");
                   i.putExtra("Operation",task.get(groupPosition).task_option.get(childPosition).toString());
<<<<<<< HEAD
                   i.putExtra("Username",Username);
=======
<<<<<<< HEAD
                   i.putExtra("Username",Username);
=======
<<<<<<< HEAD

=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
                   startActivity(i);

               }
                if(task.get(groupPosition).task_option.get(childPosition)=="Complete")
                {
                    db.deleteInformation(db, task.get(groupPosition).Name,Username);
                    finish();
                    Intent i= new Intent(TaskListView.this,TaskListView.class);
                    startActivity(i);

                }


                Log.i("Clicked"+task.get(groupPosition).Name,task.get(groupPosition).task_option.get(childPosition));
                Toast.makeText(getApplicationContext(), task.get(groupPosition).task_option.get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
    private ArrayList<Task> getData()
    {
       // String[] TaskDescList= new String()[10];
        List<TaskDetails> TaskList = new ArrayList<TaskDetails>();
        TaskDetails t= new TaskDetails();
        TaskList= db.getInformation(db,Username);

        Task t1=new Task("Grocery Shopping");
        t1.task_option.add("Edit");
        t1.task_option.add("Complete");

        Task t2=new Task("Submit documents");
        t2.task_option.add("Edit");
        t2.task_option.add("Complete");
        ArrayList<Task> allTasks = new ArrayList<Task>();
<<<<<<< HEAD
//        allTasks.add(t1);
//        allTasks.add(t2);
=======
        allTasks.add(t1);
        allTasks.add(t2);
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        Iterator itr= TaskList.iterator();
                while(itr.hasNext())
                {
                        Object TaskElement = itr.next();
                        t=(TaskDetails)TaskElement;
                        Log.i("TaskDesc",t.Taskname);
                        Task t3= new Task(t.Taskname);
                        t3.task_option.add("Edit");
                        t3.task_option.add("Complete");
                        allTasks.add(t3);

                }
        return allTasks;
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
            Intent i= new Intent(TaskListView.this,Settings.class);
            startActivity(i);
        }
        if(id== R.id.Help){
            Intent i= new Intent(TaskListView.this,Help.class);
            startActivity(i);
        }
        if(id== R.id.Logout){
<<<<<<< HEAD

            ParseUser.logOut();
            //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
            Intent intent = new Intent(TaskListView.this, MainActivity.class);
            startActivity(intent);
            finish();
=======
            Intent i= new Intent(TaskListView.this,Logout.class);
            startActivity(i);
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        }


        return super.onOptionsItemSelected(item);
    }
}
