package com.hillssoft.app.mtom.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hillssoft.app.R;
import com.hillssoft.app.mtom.manager.AppNotificationCenterManager;
import com.hillssoft.app.mtom.manager.BaseActivityManager;
import com.hillssoft.app.mtom.manager.ContactManager;

public class SplashActivity extends BaseActivityManager {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		
	}
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_splash_activity);
		
	}
	
	
	private synchronized void initApp(){
		
	}
	
	
}
