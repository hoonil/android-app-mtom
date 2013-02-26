package com.hillssoft.framework.manager;

import android.content.Context;

import com.hillssoft.framework.base.BaseApp;

public class AppManager extends BaseApp {
	
	
	
	private static Context context;
	
	public static final String NOTIFICATION_INITIALIZE_COMPLETE = "NOTIFICATION_INITIALIZE_COMPLETE";
	public static final String NOTIFICATION_INSTALL_COMPLETE = "NOTIFICATION_INSTALL_COMPLETE";
	public static final String NOTIFICATION_LOGIN_COMPLETE = "NOTIFICATION_LOGIN_COMPLETE";
	
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static AppManager instance;
	private AppNotificationCenterManager appNotificationManager = null;
	
	
	protected AppManager(Context paramContext) {
		super();
		context = paramContext;
		//initalizeBaseApp();
		
	}
	
	public static AppManager getInstance(){
		if(instance == null){
			synchronized (AppManager.class) {
				instance = new AppManager(context);
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
	/******************************************************************
	 ******************************************************************/
	
	
	
	
	
	
//	@Override
//	public void initalizeBaseApp(Context context) {
//		super.initalizeBaseApp();
//		
//		/**
//		 * [ Register Event ]
//		 */
//		AppNotificationCenterManager.getInstance().register(NOTIFICATION_INSTALL_COMPLETE, this, new Handler() {
//        	@Override
//        	public void handleMessage(Message msg) {
//        		Intent intent = IntentManager.getMainIntent(context);
//        		startActivity(intent);
//        	}
//        });
//		
//		
//		/**
//		 * [ 초기화 시작 ]
//		 */
//		
//		AppNotificationCenterManager.getInstance().notify(NOTIFICATION_INSTALL_COMPLETE);
//		
//	}
	
	
	
	
	
	
	
	
}
