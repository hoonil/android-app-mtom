package com.hillssoft.mtom.sample;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import base.BaseActivity;

import com.hillssoft.mtom.R;

public class ViewObjectTestActivity extends BaseActivity {
	Button btn1;
	Button btn2;
	Button btn3;
	
	Button addBtn1;
	
	TextView txt1;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.activity_sample_view_object_test, menu);
		return true;
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_view_object_test);
		
		initializeView();
		setEventListener();
	}


	
	private void initializeView(){
		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		txt1 = (TextView)findViewById(R.id.subject_text_view);
		
		/*
		 * [ Set New Mark at TextView ]
		 */
		SpannableString spanStr = new SpannableString(txt1.getText() + "  ");
		Drawable draw = getResources().getDrawable(R.drawable.icon_new);
		draw.setBounds(0, 0, draw.getIntrinsicWidth(), draw.getIntrinsicHeight());
		ImageSpan imgNew = new ImageSpan(draw, ImageSpan.ALIGN_BASELINE);
		spanStr.setSpan(imgNew, spanStr.length()-1, spanStr.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		txt1.setText(spanStr);
		txt1.setTextSize(30);
		
		
		
		
		
	}
	
	private void setEventListener(){
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				btn3.setVisibility(View.GONE);
			}
		});
		
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}
