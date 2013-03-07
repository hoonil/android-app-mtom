package com.hillssoft.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.hillssoft.app.mtom.MtomMainTab;
import com.hillssoft.app.sample.SampleTabActivity;
import com.hillssoft.framework.base.BaseTab;
import com.hillssoft.framework.manager.BaseTabManager;
import com.hillssoft.framework.manager.StringKeyManager;

public class IndexActivity extends BaseTabManager {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	public void initializeTab(){
		final TabHost tab = getTabHost();
		tab.clearAllTabs();
		tab.addTab(tab.newTabSpec("Sample").setIndicator("Sample").setContent(new Intent(this, SampleTabActivity.class)));
		tab.addTab(tab.newTabSpec("mTOm").setIndicator("mTOm").setContent(new Intent(this, MtomMainTab.class)));
		tab.setCurrentTab(getIntent().getIntExtra(StringKeyManager.KEY_CURRENT_TAB_INDEX, 0));
	}
	
	
}
