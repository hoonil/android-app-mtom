package com.hillssoft.android.app.mtom.conf;

import android.text.format.DateUtils;
import android.util.Log;

import com.hillssoft.android.framework.manager.LoggerManager;



public abstract class AppConf {
	
	
	public static final String APP_TAG = "MTOM";
	
	
	/*
	 * [ App Environment ]
	 */
	public static enum AppEnv{
		DEV, STG, PROD;
	}
	public static final AppEnv APP_ENV = AppEnv.DEV;
	
	
	/*
	 * [ URL ]
	 */
	public static final String APP_WEB_SERVER_URL = initApiServerUrl();
	
	/*
	 * [ Web Server Encode  ]
	 */
	public static final String APP_WEB_SERVER_ENCODING = "UTF-8";
	
	/*
	 * [ DB ]
	 */
	public static final String APP_DB_NAME = APP_ENV.toString() + "_" + "db_mtom";
	
	
	/*
	 * [ Shared Preference ]
	 */
	public static final String APP_SHARD_PREFERENCE_DEFAULT_NAME = APP_ENV.toString() + "_" + APP_TAG + "_pref";
	
	
	
	
	
	/*
	 * [ Debug ]
	 */
	public static final String 	LOGGER_TRACE_PREFIX_PACKAGE_NAME 	= "com.hillssoft.android";
	public static final int 	LOGGER_LOG_LEVEL 					= initLoggerLevel();
	public static final int 	LOGGER_LOG_MEMORY_LEVEL 			= initMemoryLoggerLevel();
	public static final int 	LOGGER_LOG_MEMORY_SIZE 				= initMemoryLoggerSize();
	public static final boolean LOGGER_IS_DEBUGGABLE 				= initDebuggable();
	public static final boolean LOGGER_DEBUG_TRACE 					= true;
	public static final boolean LOGGER_DEBUG_DATA_TRACE				= true;

	
	/*
	 * [ Network ]
	 */
	// Time
	public static final int CONNECTION_TIMEOUT = 1000 * 8;
	public static final int READ_TIMEOUT = 1000 * 20;
	public static final long UNDER_MAINTENANCE_INTERVAL = DateUtils.MINUTE_IN_MILLIS;
	
	// Size
	public static final int DOWNLOADER_BUFFER = 1024 * 8;
	
	// Device
	public static int DEFAULT_DENSITY_DPI = 240;
	
	
	/************************************************************************************
	 *	[ Set Configure Method ] 
	 ************************************************************************************/
	
	private static int initLoggerLevel() {
		switch (APP_ENV) {
		case PROD:
			return Log.ERROR;
		}
		return LoggerManager.DEV;
	}
	
	private static boolean initDebuggable() {
		switch (APP_ENV) {
		case PROD:
			return false;
		}
		return true;
	}

	private static int initMemoryLoggerSize() {
		switch (APP_ENV) {
		case PROD:
			return 20;
		}
		return 500;
	}

	private static int initMemoryLoggerLevel() {
		switch (APP_ENV) {
		case PROD:
			return Log.ERROR;
		}
		return Log.INFO;
	}
	
	
	/************************************************************************************
	 *	[ Url Configure Method ] 
	 ************************************************************************************/
	private static String initApiServerUrl() {
		switch (AppConf.APP_ENV) {
		case DEV:
			return "dev-app-smartphone-web.hillssoft.com/app_mtom";
		case STG:
			return "dev-app-smartphone-web.hillssoft.com/app_mtom";
		case PROD:
			return "dev-app-smartphone-web.hillssoft.com/app_mtom";
		default :
			return null;
		}
	}
	
	
}
