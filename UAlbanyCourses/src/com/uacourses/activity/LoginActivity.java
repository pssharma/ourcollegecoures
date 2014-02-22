package com.uacourses.activity;

import com.example.homeandroid.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends UACoursesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addSaveButton();
    }


   
    
    private void addSaveButton() {
    	
    	Button saveBtn = (Button)findViewById(R.id.login);
    	saveBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
				alert.setMessage("Coding still in progress!!");
				alert.setCancelable(true);
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				alert.create().show();
			}
		});
    	
    }
    
}
