package com.hillssoft.framework.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

abstract public class BaseActivity extends Activity implements IBaseActivity{
	
	protected Activity 	self = null;
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		self = this;
		
		/**
		 * [ Common Object ]
		 */
		initializeAppCommonObject(self);
		
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
	
	
	protected void initializeAppCommonObject(Context context){
		
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
