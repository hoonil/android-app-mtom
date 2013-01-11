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
		Log.d("!!!!!! StaticBroadcastReceiver", "!!!!!!!!!!!!!!!!");
		Toast.makeText(context, "!!! StaticBroadcastReceiver Message !!! "
								+ "\n Event Name : " + intent.getAction()
								+ "\n Package Name : " + context.getPackageName().toString(), Toast.LENGTH_SHORT).show();
		
		
		
	}
}
