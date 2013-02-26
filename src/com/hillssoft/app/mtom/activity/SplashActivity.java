package com.hillssoft.app.mtom.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hillssoft.app.R;
import com.hillssoft.framework.manager.BaseActivityManager;

public class SplashActivity extends BaseActivityManager {

	int count = 0;
	TextView txt1 = null;
	Button btn1 = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		onDoStart();
	}
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_splash_activity);
		
		
		txt1 = (TextView)findViewById(R.id.txt1);
		btn1 = (Button)findViewById(R.id.btn1);
		
		
	}
	
	@Override
	protected void initializeView(int layoutResID) {
		super.initializeView(layoutResID);
	}
		
	protected void onDoStart(){
		
		
		
		
		
	}

	
	
	
	public class Run implements Runnable{
		@Override
		public void run() {
			try{
				Thread.sleep(1000);
				count++;
			}catch(InterruptedException e){
				
			}
		}
	}
	
	
	
	
}
