package com.hillssoft.android.framework.manager;

import android.os.Bundle;

import com.hillssoft.android.framework.base.BaseTab;

abstract public class BaseTabManager extends BaseTab {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeTab();
		initializeBindService();
	}
	abstract public void initializeTab();
	protected void initializeBindService(){}
	
	
}
