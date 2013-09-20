package com.hillssoft.android.app.mtom.gcm;

import java.util.Iterator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gcm.GCMBaseIntentService;
import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.framework.log.Logger;

public class GCMIntentService extends GCMBaseIntentService {

	public GCMIntentService() {
		super(AppConf.APP_GCM_SENDER_ID);
		//Logger.d("!!!!! Called GCMIntentService !!!!!");	
		//Logger.d("-------------------------------------------------------------------------");	
		
	}
	
	@Override
	protected void onMessage(Context context, Intent intent) {
		Logger.d("Called GCM onMessage");
		
		Bundle bundle = intent.getExtras();

        Iterator<String> iterator = bundle.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            String value = bundle.get(key).toString();
            Logger.d("onMessage. "+ key +" : " + value);
        }
		
	}
	
	@Override
	protected void onError(Context context, String arg1) {
		Logger.d("Called GCM onError");
	}
	
	@Override
	protected void onRegistered(Context context, String arg1) {
		Logger.d("Called GCM onRegistered");
	}
	
	@Override
	protected void onUnregistered(Context context, String arg1) {
		Logger.d("Called GCM onUnregistered");
	}
}
