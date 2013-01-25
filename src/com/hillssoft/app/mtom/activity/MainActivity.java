package com.hillssoft.app.mtom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.hillssoft.app.R;
import com.hillssoft.app.mtom.MtomTab;
import com.hillssoft.app.sample.SampleTabActivity;
import com.hillssoft.framework.base.BaseTab;


public class MainActivity extends BaseTab {
	@Override
	public void initializeTab() {
		final TabHost tab = getTabHost();;
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_friend_title)).setIndicator(getString(R.string.mtom_friend_title)).setContent(new Intent(this, SampleTabActivity.class)));
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_chat_title)).setIndicator(getString(R.string.mtom_chat_title)).setContent(new Intent(this, MtomTab.class)));
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_search_title)).setIndicator(getString(R.string.mtom_search_title)).setContent(new Intent(this, MtomTab.class)));
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_more_title)).setIndicator(getString(R.string.mtom_more_title)).setContent(new Intent(this, MtomTab.class)));
	}
	
	
	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.mtom_mtom_tab_activity);
//	}
//
//	
//	
//	@Override
//	protected void initializeView() {
//		// TODO Auto-generated method stub
//		super.initializeView();
//	}
}
