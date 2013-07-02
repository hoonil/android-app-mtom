package com.hillssoft.android.app.mtom.activity.more;

import android.os.Bundle;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.app.mtom.manager.LoggerManager;

public class MoreListActivity extends BaseActivityManager{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LoggerManager.i("MoreListActivity - onCreate");
	}
	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
		setContentView(R.layout.mtom_activity_more_more_list_activity);
	}
}
