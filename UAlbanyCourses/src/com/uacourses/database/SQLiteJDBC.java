package com.uacourses.database;

import java.sql.*;

import com.uacourses.beans.LoginInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
public class SQLiteJDBC extends SQLiteOpenHelper{

	public SQLiteJDBC(Context context) {
		super(context, "ualbanydb", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		Log.d("notify", "creating tables");
		
		/*String  courses= "CREATE TABLE COURSES "+"(COURSEID CHAR(16) NOT NULL,"+
	    		  "COURSENAME CHAR(16) NOT NULL,"+"INSTRUCTOR CHAR(16),"+
	    		  "CLASSTIME CHAR(26),"+" CLASSLOCATION CHAR(26),"+" SEMESTER CHAR(16), "+
	    		  " PRIMARY KEY(COURSEID))";
		String majors = "CREATE TABLE MAJORS " +
                "(MAJOR CHAR(16) NOT NULL," +
                " COURSEID CHAR(16) NOT NULL," +
                " DEPARTMENT CHAR(26),"+" PRIMARY KEY(MAJOR,COURSEID),"+"FOREIGN KEY(COURSEID) REFERENCES COURSES(COURSEID))"; 
		 String Instructors = "CREATE TABLE INSTRUCTORS " +
                 "(INSTRUCTORID CHAR(6) PRIMARY KEY," +
                 " INSTRUCTORNAME CHAR(16) NOT NULL," +
                 " COURSEID CHAR(16),"+"COURSENAME CHAR(16),"+"FOREIGN KEY(INSTRUCTORNAME) REFERENCES COURSES(INSTRUCTOR))";*/ 
		 String login = "CREATE TABLE LOGININFO " +
                 "(USERID INTEGER PRIMARY KEY AUTOINCREMENT," +
                 "USERNAME TEXT," +
                 " PASSWORD TEXT," +
                 " EMAIL TEXT)";
		 
		
		try{
		/*db.execSQL(courses);
		db.execSQL(majors);
		db.execSQL(Instructors);*/
		db.execSQL(login);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("could not create tables");
		}
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	
	public LoginInfo getLoginInfo(String username, String password)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues vals = new ContentValues();
		vals.put("username","test");
		vals.put("password", "test123");
		vals.put("email", "test@email.com");
		db.insert("LOGININFO", null, vals);
		
		LoginInfo logininfo = null;
		
		Cursor cur = db.query("LOGININFO", new String[]{"USERID","USERNAME","PASSWORD","EMAIL"}, "USERNAME = ?", new String[] {String.valueOf(username)}, null, null, null);
		
		if(cur != null)
			cur.moveToFirst();
		
		
		if(password != null && password.equals(cur.getString(2)))
		{
			logininfo = new LoginInfo();
			logininfo.setUserid(cur.getInt(0));
			logininfo.setUsername(cur.getString(1));
			logininfo.setEmail(cur.getString(3));
		}
		
		db.close();
		return logininfo;
	}

}

