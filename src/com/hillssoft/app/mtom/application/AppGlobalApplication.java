package com.hillssoft.app.mtom.application;

import java.util.HashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.hillssoft.framework.manager.DatabaseManager;
import com.hillssoft.framework.manager.LoggerManager;
import com.hillssoft.framework.manager.SharedPreferenceManager;
import com.hillssoft.framework.type.IDisposable;

public class AppGlobalApplication extends Application {
	
	
	private static AppGlobalApplication instance = null;
	private Activity currentActivity = null;
	private Handler handler = new Handler(Looper.getMainLooper());
	private LinkedList<IDisposable> sharedResources = new LinkedList<IDisposable>();
	

	/**
	 * [ Preference Object ]
	 */
	private SharedPreferenceManager defaultAppSharedPreference = null;
	
	
	/**
	 * [ Handler ]
	 */
	private Handler appGlobalApplicaitonHandler = new Handler(Looper.getMainLooper());
	
	
	/**
	 * [ DB Object ]
	 */
	private DatabaseManager dbManager = null;
	//private SQLiteDatabase db = null;
	private HashMap<String, String> dbSqlParams = new HashMap<String, String>();
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		/*
		 * [ Static Object 초기화 ]
		 */
		try {
			disposeSharedResources();
		} catch (Exception e) {
			LoggerManager.e(e);
		}
		
		instance = this;
		initializeAppGlobalApplicationObject();
		initializeApplicationDefaultCacheData();

		
	}
	
	@Override
	public void onTerminate() {
		// TODO Auto-generated method stub
		super.onTerminate();
		disposeSharedResources();
		instance = null;
		
	}
	
	
	
	public final static AppGlobalApplication getAppGlobalApplicationContext() {
		return instance;
	}
	
	private void initializeAppGlobalApplicationObject(){
		LoggerManager.i("00001. AppGlobalApplication - initializeApplication Start");
		
		instance = this;
		
		/*
		 * [ Activity Task ]
		 */
		currentActivity = null;
		
		/*
		 * [ Preference ]
		 */
		defaultAppSharedPreference = new SharedPreferenceManager();

		/*
		 * [ Global Handler ]
		 */
		appGlobalApplicaitonHandler = new Handler(Looper.getMainLooper());
		
	}
	
	private void initializeApplicationDefaultCacheData(){

	}
	

	public Activity getCurrentActivity() {
		return currentActivity;
	}
	
	public void setCurrentActivity(Activity activity) {
		currentActivity = activity;
	}
	
	public void disposeSharedResources() {
		while (!sharedResources.isEmpty()) {
			IDisposable sharedResource = sharedResources.poll();
			if (sharedResource != null) {
				try {
					sharedResource.dispose();
				} catch (Exception e) {
					LoggerManager.e("Error - disposeSharedResources()");
				}
			}
		}
	}
	
	public SharedPreferenceManager getApplicationDefaultSharedPreference(){
		return defaultAppSharedPreference;
	}
	
	public Handler getApplicationDefaultHandler() {
		return handler;
	}
	
	
	public void addDisposableResource(IDisposable obj) {
		sharedResources.add(obj);
	}
	
	
}
