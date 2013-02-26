package com.hillssoft.app.sample.view;

import android.os.Bundle;

import com.hillssoft.app.R;
import com.hillssoft.framework.manager.BaseActivityManager;

public class ListViewDetailActivity extends BaseActivityManager {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}

	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
		setContentView(R.layout.sample_view_list_view_detail_activity);
	}

}
