package com.hillssoft.android.framework.manager;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.base.BaseActivity;

public class BaseActivityManager extends BaseActivity {
	
	/*
	 * [ Define Default Object ]
	 */
	protected Activity 	self = null;
	protected AppManager appManager = null;
	protected UserManager userManager = null;
	protected AppGlobalApplication appGlobalApplication = null;
	protected SharedPreferenceManager defaultAppSharedPreference = null;
	protected Handler defaultApplicationHandler = null;
	protected HashMap<String, String> dbSqlParams = new HashMap<String, String>();
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
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
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.base_activity_actionbar, menu);
		return super.onCreateOptionsMenu(menu);
		
	}
	
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


	
	protected void openErrorMessage(int resMsgId){
		Toast t = Toast.makeText(self, resMsgId, Toast.LENGTH_SHORT);
		t.setGravity(Gravity.CENTER, 0, 0);
		t.show();
	}

	
	
	
	
	
}
