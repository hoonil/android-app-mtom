package com.hillssoft.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.hillssoft.app.mtom.MtomTabActivity;
import com.hillssoft.app.sample.SampleTabActivity;
import com.hillssoft.framework.base.BaseTabActivity;

public class IndexActivity extends BaseTabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	protected void initializeTab(){
		final TabHost tab = getTabHost();;
		tab.addTab(tab.newTabSpec("Sample").setIndicator("Sample").setContent(new Intent(this, SampleTabActivity.class)));
		tab.addTab(tab.newTabSpec("mTOm").setIndicator("mTOm").setContent(new Intent(this, MtomTabActivity.class)));
	}
	
	
	@Override
	protected void initializeBindService() {
		// TODO Auto-generated method stub
		super.initializeBindService();
	}
	
}
