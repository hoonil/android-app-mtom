package com.hillssoft.framework.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.framework.manager.LoggerManager;

abstract public class BaseActivity extends Activity implements IBaseActivity{
	
	protected Activity 	self = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LoggerManager.i("01. Base Activity - onCreate Start");
		
		/**
		 * [ Common Object ]
		 */
		initializeAppCommonObject();
		
		/**
		 * [ View ]
		 */
		initializeView();
		setInitializeViewEventListener();

		/**
		 * [ Service ]
		 */
		initializeBindService();
		
		/**
		 * [ Broadcast Receiver ]
		 */
		initializeBindBroadcastReceiver();
		
		
	}
	
	
	protected void initializeAppCommonObject(){
		self = this;
		
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

	protected void initializeBindService(){
		
	}
	
	protected void initializeBindBroadcastReceiver(){
		
	}


	
}
