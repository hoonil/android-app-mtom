package com.hillssoft.android.app.mtom.gcm;

import android.content.Context;

import com.google.android.gcm.GCMBroadcastReceiver;

public class GCMReceiver extends GCMBroadcastReceiver {
	@Override
	protected String getGCMIntentServiceClassName(Context context) {
		return GCMIntentService.class.getCanonicalName();
	}
}