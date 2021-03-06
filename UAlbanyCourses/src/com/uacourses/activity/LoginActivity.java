package com.uacourses.activity;

import com.uacourses.activity.R;
import com.uacourses.beans.LoginInfo;
import com.uacourses.database.SQLiteJDBC;
import com.uacourses.database.Select;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends UACoursesActivity {
	
	
	public static final String FILE = "Login.txt";
    private SharedPreferences sprefs;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.d("notify", "on create");
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_login);
        sprefs = getSharedPreferences(FILE, Context.MODE_PRIVATE);
    	if(sprefs.contains("username"))
		{
    		gotoDetails();
		} else {
			
			
			addLoginButton();
		}
    }

    
    private void addLoginButton() {
    	
    	
    	Button loginBtn = (Button)findViewById(R.id.login);
    	loginBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				EditText username = (EditText)findViewById(R.id.username);
		    	EditText password = (EditText)findViewById(R.id.password);
		    	LoginActivity.this.username = username.getText().toString();
		    	LoginActivity.this.password = password.getText().toString();
		    	
		    	LoginInfo loginInfo = null;
		    	
		    	//loginInfo = Select.getLoginInfo(LoginActivity.this.username, LoginActivity.this.password);
		    	
		    	if(!(LoginActivity.this.username.equals("") || LoginActivity.this.password.equals("")))
		    	{
		    		SQLiteJDBC db = new SQLiteJDBC(v.getContext());
		    		loginInfo = db.getLoginInfo(LoginActivity.this.username, LoginActivity.this.password);
		    	}
		    	
		    	if(LoginActivity.this.username.equals("UAlbany") && LoginActivity.this.password.equals("UAlbany456"))
		    	{
		    		saveDataInPrefs(LoginActivity.this.username, LoginActivity.this.password);
					gotoDetails();
		    		
		    	} 
		    	else if(loginInfo != null)
		    	{
		    		saveDataInPrefs(loginInfo.getUsername(), loginInfo.getEmail());
					gotoDetails();
		    		
		    	}
		    	else {
		    		Toast toast = Toast.makeText(getApplicationContext(), "Invalid username/ password!!!",
		    						Toast.LENGTH_SHORT);
		    		toast.setGravity(Gravity.CENTER, 0, 0);
		    		toast.show();
		    	}
			}
		});
    	
    }
    
    public void gotoDetails()
    {
    	Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
		startActivity(intent);
    }
    
    public void saveDataInPrefs(String username, String email)
    {
    	Editor editor = sprefs.edit();
    	editor.putString("username", username);
    	editor.putString("email", email);
    	editor.commit();
    	
    }
    
    
}
