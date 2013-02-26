package com.hillssoft.app.sample.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.hillssoft.app.R;
import com.hillssoft.framework.manager.BaseActivityManager;

public class SubActivity extends BaseActivityManager {
	
	TextView txt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			
	}

	protected void initializeView(){
		super.initializeView();
		setContentView(R.layout.sample_activity_sub_activity);	
		
		txt1 = (TextView)findViewById(R.id.txt1);
		txt1.setText(Integer.toString(PackageManager.GET_CONFIGURATIONS));
		
	}
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		
	}

}
