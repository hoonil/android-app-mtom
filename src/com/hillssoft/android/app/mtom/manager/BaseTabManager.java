package com.hillssoft.android.app.mtom.manager;

import android.os.Bundle;

import com.hillssoft.android.framework.activity.BaseTabActivity;

abstract public class BaseTabManager extends BaseTabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeTab();
		initializeBindService();
	}
	abstract public void initializeTab();
	protected void initializeBindService(){}
	
	
}
