package com.hillssoft.android.app.sample.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hillssoft.android.R;
import com.hillssoft.android.framework.manager.BaseActivityManager;

public class ViewObjectActivity extends BaseActivityManager {
	
	Button btn1;
	Button btn2;
	Button btn3;
	
	Button addBtn1;
	
	TextView txt1;
	EditText edit1; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState); 
		
		outState.putString("edit1", edit1.getText().toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		
		/*
		 * [Data Restore]]
		 */
		if(savedInstanceState != null){
			edit1.setText(savedInstanceState.getString("edit1"));
		}
		
	}
	
	
	
	protected void initializeView(){
		super.initializeView();
		setContentView(R.layout.sample_view_view_object_activity);
		

		btn1 = (Button)findViewById(R.id.btn1);
		btn2 = (Button)findViewById(R.id.btn2);
		btn3 = (Button)findViewById(R.id.btn3);
		txt1 = (TextView)findViewById(R.id.subject_text_view);
		edit1 = (EditText)findViewById(R.id.edit_text1);
		
		
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
		
		
		/*
		 * [ Date Restore ]
		 */
		edit1.setSaveEnabled(false);
		edit1.setText("TEST DATA - Default");
		
		
		
	}
	
	protected void setInitializeViewEventListener(){
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
