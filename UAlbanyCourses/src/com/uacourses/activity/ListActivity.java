package com.uacourses.activity;

import java.util.Iterator;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListActivity extends UACoursesActivity {
	
	//EditText courseName = (EditText)findViewById(R.id.courseName);
	
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		String major = getIntent().getExtras().getString("major");
		String year = getIntent().getExtras().getString("year");
		String semester = getIntent().getExtras().getString("semester");
		String minor = getIntent().getExtras().getString("minor");
		String[] courses;
		LinearLayout layout = (LinearLayout)findViewById(R.id.textViewAsList);
		if(major.equalsIgnoreCase("Computer Science") && year.equalsIgnoreCase("")
				&& semester.equalsIgnoreCase("") && minor.equalsIgnoreCase("")) {
			courses = new String[] {"Software engineering","Databases"};
		}
		else if(major.equalsIgnoreCase("Computer Science") && year.equalsIgnoreCase("2014")
				&& semester.equalsIgnoreCase("spring") && minor.equalsIgnoreCase("")) {
			courses = new String[] {"Software engineering","Databases",};
		}
		else if(major.equalsIgnoreCase("Computer Science") && year.equalsIgnoreCase("2014")
				&& semester.equalsIgnoreCase("spring") && minor.equalsIgnoreCase("painting")) {
			courses = new String[] {"Software engineering","Databases","Painting"};
		}
		else if(major.equalsIgnoreCase("Computer Science") && year.equalsIgnoreCase("2014")
				&& semester.equalsIgnoreCase("spring") && minor.equalsIgnoreCase("Music")) {
			courses = new String[] {"Software engineering","Databases","Music"};
		}
		else if(major.equalsIgnoreCase("") && !year.equalsIgnoreCase("")
				&& semester.equalsIgnoreCase("") && minor.equalsIgnoreCase("Painting")) {
			courses = new String[] {"Painting"};
		}
		else if(major.equalsIgnoreCase("") && year.equalsIgnoreCase("2014")
				&& semester.equalsIgnoreCase("spring") && minor.equalsIgnoreCase("painting")) {
			courses = new String[] {"Painting"};
		}
		else if(major.equalsIgnoreCase("") && year.equalsIgnoreCase("2014")
				&& semester.equalsIgnoreCase("spring") && minor.equalsIgnoreCase("Music")) {
			courses = new String[] {"Music"};
		}
		else 
		{
			courses = new String[] {"Software engineering","Databases","Music","Painting"};
		}
		
		
		TextView[] texts = new TextView[courses.length];
		TextView textView; 

		for (int i = 0; i < texts.length; i++) 
		{
			textView = new TextView(this);
			textView.setText(courses[i]);
			texts[i] = textView;
			texts[i].setBackgroundColor(Color.parseColor("#67587666"));
			texts[i].setTextColor(Color.parseColor("#F7FE2E"));
			texts[i].setClickable(true);
			layout.addView(texts[i]);
		}
		
		
	}
		  
	}	


