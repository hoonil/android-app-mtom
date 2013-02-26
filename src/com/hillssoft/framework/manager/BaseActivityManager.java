package com.hillssoft.framework.manager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.hillssoft.framework.base.BaseActivity;

public class BaseActivityManager extends BaseActivity {
	AppManager appManager;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeActivity();
		
		
	}
	
	protected void initializeAppCommonObject(){
		super.initializeAppCommonObject(self);
		appManager = AppManager.getInstance();
		
	}
	
	
	
	
	
	
	private void initializeActivity(){
		/**
		 * [ Register Event ]
		 */
//		AppNotificationCenterManager.getInstance().register(AppManager.NOTIFICATION_INSTALL_COMPLETE, this, new Handler() {
//        	@Override
//        	public void handleMessage(Message msg) {
//        		startActivity(IntentManager.getMainIntent(self));
//        		Log.i("aaaaaaaaaaaaaaaaaaaaa", "sssssssssssssssssssssssssssssssss");
//        	}
//        });
		
		
		/**
		 * [ 초기화 시작 ]
		 */
		//AppNotificationCenterManager.getInstance().notify(AppManager.NOTIFICATION_INSTALL_COMPLETE);
		
	}
	
	
}
