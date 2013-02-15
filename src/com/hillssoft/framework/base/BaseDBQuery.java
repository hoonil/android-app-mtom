package com.hillssoft.framework.base;

import java.util.HashMap;


abstract class BaseDBQuery implements IBaseDBQuery {
	
	public static enum QueryKey{};
	abstract public String getQuery(QueryKey key);
	abstract public String getQuery(QueryKey key, HashMap<String, String> params);
}
