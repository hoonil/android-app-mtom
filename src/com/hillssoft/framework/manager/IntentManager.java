package com.hillssoft.framework.manager;

import android.content.Context;
import android.content.Intent;

import com.hillssoft.app.mtom.MtomMainTab;
import com.hillssoft.app.mtom.activity.friend.FriendListActivity;
import com.hillssoft.framework.base.BaseIntent;

public class IntentManager extends BaseIntent {
	
	
	
	public static Intent getMainTabIntent(Context context) {
		//Intent intent = new Intent(context, IndexActivity.class);
		Intent intent = new Intent(context, MtomMainTab.class);
		intent.putExtra(StringKeyManager.KEY_CURRENT_TAB_INDEX, 0);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	public static Intent getFriendListIntent(Context context) {
		Intent intent = new Intent(context, FriendListActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	
	
}
