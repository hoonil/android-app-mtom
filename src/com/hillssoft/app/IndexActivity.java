package com.hillssoft.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.hillssoft.app.mtom.MtomTab;
import com.hillssoft.app.sample.SampleTabActivity;
import com.hillssoft.framework.base.BaseTab;

public class IndexActivity extends BaseTab {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	public void initializeTab(){
		final TabHost tab = getTabHost();
		tab.clearAllTabs();
		tab.addTab(tab.newTabSpec("Sample").setIndicator("Sample").setContent(new Intent(this, SampleTabActivity.class)));
		tab.addTab(tab.newTabSpec("mTOm").setIndicator("mTOm").setContent(new Intent(this, MtomTab.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
	}
	
	
	@Override
	protected void initializeBindService() {
		// TODO Auto-generated method stub
		super.initializeBindService();
	}
	
	
	//////////////////////////
}
