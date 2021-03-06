package com.hillssoft.android.app.mtom.manager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.framework.type.ValueMap;

public class SharedPreferenceManager {
	
	
	private boolean beginCommit = false;
	protected Context context;
	protected ValueMap<String, Object> cache;
	private SharedPreferences sharedPreference = null;
	private SharedPreferences.Editor sharedPreferenceEditor = null;
	

	public static final String KEY_IS_INITIALIZE_APPLICATION_DEFAULT_DB_DATA = "is_initialize_application_default_db_schema";
	public static final String KEY_IS_INITIALIZE_APPLICATION_DEFAULT_USER_DATA = "is_initialize_application_default_user_data";
	public static final String KEY_IS_INITIALIZE_APPLICATION_USER_UUID = "is_initialize_application_user_uuid";
	public static final String KEY_IS_INITIALIZE_APPLICATION_USER_SESSION_KEY = "is_initialize_application_user_session_key";
	public static final String KEY_IS_INITIALIZE_APPLICATION_USER_ID = "is_initialize_application_user_id";
	
	public static final String KEY_IS_INITIALIZE_APPLICATION_COMPLETED = "is_initialize_application_completed";
	
	public static final String KEY_USER_UUID = "uuid";
	public static final String KEY_USER_SESSION_KEY = "user_session_key";
	public static final String KEY_USER_ID = "user_id";
	public static final String KEY_USER_NICKNAME = "user_nickname";
	
	
	
	public SharedPreferenceManager() {
		cache = new ValueMap<String, Object>(); 
		context = AppGlobalApplication.getAppGlobalApplicationContext();
		sharedPreference = context.getSharedPreferences(AppConf.APP_SHARD_PREFERENCE_DEFAULT_NAME, Context.MODE_PRIVATE);
		sharedPreferenceEditor = sharedPreference.edit();
	}
	
	public SharedPreferenceManager(String key) {
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
		getSharedPreferencesEditor().commit();
		beginCommit = false;
	}

	public void commitSharedPreference(String key, String value) {
		getSharedPreferencesEditor().putString(key, value);
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
		getSharedPreferencesEditor().putInt(key, value);
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
		getSharedPreferencesEditor().putBoolean(key, value);
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
		getSharedPreferencesEditor().putLong(key, value);
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
		getSharedPreferencesEditor().putFloat(key, value);
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

	private SharedPreferences.Editor getSharedPreferencesEditor() {
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
			getSharedPreferencesEditor().putString(key, null);
		}

		getSharedPreferencesEditor().commit();
		cache.clear();
	}
	
	
	
}
