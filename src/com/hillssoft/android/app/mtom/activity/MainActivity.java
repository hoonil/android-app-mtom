package com.hillssoft.android.app.mtom.activity;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.app.mtom.manager.HttpRequestManager;
import com.hillssoft.android.app.mtom.manager.IntentManager;
import com.hillssoft.android.app.mtom.manager.SoundManager;
import com.hillssoft.android.framework.log.Logger;
import com.hillssoft.android.framework.net.HttpResponse;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends BaseActivityManager implements OnNavigationListener {

	
	/*
	 * [ ActionBar & Tab　관련 ]
	 */
	
	
	private ActionBarDrawerToggle actionBarDrawerToggle = null;
	private DrawerLayout mainDrawerLayout = null;
	private LinearLayout mainLeftDrawerMenuLayout = null;
	private LinearLayout mainRightDrawerMenuLayout = null;
	
	
	/*
	 * [ Slid Menu ]
	 */
	private SlidingMenu slidingMenu = null;
	
	
	
	/**
	 * [ Define Fragment Variables ]
	 */
//	FragmentManager fragmentManager = getSupportFragmentManager();
//	Fragment lefMenuFragment = new LeftMenuFragment();
//	Fragment rightMenuFragment = new RightMenuFragment();
		
	
	
	
	/**
	 * [ Widget ]
	 */
	private final int viewPagerCount = 2;
	private ViewPager viewPager = null;
	private CirclePageIndicator viewPagerIndicator = null;
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//initializeMainTabMenu();
		overridePendingTransition(0, 0);
		initializeView();
		initializeSlidingMenu();
		setInitializeViewEventListener();
		
		
		
		
		Logger.d("Start Main");

		
		//setTestCode();

	}
	
	
	
	
	@Override
	protected void initializeActionBar() {
		super.initializeActionBar();
		actionBar = self.getSupportActionBar();
		actionBar.setDisplayOptions(	
				//ActionBar.DISPLAY_SHOW_HOME | 
				//ActionBar.DISPLAY_HOME_AS_UP | 
				//ActionBar.DISPLAY_USE_LOGO | 
				//ActionBar.DISPLAY_SHOW_TITLE | 
				ActionBar.DISPLAY_SHOW_CUSTOM
		);
		
		actionBarBackBtn.setVisibility(View.GONE);
		actionBarLeftMenuBtn.setVisibility(View.VISIBLE);
		actionBarLogo.setVisibility(View.GONE);
		actionBarTitle.setVisibility(View.VISIBLE);
		actionBarWriteBtn.setVisibility(View.VISIBLE);
		actionBarRefreshBtn.setVisibility(View.VISIBLE);
		actionBarRightMenuBtn.setVisibility(View.VISIBLE);
		
		
		/*
		 * [ Set ActionBar Event ]
		 */
		actionBarTitle.setOnClickListener(null);
		actionBarTitle.setOnTouchListener(null);
		
		
		

	}
	
	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		return false;
	}
	
	
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_activity_main_activity);
		
		/*
		 * [ ViewPager ]
		 */
		viewPager = (ViewPager)findViewById(R.id.view_pager);
		viewPager.setPageMargin(50);
		viewPager.setAdapter(new ViewPagerAdapter(self.getApplicationContext()));
		
		/*
		 * [ ViewPager Indicator ]
		 */
		viewPagerIndicator = new CirclePageIndicator(self.getApplicationContext());
		viewPagerIndicator = (CirclePageIndicator)findViewById(R.id.view_pager_indicator);
		viewPagerIndicator.setViewPager(viewPager);
		viewPagerIndicator.notifyDataSetChanged();
		viewPagerIndicator.setPageColor(Color.WHITE);
		viewPagerIndicator.setFillColor(Color.BLACK);
		viewPagerIndicator.setVisibility(View.VISIBLE);
		
	}
	
	@Override
	protected void setInitializeViewEventListener() {
		super.setInitializeViewEventListener();
	}
	
	
	private void initializeSlidingMenu(){		
		mainDrawerLayout = (DrawerLayout)findViewById(R.id.main_drawer_layout);
		mainLeftDrawerMenuLayout = (LinearLayout)findViewById(R.id.main_left_drawer_menu_layout);
		mainRightDrawerMenuLayout = (LinearLayout)findViewById(R.id.main_right_drawer_menu_layout);
//		actionBarDrawerToggle = new ActionBarDrawerToggle(self, mainDrawerLayout, R.drawable.ic_action_overflow, R.string.main_left_drawer_menu_open, R.string.main_left_drawer_menu_close){
//			@Override
//			public void onDrawerClosed(View drawerView) {
//				//super.onDrawerClosed(drawerView);
//			}
//			@Override
//			public void onDrawerOpened(View drawerView) {
//				//super.onDrawerOpened(drawerView);
//			}
//			@Override
//			public void onDrawerSlide(View drawerView, float slideOffset) {
//				//super.onDrawerSlide(drawerView, slideOffset);
//			}
//			@Override
//			public void onDrawerStateChanged(int newState) {
//				//super.onDrawerStateChanged(newState);
//			}
//			
//		};
		//mainDrawerLayout.setDrawerListener(actionBarDrawerToggle);
		mainDrawerLayout.setDrawerLockMode(DrawerLayout.STATE_IDLE);
		actionBarLogo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainDrawerLayout.closeDrawer(mainRightDrawerMenuLayout);
				if(mainDrawerLayout.isDrawerOpen(mainLeftDrawerMenuLayout)){
					mainDrawerLayout.closeDrawers();
				}else{
					mainDrawerLayout.openDrawer(mainLeftDrawerMenuLayout);
				}
				
			}
		});
		actionBarLeftMenuBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainDrawerLayout.closeDrawer(mainRightDrawerMenuLayout);
				if(mainDrawerLayout.isDrawerOpen(mainLeftDrawerMenuLayout)){
					mainDrawerLayout.closeDrawers();
				}else{
					mainDrawerLayout.openDrawer(mainLeftDrawerMenuLayout);
				}
				
			}
		});
		actionBarRightMenuBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mainDrawerLayout.closeDrawer(mainLeftDrawerMenuLayout);
				if(mainDrawerLayout.isDrawerOpen(mainRightDrawerMenuLayout)){
					mainDrawerLayout.closeDrawers();
				}else{
					mainDrawerLayout.openDrawer(mainRightDrawerMenuLayout);
				}
				
			}
		});
		
		
		mainDrawerLayout.setDrawerListener(new DrawerListener() {
			
			@Override
			public void onDrawerStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDrawerSlide(View arg0, float arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDrawerOpened(View view) {
				// TODO Auto-generated method stub
				if(view.equals(mainLeftDrawerMenuLayout)){
					Logger.i("Open Left Sliding Menu");
				}else if(view.equals(mainRightDrawerMenuLayout)){
					Logger.i("Open Right Sliding Menu");
				}
				
			}
			
			@Override
			public void onDrawerClosed(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setLeftSlidingMenu();
		setRightSlidingMenu();
	}
	
	
	
	private void setLeftSlidingMenu(){
		
		
		
		Button noticeBtn = (Button)findViewById(R.id.notice_btn);
		noticeBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new IntentManager().getNoticeIntent(self);
				startActivity(intent);
			}
		});
		
		
		
	}
	

	private void setRightSlidingMenu(){
		
	}

	
	
	
	///////////////////////////////////////////////////////////
	/////		[ View Pager ]
	///////////////////////////////////////////////////////////
	private class ViewPagerAdapter extends PagerAdapter{
        
        private LayoutInflater inflater;
 
        public ViewPagerAdapter(Context c){
            super();
            inflater = LayoutInflater.from(c);
        }
         
        @Override
        public int getCount() {
            return viewPagerCount;
        }
 
        @Override
        public Object instantiateItem(View pager, final int position) {
        	
        	View v = null;
        	
        	
        	/*
        	 * [ Set UI ]
        	 */
        	switch (position) {
				case 0:
					v = inflater.inflate(R.layout.mtom_activity_main_activity_main_layout_my_news_feed, null);
					final PullToRefreshListView listView = (PullToRefreshListView)v.findViewById(R.id.my_news_feed_list_view);
					listView.setOnRefreshListener(new OnRefreshListener<ListView>() {
						@Override
						public void onRefresh(PullToRefreshBase<ListView> refreshView) {
							int a = 1;
							int b = 2;
							listView.onRefreshComplete();
						}
					});
					
					
		        break;
				
				case 1:
					v = inflater.inflate(R.layout.mtom_activity_main_activity_main_layout_public_post, null);
		        break;

				default:
					
				break;
			}
		   
		   
		   ((ViewPager)pager).addView(v, 0); 
            return v; 
        }

        @Override
        public void destroyItem(View pager, int position, Object view) {    
            ((ViewPager)pager).removeView((View)view);
        }
         
        @Override
        public boolean isViewFromObject(View pager, Object obj) {
            return pager == obj; 
        }
 
        @Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}
        @Override public Parcelable saveState() { return null; }
        @Override public void startUpdate(View arg0) {}
        @Override public void finishUpdate(View arg0) {}
        public int getItemPosition(Object object) {return POSITION_NONE; }

    }
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************************************************************************
	 *****		[ Option Menu ] 
	 ******************************************************************************************/
//	@Override
//	protected void onPostCreate(Bundle savedInstanceState) {
//	    super.onPostCreate(savedInstanceState);
//	    actionBarDrawerToggle.syncState();
//	}
//	@Override
//	public void onConfigurationChanged(Configuration newConfig) {
//	    super.onConfigurationChanged(newConfig);
//	    actionBarDrawerToggle.onConfigurationChanged(newConfig);
//	}
//	
//	@Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //MenuItem item = menu.add("HELP").setIcon(android.R.drawable.ic_menu_help);
//        //MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
//        getMenuInflater().inflate(R.menu.global_default_menu, menu);
//        
//        /*
//         * [ Set ActionView - SearchView ]
//         */
//        SearchView searchView = null;
//        MenuItem menuItem = menu.findItem(R.id.menu_item_action_search);
//        
//        
//        //searchView = (SearchView) menuItem.getActionView();
//        
//        
//        return true;
//    }
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		
//		if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//			mainDrawerLayout.closeDrawer(mainRightDrawerMenuLayout);
//			if(mainDrawerLayout.isDrawerOpen(mainLeftDrawerMenuLayout)){
//				return false;
//			}else{
//				return true;
//			}
//	    }
//		
//	    return super.onOptionsItemSelected(item);
//	    
//	}
	
	
	
	
	
	
	
	/******************************************************************************************
	 *****		[ Test Code ] 
	 ******************************************************************************************/
	
	/*
	 * [ Test Object ]
	 */
	private Button volleyTestBtn = null;
	private TextView volleyTestMsg = null;
	private ImageView volleyTestImg = null;
	private Button uilTestBtn = null;
	private Button soundPlayBtn = null;
	private Button soundStopBtn = null;
	
	private void setTestCode(){
		/*
		 * [ Set Test Object ]
		 */
		volleyTestMsg = (TextView)findViewById(R.id.volley_test_msg);
		volleyTestImg = (ImageView)findViewById(R.id.volley_test_img);
		volleyTestBtn = (Button)findViewById(R.id.volley_test_btn);
		
		uilTestBtn = (Button)findViewById(R.id.uil_test_btn);
		
		
		soundPlayBtn = (Button)findViewById(R.id.sound_play_btn);
		soundStopBtn = (Button)findViewById(R.id.sound_stop_btn);
		
		
		
		//////////////////
		///
		/////////////////
		soundPlayBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				SoundManager.getInstance().playSound();
			}
		});
		
		soundStopBtn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				SoundManager.getInstance().stopSound();
			}
		});
		
		
		//HttpRequestManager.getInstance().addImageLoaderRequest("http://hoonil.codns.com/test.png", volleyTestImg, R.drawable.ic_launcher, R.drawable.ic_launcher);
		//HttpRequestManager.getInstance().addImageLoaderRequest("http://hoonil.codns.com/test.png", volleyTestImg, R.drawable.ic_launcher, R.drawable.ic_launcher);
		//HttpRequestManager.getInstance().addViewBackgroundImageLoaderRequest("http://hoonil.codns.com/hills_etc/images/korea/hills_member/skin_01/icon_home.gif", volleyTestBtn);
		
		
		//ImageLoaderManager.getInstance().
		
		
		
		
		/*
		 * [ ]
		 */
		volleyTestBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				
				Map<String, String> params = new HashMap<String, String>();
				params.put("aaaa", "111111111111111");
				params.put("bbbb", "222222222222222");
				
				
				
//				HttpResponse.Listener<JSONObject> successListener =  new HttpResponse.Listener<JSONObject>(){
//					@Override
//					public void onResponse(JSONObject response) {
//						LoggerManager.i("!!!!!!! OK !!!!!!");
//						LoggerManager.i(response.toString());
//						testMsg.setText(response.toString());
//					}
//				};
//				HttpResponse.ErrorListener errorListener = new HttpResponse.ErrorListener() {
//					@Override
//					public void onErrorResponse(VolleyError error) {
//						LoggerManager.i("ERROR");
//						LoggerManager.i(error.toString());
//					}
//				};
//				HttpRequestManager.getInstance().addJsonRequest(HttpRequestManager.POST, "http://hoonil.codns.com/app_mtom/index.php?t=11", params, successListener, errorListener);
				
				
				/*
				 * [ String Request ]
				 */
				HttpResponse.Listener<String> successListener =  new HttpResponse.Listener<String>(){
					@Override
					public void onResponse(String response) {
						Logger.i("!!!!!!! OK !!!!!!");
						Logger.i(response.toString());
						volleyTestMsg.setText(response.toString());
					}
				};
				HttpResponse.ErrorListener errorListener = new HttpResponse.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Logger.i("ERROR");
						Logger.i(error.toString());
					}
				};
				HttpRequestManager.getInstance().addStringRequest(HttpRequestManager.POST, "http://hoonil.codns.com/app_mtom/index.php?key=search", params, successListener, errorListener);
				
				
				
				/*
				 * [ Image Request ]
				 */
				HttpRequestManager.getInstance().addViewBackgroundImageLoaderRequest("http://hoonil.codns.com/5mb.png", volleyTestImg, getWindowManager());
				
				
			}
		});
		
		
		uilTestBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				HttpResponse.Listener<Bitmap> successListener =  new HttpResponse.Listener<Bitmap>(){
					@Override
					public void onResponse(Bitmap response) {
						Logger.i("!!!!!!! OK !!!!!!");
						Logger.i(response.toString());
					}
				};
				HttpResponse.ErrorListener errorListener = new HttpResponse.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Logger.i("ERROR");
						Logger.i(error.toString());
					}
				};
				
				HttpRequestManager.getInstance().addImageRequest("http://hoonil.codns.com/10mb.png", successListener, errorListener);
				
			}
		});
		
	}
		

	
	
	
	
	

}
