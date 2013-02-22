package com.hillssoft.app.mtom.manager;

import com.hillssoft.framework.base.BaseContact;

public class ContactManager extends BaseContact {
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static ContactManager instance;
	
	public ContactManager getInstance(){
		if(instance == null){
			synchronized (ContactManager.class) {
				instance = new ContactManager();
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
