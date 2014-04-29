package com.uacourses.database;

import java.sql.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
public class SQLiteJDBC extends SQLiteOpenHelper{

	public SQLiteJDBC(Context context) {
		super(context, "ualbany.db", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		Log.d("notify", "creating tables");
		
		String  courses= "CREATE TABLE COURSES "+"(COURSEID CHAR(16) NOT NULL,"+
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
                 " COURSEID CHAR(16),"+"COURSENAME CHAR(16),"+"FOREIGN KEY(INSTRUCTORNAME) REFERENCES COURSES(INSTRUCTOR))"; 
		 String login = "CREATE TABLE LOGININFO " +
                 "(USERNAME CHAR(16) PRIMARY KEY," +
                 " PASSWORD CHAR(26) NOT NULL," +
                 " EMAIL CHAR(36))";
		 
		
		try{
		db.execSQL(courses);
		db.execSQL(majors);
		db.execSQL(Instructors);
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
	

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		     
		      System.out.println("Opened database successfully");
		      stmt = c.createStatement();
		      String  sql= "CREATE TABLE COURSES "+"(COURSEID CHAR(16) NOT NULL,"+
		    		  "COURSENAME CHAR(16) NOT NULL,"+"INSTRUCTOR CHAR(16),"+
		    		  "CLASSTIME CHAR(26),"+" CLASSLOCATION CHAR(26),"+" SEMESTER CHAR(16), "+
		    		  " PRIMARY KEY(COURSEID))";
		      stmt.executeUpdate(sql);
		     
		      sql = "CREATE TABLE MAJORS " +
		                   "(MAJOR CHAR(16) NOT NULL," +
		                   " COURSEID CHAR(16) NOT NULL," +
		                   " DEPARTMENT CHAR(26),"+" PRIMARY KEY(MAJOR,COURSEID),"+"FOREIGN KEY(COURSEID) REFERENCES COURSES(COURSEID))"; 
		      stmt.executeUpdate(sql);
		   
		      sql = "CREATE TABLE INSTRUCTORS " +
	                   "(INSTRUCTORID CHAR(6) PRIMARY KEY," +
	                   " INSTRUCTORNAME CHAR(16) NOT NULL," +
	                   " COURSEID CHAR(16),"+"COURSENAME CHAR(16),"+"FOREIGN KEY(INSTRUCTORNAME) REFERENCES COURSES(INSTRUCTOR))"; 
		      stmt.executeUpdate(sql);
		      
		      sql = "CREATE TABLE LOGININFO " +
	                   "(USERNAME CHAR(16) PRIMARY KEY," +
	                   " PASSWORD CHAR(26) NOT NULL," +
	                   " EMAIL CHAR(36))"; 
		      stmt.executeUpdate(sql);
		  
		      
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Table created successfully");
	}*/
	
	
	

}

