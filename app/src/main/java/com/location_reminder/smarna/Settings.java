package com.location_reminder.smarna;

<<<<<<< HEAD
import android.content.Context;
=======
<<<<<<< HEAD
import android.content.Context;
=======
<<<<<<< HEAD
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
import android.content.Intent;
=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.parse.ParseUser;

=======
>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
public class Settings extends AppCompatActivity {
    private static SeekBar seek_bar;
    private static TextView text_view;
    Context ctx = this;
    int Rad_progress_value;
    int Freq_progress_value;
    DatabaseOperations db = new DatabaseOperations(ctx);
    ParseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
<<<<<<< HEAD
        // android.support.v7.app.ActionBar actionbar= getSupportActionBar();
//        actionbar.setLogo(R.drawable.set_location);
//        actionbar.setDisplayUseLogoEnabled(true);
//        actionbar.setDisplayShowHomeEnabled(true);
        seekbar_freq();
        seekbar_radius();
    }

    public void seekbar_freq() {
        seek_bar = (SeekBar) findViewById(R.id.seekBar);
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {


                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Freq_progress_value = progress;
                        if (progress == 0)
                            Toast.makeText(Settings.this, "Low - Notify only once", Toast.LENGTH_LONG).show();
                        if (progress == 1)
                            Toast.makeText(Settings.this, "Medium - Once in three hours ", Toast.LENGTH_LONG).show();
                        if (progress == 2)
                            Toast.makeText(Settings.this, "High - Notify every hour", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void seekbar_radius() {
        seek_bar = (SeekBar) findViewById(R.id.seekBar2);
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {


                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Rad_progress_value = progress;
                        if (progress == 0)
                            Toast.makeText(Settings.this, "Immediate - Within half a mile", Toast.LENGTH_LONG).show();
                        if (progress == 1)
                            Toast.makeText(Settings.this, "Near - 2 miles", Toast.LENGTH_LONG).show();
                        if (progress == 2)
                            Toast.makeText(Settings.this, "Far - 5 miles", Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
=======
<<<<<<< HEAD
        // android.support.v7.app.ActionBar actionbar= getSupportActionBar();
//        actionbar.setLogo(R.drawable.set_location);
//        actionbar.setDisplayUseLogoEnabled(true);
//        actionbar.setDisplayShowHomeEnabled(true);
        seekbar_freq();
        seekbar_radius();
    }

    public void seekbar_freq() {
        seek_bar = (SeekBar) findViewById(R.id.seekBar);
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {


                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Freq_progress_value = progress;
                        if (progress == 0)
                            Toast.makeText(Settings.this, "Low - Notify only once", Toast.LENGTH_LONG).show();
                        if (progress == 1)
                            Toast.makeText(Settings.this, "Medium - Once in three hours ", Toast.LENGTH_LONG).show();
                        if (progress == 2)
                            Toast.makeText(Settings.this, "High - Notify every hour", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void seekbar_radius() {
        seek_bar = (SeekBar) findViewById(R.id.seekBar2);
        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {


                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Rad_progress_value = progress;
                        if (progress == 0)
                            Toast.makeText(Settings.this, "Immediate - Within half a mile", Toast.LENGTH_LONG).show();
                        if (progress == 1)
                            Toast.makeText(Settings.this, "Near - 2 miles", Toast.LENGTH_LONG).show();
                        if (progress == 2)
                            Toast.makeText(Settings.this, "Far - 5 miles", Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );
=======
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
>>>>>>> 0125b8b45ae01fc5ffc6bef3983758392847d693
>>>>>>> 0c726a28134350d1f7ca760a9732263bc10e13f0
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

        if (id == R.id.Help) {
            Intent i = new Intent(Settings.this, Help.class);
            startActivity(i);
        }
=======

>>>>>>> 0d66c1ab5386cf0bae91b5aec364989d2c1789db
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        UserSettings settings= new UserSettings();
        settings.NotificationFreq=Freq_progress_value;

        if(Rad_progress_value==0)
            settings.NotificationRadius=500;
        if(Rad_progress_value==1)
            settings.NotificationRadius=1000;
        if(Rad_progress_value==2)
            settings.NotificationRadius=3000;

        currentUser=ParseUser.getCurrentUser();
        db.putSettingsInfo(db,settings,currentUser.getUsername().toString());
        Log.i("Setting added","User settings added to database");

        super.onBackPressed();

    }
}