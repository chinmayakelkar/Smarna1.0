package com.location_reminder.smarna;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

/**
 * Created by Chinmaya on 08-Oct-15.
 */
public class AddTask extends AppCompatActivity{

    Button voice;
     EditText taskdescription;
    static final int check=111;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);
        Button voice=(Button)findViewById(R.id.speak);
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
    }
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
        if(id==R.id.action_home)
        {
            //Change here to task list screen
            Intent intent = new Intent(AddTask.this, Logout.class);
            startActivity(intent);
            finish();

        }
        if(id==R.id.action_logout)
        {
            Intent intent = new Intent(AddTask.this, Logout.class);
            startActivity(intent);
            finish();

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
