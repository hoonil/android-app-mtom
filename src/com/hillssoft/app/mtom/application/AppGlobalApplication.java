package com.hillssoft.app.mtom.application;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;

import com.hillssoft.app.mtom.db.AppDB;
import com.hillssoft.app.mtom.db.AppDBQuery;
import com.hillssoft.framework.manager.AppNotificationCenterManager;
import com.hillssoft.framework.manager.AppSharedPreferenceManager;
import com.hillssoft.framework.manager.DatabaseManager;
import com.hillssoft.framework.manager.LoggerManager;
import com.hillssoft.framework.type.IDisposable;

public class AppGlobalApplication extends Application {
	
	
	private static AppGlobalApplication instance = null;
	private AppNotificationCenterManager appNotificationCenterManager;
	private Activity currentActivity = null;
	private Handler handler = new Handler(Looper.getMainLooper());
	private LinkedList<IDisposable> sharedResources 	= new LinkedList<IDisposable>();
	

	/**
	 * [ Preference Object ]
	 */
	private AppSharedPreferenceManager defaultAppShardPreference = null;
	
	
	/**
	 * [ Handler ]
	 */
	private Handler appGlobalApplicaitonHandler = new Handler(Looper.getMainLooper());
	
	
	/**
	 * [ DB Object ]
	 */
	private DatabaseManager dbManager = null;
	private SQLiteDatabase db = null;
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
		initializeApplicationDefaultDbData();
		initializeApplicationDefaultUserData();
		initializeApplicationUserSessionData();
		bindApplicationDefaultNotificationCenter();
		updateInitializeApplicationCompleted();
		
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
		defaultAppShardPreference = new AppSharedPreferenceManager();

		/*
		 * [ DB ]
		 */
		dbManager = DatabaseManager.getInstance();
		db = dbManager.getWritableDatabase();
		
		/*
		 * [ NotificationCenter ]
		 */
		appNotificationCenterManager = AppNotificationCenterManager.getInstance();
		
	}
	
	private void initializeApplicationDefaultCacheData(){
		if(!defaultAppShardPreference.getBoolean(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_CACHE_DATA, false)){
			
		}

	}
	
	
	private void initializeApplicationDefaultDbData(){
		if(!defaultAppShardPreference.getBoolean(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_SCHEMA, false)){
			/*
			 * [ Set DB SQL Params ]
			 */
			dbSqlParams.clear();
			dbSqlParams.put("message", "test~~~ message");
			dbSqlParams.put("create_at", Long.toString(Calendar.getInstance().getTimeInMillis() / 1000));
			dbSqlParams.put("state", "1");
			dbSqlParams.put("is_del", "0");
			
			/*
			 * [ DB Execute ]
			 */
			db.execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.INSERT_TABLE_POST, dbSqlParams));
			defaultAppShardPreference.commitSharedPreference(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_SCHEMA, true);
		}
	}
	
	private void initializeApplicationDefaultUserData(){
		if(!defaultAppShardPreference.getBoolean(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA, false)){
			defaultAppShardPreference.commitSharedPreference(AppSharedPreferenceManager.KEY_USER_ID, "10001");
			defaultAppShardPreference.commitSharedPreference(AppSharedPreferenceManager.KEY_USER_NICKNAME, "hoonil.kang");
			defaultAppShardPreference.commitSharedPreference(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA, true);
		}
	}
	
	private void initializeApplicationUserSessionData(){
		if(!defaultAppShardPreference.getBoolean(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_USER_SESSION_DATA, false)){
			defaultAppShardPreference.commitSharedPreference(AppSharedPreferenceManager.KEY_USER_SESSION_KEY, "abcd1234aaaabbbb");
			defaultAppShardPreference.commitSharedPreference(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_USER_SESSION_DATA, true);
		}
	}
	
	
	
	private void bindApplicationDefaultNotificationCenter(){
		

		
		
	}
	
	
	private void updateInitializeApplicationCompleted(){
		if(!defaultAppShardPreference.getBoolean(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_COMPLETED, false)){
			defaultAppShardPreference.commitSharedPreference(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_COMPLETED, true);
		}
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
	
	public AppSharedPreferenceManager getDefaultShardPreference(){
		return defaultAppShardPreference;
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	
	public void addDisposableResource(IDisposable obj) {
		sharedResources.add(obj);
	}
	
	
}
