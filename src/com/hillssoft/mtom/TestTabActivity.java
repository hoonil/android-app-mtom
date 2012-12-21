package com.hillssoft.mtom;

import android.os.Bundle;
import android.view.Menu;
import base.BaseActivity;

public class TestTabActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_test_tab, menu);
		return true;
	}
	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
	}
	
	

	
	

}
