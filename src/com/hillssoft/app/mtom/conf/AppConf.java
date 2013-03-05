package com.hillssoft.app.mtom.conf;

import android.util.Log;

import com.hillssoft.framework.manager.LoggerManager;



public abstract class AppConf {
	
	
	public static final String APP_TAG = "MTOM";
	
	/*
	 * [ App Enviroment ]
	 */
	public static enum AppEnv{
		DEV, STG, PROD;
	}
	public static final AppEnv APP_ENV = AppEnv.DEV;
	
	
	/*
	 * [ URL ]
	 */
	public static final String APP_WEB_SERVER_URL = "http://hoonil.codns.com";
	
	
	/*
	 * [ DB ]
	 */
	public static final String APP_DB_NAME = "db_mtom";
	
	
	/*
	 * [ Shard Prefernce ]
	 */
	public static final String APP_SHARD_PREFERENCE_NAME = APP_TAG + "_pref";
	
	
	
	/*
	 * [ Debug ]
	 */
	public static final int 	LOGGER_LOG_LEVEL 		= initLoggerLevel();
	public static final int 	LOGGER_LOG_MEMORY_LEVEL = initMemoryLoggerLevel();
	public static final int 	LOGGER_LOG_MEMORY_SIZE 	= initMemoryLoggerSize();
	public static final boolean LOGGER_IS_DEBUGGABLE 	= initDebuggable();
	public static final boolean LOGGER_DEBUG_TRACE 		= true;
	public static final boolean LOGGER_DEBUG_DATA_TRACE	= true;

	
	
	
	
	
	
	
	
	
	/************************************************************************************
	 *	[ Set Config Method ] 
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
	
}
