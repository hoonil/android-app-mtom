package com.hillssoft.android.app.mtom.manager;




import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.activity.BaseActivity;

public class BaseActivityManager extends BaseActivity {
	
	/*
	 * [ Define Default Object ]
	 */
	protected ActionBarActivity self = null;
	protected android.support.v7.app.ActionBar actionBar = null;
	
	protected AppGlobalApplication appGlobalApplication = null;
	protected SharedPreferenceManager defaultAppSharedPreference = null;
	protected Handler activityHandler = null;
	protected Handler defaultApplicationHandler = null;
	
	protected AppManager appManager = null;
	protected UserManager userManager = null;
	
	
	/*
	 * [ Action Bar Variables ]
	 */
	protected ImageButton actionBarBackBtn = null;
	protected ImageButton actionBarLeftMenuBtn = null;
	protected ImageButton actionBarLogo = null;
	protected TextView actionBarTitle = null;
	protected ImageButton actionBarWriteBtn = null;
	protected ImageButton actionBarRefreshBtn = null;
	protected ImageButton actionBarRightMenuBtn = null;
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		overridePendingTransition(R.anim.activity_slide_child, R.anim.activity_slide_parent);
		
		self = this;
		
		/**
		 * [ Common Object ]
		 */
		initializeBaseActivityManagerObject();
		
		/**
		 * [ Set ActionBar ]
		 */
		initializeActionBar();
		
		/**
		 * [ View ]
		 */
		initializeView();
		setInitializeViewEventListener();

		/**
		 * [ Notification ]
		 */
		bindAppDefaultNotificationCenterEvent();
		
		/**
		 * [ Service ]
		 */
		initializeBindService();
		
		/**
		 * [ Broadcast Receiver ]
		 */
		initializeBindBroadcastReceiver();
		
		
		
	}
	
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		MenuInflater inflater = getMenuInflater();
//		inflater.inflate(R.menu.base_activity_actionbar, menu);
//		return super.onCreateOptionsMenu(menu);
//		
//	}
	
	protected void initializeBaseActivityManagerObject(){
		/*
		 * [ Set self object]
		 */
		self = this;
		
		/*
		 * [ Set object from AppGlobalApplication ]
		 */
		appGlobalApplication = (AppGlobalApplication)AppGlobalApplication.getAppGlobalApplicationContext();
		appGlobalApplication.setCurrentActivity(this);
		activityHandler = new Handler();
		defaultApplicationHandler = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultHandler();
		defaultAppSharedPreference = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultSharedPreference();
		
		/*
		 * [ Set application configure object ]
		 */
		appManager = AppManager.getInstance();
		
		/*
		 * [ Set user info object]
		 */
		userManager = UserManager.getInstance();
		
	}
	
	protected void initializeActionBar(){
		actionBar = self.getSupportActionBar();
		actionBar.setDisplayOptions(	
				//ActionBar.DISPLAY_SHOW_HOME | 
				//ActionBar.DISPLAY_HOME_AS_UP | 
				//ActionBar.DISPLAY_USE_LOGO | 
				//ActionBar.DISPLAY_SHOW_TITLE | 
				ActionBar.DISPLAY_SHOW_CUSTOM
		);
		actionBar.setCustomView(R.layout.global_action_bar_custom_view);
		
		/*
		 * [ Set ActionBar Menu Object ]
		 */
		actionBarBackBtn = (ImageButton) actionBar.getCustomView().findViewById(R.id.action_bar_back);
		actionBarLeftMenuBtn = (ImageButton) actionBar.getCustomView().findViewById(R.id.action_bar_left_menu_btn);
		actionBarLogo = (ImageButton) actionBar.getCustomView().findViewById(R.id.action_bar_logo);
		actionBarTitle = (TextView) actionBar.getCustomView().findViewById(R.id.action_bar_title);
		actionBarWriteBtn = (ImageButton) actionBar.getCustomView().findViewById(R.id.action_bar_write);
		actionBarRefreshBtn = (ImageButton) actionBar.getCustomView().findViewById(R.id.action_bar_refresh);
		actionBarRightMenuBtn = (ImageButton) actionBar.getCustomView().findViewById(R.id.action_bar_right_menu_btn);
		
		/*
		 * [ Set ActionBar Event ]
		 */
		actionBarWriteBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new IntentManager().getPostRegisterIntent(self);
				startActivity(intent);
			}
		});
		
		actionBarBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		actionBarTitle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
		
		/*
		 * [ Set Button Selector ]
		 */
		actionBarBackBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					actionBarBackBtn.setBackgroundDrawable(null);
					actionBarTitle.setBackgroundDrawable(null);
				}else if(event.getAction() == MotionEvent.ACTION_DOWN){
					actionBarBackBtn.setBackgroundColor(getResources().getColor(R.color.blue));
					actionBarTitle.setBackgroundColor(getResources().getColor(R.color.blue));
				}
				return false;
			}
		});
		actionBarLeftMenuBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					actionBarLeftMenuBtn.setBackgroundDrawable(null);
				}else if(event.getAction() == MotionEvent.ACTION_DOWN){
					actionBarLeftMenuBtn.setBackgroundColor(getResources().getColor(R.color.blue));
				}
				return false;
			}
		});
		actionBarTitle.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					actionBarBackBtn.setBackgroundDrawable(null);
					actionBarTitle.setBackgroundDrawable(null);
				}else if(event.getAction() == MotionEvent.ACTION_DOWN){
					actionBarBackBtn.setBackgroundColor(getResources().getColor(R.color.blue));
					actionBarTitle.setBackgroundColor(getResources().getColor(R.color.blue));
				}
				return false;
			}
		});
		actionBarWriteBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					actionBarWriteBtn.setBackgroundDrawable(null);
				}else if(event.getAction() == MotionEvent.ACTION_DOWN){
					actionBarWriteBtn.setBackgroundColor(getResources().getColor(R.color.blue));
				}
				return false;
			}
		});
		actionBarRefreshBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					actionBarRefreshBtn.setBackgroundDrawable(null);
				}else if(event.getAction() == MotionEvent.ACTION_DOWN){
					actionBarRefreshBtn.setBackgroundColor(getResources().getColor(R.color.blue));
				}
				return false;
			}
		});
		actionBarRightMenuBtn.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction() == MotionEvent.ACTION_UP){
					actionBarRightMenuBtn.setBackgroundDrawable(null);
				}else if(event.getAction() == MotionEvent.ACTION_DOWN){
					actionBarRightMenuBtn.setBackgroundColor(getResources().getColor(R.color.blue));
				}
				return false;
			}
		});
		
		
		
		/*
		 * [ Set ActionBar Navigation Mode ]
		 */
		//SpinnerAdapter navigationListAdapter = ArrayAdapter.createFromResource(self, R.array.main_activity_action_bar_navigation_list, android.R.layout.simple_spinner_dropdown_item);
		//actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		//actionBar.setListNavigationCallbacks(navigationListAdapter, this);
		
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		overridePendingTransition(R.anim.activity_slide_exit_parent, R.anim.activity_slide_exit_child);
	}
	
	
	protected void initializeView(){
		
	}
	
	protected void initializeView(int layoutResID){
		if(layoutResID < 0){
			setContentView(layoutResID);
		}
	}

	protected void setInitializeViewEventListener(){
		
	}

	protected void bindAppDefaultNotificationCenterEvent(){

	}

	
	
	
	protected void initializeBindService(){
		
	}
	
	protected void initializeBindBroadcastReceiver(){
		
	}


	
	protected void openErrorMessage(int resMsgId){
		Toast t = Toast.makeText(self, resMsgId, Toast.LENGTH_SHORT);
		t.setGravity(Gravity.CENTER, 0, 0);
		t.show();
	}

	
	private void initializeMainTabMenu(){
		//actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//actionBar.addTab(actionBar.newTab().setText("Tab1").setTabListener(new TabListener<MainFragment>(self, "tab1", MainFragment.class)));
		//actionBar.addTab(actionBar.newTab().setText("Tab2").setTabListener(new TabListener<MainFragment>(self, "tab2", MainFragment.class)));
		//actionBar.addTab(actionBar.newTab().setText("Tab3").setTabListener(new TabListener<MainFragment>(self, "tab3", MainFragment.class)));
	}
	protected class TabListener<T extends Fragment> implements ActionBar.TabListener {
	    private Fragment mFragment;
	    private final ActionBarActivity mActivity;
	    private final String mTag;
	    private final Class<T> mClass;
	
	    public TabListener(ActionBarActivity activity, String tag, Class<T> clz) {
	        mActivity = activity;
	        mTag = tag;
	        mClass = clz;
	    }
	    public void onTabSelected(Tab tab, FragmentTransaction ft) {
	
	        mFragment = mActivity.getSupportFragmentManager().findFragmentByTag(mTag);
	        if (mFragment == null) {
	            mFragment = Fragment.instantiate(mActivity, mClass.getName());
	            ft.add(android.R.id.content, mFragment, mTag);
	        } else {
	            ft.attach(mFragment);
	        }
	        
	    }
	    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	    	if (mFragment != null) {
	            ft.detach(mFragment);
	        }
	    }
	    public void onTabReselected(Tab tab, FragmentTransaction ft) {
	    	mFragment = null;
	    }
	}
	
	
	
	
}
