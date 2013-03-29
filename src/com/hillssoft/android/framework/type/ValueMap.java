package com.hillssoft.android.framework.type;

import java.util.HashMap;
import java.util.Map;

public class ValueMap<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = 2641814577596644354L;

	public ValueMap() {
		super();
	}

	public ValueMap(int capacity, float loadFactor) {
		super(capacity, loadFactor);
	}

	public ValueMap(int capacity) {
		super(capacity);
	}

	public ValueMap(Map<? extends K, ? extends V> map) {
		super(map);
	}

	public final boolean getBoolean(final String key) {
		return Boolean.valueOf(getString(key));
	}
	
	public final boolean getBoolean(final String key, boolean defaultValue) {
		return Boolean.valueOf(getString(key, defaultValue));
	}

	public final double getDouble(final String key) {
		return Double.valueOf(getString(key));
	}
	
	public final double getDouble(final String key, double defaultValue) {
		return Double.valueOf(getString(key, defaultValue));
	}

	public final int getInt(final String key) {
		return Integer.valueOf(getString(key));
	}
	
	public final int getInt(final String key, int defaultValue) {
		return Integer.valueOf(getString(key, defaultValue));
	}

	public final long getLong(final String key) {
		return Long.valueOf(getString(key));
	}

	public final long getLong(final String key, long defaultValue) {
		return Long.valueOf(getString(key, defaultValue));
	}
	
	public final float getFloat(final String key) {
		return Float.valueOf(getString(key));
	}

	public final float getFloat(final String key, float defaultValue) {
		return Float.valueOf(getString(key, defaultValue));
	}
		
	public final String getString(final String key, final Object defaultValue) {
		final String value = getString(key);
		return value != null ? value : 
			defaultValue != null ? String.valueOf(defaultValue) : null;
	}

	public final String getString(final String key) {
		final Object value = get(key);
		return value == null ? null : String.valueOf(value);
	}

}

