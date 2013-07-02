package com.hillssoft.android.app.mtom.manager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.app.mtom.conf.AppConf.AppEnv;
import com.hillssoft.android.framework.base.BaseApp;
import com.hillssoft.android.framework.type.IDisposable;
import com.hillssoft.android.framework.util.DialogUtil;

public class AppManager extends BaseApp implements IDisposable {
	
	
	/*
	 * [ Define Object ]
	 */
	private static AppManager instance;
	private Context context = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationContext();
	private SharedPreferenceManager defaultSharedPreference = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultSharedPreference();
	
	
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
	
	
	
	private void initializeAppManagerObject(){
		
	}
	
	
	
	public boolean isAppInitializeCompleted(){
		return defaultSharedPreference.getBoolean(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_COMPLETED, false);
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
	

	
	public boolean isNetworkOnline() {
		Context context = AppGlobalApplication.getAppGlobalApplicationContext();
		if (context == null) {
			return false;
		}
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		return info != null && info.isConnectedOrConnecting();
	}
	
	public boolean isAirplaneMode() {
		return !isNetworkOnline();
	}
	
	public boolean checkAndAlertNetworkAvailable() {
		if (isAirplaneMode()) {
			DialogUtil.showAlertForNetworkIsNotUnavailable();
			return false;
		}
		return true;
	}
	
	
	
	
	
}
