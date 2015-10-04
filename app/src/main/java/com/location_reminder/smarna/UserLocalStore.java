package com.location_reminder.smarna;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Chinmaya on 03-Oct-15.
 */
public class UserLocalStore {
    public static final String User_Creds="UserCreds";
    SharedPreferences userLocalDatabase;
    public UserLocalStore(Context context)
    {
        userLocalDatabase=context.getSharedPreferences(User_Creds,0);
    }
    public void StoreUserData(User user)
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putString("Emailid",user.emailid);
        spEditor.putString("password",user.password);
        spEditor.putString("username",user.username);
        spEditor.commit();
    }
    public User getLoggedInUser()
    {
        String username= userLocalDatabase.getString("username", "");
        String password=userLocalDatabase.getString("password","");
        String emailid=userLocalDatabase.getString("Emailid","");
        User storedUser= new User(username,emailid, password);
        return storedUser;
    }

    public void SetUserLoggedin(boolean loggedIn)
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }
    public void ClearUserData()
    {
        SharedPreferences.Editor spEditor=userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
    public boolean CheckUserLoggedIn()
    {
        if(userLocalDatabase.getBoolean("loggedIn",false)==true){
            return true;
        }
        else{
            return false;
        }
    }
}
