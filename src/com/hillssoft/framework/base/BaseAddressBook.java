package com.hillssoft.framework.base;

import java.util.List;

import android.content.ContentResolver;
import android.content.Context;

public class BaseAddressBook {
	
	private static BaseAddressBook instance;
	private static List<String> addressList;
	
	static public BaseAddressBook getInstance(){
		
		if(instance == null){
			synchronized (BaseAddressBook.class) {
				try{
					instance = new BaseAddressBook();
				}catch(Exception e){
					
				}
			}
		}
		return instance;
	}
	
	
	public List getAddressList(Context context){
		ContentResolver cr = context.getContentResolver(); 
		
		return addressList;
	}
	
	
	
	
}





