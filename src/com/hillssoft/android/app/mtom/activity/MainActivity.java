package com.hillssoft.android.app.mtom.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Button;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.fragment.LeftMenuFragment;
import com.hillssoft.android.app.mtom.fragment.RightMenuFragment;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;

public class MainActivity extends BaseActivityManager {

	
	/**
	 * [ Define Fragment Variables ]
	 */
//	FragmentManager fragmentManager = getSupportFragmentManager();
//	Fragment lefMenuFragment = new LeftMenuFragment();
//	Fragment rightMenuFragment = new RightMenuFragment();
			
	
	/**
	 * [ Widget ]
	 */
	boolean isMenuOpen = false;
	Button fragmentBtn = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeView();
		setInitializeViewEventListener();
	}
	
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_activity_main_tab_activity);
	}
	
//	protecte void initializeView() {
//		setContentView(R.layout.mtom_activity_main_tab_activity);
//		
//		/*
//		 * [ Widget ]
//		 */
//		fragmentBtn = (Button)findViewById(R.id.fragment_btn);
//	}
		
		
//	
//	private void setInitializeViewEventListener(){
////		fragmentBtn.setOnClickListener(new OnClickListener() {
////			@Override
////			public void onClick(View v) {
////				if(isMenuOpen){
////					FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////					fragmentTransaction.remove(lefMenuFragment);
////					fragmentTransaction.addToBackStack(null);
////					fragmentTransaction.commit();
////					isMenuOpen = false;
////				}else{
////					FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
////					fragmentTransaction.replace(android.R.id.content, lefMenuFragment, "tag2");
////					fragmentTransaction.addToBackStack(null);
////					fragmentTransaction.commit();
////					isMenuOpen = true;
////				}
////				
////				
////			}
////		});
//	}
//		
		


}
