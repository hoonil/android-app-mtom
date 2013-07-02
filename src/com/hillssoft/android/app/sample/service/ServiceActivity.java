package com.hillssoft.android.app.sample.service;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;

public class ServiceActivity extends BaseActivityManager {
	
	private Button btn1;
	private Button btn2;
	private Button btn3;
	
	private TextView txtMsg;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.sample_service_activity);

		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		txtMsg = (TextView)findViewById(R.id.txtMsg);
		
	}
	@Override
	protected void initializeBindService() {
		super.initializeBindService();
	}
	@Override
	protected void initializeBindBroadcastReceiver() {
		super.initializeBindBroadcastReceiver();
	}
	@Override
	protected void setInitializeViewEventListener() {
		
		
		
		
//		btn1.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//				txtMsg.setText("!!! Start Service !!!");
//			};
//		});
		
//		btn2.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//			
//			};
//		});
//		
//		btn3.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//			
//			};
//		});
		
		
	}
}
