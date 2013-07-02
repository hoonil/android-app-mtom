package com.hillssoft.android.app.sample.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;

public class BroadcastActivity extends BaseActivityManager {
	
	private Button btn1;
	private Button btn2;
	private Button btn3;
	
	private TextView txt1;
	
	private BroadcastReceiver broadcastReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	
	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
		setContentView(R.layout.sample_broadcast_broadcast_activity);


		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		
		txt1 = (TextView)findViewById(R.id.txt1);
	}
	
	
	@Override
	protected void initializeBindService() {
		// TODO Auto-generated method stub
		super.initializeBindService();
	}
	
	@Override
	protected void initializeBindBroadcastReceiver() {
		super.initializeBindBroadcastReceiver();
		broadcastReceiver = new BroadcastReceiver(){
			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				txt1.setText("called btn2~~~~~~~~~~~~~");
				Toast.makeText(context, "Called by DynamicBroadcastReceiverInner BroadcastReceiver !!!!", Toast.LENGTH_SHORT).show();
			}
		};
		IntentFilter filter = new IntentFilter();
		filter.addAction("DynamicBroadcastReceiverInner");
		registerReceiver(broadcastReceiver, filter);
		
	}
	
	@Override
	protected void setInitializeViewEventListener() {
		btn1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txt1.setText("!!! Btn1 !!!");
				Intent intent = new Intent("StaticBroadcastReceiver");
				sendBroadcast(intent);
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				txt1.setText("!!! Btn2 !!!");
				Intent intent = new Intent("DynamicBroadcastReceiverInner");
				sendBroadcast(intent);
			}
		});
				
		btn3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				txt1.setText("!!! Btn3 !!!");
				Intent intent = new Intent("DynamicBroadcastReceiverExtra");
				sendBroadcast(intent);
			}
		});

	}

	
	
	
	
	
	
}
