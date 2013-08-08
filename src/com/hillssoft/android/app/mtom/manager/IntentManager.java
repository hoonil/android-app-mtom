package com.hillssoft.android.app.mtom.manager;

import android.content.Context;
import android.content.Intent;

import com.hillssoft.android.app.mtom.activity.MainActivity;
import com.hillssoft.android.app.mtom.activity.auth.MemberRegisterActivity;
import com.hillssoft.android.app.mtom.activity.friend.FriendListActivity;
import com.hillssoft.android.framework.base.BaseIntent;

public class IntentManager extends BaseIntent {
	
	public static Intent getMainIntent(Context context) {
		Intent intent = new Intent(context, MainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}

	public static Intent getAuthMemberRegister(Context context) {
		Intent intent = new Intent(context, MemberRegisterActivity.class);
		//intent.putExtra(StringKeyManager.KEY_CURRENT_TAB_INDEX, 0);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	
	public static Intent getFriendListIntent(Context context) {
		Intent intent = new Intent(context, FriendListActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	
	
}