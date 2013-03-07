package com.hillssoft.framework.manager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.app.mtom.conf.AppConf.AppEnv;
import com.hillssoft.framework.base.BaseApp;
import com.hillssoft.framework.type.IDisposable;

public class AppManager extends BaseApp implements IDisposable {
	
	
	/*
	 * [ Define Object ]
	 */
	private Context context = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationContext();
	private AppSharedPreferenceManager defaultShardPreference = AppGlobalApplication.getAppGlobalApplicationContext().getDefaultShardPreference();
	
	
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static AppManager instance;
	private AppNotificationCenterManager appNotificationManager = null;
	
	
	protected AppManager() {
		super();
		
		initializeAppManagerObject();
		
	}
	
	public static AppManager getInstance(){
		if(instance == null){
			synchronized (AppManager.class) {
				instance = new AppManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
	/******************************************************************
	 ******************************************************************/
	
	
	
	private void initializeAppManagerObject(){
		
	}
	
	
	
	public boolean isAppInitializeCompleted(){
		return defaultShardPreference.getBoolean(AppSharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_COMPLETED, false);
	}
	
	
	
	public int getAppVersionCode(){
		try{
			int versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
			return versionCode;
		}catch(NameNotFoundException e){
			return 0;
		}
	}
	
	public String getAppVersionName(){
		try{
			PackageInfo pinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			return pinfo.versionName;
		}catch(NameNotFoundException e){
			return null;
		}
	}
	
	
	public AppEnv getAppEnv(){
		return AppConf.APP_ENV;
	}
	
	
	
	
	
	
	
	
	
	
}
