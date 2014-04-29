package com.uacourses.activity;

import com.uacourses.internet.ServletTask;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class RateProfessorActivity extends UACoursesActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate_professor);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rate_professor, menu);
		return true;
	}
	
	private final String URL = "http://192.168.1.103:8080/UAlbany_Courses/PostProfessorReview";
	
	public void saveProfessorReview(View v)
	{
		RatingBar rtb = (RatingBar)findViewById(R.id.professorRating);
		float professorRating = rtb.getRating();
		
		EditText edTxt = (EditText)findViewById(R.id.review);
		String review = edTxt.getText().toString();
		
		EditText edTxtName = (EditText)findViewById(R.id.professorName);
		String professorName = edTxtName.getText().toString();
		
		EditText edTxtCourseName = (EditText)findViewById(R.id.courseName);
		String courseName = edTxtCourseName.getText().toString();
		
		ServletTask task = new ServletTask();
    	task.setReview(review);
    	task.setProfessorName(professorName);
    	task.setProfessorRating(professorRating);
    	task.setCourseName(courseName);
    	
    	Toast toast = Toast.makeText(v.getContext(), "Save Successful",
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
    	
		task.execute(new String[] {URL});
	}
	
	public void viewReviews(View v) 
    {
    	/*Uri uriUrl = Uri.parse("http://192.168.1.103:8080/UAlbany_Courses/professorreviews.jsp");
    	Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
    	startActivity(launchBrowser);*/
		Intent intent = new Intent(v.getContext(), ViewProfReviewsActivity.class);
		startActivity(intent);
    }
	
	public void logout(View v)
	{
		SharedPreferences sprefs = getSharedPreferences(LoginActivity.FILE, Context.MODE_PRIVATE);
    	Editor editor = sprefs.edit();
    	editor.clear();
    	editor.commit();
    	Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
    	startActivity(intent);
	}

}
