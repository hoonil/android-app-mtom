package com.hillssoft.mtom;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import base.BaseActivity;

import com.hillssoft.mtom.sample.ActivityOpenActivity;
import com.hillssoft.mtom.sample.ListViewActivity;
import com.hillssoft.mtom.sample.ViewObjectTestActivity;

public class IntroActivity extends BaseActivity {
	
	/**
	 * Define Member Object Variables
	 */
	private Button btn1;
	private Button btn2;
	private Button btn3;
	
	
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
		setEventListener();
		
		
	}

	
	
	private void initializeView(){
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
	}
	
	private void setEventListener(){
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(IntroActivity.this, ActivityOpenActivity.class);
				startActivity(intent);
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(IntroActivity.this, ViewObjectTestActivity.class);
				startActivity(intent);
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(IntroActivity.this, ListViewActivity.class);
				startActivity(intent);
			}
		});
		
	}
	
	
}
