package com.hillssoft.framework.manager;

import java.util.UUID;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.framework.type.IDisposable;

public class UserManager implements IDisposable {
	
	private static UserManager instance;
	private SharedPreferenceManager defaultSharedPreference = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationDefaultSharedPreference();
	
	
	protected UserManager() {
		super();
	}
	
	public static UserManager getInstance(){
		if(instance == null){
			synchronized (UserManager.class) {
				instance = new UserManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
	
	
	public String getUserAnonymousSessionKey(){
		return defaultSharedPreference.getString(SharedPreferenceManager.KEY_ANONYMOUS_USER_SESSION_KEY, "");
	}
	
	public String getUserSessionKey(){
		return defaultSharedPreference.getString(SharedPreferenceManager.KEY_USER_SESSION_KEY, "");
	}
	
	public String getUserId(){
		return defaultSharedPreference.getString(SharedPreferenceManager.KEY_USER_ID, "");
	}
	
	public String getUserNickname(){
		return defaultSharedPreference.getString(SharedPreferenceManager.KEY_USER_NICKNAME, "");
	}
	
	public String getUUID(){
		return defaultSharedPreference.getString(SharedPreferenceManager.KEY_USER_UUID, "");
	}
	
	public String createNewUUID(){
		return UUID.randomUUID().toString();
	}
	
	
	
}

