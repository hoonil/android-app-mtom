package com.hillssoft.mtom.sample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import base.BaseActivity;

import com.hillssoft.mtom.R;

public class ActivityOpenActivity extends BaseActivity {

	TextView txt1;
	Button btn1;
	Button btn2;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_activity_open);
		initializeView();
		initializeBindService();
		setInitializeViewEventListener();
	}

	
	protected void initializeView(){
		txt1 = (TextView)findViewById(R.id.txt1);
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		
		txt1.setText(Integer.toString(PackageManager.GET_ACTIVITIES));
	}
	
	protected void setInitializeViewEventListener(){
		btn1.setOnClickListener(new Btn1Event());
		btn2.setOnClickListener(new Btn2Event());
		
	}
	
	
	
	private class Btn1Event implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(ActivityOpenActivity.this, ActivityOpenSubActivity.class);
			startActivity(intent);
			
			//ComponentName cn = new ComponentName("jp.naver.line.android", "jp.naver.line.android");
			//Intent intent = new Intent();
			//intent.setComponent(cn);
			//startActivity(intent);
			
			
			
		}
	}
	
	private class Btn2Event implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			final String packageName = "jp.naver.line.android";
			Intent checkIntent = getPackageManager().getLaunchIntentForPackage(packageName);
			if(checkIntent == null){
				return;
			}
			
			Intent intent = new Intent();
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.setAction(Intent.ACTION_SEND);
			intent.setType("text/plain");
			intent.setPackage(packageName);
			intent.putExtra(Intent.EXTRA_TEXT, "KaKaoTalk Download \n" +
					"https://play.google.com/store/apps/details?id=com.kakao.talk");
			startActivity(intent);

			
			
		}
	}
	
	
	
}
