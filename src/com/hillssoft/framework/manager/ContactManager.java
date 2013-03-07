package com.hillssoft.framework.manager;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.framework.base.BaseContact;
import com.hillssoft.framework.type.IDisposable;

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
