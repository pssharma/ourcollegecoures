package com.uacourses.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class ViewProfReviewsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_prof_reviews);
		
		WebView profReviewsWebView = (WebView)findViewById(R.id.profReviewsWebView);
		profReviewsWebView.loadUrl("http://192.168.1.103:8080/UAlbany_Courses/professorreviews.jsp");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_prof_reviews, menu);
		return true;
	}

}
