package com.hillssoft.android.app.mtom.manager;

import java.util.Map;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.net.BaseHttpRequestManager;
import com.hillssoft.android.framework.type.IDisposable;

public class HttpRequestManager extends BaseHttpRequestManager implements IDisposable {
	
	/*
	 * [ Set Sington Instance ]
	 */
	private static HttpRequestManager instance;
	
	
	public static HttpRequestManager getInstance(){
		if(instance == null){
			synchronized (HttpRequestManager.class) {
				instance = new HttpRequestManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	
	public void dispose() {
		instance = null;
	}
	
	
	
	protected Map<String,String> getHttpRequestHeaders() {
		return super.getHttpRequestHeaders();
	};
}
