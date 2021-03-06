package com.hillssoft.android.app.mtom.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.android.gcm.GCMRegistrar;
import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.AppNotificationCenterManager;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.app.mtom.manager.IntentManager;
import com.hillssoft.android.app.mtom.manager.SharedPreferenceManager;
import com.hillssoft.android.framework.log.Logger;

public class SplashActivity extends BaseActivityManager {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//VMRuntime.getRuntime().setTargetHeapUtilization(0.85f);
		//VMRuntime.getRuntime().setTargetHeapUtilization(0.7f);
		//dalvik.system.VMRuntime.getRuntime().setTargetHeapUtilization(0.7f);
		
		super.onCreate(savedInstanceState);
		overridePendingTransition(0, 0);
		bindAppNotificationCenterEvent();
		initializeApplication();
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.gc();
	}
	
	@Override
	protected void initializeActionBar() {
		super.initializeActionBar();
		self.getSupportActionBar().hide();
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
			Logger.e(e.toString());
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
			//AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.ACTIVITY_SPLASH_NOTIFICATION_EVENT_REDIRECT_MAIN);
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
        		activityHandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						if(self != null){
							startActivity(IntentManager.getMainIntent(self));
							finish();
						}
					}
				}, 500);
        	}
        });
		
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.ACTIVITY_SPLASH_NOTIFICATION_EVENT_MEMBER_REGISTER, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		activityHandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						if(self != null){
							startActivity(IntentManager.getAuthMemberRegister(self));
							finish();
		        		}
					}
				}, 500);
        	}
        });
		


	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
