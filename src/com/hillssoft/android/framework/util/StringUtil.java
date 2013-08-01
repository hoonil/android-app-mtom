package com.hillssoft.android.framework.util;



public class StringUtil{

	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0 || "null".equalsIgnoreCase(str));
	}
	
	public static boolean isEmpty(CharSequence charsequence) {
		if (charsequence == null) return true;
		
		return isEmpty(charsequence.toString());
	}
	
	public static boolean isNull(String str) {
		return (str == null || str.length() == 0);
	}
	
}
