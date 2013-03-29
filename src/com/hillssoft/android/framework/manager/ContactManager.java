package com.hillssoft.android.framework.manager;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.base.BaseContact;
import com.hillssoft.android.framework.type.IDisposable;

public class ContactManager extends BaseContact implements IDisposable {
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static ContactManager instance;
	
	public ContactManager getInstance(){
		if(instance == null){
			synchronized (ContactManager.class) {
				instance = new ContactManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
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
