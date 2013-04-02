package com.hillssoft.android.app.mtom.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.hillssoft.android.R;
import com.hillssoft.android.framework.manager.AppNotificationCenterManager;
import com.hillssoft.android.framework.manager.BaseActivityManager;
import com.hillssoft.android.framework.manager.LoggerManager;
import com.hillssoft.android.framework.manager.SharedPreferenceManager;
import com.hillssoft.android.framework.manager.UserManager;

public class SplashActivity extends BaseActivityManager {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeApplication();
	}
	
	
	private void initializeApplication(){
		try{
			synchronized(this){
				if(appManager.isAppInitializeCompleted()){
					initializeApplicationStartup();
				}else{
					initializeApplicationDefaultDbData();
					initializeApplicationDefaultUserData();
					initializeApplicationStartup();
				}
			}

		}catch(Exception e){
			LoggerManager.e(e.toString());
			AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_APPLICATION_TERMINATE);
		}
	}
	
	
	private synchronized void initializeApplicationDefaultDbData(){
		if(!defaultAppSharedPreference.getBoolean(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_DATA, false)){
			/*
			 * [ Sample - Set DB SQL Parameters ]
			 */
			//dbSqlParams.clear();
			//dbSqlParams.put("message", "test~~~ message");
			//dbSqlParams.put("create_at", Long.toString(Calendar.getInstance().getTimeInMillis() / 1000));
			//dbSqlParams.put("state", "1");
			//dbSqlParams.put("is_del", "0");
			
			/*
			 * [ DB Execute ]
			 */
			//DatabaseManager.getInstance().getDatabase().execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.INSERT_TABLE_POST, dbSqlParams));
			defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_DATA, true);
		}
	}
	
	private synchronized void initializeApplicationDefaultUserData(){
		if(!defaultAppSharedPreference.getBoolean(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA, false)){
			String uuid = UserManager.getInstance().createNewUUID();
			defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_USER_UUID, uuid);
			defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA, true);
		}
	}
	
	
	private synchronized void initializeApplicationStartup(){
		if(defaultAppSharedPreference.getBoolean(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_COMPLETED, false)){
			AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_REDIRECT_MAIN_TAB);
		}else{
			AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_MEMBER_REGISTER);
		}
	}
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
				AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_CURRENT_ACTIVITY_CLOSE);
			}
		});
		/////////////////////////////////////////
		
		
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
