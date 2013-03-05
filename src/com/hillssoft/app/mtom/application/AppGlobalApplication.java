package com.hillssoft.app.mtom.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.app.mtom.db.AppDB;
import com.hillssoft.framework.manager.LoggerManager;

public class AppGlobalApplication extends Application {
	
	
	private boolean isInitializeApplication = false;
	
	/**
	 * [ ]
	 */
	private static AppGlobalApplication instance = null;
	public SharedPreferences shardPreference = null;
	public SharedPreferences.Editor shardPreferenceEditor = null;
	
	/**
	 * [ DB Object ]
	 */
	private AppDB appDB = null;
	private SQLiteDatabase conDB = null;
	
	//private Cursor mCursor = null;
	//private ContentValues mContentValue = null;
	
	
	/**
	 * [  ]
	 */
	public static final String APP_GLOBAL_APPLICATION_NOTIFICATION_INITIALIZE_COMPLETE = "AppGlobalApplication_NOTIFICATION_INITIALIZE_COMPLETE";
	public static final String NOTIFICATION_INSTALL_COMPLETE = "AppGlobalApplication_NOTIFICATION_INSTALL_COMPLETE";
	public static final String NOTIFICATION_LOGIN_COMPLETE = "AppGlobalApplication_NOTIFICATION_LOGIN_COMPLETE";
	
	
	/**
	 * [ ShardPreference Hash Key ]
	 */
	public static final String SHARD_PREFERENCE_HASH_KEY_USER_ID = "user_id";
	public static final String SHARD_PREFERENCE_HASH_KEY_SESSION_KEY = "session_key";
	public static final String SHARD_PREFERENCE_HASH_KEY_IS_INSTALL_COMPLETED = "is_install_completed";
	
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		initializeGlobalApplicationObject();
		initializeApplicationDB();
		initializeApplicationShardPreference();
		bindNotificationCenter();
		
		
	}
	
	public final static AppGlobalApplication getGlobalApplicationContext() {
		return instance;
	}
	
	private void initializeGlobalApplicationObject(){
		LoggerManager.i("00001. AppGlobalApplication - initializeApplication Start");
		
		instance = this;
		
		/*
		 * [ Preference ]
		 */
		shardPreference = getSharedPreferences(AppConf.APP_SHARD_PREFERENCE_NAME, MODE_PRIVATE);
		shardPreferenceEditor = shardPreference.edit();
		
		
		/*
		 * [ DB ]
		 */
		appDB = new AppDB(this);
		conDB = appDB.getWritableDatabase();
		
	}
	
	
	private void initializeApplicationDB(){
		
	}
	
	
	private void initializeApplicationShardPreference(){
		shardPreferenceEditor.putString(SHARD_PREFERENCE_HASH_KEY_USER_ID, "10001");
		shardPreferenceEditor.putString(SHARD_PREFERENCE_HASH_KEY_SESSION_KEY, "kanghoonil12345678");
		shardPreferenceEditor.putBoolean(SHARD_PREFERENCE_HASH_KEY_IS_INSTALL_COMPLETED, true);
		shardPreferenceEditor.commit();
	}
	
	private void bindNotificationCenter(){
		
	}
	
	
}
