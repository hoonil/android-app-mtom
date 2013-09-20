package com.hillssoft.android.app.mtom.manager;

import android.content.Context;
import android.content.Intent;

import com.hillssoft.android.app.mtom.activity.MainActivity;
import com.hillssoft.android.app.mtom.activity.etc.NoticeActivity;
import com.hillssoft.android.app.mtom.activity.member.MemberRegisterActivity;
import com.hillssoft.android.app.mtom.activity.post.PostRegisterActivity;
import com.hillssoft.android.app.mtom.activity.post.PostViewActivity;
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
	
	public static Intent getPostRegisterIntent(Context context) {
		Intent intent = new Intent(context, PostRegisterActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	public static Intent getPostViewIntent(Context context) {
		Intent intent = new Intent(context, PostViewActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	public static Intent getNoticeIntent(Context context) {
		Intent intent = new Intent(context, NoticeActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
		return intent;
	}
	
	
	
	
}
