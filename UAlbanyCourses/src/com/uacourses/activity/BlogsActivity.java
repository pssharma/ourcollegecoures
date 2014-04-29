package com.uacourses.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;

public class BlogsActivity extends UACoursesActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blogs);
		 
		WebView blogsWebView = (WebView)findViewById(R.id.blogsWebView);
		blogsWebView.loadUrl("http://192.168.1.103:8080/UAlbany_Courses/blogs.jsp");
		
		
			}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blogs, menu);
		return true;
	}

}
