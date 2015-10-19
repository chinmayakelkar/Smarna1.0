package com.example.devanshi.navigationdrawer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
        Button btshow;
        public ListView thelistview;

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        btshow = (Button) findViewById(R.id.button);
        btshow.setOnClickListener(new View.OnClickListener()
        {
            public  void onClick(View v){
                Intent i= new Intent(MainActivity.this,AddTask.class);
                startActivity(i);
    }String[] values = new String[]{"Grocery shopping", "Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Visit ATM", "pickUpLaundry",
                    "Visit frnd", "CollectParcel",
                    "MobileShop"};

            ListAdapter myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
            ListView thelistview= (ListView)findViewById(R.id.listview);
            thelistview= (ListView)findViewById(R.id.listview);
            thelistview.setAdapter(myadapter);
            thelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    String tvshow = "YouSelected" + String.valueOf(adapterView.getItemAtPosition(position));
                    Toast.makeText(MainActivity.this, tvshow, Toast.LENGTH_SHORT).show();

                }
            });
        }


    @Override
    public void onNavigationDrawerItemSelected(int position) {
        Fragment myFragment=null;

        switch (position){
            case 0:
                myFragment=new First_Fragment();
                break;
            case 1:
                myFragment=new Second_Fragment();
                break;
            case 2:
                myFragment=new Third_Fragment();
                break;
        }
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, myFragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
    //Button btshow;
    //public ListView thelistview;
    @Override
   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        btshow = (Button) findViewById(R.id.button);
        btshow.setOnClickListener(new View.OnClickListener()
        {
            public  void onClick(View v){
                Intent i= new Intent(MainActivity.this,AddTask.class);
                startActivity(i);
            }
        });*/


        // final ListView listview = (ListView) findViewById(R.id.listview);
        String[] values = new String[]{"Grocery shopping", "Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Grocery shopping","Visit ATM", "pickUpLaundry",
                "Visit frnd", "CollectParcel",
                "MobileShop"};

        ListAdapter myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        ListView thelistview= (ListView)findViewById(R.id.listview);
        thelistview= (ListView)findViewById(R.id.listview);
        thelistview.setAdapter(myadapter);
        thelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String tvshow = "YouSelected" + String.valueOf(adapterView.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, tvshow, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
