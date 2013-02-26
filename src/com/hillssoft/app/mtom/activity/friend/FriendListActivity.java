package com.hillssoft.app.mtom.activity.friend;

import java.util.HashMap;
import java.util.List;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.hillssoft.app.R;
import com.hillssoft.framework.manager.BaseActivityManager;
import com.hillssoft.framework.manager.ContactManager;

public class FriendListActivity extends BaseActivityManager{
	
	private ExpandableListView friendListView;
	private TextView txt;
	private Button btn;
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
		btn = (Button)findViewById(R.id.btn);
		
		
		/*
		 * []
		 */
		
		
		/*
		 * [ Get Address List ]
		 */
		addressList = new ContactManager().getInstance().getAddressList(getApplicationContext());
		
		
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
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				AudioManager ad = (AudioManager)getSystemService(AUDIO_SERVICE);
//				ad.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);	
				
//				Vibrator vr = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
//				vr.vibrate(1000);
				
				SoundPool soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
				int soundBeep = soundPool.load(getApplicationContext(), R.raw.sample, 1);
				soundPool.play( soundBeep, 1f, 1f, 0, 0, 1f );
				
			}
		});
	}
}






