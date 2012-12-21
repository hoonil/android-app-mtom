package com.hillssoft.mtom.sample.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlertReceiver extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		
		Log.e("AlertReceiver", "!!!!!!!!!!!!!!!!");
		Toast.makeText(context, "AlertReceiver Message", Toast.LENGTH_SHORT).show();
	}
}
