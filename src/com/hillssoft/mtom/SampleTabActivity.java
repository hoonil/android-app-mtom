package com.hillssoft.mtom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.drm.DrmStore.Action;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import base.BaseActivity;

import com.hillssoft.mtom.sample.ActivityOpenActivity;
import com.hillssoft.mtom.sample.BroadcastActivity;
import com.hillssoft.mtom.sample.DBActivity;
import com.hillssoft.mtom.sample.GraphActivity;
import com.hillssoft.mtom.sample.ListViewActivity;
import com.hillssoft.mtom.sample.ServiceActivity;
import com.hillssoft.mtom.sample.ViewObjectActivity;

public class SampleTabActivity extends BaseActivity {
	
	/**
	 * Define Member Object Variables
	 */
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	
	
	
	private TextView txt1;
	
	private BroadcastReceiver broadcastReceiver;
	private BroadcastReceiver broadcastReceiver2;
	private BroadcastReceiver broadcastReceiver3;
	
	
	/**
	 * Define Member Variables
	 */
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeView();
		initializeBindService();
		initializeBindBroadcastReceiver();
		setInitializeViewEventListener();
	}
	
	

	protected void initializeView(){
		super.initializeView();
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		btn4 = (Button)findViewById(R.id.btn4);
		btn5 = (Button)findViewById(R.id.btn5);
		btn6 = (Button)findViewById(R.id.btn6);
		btn7 = (Button)findViewById(R.id.btn7);
		
		
		txt1 = (TextView)findViewById(R.id.txt1);
	}
	
	protected void setInitializeViewEventListener(){
		super.setInitializeViewEventListener();
		
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, ActivityOpenActivity.class);
				startActivity(intent);
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, ViewObjectActivity.class);
				startActivity(intent);
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, ListViewActivity.class);
				startActivity(intent);
			}
		});
		
		btn4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, GraphActivity.class);
				startActivity(intent);
			}
		});
		
		
		btn5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, BroadcastActivity.class);
				startActivity(intent);
			}
		});
		
		btn6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, ServiceActivity.class);
				startActivity(intent);
			}
		});
		
		btn7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, DBActivity.class);
				startActivity(intent);
			}
		});
		
		
		
	}
	
	@Override
	protected void initializeBindService() {
		// TODO Auto-generated method stub
		super.initializeBindService();
	}
	
	@Override
	protected void initializeBindBroadcastReceiver() {
		// TODO Auto-generated method stub
		super.initializeBindBroadcastReceiver();
		
		
		broadcastReceiver = new BroadcastReceiver(){
			@Override
			public void onReceive(Context context, Intent intent) {
				Log.d("!!! DynamicBroadcastReceiverExtra !!!", "SampleTabActivity - initializeBindBroadcastReceiver called ~~~~~~");
				Toast.makeText(context, "1. Called by Dynamic DynamicBroadcastReceiverExtra !!!!", Toast.LENGTH_SHORT).show();
			}
		};

		
		IntentFilter filter = new IntentFilter();
		filter.addAction("DynamicBroadcastReceiverExtra");
		registerReceiver(broadcastReceiver, filter);

		
	}
	
}
