package com.hillssoft.framework.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.framework.base.BaseApp;

public class AppManager extends BaseApp {
	
	
	/*
	 * 
	 */
	private static Context context;
	private SharedPreferences shardPreference;
	private AppNotificationCenterManager appNotificationCenterManager;
	
	
	/*
	 * 
	 */
	public static final String NOTIFICATION_INSTALL_COMPLETED = "AppManager_NOTIFICATION_INSTALL_COMPLETED";
	public static final String NOTIFICATION_LOGIN_COMPLETE = "NOTIFICATION_LOGIN_COMPLETE";
	
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static AppManager instance;
	private AppNotificationCenterManager appNotificationManager = null;
	
	
	protected AppManager(Context pContext) {
		super();
		
		initializeAppManagerObject(pContext);
		bindCommonNotificationCenterEvent();
		initializeApp(pContext);
		
		
		
		
	}
	
	public static AppManager getInstance(Context context){
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
	
	
	
	private void initializeAppManagerObject(Context pContext){
		context = pContext;
		shardPreference = pContext.getSharedPreferences(AppConf.APP_SHARD_PREFERENCE_NAME, Activity.MODE_PRIVATE);
		appNotificationCenterManager = AppNotificationCenterManager.getInstance();
	}
	
	
	/**
	 * [ 공통 이벤트 등록 메소드 ]
	 */
	private void bindCommonNotificationCenterEvent(){
		/**
		 * [ Register Event for app install ]
		 */
		appNotificationManager.getInstance().register(AppManager.NOTIFICATION_INSTALL_COMPLETED, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		
        		
        		LoggerManager.i("3333333333333333333333333333333333333333aaaaaaaaaaaaaaaaaaaaa");
        		
        		//Intent intent = IntentManager.getMainIntent(context);
        		//startActivity(intent);
        	}
        });
		
	}
	
	
	
	/**
	 * [ 공통 초기화 메소드 ]
	 * @param context
	 */
	public void initializeApp(Context context) {
		/**
		 * [ App initialization start ]
		 */
		//AppNotificationCenterManager.getInstance().notify(NOTIFICATION_INSTALL_COMPLETE);
		
	}
	
	
	public boolean isInstallCompleted(){
		return shardPreference.getBoolean(AppGlobalApplication.SHARD_PREFERENCE_HASH_KEY_IS_INSTALL_COMPLETED, false);
	}
	
	
	
	
	
}
