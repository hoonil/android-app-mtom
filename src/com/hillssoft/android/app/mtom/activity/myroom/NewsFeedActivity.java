package com.hillssoft.android.app.mtom.activity.myroom;

import android.os.Bundle;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.framework.log.Logger;

public class NewsFeedActivity extends BaseActivityManager {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Logger.i("NewsFeedActivity - onCreate");
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
