package com.hillssoft.android.app.mtom.activity.search;

import android.os.Bundle;

import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.app.mtom.manager.LoggerManager;

public class SearchActivity extends BaseActivityManager {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		LoggerManager.i("SearchActivity - onCreate");
	}
}
