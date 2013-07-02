package com.hillssoft.android.app.sample.view;

import android.os.Bundle;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.framework.manager.BaseActivityManager;

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
