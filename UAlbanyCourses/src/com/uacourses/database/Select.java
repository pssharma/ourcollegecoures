package com.uacourses.database;


import java.sql.*;

import com.uacourses.beans.LoginInfo;
public class Select {

	/**
	 * @param args
	 */
	
	private static Connection c = null;
    private static PreparedStatement stmt = null;
	
	public static LoginInfo getLoginInfo(String username, String password)
	{
		LoginInfo loginInfo = null;
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      String sqlQuery = "SELECT * FROM LOGININFO WHERE USERNAME = ? AND PASSWORD = ?";
		      stmt = c.prepareStatement(sqlQuery);
		      stmt.setString(1, username);
		      stmt.setString(2, password);		      
		      ResultSet rs = stmt.executeQuery();
		      
		      
		      while ( rs.next() ) {
		    	 String usernameFromDb = rs.getString("USERNAME");
		    	 String passwordFromDb  = rs.getString("PASSWORD");
		    	 String emailFromDb = rs.getString("EMAIL");
		    	  loginInfo = new LoginInfo();
			      loginInfo.setUsername(usernameFromDb);
			      loginInfo.setPassword(passwordFromDb);
			      loginInfo.setEmail(emailFromDb);
		         }
		      
		      
		}
		catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
		
		return loginInfo;
	}
	
	/*public static void main(String[] args) {
		 Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM MAJORS;" );
		      while ( rs.next() ) {
		    	 String major = rs.getString("MAJOR");
		    	 String courseID  = rs.getString("COURSEID");
		    	 String department = rs.getString("DEPARTMENT");
		         
		    	 System.out.println( "MAJOR = " + major );
		         System.out.println( "COURSEID = " + courseID );
		         System.out.println( "DEPARTMENT = " + department );
		         System.out.println();}
		         
		         rs = stmt.executeQuery( "SELECT * FROM COURSES;" );
			      while ( rs.next() ) {
			    	 String courseID  = rs.getString("COURSEID");
			    	 String courseName = rs.getString("COURSENAME");
			    	 String instructor = rs.getString("INSTRUCTOR");
			    	 String classLocation =rs.getString("CLASSLOCATION");
			         String classTime = rs.getString("CLASSTIME");
			    	 System.out.println( "COURSEID = " + courseID );
			    	 System.out.println( "COURSENAME = " + courseName );
			         System.out.println( "INSTRUCTOR = " + instructor );
			         System.out.println( "CLASSTIME = " + classTime );
			         System.out.println( "CLASSLOCATION = " + classLocation );
		         System.out.println();
		      }
			      rs = stmt.executeQuery( "SELECT * FROM INSTRUCTORS;" );
			      while ( rs.next() ) {
			    	 String instructorID  = rs.getString("INSTRUCTORID");
			    	 String instructorName = rs.getString("INSTRUCTORNAME");
			    	 String courseName = rs.getString("COURSENAME");
			    	 String courseID = rs.getString("COURSEID");
			    	 System.out.println( "INSTRUCTORID = " + instructorID );
			         System.out.println( "INSTRUCTORNAME = " + instructorName );
			    	 System.out.println( "COURSEID = " + courseID );
			    	 System.out.println( "COURSENAME = " + courseName );
			         
			         
		         System.out.println();
		      }
		      rs.close();
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("Operation done successfully");
	}*/

}

