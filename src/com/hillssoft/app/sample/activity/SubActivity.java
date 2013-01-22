package com.hillssoft.app.sample.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.hillssoft.app.R;
import com.hillssoft.framework.base.BaseActivity;

public class SubActivity extends BaseActivity {
	
	TextView txt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			
	}

	protected void initializeView(){
		setContentView(R.layout.sample_activity_sub_activity);	
		
		txt1 = (TextView)findViewById(R.id.txt1);
		txt1.setText(Integer.toString(PackageManager.GET_CONFIGURATIONS));
		
	}


}
