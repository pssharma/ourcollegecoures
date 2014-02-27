package com.uacourses.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends UACoursesActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
	}

	public void submitButton(View v)
	{
		Intent intent = new Intent(getApplicationContext(), ListActivity.class);
		String major = ((EditText)findViewById(R.id.major)).getText().toString();
		String year = ((EditText)findViewById(R.id.year)).getText().toString();
		String semester = ((EditText)findViewById(R.id.semester)).getText().toString();
		String minor = ((EditText)findViewById(R.id.minor)).getText().toString();
		
		intent.putExtra("major", major);
		intent.putExtra("year", year);
		intent.putExtra("semester", semester);
		intent.putExtra("minor", minor);
		
		startActivity(intent);
	}
	
	public void logout(View v)
    {
    	Button logout = (Button)findViewById(R.id.logout);
		logout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sprefs = getSharedPreferences(LoginActivity.FILE, Context.MODE_PRIVATE);
		    	Editor editor = sprefs.edit();
		    	editor.clear();
		    	editor.commit();
		    	Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
		    	startActivity(intent);
				
			}
		});
    	
    }
	
}
