package com.hillssoft.framework.manager;

import android.os.Bundle;

import com.hillssoft.framework.base.BaseTab;

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
