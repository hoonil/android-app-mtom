package com.hillssoft.framework.manager;

import android.content.Context;
import android.content.Intent;

import com.hillssoft.app.IndexActivity;
import com.hillssoft.framework.base.BaseIntent;

public class IntentManager extends BaseIntent {
	
	
	
	public static Intent getMainIntent(Context context) {
		
		
		Intent intent = new Intent(context, IndexActivity.class);
		//intent.putExtra("KEY_CURRENT_INDEX", 0);
		//intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	
	
}
