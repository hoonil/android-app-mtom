package com.hillssoft.android.app.mtom.manager;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.activity.BaseFragmentActivity;

public class BaseFragmentActivityManager extends BaseFragmentActivity {
	
	/*
	 * [ Define Default Object ]
	 */
	protected Activity 	self = null;
	protected AppManager appManager = null;
	protected UserManager userManager = null;
	protected AppGlobalApplication appGlobalApplication = null;
	protected SharedPreferenceManager defaultAppSharedPreference = null;
	protected Handler activityHandler = null;
	protected Handler defaultApplicationHandler = null;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		self = this;
		
		/**
		 * [ Common Object ]
		 */
		initializeBaseActivityManagerObject();
		
		/**
		 * [ View ]
		 */
		initializeView();
		setInitializeViewEventListener();

		/**
		 * [ Notification ]
		 */
		bindAppDefaultNotificationCenterEvent();
		
		/**
		 * [ Service ]
		 */
		initializeBindService();
		
		/**
		 * [ Broadcast Receiver ]
		 */
		initializeBindBroadcastReceiver();
		
		
	}
	
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		MenuInflater inflater = (MenuInflater)getMenuInflater();
//		inflater.inflate(R.menu.base_activity_actionbar, menu);
//		return super.onCreateOptionsMenu(menu);
//		
//	}
	
	protected void initializeBaseActivityManagerObject(){
		/*
		 * [ Set self object]
		 */
		self = this;
		
		/*
		 * [ Set object from AppGlobalApplication ]
		 */
		appGlobalApplication = (AppGlobalApplication)AppGlobalApplication.getAppGlobalApplicationContext();
		appGlobalApplication.setCurrentActivity(this);
		activityHandler = new Handler();
		defaultApplicationHandler = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultHandler();
		defaultAppSharedPreference = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultSharedPreference();
		
		/*
		 * [ Set application configure object ]
		 */
		appManager = AppManager.getInstance();
		
		/*
		 * [ Set user info object]
		 */
		userManager = UserManager.getInstance();
		
	}
	
	protected void initializeView(){
		//ActionBar actionBar = getActionBar();
	}
	
	protected void initializeView(int layoutResID){
		if(layoutResID < 0){
			setContentView(layoutResID);
		}
	}

	protected void setInitializeViewEventListener(){
		
	}

	protected void bindAppDefaultNotificationCenterEvent(){

	}

	
	
	
	protected void initializeBindService(){
		
	}
	
	protected void initializeBindBroadcastReceiver(){
		
	}



	
	
	
	
	
}
