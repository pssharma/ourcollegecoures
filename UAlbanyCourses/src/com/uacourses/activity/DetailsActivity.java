package com.uacourses.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.uacourses.internet.ServletTask;

public class DetailsActivity extends UACoursesActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		
		String courseNameFrmIntent = getIntent().getExtras().getString("courseName");
		if(courseNameFrmIntent == null)
			courseNameFrmIntent = "";
		
		EditText courseNo = (EditText)findViewById(R.id.courseNo);
		EditText courseName = (EditText)findViewById(R.id.courseName);
		EditText semester = (EditText)findViewById(R.id.semester);
		EditText instructor = (EditText)findViewById(R.id.instructor);
		String[] profs = {"Prof. M. Chen","Prof. Jeong","Prof. Xavier","Prof. F. Jackman"};
		SpannableString content;
		
		
		EditText timings = (EditText)findViewById(R.id.timings);
		EditText location = (EditText)findViewById(R.id.location);
		EditText description = (EditText)findViewById(R.id.description);
		
		if(courseNameFrmIntent.equalsIgnoreCase("Software engineering")) {		//THIS IS A MAJOR COURSE
		courseNo.setText("12345");
		courseName.setText("SE");
		semester.setText("Spring");
		content = new SpannableString(profs[0]);
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		instructor.setText(content);
		timings.setText("11.45a - 1.00p");
		location.setText("LC 3B");
		description.setText("Software Engineering: This course helps students in studying the in " +
							"and out of software development");
		} else if (courseNameFrmIntent.equalsIgnoreCase("Databases")) {		//THIS IS A MAJOR COURSE
			courseNo.setText("34567");
			courseName.setText("Databases");
			semester.setText("Spring");
			content = new SpannableString(profs[1]);
			content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
			instructor.setText(content);
			timings.setText("8.45a - 10.00a");
			location.setText("LC 21");
			description.setText("Databases: This course helps students in studying the in " +
								"and out of DBMS");
		} else if (courseNameFrmIntent.equalsIgnoreCase("Music")) {			//THIS IS A MINOR COURSE
			courseNo.setText("77456");
			courseName.setText("Music");
			semester.setText("Spring");
			content = new SpannableString(profs[2]);
			content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
			instructor.setText(content);
			timings.setText("2.35p - 3.35p");
			location.setText("LC 5");
			description.setText("Music: This course helps students in studying the in " +
								"and out of Music");
		} else if (courseNameFrmIntent.equalsIgnoreCase("Painting")) {		//THIS IS A MINOR COURSE
			courseNo.setText("77457");
			courseName.setText("Painting");
			semester.setText("Spring");
			content = new SpannableString(profs[3]);
			content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
			instructor.setText(content);
			timings.setText("4.35p - 5.35p");
			location.setText("LC 6");
			description.setText("Painting: This course helps students in studying the in " +
								"and out of painting");
		}
		
		
		
		TextView rateMyProfTxtAsLink = (TextView)findViewById(R.id.rateMyProf);
		rateMyProfTxtAsLink.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), RateProfessorActivity.class);
				startActivity(intent);
			}
		});
		
		
		logout();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}
	

    public void logout()
    {
    	Button logout = (Button)findViewById(R.id.logoutDetailsPage);
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
    
    private final String URL = "http://192.168.1.103:8080/UAlbany_Courses/PostBlogServlet";
    
    public void saveBlog(View v)
    {
    	String blogSpot = ((EditText)findViewById(R.id.blogSpot)).getText().toString();
    	SharedPreferences sprefs = getSharedPreferences(LoginActivity.FILE, Context.MODE_PRIVATE);
    	String username = sprefs.getString("username", "");
    	
    	ServletTask task = new ServletTask();
    	task.setBlogSpot(blogSpot);
    	task.setUsername(username);
    	
    	Toast toast = Toast.makeText(v.getContext(), "Save Successful",
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
		
		task.execute(new String[] {URL});
    }
    
    public void viewBlogs(View v) 
    {
    	/*Uri uriUrl = Uri.parse("http://192.168.1.103:8080/UAlbany_Courses/blogs.jsp");
    	Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
    	startActivity(launchBrowser);*/
    	Intent intent = new Intent(v.getContext(), BlogsActivity.class);
		startActivity(intent);
    }
    
    

}
