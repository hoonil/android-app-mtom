package com.hillssoft.app.mtom;

import android.content.Intent;
import android.widget.TabHost;

import com.hillssoft.app.R;
import com.hillssoft.app.mtom.activity.chat.ChatRoomListActivity;
import com.hillssoft.app.mtom.activity.friend.FriendListActivity;
import com.hillssoft.app.mtom.activity.more.MoreListActivity;
import com.hillssoft.app.mtom.activity.myroom.NewsFeedActivity;
import com.hillssoft.app.mtom.activity.search.SearchActivity;
import com.hillssoft.framework.manager.BaseTabManager;

public class MtomMainTab extends BaseTabManager {

	
	@Override
	public void initializeTab() {
		final TabHost tab = getTabHost();;
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_news_feed_title)).setIndicator(getString(R.string.mtom_news_feed_title)).setContent(new Intent(this, NewsFeedActivity.class)));
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_friend_title)).setIndicator(getString(R.string.mtom_friend_title)).setContent(new Intent(this, FriendListActivity.class)));
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_search_title)).setIndicator(getString(R.string.mtom_search_title)).setContent(new Intent(this, SearchActivity.class)));
		tab.addTab(tab.newTabSpec(getString(R.string.mtom_more_title)).setIndicator(getString(R.string.mtom_more_title)).setContent(new Intent(this, MoreListActivity.class)));
	}

		 @Override
		public void setContentView(int layoutResID) {
			// TODO Auto-generated method stub
			super.setContentView(layoutResID);
		}
	
	
}
