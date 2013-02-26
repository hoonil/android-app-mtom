package com.hillssoft.framework.base;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.app.mtom.conf.AppConf.AppEnv;

abstract public class BaseApp implements IBaseObjectDisposable {

	
	protected BaseApp() {
		super();
	}
	
	protected void initalizeBaseApp(Context context){
		
	}
	
	public static int getAppVersionCode(Context context){
		try{
			int versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
			return versionCode;
		}catch(NameNotFoundException e){
			return 0;
		}
	}
	
	
	public static AppEnv getAppEnv(){
		return AppConf.APP_ENV;
	}
	
	
	
	
	
	
}
