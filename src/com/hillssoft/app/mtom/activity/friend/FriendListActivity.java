package com.hillssoft.app.mtom.activity.friend;

import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.widget.TextView;

import com.hillssoft.app.R;
import com.hillssoft.app.mtom.manager.AddressManager;
import com.hillssoft.app.mtom.manager.BaseActivityManager;

public class FriendListActivity extends BaseActivityManager{
	
	
	private TextView txt;
	private List<HashMap> addressList;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_friend_friend_list_activity);
		
		
		/*
		 * []
		 */
		txt = (TextView)findViewById(R.id.txt);
		
		
		
		/*
		 * []
		 */
		
		
		/*
		 * [ Get Address List ]
		 */
		addressList = new AddressManager().getInstance().getAddressList(getApplicationContext());
		
		
		String str = "";
		
		for(int i = 0; i < addressList.size(); i++){
			txt.append(Integer.toString(i) + "\n");
			//txt.setText(Integer.toString(i) + "\n");
			
			//txt.setText(txt.getText() + addressList.get(i).get(addressList.get(i).keySet().toString()));
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	@Override
	protected void setInitializeViewEventListener() {
		super.setInitializeViewEventListener();
		
	}
}
