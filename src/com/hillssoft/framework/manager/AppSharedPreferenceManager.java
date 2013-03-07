package com.hillssoft.framework.manager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.framework.type.ValueMap;

public class AppSharedPreferenceManager {
	
	
	private boolean beginCommit = false;
	protected Context context;
	protected ValueMap<String, Object> cache;
	private SharedPreferences sharedPreference = null;
	private SharedPreferences.Editor sharedPreferenceEditor = null;
	

	public static final String KEY_IS_INITIALIZE_APPLICATION_COMPLETED = "is_initialize_application_completed";
	public static final String KEY_IS_INITIALIZE_APPLICATION_DEFAULT_CACHE_DATA = "is_initialize_application_default_cache_data";
	public static final String KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_SCHEMA = "is_initialize_application_default_db_schema";
	public static final String KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA = "is_initialize_application_default_user_data";
	public static final String KEY_IS_INITIALIZE_APPLICATION_USER_SESSION_DATA = "is_initialize_application_user_session_data";
	
	public static final String KEY_USER_SESSION_KEY = "user_session_key";
	public static final String KEY_USER_ID = "user_id";
	public static final String KEY_USER_NICKNAME = "user_nickname";
	
	
	
	
	
	public AppSharedPreferenceManager() {
		cache = new ValueMap<String, Object>(); 
		context = AppGlobalApplication.getAppGlobalApplicationContext();
		sharedPreference = context.getSharedPreferences(AppConf.APP_SHARD_PREFERENCE_DEFAULT_NAME, Context.MODE_PRIVATE);
		sharedPreferenceEditor = sharedPreference.edit();
	}
	
	public AppSharedPreferenceManager(String key) {
		cache = new ValueMap<String, Object>(); 
		context = AppGlobalApplication.getAppGlobalApplicationContext();
		sharedPreference = context.getSharedPreferences(key, Context.MODE_PRIVATE);
		sharedPreferenceEditor = sharedPreference.edit();
	}	


	protected Set<String> getProtectedKeySet() {
		return new HashSet<String>();
	}

	public void beginCommit() {
		beginCommit = true;
	}

	public void syncCommit() {
		getEditor().commit();
		beginCommit = false;
	}

	public void commitSharedPreference(String key, String value) {
		getEditor().putString(key, value);
		if (!beginCommit) {
			cache.put(key, value);
		} else {
			cache.remove(key);
		}
	}

	public String getString(String key, String defaultValue) {
		String value = cache.getString(key);
		if (value != null) {
			return value;
		}

		String result = sharedPreference.getString(key, defaultValue);
		cache.put(key, result);
		return result;
	}

	public void commitSharedPreference(String key, int value) {
		getEditor().putInt(key, value);
		if (!beginCommit) {
			sharedPreferenceEditor.commit();
			cache.put(key, value);
		} else {
			cache.remove(key);
		}
	}

	public int getInt(String key, int defaultValue) {
		if (cache.containsKey(key)) {
			return cache.getInt(key);
		}

		int result = sharedPreference.getInt(key, defaultValue);
		cache.put(key, result);
		return result;
	}

	public void commitSharedPreference(String key, boolean value) {
		getEditor().putBoolean(key, value);
		if (!beginCommit) {
			sharedPreferenceEditor.commit();
			cache.put(key, value);
		} else {
			cache.remove(key);
		}
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		if (cache.containsKey(key)) {
			return cache.getBoolean(key);
		}

		boolean result = sharedPreference.getBoolean(key, defaultValue);
		cache.put(key, result);
		return result;
	}

	public void commitSharedPreference(String key, long value) {
		getEditor().putLong(key, value);
		if (!beginCommit) {
			sharedPreferenceEditor.commit();
			cache.put(key, value);
		} else {
			cache.remove(key);
		}
	}

	public long getLong(String key, long defaultValue) {
		if (cache.containsKey(key)) {
			return cache.getLong(key);
		}

		long result = sharedPreference.getLong(key, defaultValue);
		cache.put(key, result);
		return result;
	}
	
	public void commitSharedPreference(String key, float value) {
		getEditor().putFloat(key, value);
		if (!beginCommit) {
			sharedPreferenceEditor.commit();
			cache.put(key, value);
		} else {
			cache.remove(key);
		}
	}

	public Float getFloat(String key, float defaultValue) {
		if (cache.containsKey(key)) {
			return cache.getFloat(key);
		}

		Float result = sharedPreference.getFloat(key, defaultValue);
		cache.put(key, result);
		return result;
	}
	
	public SharedPreferences getSharedPreferences() {
		return sharedPreference;
	}

	private SharedPreferences.Editor getEditor() {
		return sharedPreferenceEditor;
	}
	
	public void removeAllPreferences() {
		removeAllPreferences(false);
	}
	
	public void removeAllPreferences(boolean bExceptAccessToken) {
		Map<String, ?> map = getSharedPreferences().getAll();

		Iterator<String> it = map.keySet().iterator();
		String key = null;
		Set<String> set = getProtectedKeySet();
		while (it.hasNext()) {
			key = it.next();
			
			if (set.contains(key)) {
				continue;
			}
			getEditor().putString(key, null);
		}

		getEditor().commit();
		cache.clear();
	}
	
	
	
}
