package com.hillssoft.framework.base;

import android.app.Activity;
import android.os.Bundle;

abstract public class BaseActivity extends Activity implements IBaseActivity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeView();
		setInitializeViewEventListener();

		initializeBindService();
		initializeBindBroadcastReceiver();
	}
	
	
	protected void initializeView(){
		
	}
	protected void setInitializeViewEventListener(){
		
	}

	
	protected void initializeBindService(){}
	protected void initializeBindBroadcastReceiver(){}


	protected void initializeView(int layoutResID){
		if(layoutResID < 0){
			setContentView(layoutResID);
		}
	}
	
}
