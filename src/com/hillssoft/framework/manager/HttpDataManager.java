package com.hillssoft.framework.manager;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.framework.type.IDisposable;

public class HttpDataManager implements IDisposable {

	
	private static HttpDataManager instance;
	private Thread thread;
	
	
	public HttpDataManager() {
		thread = new Thread("HttpDataManager-Thread");
	}
	
	
	public static HttpDataManager getInstance(){
		
		if(instance == null){
			instance = new HttpDataManager();
			AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
		}
		
		return instance;
	}
	
	@Override
	public void dispose() {
		instance = null;
	}
	
	
	
	
	
	
	
}
