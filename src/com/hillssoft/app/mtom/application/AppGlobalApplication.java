package com.hillssoft.app.mtom.application;

import android.app.Application;

public class AppGlobalApplication extends Application {
	
	
	
	private static AppGlobalApplication instance = null;
	private boolean isInitializeApplication = false;
	
	
	
	/**
	 * [  ]
	 */
	public static final String APP_GLOBAL_APPLICATION_NOTIFICATION_INITIALIZE_COMPLETE = "AppGlobalApplication_NOTIFICATION_INITIALIZE_COMPLETE";
	public static final String NOTIFICATION_INSTALL_COMPLETE = "AppGlobalApplication_NOTIFICATION_INSTALL_COMPLETE";
	public static final String NOTIFICATION_LOGIN_COMPLETE = "AppGlobalApplication_NOTIFICATION_LOGIN_COMPLETE";
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		initializeApplication();
		
	}
	
	
	private void initializeApplication(){
		
	}
	
	
	
}
