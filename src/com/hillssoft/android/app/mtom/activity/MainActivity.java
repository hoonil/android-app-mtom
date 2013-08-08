package com.hillssoft.android.app.mtom.activity;

import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.app.mtom.manager.HttpRequestManager;
import com.hillssoft.android.framework.log.Logger;
import com.hillssoft.android.framework.net.HttpResponse;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends BaseActivityManager {

	
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
	
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeMainTabMenu();
		initializeView();
		initializeSlidingMenu();
		setInitializeViewEventListener();
		
		
		
		
		setTestCode();
		
	}
	
	
	@Override
	protected void initializeActionBar() {
		super.initializeActionBar();
		self.getSupportActionBar().setTitle("Main Activity Title");
	}
	
	
	private void initializeMainTabMenu(){
		//self.getSupportActionBar().addTab("aaa")
	}
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_activity_main_activity);
		
	}
	
	
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
		
	}
	
	
	private void initializeSlidingMenu(){
//		slidingMenu = new SlidingMenu(self);
//		slidingMenu.setMode(SlidingMenu.LEFT);
//		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//		slidingMenu.setShadowWidth(20);
		
		//slidingMenu.setShadowDrawable(R.drawable.shadow_sliding_menu);
//		slidingMenu.setBehindOffsetRes(100);
//		slidingMenu.setFadeDegree(0.35f);
//		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
//		slidingMenu.setMenu(R.layout.left_menu);
//		getSupportFragmentManager().beginTransaction().replace(R.id.left_menu, new Le).commit();
	}
	
	
	
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuItem item = menu.add("HELP").setIcon(android.R.drawable.ic_menu_help);
        //MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        
        
        getMenuInflater().inflate(R.menu.global_default_menu, menu);
        return true;
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Logger.d(item.getTitle().toString());
		return super.onOptionsItemSelected(item);
	}
	
	
	
	
	
	
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
	
	private void setTestCode(){
		/*
		 * [ Set Test Object ]
		 */
		volleyTestMsg = (TextView)findViewById(R.id.volley_test_msg);
		volleyTestImg = (ImageView)findViewById(R.id.volley_test_img);
		volleyTestBtn = (Button)findViewById(R.id.volley_test_btn);
		
		uilTestBtn = (Button)findViewById(R.id.uil_test_btn);
		
		
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
