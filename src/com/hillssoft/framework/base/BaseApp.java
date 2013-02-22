package com.hillssoft.framework.base;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Handler;
import android.os.Message;

import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.app.mtom.manager.AppNotificationCenterManager;

abstract public class BaseApp implements IBaseObjectDisposable {
	
	
	public static final String NOTIFICATION_INSTALL_COMPLETE = "NOTIFICATION_INSTALL_COMPLETE";
	public static final String NOTIFICATION_INITIALIZE_COMPLETE = "NOTIFICATION_INITIALIZE_COMPLETE";
	public static final String NOTIFICATION_LOGIN_COMPLETE = "NOTIFICATION_LOGIN_COMPLETE";
	
	private AppNotificationCenterManager notificationManager = null;
	
	abstract public BaseApp getInstance();
	
	
	protected BaseApp() {
		initalizeApp();
	}
	
	public void initalizeApp(){
		
		AppNotificationCenterManager.getInstance().register(NOTIFICATION_INSTALL_COMPLETE, this, new Handler() {
        	@Override
        	public void handleMessage(Message msg) {
        		//Toast.makeText(this, "Test Notification - install complete", Toast.LENGTH_LONG);
        	}
        });
		
	}
	
	public static int getAppVersionCode(Context context){
		try{
			int versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
			return versionCode;
		}catch(NameNotFoundException e){
			return 0;
		}
	}
	
	
	public static String getAppEnv(){
		return AppConf.APP_ENV;
	}
	
	
	
	
	
	
}
