package com.hillssoft.framework.manager;

import android.os.Bundle;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.framework.base.BaseActivity;

public class BaseActivityManager extends BaseActivity {
	
	/*
	 * []
	 */
	protected AppManager appManager;
	protected AppGlobalApplication appGlobalApplication;
	
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
	}
	
	protected void initializeAppCommonObject(){
		super.initializeAppCommonObject();
		appManager = AppManager.getInstance(self);
		appGlobalApplication = (AppGlobalApplication)getApplicationContext();
		
	}
	
	
	
	
	
	
}
