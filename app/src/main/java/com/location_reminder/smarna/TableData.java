package com.location_reminder.smarna;

import android.provider.BaseColumns;

import java.util.Date;

/**
 * Created by Admin on 10-10-2015.
 */
public class TableData {

    public TableData()
    {}

    public static abstract  class  TableInfo implements BaseColumns
    {
        public  static final String Taskname="taskName";
        public static final String  Location="location";
        public static final String Task_Date= "taskDate";
        public static final String  Task_Time="task_time";
        public  static  final String DATABASE_Name="user_Info";
        public static final String Table_Name="Task_info1";


    }
}
