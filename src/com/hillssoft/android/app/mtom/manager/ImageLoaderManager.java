package com.hillssoft.android.app.mtom.manager;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.net.BaseHttpRequestManager;
import com.hillssoft.android.framework.type.IDisposable;

public class ImageLoaderManager extends BaseHttpRequestManager implements IDisposable {
	/*
	 * [ Set Sington Instance ]
	 */
	private static ImageLoaderManager instance;
	
	
	public static ImageLoaderManager getInstance(){
		if(instance == null){
			synchronized (ImageLoaderManager.class) {
				instance = new ImageLoaderManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	
	public void dispose() {
		instance = null;
	}
}
