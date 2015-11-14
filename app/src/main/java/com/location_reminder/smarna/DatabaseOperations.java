package com.location_reminder.smarna;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10-10-2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version=1;
    public  String CREATE_QUERY="CREATE TABLE "+ TableData.TableInfo.Table_Name +" ( "+ TableData.TableInfo.Taskname+" TEXT,"
            + TableData.TableInfo.Location+" TEXT,"+ TableData.TableInfo.Task_Date+" DATE,"+ TableData.TableInfo.Task_Time+" TIME );";
    public String CREATE_SettingsQuery;
    ParseUser currentUser=ParseUser.getCurrentUser();

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_Name, null, database_version);
        Log.d("Database operation","database created"+ CREATE_QUERY);
    }
    public DatabaseOperations(Context context,String Username) {
        super(context, TableData.TableInfo.DATABASE_Name, null, database_version);
        CREATE_QUERY="CREATE TABLE "+ TableData.TableInfo.Table_Name+Username +" ( "+ TableData.TableInfo.Taskname+" TEXT,"
                + TableData.TableInfo.Location+" TEXT,"+ TableData.TableInfo.Task_Date+" DATE,"+ TableData.TableInfo.Task_Time+" TIME )";
        CREATE_SettingsQuery="CREATE TABLE "+Username+"Settings"+" ( "+"Notifiy_Freq INTEGER, Notify_Radius INTEGER )";
        //db.execSQL(CREATE_SettingsQuery);
        Log.i("Query",CREATE_SettingsQuery);
        Log.d("Database operation", "database created" + CREATE_QUERY);

    }


    public void onCreate(SQLiteDatabase db,String Username) {

        db.execSQL(CREATE_QUERY);
        db.execSQL(CREATE_SettingsQuery);
        Log.d("Database operation", "table created");

    }


    public void onCreate(SQLiteDatabase db ) {
        String strUser=currentUser.getUsername().toString();
        Log.i("usernme",strUser);
        CREATE_QUERY="CREATE TABLE "+ TableData.TableInfo.Table_Name+strUser +" ( "+ TableData.TableInfo.Taskname+" TEXT,"
                + TableData.TableInfo.Location+" TEXT,"+ TableData.TableInfo.Task_Date+" DATE,"+ TableData.TableInfo.Task_Time+" TIME )";
        CREATE_SettingsQuery="CREATE TABLE "+strUser+"Settings"+" ( "+"Notify_Freq INTEGER, Notify_Radius INTEGER )";
        db.execSQL(CREATE_QUERY);
        db.execSQL(CREATE_SettingsQuery);
        Log.i("Query", CREATE_SettingsQuery);

        Log.d("Database operation1", "table created");
    }



    public void putInformation(DatabaseOperations dop, TaskDetails taskDetails, String username)
    {
        SQLiteDatabase sq= dop.getWritableDatabase();

        //  String InsertQuery=" INSERT INTO "+TableData.TableInfo.Table_Name +" ("
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableInfo.Taskname, taskDetails.Taskname);
        cv.put(TableData.TableInfo.Location, taskDetails.Location);
        cv.put(TableData.TableInfo.Task_Date, taskDetails.Task_Date);
        cv.put(TableData.TableInfo.Task_Time, taskDetails.Task_Time);
        long k =sq.insert(TableData.TableInfo.Table_Name+username, null, cv);
        Log.d("Database operation", "database inserted");
        sq.close();
    }

    public void putSettingsInfo(DatabaseOperations dop, UserSettings settings, String username)
    {
        SQLiteDatabase sq= dop.getWritableDatabase();

        //  String InsertQuery=" INSERT INTO "+TableData.TableInfo.Table_Name +" ("
        ContentValues cv= new ContentValues();
        cv.put("Notify_Freq", settings.NotificationFreq);
        cv.put("Notify_Radius", settings.NotificationRadius);

        long k =sq.insert(username+"Settings", null, cv);
        Log.d("Database operation", "database inserted");
        sq.close();
    }

    public void deleteInformation(DatabaseOperations dop, String taskname, String username)
    {
        SQLiteDatabase sq= dop.getWritableDatabase();
        sq.delete(TableData.TableInfo.Table_Name + username, "taskName = '" + taskname + "'", null);
        sq.close();
    }

    public void updateInformation(DatabaseOperations dop, TaskDetails taskDetails, String username)
    {

        SQLiteDatabase sq= dop.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableInfo.Location, taskDetails.Location);
        cv.put(TableData.TableInfo.Task_Date, taskDetails.Task_Date);
        cv.put(TableData.TableInfo.Task_Time, taskDetails.Task_Time);
        long k =sq.update(TableData.TableInfo.Table_Name+username, cv,TableData.TableInfo.Taskname+" = '"+taskDetails.Taskname+"'",null);

        sq.close();
    }

    public List<TaskDetails> getInformation(DatabaseOperations dop, String username)
    {
        List<TaskDetails> TaskList = new ArrayList<TaskDetails>();
        TaskDetails taskDetails= new TaskDetails();
        SQLiteDatabase sq= dop.getReadableDatabase();
        ContentValues cv= new ContentValues();
        Cursor allrows= sq.rawQuery("SELECT * FROM " + TableData.TableInfo.Table_Name+ username, null);
        System.out.println("COUNT : " + allrows.getCount());
        while(allrows.moveToNext())
        {
            taskDetails= new TaskDetails();
            taskDetails.Taskname=allrows.getString(0);
            taskDetails.Location=allrows.getString(1);
            taskDetails.Task_Date=allrows.getString(2);
            taskDetails.Task_Time=allrows.getString(3);
            TaskList.add(taskDetails);
            Log.i("taskdetails", "taskname" + taskDetails.Taskname);
        }
        allrows.close();
        Log.i("final list", TaskList.toString());
        sq.close();
        return TaskList;
    }

    public UserSettings getUserSettings(DatabaseOperations dop, String username)
    {

        List<TaskDetails> TaskList = new ArrayList<TaskDetails>();
        String NotificationFreq,NotificationRad;
        UserSettings settings= new UserSettings();
        SQLiteDatabase sq= dop.getReadableDatabase();
        ContentValues cv= new ContentValues();
        Cursor allrows= sq.rawQuery("SELECT * FROM "+ username+"Settings", null);
        System.out.println("COUNT : " + allrows.getCount());
        while(allrows.moveToNext())
        {
            //  taskDetails= new TaskDetails();
            settings.NotificationFreq=allrows.getInt(0);
            settings.NotificationRadius=allrows.getInt(1);

            Log.i("Freq",settings.NotificationFreq.toString());
        }
        allrows.close();
        Log.i("final list", TaskList.toString());
        sq.close();

        return settings;
    }


    public TaskDetails getTask(DatabaseOperations dop, String taskName, String username)
    {
        List<TaskDetails> TaskList = new ArrayList<TaskDetails>();
        TaskDetails taskDetails= new TaskDetails();
        SQLiteDatabase sq= dop.getReadableDatabase();
        ContentValues cv= new ContentValues();
        Cursor allrows= sq.rawQuery("SELECT * FROM " + TableData.TableInfo.Table_Name+username +" WHERE "+ TableData.TableInfo.Taskname+" = '"+ taskName +"'", null);
        allrows.moveToNext();
        taskDetails= new TaskDetails();
        taskDetails.Taskname=allrows.getString(0);
        taskDetails.Location=allrows.getString(1);
        taskDetails.Task_Date=allrows.getString(2);
        taskDetails.Task_Time=allrows.getString(3);
        allrows.close();
        sq.close();
        return taskDetails;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createUserTable(DatabaseOperations db, String username) {

        SQLiteDatabase sq= db.getWritableDatabase();
        CREATE_QUERY="CREATE TABLE "+ TableData.TableInfo.Table_Name+username +" ( "+ TableData.TableInfo.Taskname+" TEXT,"
                + TableData.TableInfo.Location+" TEXT,"+ TableData.TableInfo.Task_Date+" DATE,"+ TableData.TableInfo.Task_Time+" TIME )";
        CREATE_SettingsQuery="CREATE TABLE "+username+"Settings"+" ( "+"Notify_Freq INTEGER, Notify_Radius INTEGER )";
        sq.execSQL(CREATE_QUERY);
        sq.execSQL(CREATE_SettingsQuery);
        sq.close();
    }
}
