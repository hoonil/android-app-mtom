package com.hillssoft.android.app.mtom.activity;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.hillssoft.android.app.mtom.R;
import com.hillssoft.android.app.mtom.manager.BaseActivityManager;
import com.hillssoft.android.app.mtom.net.HttpRequestManager;
import com.hillssoft.android.framework.log.Logger;
import com.hillssoft.android.framework.net.HttpResponse;

public class MainActivity extends BaseActivityManager {

	
	/**
	 * [ Define Fragment Variables ]
	 */
//	FragmentManager fragmentManager = getSupportFragmentManager();
//	Fragment lefMenuFragment = new LeftMenuFragment();
//	Fragment rightMenuFragment = new RightMenuFragment();
		
	public static Activity meActivity = null;
	
	
	
	/**
	 * [ Widget ]
	 */
	boolean isMenuOpen = false;
	
	
	/*
	 * [ Test Object ]
	 */
	private Button volleyTestBtn = null;
	private TextView volleyTestMsg = null;
	private ImageView volleyTestImg = null;
	
	
	
	private Button uilTestBtn = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeView();
		setInitializeViewEventListener();
		meActivity = self;
		
	}
	
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_activity_main_activity);
		
		/*
		 * [ Set Test Object ]
		 */
		volleyTestMsg = (TextView)findViewById(R.id.volley_test_msg);
		volleyTestImg = (ImageView)findViewById(R.id.volley_test_img);
		volleyTestBtn = (Button)findViewById(R.id.volley_test_btn);
		
		uilTestBtn = (Button)findViewById(R.id.uil_test_btn);
		
		
		HttpRequestManager.getInstance().addImageLoaderRequest("http://hoonil.codns.com/hills_etc/images/korea/hills_member/skin_01/icon_home.gif", volleyTestImg, R.drawable.ic_launcher, R.drawable.ic_launcher);
		HttpRequestManager.getInstance().addImageLoaderRequest("http://hoonil.codns.com/hills_etc/images/korea/hills_member/skin_01/icon_home.gif", volleyTestImg, R.drawable.ic_launcher, R.drawable.ic_launcher);
		//HttpRequestManager.getInstance().addViewBackgroundImageLoaderRequest("http://hoonil.codns.com/hills_etc/images/korea/hills_member/skin_01/icon_home.gif", volleyTestBtn);
		
	}
	
	
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
		
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
				HttpRequestManager.getInstance().addImageLoaderRequest("http://hoonil.codns.com/hills_etc/images/korea/hills_admin/skin_01/bullet2.gif", volleyTestImg, R.drawable.ic_launcher, R.drawable.ic_launcher);
				
				
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
				
				HttpRequestManager.getInstance().addImageRequest("http://hoonil.codns.com/hills_etc/images/korea/hills_admin/skin_01/bullet2.gif", successListener, errorListener);
				
			}
		});
		
		
	}
		
		


}
