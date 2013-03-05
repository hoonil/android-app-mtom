package com.hillssoft.app.mtom.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.hillssoft.app.R;
import com.hillssoft.framework.manager.AppManager;
import com.hillssoft.framework.manager.AppNotificationCenterManager;
import com.hillssoft.framework.manager.BaseActivityManager;
import com.hillssoft.framework.manager.LoggerManager;

public class SplashActivity extends BaseActivityManager {

	

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LoggerManager.i("03. SplashActivity - onCreate Start");
		onDoStart();
	}
	
	
	@Override
	protected void initializeAppCommonObject() {
		super.initializeAppCommonObject();
	}
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_splash_activity);
		
		
		
		/////////////////////////////////////////
		run = new Thread(new Run(), "run-###1");
		run.start();
		txt1 = (TextView)findViewById(R.id.txt1);
		btn1 = (Button)findViewById(R.id.btn1);
		txt1.setText("aaaa");
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				count = 0;
				txt1.setText(Integer.toString(count));
			}
		});
		/////////////////////////////////////////
		
		
	}
	
	
	@Override
	protected void setInitializeViewEventListener() {
		super.setInitializeViewEventListener();
		
	}
	
	
	
	protected void onDoStart(){
		
		/**
		 * [ Start Service ]
		 */
		if(appManager.isInstallCompleted()){
			LoggerManager.i("!!!!! Activity Startup Successed !!!!! - AppManager.getInstance().isInstallCompleted() is true");
			AppNotificationCenterManager.getInstance().notify(AppManager.NOTIFICATION_INSTALL_COMPLETED);
		}else{
			LoggerManager.e("!!!!! Activity Startup Error !!!!! - AppManager.getInstance().isInstallCompleted() is false");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	int count = 0;
	TextView txt1 = null;
	Button btn1 = null;
	
	
	/**
	 * [ Thread Test Object ]
	 */
	Thread run;
	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			
			if(msg.what == 0){
				txt1.setText(Integer.toString(count));
			}
			
			
			
			
			
		}
	};
	
	public class Run implements Runnable{
		
		UpdateTxt r = new UpdateTxt();
		
		@Override
		public void run() {
			try{
				
				while(true){
					int msgIdx = 0;
					Thread.sleep(1000);
					if(count % 10 != 0){
						msgIdx = 1;
						handler.post(r);
					}
					handler.sendEmptyMessage(msgIdx);
					
					count++;
				}
				
			}catch(InterruptedException e){
				
			}
		}
	}
	
	
	public class UpdateTxt implements Runnable{
		@Override
		public void run() {
			txt1.setText("업데이트 완료 했다~~~~ 호호호호");
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
}
