package com.hillssoft.app.mtom.manager;

import com.hillssoft.framework.base.BaseApp;

public class AppManager extends BaseApp {
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static AppManager instance;
	
	public AppManager getInstance(){
		if(instance == null){
			synchronized (AppManager.class) {
				instance = new AppManager();
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
