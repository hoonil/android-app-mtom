package com.hillssoft.app.sample.view;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.hillssoft.app.R;
import com.hillssoft.framework.manager.BaseActivityManager;

public class ListViewActivity extends BaseActivityManager {

	Button btn1;
	ListView listView1;
	
	ArrayList<String> dataArrayList;
	ArrayAdapter<CharSequence> dataArrayListAdapter;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	protected void initializeView(){
		
		super.initializeView();
		setContentView(R.layout.sample_view_list_view_activity);
		
		/*
		 * [Set View]
		 */
		btn1 = (Button)findViewById(R.id.btn1);
		listView1 = (ListView)findViewById(R.id.listView1);
		
		
		/*
		 * [Set Adapter ]
		 */
		dataArrayListAdapter = ArrayAdapter.createFromResource(this, R.array.location, R.layout.sample_view_list_view_activity_list_view_item);
		
		//listView1.setChoiceMode(listView1.CHOICE_MODE_SINGLE);
		listView1.setAdapter(dataArrayListAdapter);
		
		
		
	}

	
	
	
	@Override
	protected void setInitializeViewEventListener() {
		super.setInitializeViewEventListener();
		
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				/*
				 * [Set ListView]
				 */
				
				//listView1.setDivider(new ColorDrawable(Color.BLACK));
				//listView1.setDividerHeight(20);
				
			}
		});
	}
	
	
	
	
	

}
