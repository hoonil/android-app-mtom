package com.hillssoft.android.framework.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

abstract public class BaseContact {
	
	private List<HashMap> addressList;
	private HashMap<String, String> addressObject;
	private ContentResolver contentResolver;
	private Cursor addressListCursor;
	private Cursor phoneNumberListCursor;
	
	
	
	
	protected BaseContact() {
		// TODO Auto-generated constructor stub
		addressList = new ArrayList();
		addressObject = new HashMap<String, String>();
	}
	
	
	public List<HashMap> getAddressList(Context context){
		contentResolver = context.getContentResolver();
		addressListCursor = contentResolver.query(	ContactsContract.Contacts.CONTENT_URI, 
										null, 
										null, 
										null, 
										"DISPLAY_NAME ASC"); 
		
		int idxForAddressId = addressListCursor.getColumnIndex(ContactsContract.Contacts._ID);
		int idxForName = addressListCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
		 
		
		// Set Return Object for address list
		while(addressListCursor.moveToNext()){
			addressObject.clear();
			
			/*
			 * [ Get Display Name ]
			 */
			String name = addressListCursor.getString(idxForName);
			String phoneNumber = "";
			
			/*
			 * [Get Phone Number]
			 */
			String idxForAddressIdStr = addressListCursor.getString(idxForAddressId);
			phoneNumberListCursor = contentResolver.query(	
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, 
					null, 
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", 
					new String[]{idxForAddressIdStr}, 
					null);
			
			int idxForPhoneType = phoneNumberListCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);
			int idxForPhoneNumber = phoneNumberListCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
			
			while(phoneNumberListCursor.moveToNext()){
				if(phoneNumberListCursor.getInt(idxForPhoneType) == ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE){
					phoneNumber = phoneNumberListCursor.getString(idxForPhoneNumber);
					continue;
				}else{
					phoneNumber = "";
				}
			}
			
			/*
			 * [ Set Object ]
			 */
			addressObject.put(name, phoneNumber);
			addressList.add((HashMap)addressObject.clone());
		}
		phoneNumberListCursor.close();
		addressListCursor.close();
		
		
		return addressList;
		
		
		
	}
	
	
	/////////////////////////////////
	public class ContractType{
		private long id;
		private String name;
		private String phoneNumber;
		private String rawPhoneNumber;
		private String email;
		private String country;
		private String phoneticName;
	}
	/////////////////////////////////
	
	
	
	
	
}





