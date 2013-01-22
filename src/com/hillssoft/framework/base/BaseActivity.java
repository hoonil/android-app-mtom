package com.hillssoft.framework.base;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeView();
		initializeBindService();
		initializeBindBroadcastReceiver();
		setInitializeViewEventListener();
	}
	protected void initializeView(){}
	protected void initializeBindService(){}
	protected void initializeBindBroadcastReceiver(){}
	protected void setInitializeViewEventListener(){}
}
