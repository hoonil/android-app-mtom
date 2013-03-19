package com.hillssoft.framework.manager;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.framework.type.IDisposable;

public class HttpConnectionManager implements IDisposable {
	
	
	/*
	 * [ Define Object ]
	 */
	private static HttpConnectionManager instance;
	
	
	/*
	 * [ Enum ]
	 */
	
	
	
	
	
	public HttpConnectionManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static HttpConnectionManager getInstance(){
		if(instance == null){
			synchronized (AppManager.class) {
				instance = new HttpConnectionManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
	
	
	

	public String doGet(String url){
		
		
		return "";
	}
	
	
	public String doPost(String url){
		
		
		return "";
	}
	
	
	
	
}
