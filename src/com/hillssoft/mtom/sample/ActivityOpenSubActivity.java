package com.hillssoft.mtom.sample;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import base.BaseActivity;

import com.hillssoft.mtom.R;

public class ActivityOpenSubActivity extends BaseActivity {
	
	TextView txt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_activity_open_sub);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sample_activity_open_sub, menu);
		return true;
	}
	
	protected void initializeView(){
		txt1 = (TextView)findViewById(R.id.txt1);
		
		txt1.setText(Integer.toString(PackageManager.GET_CONFIGURATIONS));
		
	}
	
	protected void setInitializeViewEventListener(){
		
	}


}
