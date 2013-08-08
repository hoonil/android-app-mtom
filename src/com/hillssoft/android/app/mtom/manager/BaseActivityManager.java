package com.hillssoft.android.app.mtom.manager;




import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.widget.Toast;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.activity.BaseActivity;

public class BaseActivityManager extends BaseActivity {
	
	/*
	 * [ Define Default Object ]
	 */
	protected ActionBarActivity 	self = null;
	protected AppManager appManager = null;
	protected UserManager userManager = null;
	protected AppGlobalApplication appGlobalApplication = null;
	protected SharedPreferenceManager defaultAppSharedPreference = null;
	protected Handler activityHandler = null;
	protected Handler defaultApplicationHandler = null;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		self = this;
		
		/**
		 * [ Common Object ]
		 */
		initializeBaseActivityManagerObject();
		
		/**
		 * [ Set ActionBar ]
		 */
		initializeActionBar();
		
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
//		MenuInflater inflater = getMenuInflater();
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
	
	protected void initializeActionBar(){
		self.getSupportActionBar().setDisplayOptions(	ActionBar.DISPLAY_HOME_AS_UP | 
														ActionBar.DISPLAY_SHOW_HOME | 
														ActionBar.DISPLAY_USE_LOGO | 
														ActionBar.DISPLAY_SHOW_TITLE | 
														ActionBar.DISPLAY_SHOW_CUSTOM);
		self.getSupportActionBar().setCustomView(R.layout.global_action_bar_custom_view);
	}
	
	protected void initializeView(){
		
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
