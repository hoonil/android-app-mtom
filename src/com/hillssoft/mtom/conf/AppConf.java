package com.hillssoft.mtom.conf;


public abstract class AppConf {
	
	/*
	 * [ App Enviroment ]
	 */
	public static enum AppEnv{
		DEV, STG, PROD;
	}
	public static final String APP_ENV = AppEnv.DEV.toString();
	
	
	/*
	 * [ URL ]
	 */
	public static final String APP_WEB_SERVER_URL = "http://hoonil.codns.com";
	
	
	/*
	 * [ DB ]
	 */
	public static final String APP_DB_NAME = "db_mtom";
	
}
