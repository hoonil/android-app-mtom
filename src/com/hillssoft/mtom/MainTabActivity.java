package com.hillssoft.mtom;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import base.BaseTabActivity;

import com.hillssoft.mtom.sample.GraphActivity;

public class MainTabActivity extends BaseTabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	protected void initializeTab(){
		final TabHost tab = getTabHost();;
		tab.addTab(tab.newTabSpec("Sample").setIndicator("Sample").setContent(new Intent(this, SampleTabActivity.class)));
		tab.addTab(tab.newTabSpec("Test").setIndicator("Test").setContent(new Intent(this, TestTabActivity.class)));
	}
	
	
	@Override
	protected void initializeBindService() {
		// TODO Auto-generated method stub
		super.initializeBindService();
	
	
	}
	
}
