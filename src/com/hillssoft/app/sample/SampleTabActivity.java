package com.hillssoft.app.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hillssoft.app.R;
import com.hillssoft.app.mtom.MtomTab;
import com.hillssoft.app.sample.activity.MainActivity;
import com.hillssoft.app.sample.broadcast.BroadcastActivity;
import com.hillssoft.app.sample.db.DBActivity;
import com.hillssoft.app.sample.graphic.GraphActivity;
import com.hillssoft.app.sample.service.ServiceActivity;
import com.hillssoft.app.sample.view.ListViewActivity;
import com.hillssoft.app.sample.view.PullToRefreshActivity;
import com.hillssoft.app.sample.view.ViewObjectActivity;
import com.hillssoft.framework.base.BaseActivity;

public class SampleTabActivity extends BaseActivity {
	
	/**
	 * Define Member Object Variables
	 */
	private Button btnMtom;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	
	
	
	
	private TextView txt1;
	
	private BroadcastReceiver broadcastReceiver;
	private BroadcastReceiver broadcastReceiver2;
	private BroadcastReceiver broadcastReceiver3;
	
	
	/**
	 * Define Member Variables
	 */
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
	}
	
	

	protected void initializeView(){
		super.initializeView();
		setContentView(R.layout.sample_sample_tab_activity);
		
		btnMtom = (Button)findViewById(R.id.btnMtom);
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		btn4 = (Button)findViewById(R.id.btn4);
		btn5 = (Button)findViewById(R.id.btn5);
		btn6 = (Button)findViewById(R.id.btn6);
		btn7 = (Button)findViewById(R.id.btn7);
		btn8 = (Button)findViewById(R.id.btn8);
		
		txt1 = (TextView)findViewById(R.id.txt1);
		
	}
	
	protected void setInitializeViewEventListener(){
		btnMtom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, MtomTab.class);
				startActivity(intent);
			}
		});
		
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, MainActivity.class);
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
		
		btn8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SampleTabActivity.this, PullToRefreshActivity.class);
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
