package com.location_reminder.smarna;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

<<<<<<< HEAD
import com.parse.ParseUser;

=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
<<<<<<< HEAD
       // android.support.v7.app.ActionBar actionbar= getSupportActionBar();
//        actionbar.setLogo(R.drawable.set_location);
//        actionbar.setDisplayUseLogoEnabled(true);
//        actionbar.setDisplayShowHomeEnabled(true);
=======
        android.support.v7.app.ActionBar actionbar= getSupportActionBar();
        actionbar.setLogo(R.drawable.set_location);
        actionbar.setDisplayUseLogoEnabled(true);
        actionbar.setDisplayShowHomeEnabled(true);
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
<<<<<<< HEAD
        if (id == R.id.Logout) {
            ParseUser.logOut();
            //ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
            Intent intent = new Intent(Settings.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        if(id== R.id.Help){
            Intent i= new Intent(Settings.this,Help.class);
            startActivity(i);
        }
=======

>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        return super.onOptionsItemSelected(item);
    }
}
