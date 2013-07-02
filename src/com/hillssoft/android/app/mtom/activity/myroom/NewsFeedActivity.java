package com.hillssoft.android.app.mtom.activity.myroom;

import android.os.Bundle;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.framework.manager.BaseActivityManager;
import com.hillssoft.android.framework.manager.LoggerManager;

public class NewsFeedActivity extends BaseActivityManager {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		LoggerManager.i("NewsFeedActivity - onCreate");
	}
	
	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
		setContentView(R.layout.mtom_myroom_news_feed_activity);
		
		
	}
	
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
	}
	
	
}
