package com.hillssoft.mtom.sample;

import android.os.Bundle;
import android.view.Menu;
import base.BaseActivity;

import com.hillssoft.mtom.R;

public class ListViewActivity extends BaseActivity {

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sample_list_view, menu);
		return true;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_list_view);
		
		initializeView();
		setEventListener();
	}

	
	private void initializeView(){

	}
	
	private void setEventListener(){

	}

}
