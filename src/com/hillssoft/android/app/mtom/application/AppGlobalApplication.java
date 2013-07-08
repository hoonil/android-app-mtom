package com.hillssoft.android.app.mtom.application;

import java.util.HashMap;
import java.util.LinkedList;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.hillssoft.android.app.mtom.manager.DatabaseManager;
import com.hillssoft.android.app.mtom.manager.SharedPreferenceManager;
import com.hillssoft.android.framework.log.Logger;
import com.hillssoft.android.framework.type.IDisposable;




//@ReportsCrashes
//(
//		formKey = "",
//		resToastText = R.string.crash_toast_text,
//		mode = ReportingInteractionMode.DIALOG,
//		resDialogIcon = android.R.drawable.ic_dialog_info,
//		resDialogTitle = R.string.crash_dialog_title,
//		resDialogText = R.string.crash_dialog_text,
//		resDialogOkToast = R.string.crash_dialog_ok_toast,
//		mailTo = "hoonil.kang@gmail.com"		
//)
	


public class AppGlobalApplication extends Application {
	
	
	private static AppGlobalApplication instance = null;
	private Activity currentActivity = null;
	private Handler handler = new Handler(Looper.getMainLooper());
	private LinkedList<IDisposable> sharedResources = new LinkedList<IDisposable>();
	

	/**
	 * [ Preference Object ]
	 */
	private SharedPreferenceManager defaultAppSharedPreference = null;
	
	
	/**
	 * [ Handler ]
	 */
	private Handler appGlobalApplicaitonHandler = new Handler(Looper.getMainLooper());
	
	
	/**
	 * [ DB Object ]
	 */
	private DatabaseManager databaseManager = null;
	//private SQLiteDatabase db = null;
	private HashMap<String, String> dbSqlParams = new HashMap<String, String>();
	
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		/*
		 * [ Clash Log Start ]
		 */
		//ACRA.init(this);
		
		
		/*
		 * [ Static Object 초기화 ]
		 */
		try {
			disposeSharedResources();
		} catch (Exception e) {
			Logger.e(e);
		}
		
		instance = this;
		initializeAppGlobalApplicationObject();
		initializeApplicationDefaultCacheData();

		
		
		
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
		Logger.i("00001. AppGlobalApplication - initializeApplication Start");
		
		instance = this;
		
		/*
		 * [ Activity Task ]
		 */
		currentActivity = null;
		
		/*
		 * [ Preference ]
		 */
		defaultAppSharedPreference = new SharedPreferenceManager();

		/*
		 * [ Global Handler ]
		 */
		appGlobalApplicaitonHandler = new Handler(Looper.getMainLooper());
		
		/*
		 * [ DB ]
		 */
		databaseManager = DatabaseManager.getInstance();
		
	}
	
	private void initializeApplicationDefaultCacheData(){

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
					Logger.e("Error - disposeSharedResources()");
				}
			}
		}
	}
	
	public SharedPreferenceManager getApplicationDefaultSharedPreference(){
		return defaultAppSharedPreference;
	}
	
	public Handler getApplicationDefaultHandler() {
		return handler;
	}
	
	
	public void addDisposableResource(IDisposable obj) {
		sharedResources.add(obj);
	}
	
	
}
