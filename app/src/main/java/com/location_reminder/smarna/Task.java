package com.location_reminder.smarna;
import java.util.ArrayList;

/**
 * Created by ng123 on 10/8/2015.
 */
public class Task {
    public String Name;
    public String Image;
    public ArrayList<String> task_option = new ArrayList<String>();

    public Task(String Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
