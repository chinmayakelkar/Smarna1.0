package com.location_reminder.smarna;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10-10-2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version=1;
    public  String CREATE_QUERY="CREATE TABLE "+ TableData.TableInfo.Table_Name+" ( "+ TableData.TableInfo.Taskname+" TEXT,"
    + TableData.TableInfo.Location+" TEXT,"+ TableData.TableInfo.Task_Date+" DATE,"+ TableData.TableInfo.Task_Time+" TIME );";

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_Name, null, database_version);
        Log.d("Database operation","database created"+ CREATE_QUERY);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operation", "table created");

    }

    public void putInformation(DatabaseOperations dop,TaskDetails taskDetails)
    {


        SQLiteDatabase sq= dop.getWritableDatabase();

      //  String InsertQuery=" INSERT INTO "+TableData.TableInfo.Table_Name +" ("
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableInfo.Taskname,taskDetails.Taskname);
        cv.put(TableData.TableInfo.Location, taskDetails.Location);
        cv.put(TableData.TableInfo.Task_Date, taskDetails.Task_Date);
        cv.put(TableData.TableInfo.Task_Time, taskDetails.Task_Time);
        long k =sq.insert(TableData.TableInfo.Table_Name, null, cv);
        Log.d("Database operation", "database inserted");

    }

    public void deleteInformation(DatabaseOperations dop,String taskname)
    {
        SQLiteDatabase sq= dop.getWritableDatabase();
        sq.delete(TableData.TableInfo.Table_Name,"taskName = '"+taskname+"'",null);


    }

    public void updateInformation(DatabaseOperations dop,TaskDetails taskDetails)
    {

        SQLiteDatabase sq= dop.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(TableData.TableInfo.Location, taskDetails.Location);
        cv.put(TableData.TableInfo.Task_Date, taskDetails.Task_Date);
        cv.put(TableData.TableInfo.Task_Time, taskDetails.Task_Time);
        long k =sq.update(TableData.TableInfo.Table_Name, cv,TableData.TableInfo.Taskname+" = '"+taskDetails.Taskname+"'",null);


    }

    public List<TaskDetails> getInformation(DatabaseOperations dop)
    {
        List<TaskDetails> TaskList = new ArrayList<TaskDetails>();
        TaskDetails taskDetails= new TaskDetails();
        SQLiteDatabase sq= dop.getReadableDatabase();
        ContentValues cv= new ContentValues();
       Cursor allrows= sq.rawQuery("SELECT * FROM " + TableData.TableInfo.Table_Name, null);
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
        return TaskList;
    }

    public TaskDetails getTask(DatabaseOperations dop,String taskName)
    {
        List<TaskDetails> TaskList = new ArrayList<TaskDetails>();
        TaskDetails taskDetails= new TaskDetails();
        SQLiteDatabase sq= dop.getReadableDatabase();
        ContentValues cv= new ContentValues();
        Cursor allrows= sq.rawQuery("SELECT * FROM " + TableData.TableInfo.Table_Name +" WHERE "+ TableData.TableInfo.Taskname+" = '"+ taskName +"'", null);
        allrows.moveToNext();
        taskDetails= new TaskDetails();
        taskDetails.Taskname=allrows.getString(0);
        taskDetails.Location=allrows.getString(1);
        taskDetails.Task_Date=allrows.getString(2);
        taskDetails.Task_Time=allrows.getString(3);
        allrows.close();
        return taskDetails;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
