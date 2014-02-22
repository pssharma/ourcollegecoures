package com.uacourses.activity;

import com.uacourses.activity.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends UACoursesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addLoginButton();
    }


   
    
    private void addLoginButton() {
    	
    	
    	Button saveBtn = (Button)findViewById(R.id.login);
    	saveBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText username = (EditText)findViewById(R.id.username);
		    	EditText password = (EditText)findViewById(R.id.password);
				if(username.getText().toString().equals("UAlbany") && password.getText().toString().equals("UAlbany456"))
		    	{
		    		Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
		    		startActivity(intent);
		    	} else {
		    		Toast toast = Toast.makeText(getApplicationContext(), "Invalid username/ password!!!",
		    						Toast.LENGTH_SHORT);
		    		toast.setGravity(Gravity.CENTER, 0, 0);
		    		toast.show();
		    	}
			}
		});
    	
    }
    
}
