package com.hillssoft.framework.manager;

import java.util.Calendar;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.app.mtom.db.AppDBQuery;
import com.hillssoft.framework.base.BaseActivity;

public class BaseActivityManager extends BaseActivity {
	
	/*
	 * [ Define Default Object ]
	 */
	protected Activity 	self = null;
	protected AppManager appManager = null;
	protected UserManager userManager = null;
	protected AppGlobalApplication appGlobalApplication = null;
	protected SharedPreferenceManager defaultAppSharedPreference = null;
	protected Handler defaultApplicationHandler = null;
	protected HashMap<String, String> dbSqlParams = new HashMap<String, String>();
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		self = this;
		
		/**
		 * [ Common Object ]
		 */
		initializeBaseActivityManagerObject();
		
		/**
		 * [ View ]
		 */
		initializeView();
		setInitializeViewEventListener();

		/**
		 * [ Notification ]
		 */
		bindAppDefaultNotificationCenterEvent();
		
		/**
		 * [ Service ]
		 */
		initializeBindService();
		
		/**
		 * [ Broadcast Receiver ]
		 */
		initializeBindBroadcastReceiver();
		
		
	}
	
	protected void initializeBaseActivityManagerObject(){
		
		/*
		 * [ Set self object]
		 */
		self = this;
		
		/*
		 * [ Set object from AppGlobalApplication ]
		 */
		appGlobalApplication = (AppGlobalApplication)AppGlobalApplication.getAppGlobalApplicationContext();
		appGlobalApplication.setCurrentActivity(this);
		defaultApplicationHandler = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultHandler();
		defaultAppSharedPreference = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultSharedPreference();
		
		/*
		 * [ Set application configure object ]
		 */
		appManager = AppManager.getInstance();
		
		/*
		 * [ Set user info object]
		 */
		userManager = UserManager.getInstance();
		
	}
	
	protected void initializeView(){
		
	}
	
	protected void initializeView(int layoutResID){
		if(layoutResID < 0){
			setContentView(layoutResID);
		}
	}

	protected void setInitializeViewEventListener(){
		
	}

	protected void bindAppDefaultNotificationCenterEvent(){
		/**
		 * [ Register Event for application install ]
		 */
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_INITIALIZE_COMPLETE, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		LoggerManager.i("OK~~~~~~~ OK~~~~~~~~~~~~ APP_GLOBAL_APPLICATION_NOTIFICATION_INITIALIZE_COMPLETE");
        	}
        });
		
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_REDIRECT_MAIN_TAB, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		defaultApplicationHandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						if(self != null){
							startActivity(IntentManager.getMainTabIntent(self));
							finish();
		        		}
					}
				}, 500);
        	}
        });
		
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_APPLICATION_TERMINATE, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		moveTaskToBack(true);
        		finish();
        	}
        });
		
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_CURRENT_ACTIVITY_CLOSE, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		finish();
        	}
        });
		
		AppNotificationCenterManager.getInstance().register(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_APPLICATION_RESTART, this, new Handler() {
			public void handleMessage(Message msg) {
				//ActivityManager activityManager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
				//activityManager.restartPackage(appGlobalApplication.getPackageName());
        	}
//			@Override
//        	public void handleMessage(Message msg) {
//        		handler.postDelayed(new Runnable() {
//					@Override
//					public void run() {
//						if(self != null){
//							appGlobalApplication.disposeSharedResources();
//							ActivityManager am = (ActivityManager) appGlobalApplication.getSystemService(Context.ACTIVITY_SERVICE);
//							if (Integer.parseInt(Build.VERSION.SDK) < 8) {
//								am.restartPackage(appGlobalApplication.getPackageName());
//								android.os.Process.killProcess(android.os.Process.myPid());
//							}else{
//								am.restartPackage(appGlobalApplication.getPackageName());
//								android.os.Process.killProcess(android.os.Process.myPid());
//								final int retryLimit = 20;
//								new Thread() {
//									@Override
//									public void run() {
//										int retry = 0;
//										ActivityManager am = (ActivityManager) appGlobalApplication.getSystemService(Context.ACTIVITY_SERVICE);
//										String name = appGlobalApplication.getApplicationInfo().processName;
//										while (retry++ < retryLimit) {
//											List<RunningAppProcessInfo> list = am.getRunningAppProcesses();
//											for (RunningAppProcessInfo i : list) {
//												if (i.processName.equals(name) == true) {
//													if (i.importance >= RunningAppProcessInfo.IMPORTANCE_BACKGROUND)
//														am.restartPackage(appGlobalApplication.getPackageName());
//													else
//														Thread.yield();
//													break;
//												}
//											}
//											SystemClock.sleep(500);
//										}
//									}
//								}.start();
//							}
//		        		}
//					}
//				}, 500);
//        	}
        });
	}

	
	
	
	protected void initializeBindService(){
		
	}
	
	protected void initializeBindBroadcastReceiver(){
		
	}


	
	
	
	
	
	
	
}
