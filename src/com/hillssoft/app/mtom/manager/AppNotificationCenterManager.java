package com.hillssoft.app.mtom.manager;

import com.hillssoft.framework.base.BaseAppNotificationCenter;

public class AppNotificationCenterManager extends BaseAppNotificationCenter {
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static AppNotificationCenterManager instance = null;
	
	public static AppNotificationCenterManager getInstance(){
		if(instance == null){
			synchronized (AppNotificationCenterManager.class) {
				instance = new AppNotificationCenterManager();
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
	/******************************************************************
	 ******************************************************************/
	
	
	
	
	
}
