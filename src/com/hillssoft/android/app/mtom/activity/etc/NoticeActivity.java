package com.hillssoft.android.app.mtom.activity.etc;

import android.os.Bundle;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;

public class NoticeActivity extends BaseActivityManager {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.comm_full_web_view_layout);
	}
	
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
	}
	
	
	
	
}
