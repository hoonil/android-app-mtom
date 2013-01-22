package com.hillssoft.framework.base;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

import com.hillssoft.app.mtom.conf.AppConf;

public class BaseApp {
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
