package com.example.preferences;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PreferenceDemoActivity extends Activity {
		TextView textView;
		@Override
		public void onCreate(Bundle savedInstanceState) {
		   super.onCreate(savedInstanceState);
		   setContentView(R.layout.activity_main);
	
		   Button storeinformation = (Button) findViewById(R.id.storeinformation);
		   Button showinformation = (Button) findViewById(R.id.showinformation);
		   textView = (TextView) findViewById(R.id.txtPrefs);
		   
		   View.OnClickListener listener = new View.OnClickListener() {
		   @Override
		   public void onClick(View v) {
		   switch (v.getId()) {
		    case R.id.storeinformation:
	        Intent intent = new Intent(PreferenceDemoActivity.this,PrefsActivity.class);
	        startActivity(intent);
  	       break;
		   case R.id.showinformation:
		      displaySharedPreferences();
		      break;
		   default:
     	     break;
    	   }
		   }
		   };
		   storeinformation.setOnClickListener(listener);
		   showinformation.setOnClickListener(listener);
		}
 

		private void displaySharedPreferences() {
		   SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(PreferenceDemoActivity.this);
		   String username = prefs.getString("username", "Default NickName");
		   String passw = prefs.getString("password", "Default Password");
		   boolean checkBox = prefs.getBoolean("checkBox", false);
		   String listPrefs = prefs.getString("listpref", "Default list prefs");

		 
    	   StringBuilder builder = new StringBuilder();
		   builder.append("Username: " + username + "\n");
		   builder.append("Password: " + passw + "\n");
		   builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
		   builder.append("List preference: " + listPrefs);
		   textView.setText(builder.toString());
	
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
