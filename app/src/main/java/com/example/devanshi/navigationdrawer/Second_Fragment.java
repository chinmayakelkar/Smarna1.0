package com.example.devanshi.navigationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Devanshi on 10/3/2015.
 */
public class Second_Fragment extends Fragment {
    View myView;
    @Override
    @Nullable

    public View onCreateView (LayoutInflater inflater,ViewGroup container, Bundle savedInstateState){
        myView=inflater.inflate(R.layout.second_layout,container,false);
        return myView;
    }
}
