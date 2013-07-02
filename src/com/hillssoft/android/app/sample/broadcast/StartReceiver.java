package com.hillssoft.android.app.sample.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class StartReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
//		Log.d("!!!!!! StartReceiver", "StartReceiver");
//		Toast.makeText(context, "!!! StartReceiver Message !!! "
//								+ "\n Event Name : " + intent.getAction()
//								+ "\n Package Name : " + context.getPackageName().toString(), Toast.LENGTH_SHORT).show();

		
		Toast.makeText(context, "!!! StartReceiver Message !!! ", Toast.LENGTH_SHORT).show();

		
	}
}
