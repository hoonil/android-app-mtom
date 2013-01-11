package com.hillssoft.mtom.sample;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import base.BaseActivity;

import com.hillssoft.mtom.R;

public class ServiceActivity extends BaseActivity {
	
	private Button btn1;
	private Button btn2;
	private Button btn3;
	
	private TextView txtMsg;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_service);
		initializeView();
		initializeBindService();
		initializeBindBroadcastReceiver();
		setInitializeViewEventListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sample_service, menu);
		return true;
	}
	
	@Override
	protected void initializeView() {
		super.initializeView();
		
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
		super.setInitializeViewEventListener();
		
		btn1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txtMsg.setText("!!! Start Service !!!");
			};
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			
			};
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
			
			};
		});
		
		
	}
}
