package com.hillssoft.mtom.sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import base.BaseActivity;

import com.hillssoft.mtom.R;

public class BroadcastActivity extends BaseActivity {
	Button btn1;
	TextView txt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_broadcast);
		initializeView();
		initializeBindService();
		setInitializeViewEventListener();
	}

	
	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();

		btn1 = (Button)findViewById(R.id.btn1);
		txt1 = (TextView)findViewById(R.id.txt1);
	}
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				txt1.setText("Clicked !!!");
				
				Intent intent = new Intent("android.intent.action.SUPERSK");
				intent.setData(Uri.parse("sample"));
				sendBroadcast(intent);
				
				
			}
		});
	
		

		
	}

}
