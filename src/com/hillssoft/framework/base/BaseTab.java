package com.hillssoft.framework.base;

import android.app.TabActivity;
import android.os.Bundle;

abstract public class BaseTab extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeTab();
		initializeBindService();
	}
	abstract public void initializeTab();
	protected void initializeBindService(){}
	
}
