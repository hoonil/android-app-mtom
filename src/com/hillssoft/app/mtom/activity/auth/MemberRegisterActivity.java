package com.hillssoft.app.mtom.activity.auth;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.hillssoft.app.R;
import com.hillssoft.framework.manager.BaseActivityManager;
import com.hillssoft.framework.manager.IntentManager;

public class MemberRegisterActivity extends BaseActivityManager {
	
	private Button registerBtn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	
	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
		setContentView(R.layout.mtom_auth_member_register_activity);
		
		registerBtn = (Button)findViewById(R.id.register_btn);
		
	}
	
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
		
		registerBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				/**
				 * []
				 */
				
				
				startActivity(IntentManager.getMainTabIntent(self));
				finish();
			}
		});
		
	}
	
	
	
	
}
