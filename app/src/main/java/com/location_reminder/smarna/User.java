package com.location_reminder.smarna;

/**
 * Created by Chinmaya on 03-Oct-15.
 */
public class User {
    String username,emailid,password;
    public User(String username,String emailid, String password){
        this.username=username;
        this.emailid=emailid;
        this.password=password;
    }
    public User(String emailid, String password)
    {
        this.emailid=emailid;
        this.password=password;
        this.username="";
    }
}
