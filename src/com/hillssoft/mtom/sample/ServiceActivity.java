package com.hillssoft.mtom.sample;

import com.hillssoft.mtom.R;
import com.hillssoft.mtom.R.layout;
import com.hillssoft.mtom.R.menu;

import android.os.Bundle;
import android.view.Menu;
import base.BaseActivity;

public class ServiceActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_service);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sample_service, menu);
		return true;
	}

}
