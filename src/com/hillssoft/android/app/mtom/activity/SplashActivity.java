package com.hillssoft.android.app.mtom.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.AppNotificationCenterManager;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.app.mtom.manager.LoggerManager;
import com.hillssoft.android.app.mtom.manager.SharedPreferenceManager;

public class SplashActivity extends BaseActivityManager {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bindAppNotificationCenterEvent();
		initializeApplication();
	}
	
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_splash_activity);		
	}
	

	
	private void initializeApplication(){
		try{
			synchronized(this){
				if(appManager.isAppInitializeCompleted()){
					initializeApplicationStartup();
				}else{
					initializeApplicationDefaultDbData();
					initializeApplicationDefaultUserData();
					initializeApplicationStartup();
				}
			}

		}catch(Exception e){
			LoggerManager.e(e.toString());
		}
	}
	
	
	private synchronized void initializeApplicationDefaultDbData(){
		if(!defaultAppSharedPreference.getBoolean(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_DATA, false)){
			/*
			 * [ DB Execute ]
			 */
			defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_DATA, true);
		}
	}
	
	private synchronized void initializeApplicationDefaultUserData(){
		if(!defaultAppSharedPreference.getBoolean(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA, false)){
			defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA, true);
		}
	}
	
	
	private synchronized void initializeApplicationStartup(){
		if(defaultAppSharedPreference.getBoolean(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_COMPLETED, false)){
			AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.ACTIVITY_SPLASH_NOTIFICATION_EVENT_REDIRECT_MAIN);
		}else{
			AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.ACTIVITY_SPLASH_NOTIFICATION_EVENT_MEMBER_REGISTER);
		}
	}
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	private void bindAppNotificationCenterEvent(){
		
		/**
		 * [ Register Event for application install ]
		 */
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.ACTIVITY_SPLASH_NOTIFICATION_EVENT_REDIRECT_MAIN, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		defaultApplicationHandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						if(self != null){
							//startActivity(IntentManager.getMainIntent(self));
							//finish();
		        		}
					}
				}, 500);
        	}
        });
		
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.ACTIVITY_SPLASH_NOTIFICATION_EVENT_MEMBER_REGISTER, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		defaultApplicationHandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						if(self != null){
							//startActivity(IntentManager.getAuthMemberRegister(self));
							//finish();
		        		}
					}
				}, 500);
        	}
        });
		


	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
