package com.hillssoft.android.framework.base;

import java.util.HashMap;

public interface IBaseDBQuery {
	public static enum QueryKey{};
	abstract public String getQuery(QueryKey key);
	abstract public String getQuery(QueryKey key, HashMap<String, String> params);
}
