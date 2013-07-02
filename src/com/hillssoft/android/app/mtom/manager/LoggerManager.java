package com.hillssoft.android.app.mtom.manager;

import java.util.List;

import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;

import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.framework.type.LimitedLinkedList;

public class LoggerManager {

	public static final String DEFAULT_TAG = AppConf.APP_TAG;
	public static final int DEV = 0;
	
	public static final List<LogInfo> memoryLogs = new LimitedLinkedList<LogInfo>(AppConf.LOGGER_LOG_MEMORY_SIZE);
	
	
	public static class LogInfo {
		public long date;
		public int logLevel;
		public String message;

		public LogInfo(long date, int logLevel, String message) {
			this.date = date;
			this.logLevel = logLevel;
			this.message = message;
		}

		@Override
		public String toString() {
			return String.format("%s %s %s", DateFormat.format("MM-dd kk:mm:ss", date), LoggerManager.toSimpleStringLogLevel(logLevel), message);
		}
	}

	
	//private BaseLogger() {
	//}

	public static List<LogInfo> getMemoryLogs() {
		return memoryLogs;
	}

	public static String toSimpleStringLogLevel(int level) {
		switch (level) {
		case DEV:
			return "DEV";
		case Log.VERBOSE:
			return "V";
		case Log.DEBUG:
			return "D";
		case Log.INFO:
			return "I";
		case Log.WARN:
			return "W";
		case Log.ERROR:
			return "E";
		case Log.ASSERT:
			return "A";
		}

		return "NONE";
	}

	public static boolean isLoggable(int level) {
		return (level >= AppConf.LOGGER_LOG_LEVEL);
	}

	private static String getTraceInfo() {
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
		return getTraceInfo(stacks);
	}
	
	public static String getTraceInfo(StackTraceElement[] stacks) {
		StackTraceElement stack = null;
		String loggerName = LoggerManager.class.getCanonicalName();

		for (int i = 0; i < stacks.length; i++) {
			if (!stacks[i].getClassName().startsWith(loggerName) && stacks[i].getClassName().startsWith(AppConf.LOGGER_TRACE_PREFIX_PACKAGE_NAME)) {
				stack = stacks[i];
				break;
			}
		}

		if (stack == null) {
			return null;
		}

		//String klass = stack.getFileName().replace(".java", "");
		String klass = stack.getClassName();
		String method = stack.getMethodName();
		int line = stack.getLineNumber();
		return String.format("%s.%s():%d", klass, method, line);
	}

	private static String getMessageWithTrace(String message) {
		return String.format("[%s] %s", getTraceInfo(), message);
	}

	private static void putMemoryLog(int logLevel, String message) {
		if (logLevel >= AppConf.LOGGER_LOG_MEMORY_LEVEL || (AppConf.LOGGER_IS_DEBUGGABLE && logLevel == DEV)) {
			LogInfo logInfo = new LogInfo(System.currentTimeMillis(), logLevel, message);
			memoryLogs.add(logInfo);
		}
	}

	private static int printLog(int logLevel, boolean withStack, String msg) {
		if (!isLoggable(logLevel) || AppConf.LOGGER_DEBUG_TRACE == false ) {
			return 0;
		}
		
		String message = withStack ? getMessageWithTrace(msg) : msg;
		putMemoryLog(logLevel, message);

		switch (logLevel) {
		case DEV:
			return Log.d(DEFAULT_TAG, message);
		case Log.VERBOSE:
			return Log.v(DEFAULT_TAG, message);
		case Log.DEBUG:
			return Log.d(DEFAULT_TAG, message);
		case Log.INFO:
			return Log.i(DEFAULT_TAG, message);
		case Log.WARN:
			return Log.w(DEFAULT_TAG, message);
		case Log.ERROR:
			return Log.e(DEFAULT_TAG, message);
		case Log.ASSERT:
		default:
			return 0;
		}
	}

	public static int v(String format, Object... args) {
		return v(true, format, args);
	}

	public static int v(boolean withStack, String format, Object... args) {
		if (isLoggable(Log.VERBOSE)) {
			String message = String.format(format, args);
			return v(withStack, message);
		} else
			return 0;
	}

	public static int v(String msg) {
		return v(true, msg);
	}

	public static int v(Throwable tr) {
		return v(getStackTraceString(tr));
	}

	public static int v(String msg, Throwable tr) {
		return v("%s\n%s", msg, getStackTraceString(tr));
	}

	public static int v(boolean withStack, String msg) {
		return printLog(Log.VERBOSE, withStack, msg);
	}

	public static int d(String format, Object... args) {
		return d(true, format, args);
	}

	public static int d(boolean withStack, String format, Object... args) {
		if (isLoggable(Log.DEBUG)) {
			String message = String.format(format, args);
			return d(withStack, message);
		} else
			return 0;
	}

	public static int d(String msg) {
		return d(true, msg);
	}

	public static int d(Throwable tr) {
		return d(getStackTraceString(tr));
	}

	public static int d(String msg, Throwable tr) {
		return d("%s\n%s", msg, getStackTraceString(tr));
	}

	public static int d(boolean withStack, String msg) {
		return printLog(Log.DEBUG, withStack, msg);
	}

	public static int i(String format, Object... args) {
		return i(true, format, args);
	}

	public static int i(boolean withStack, String format, Object... args) {
		if (isLoggable(Log.INFO)) {
			String message = String.format(format, args);
			return i(withStack, message);
		} else
			return 0;
	}

	public static int i(String msg) {
		return i(true, msg);
	}

	public static int i(Throwable tr) {
		return i(getStackTraceString(tr));
	}

	public static int i(String msg, Throwable tr) {
		return i("%s\n%s", msg, getStackTraceString(tr));
	}

	public static int i(boolean withStack, String msg) {
		return printLog(Log.INFO, withStack, msg);
	}

	public static int w(String format, Object... args) {
		return w(true, format, args);
	}

	public static int w(boolean withStack, String format, Object... args) {
		if (isLoggable(Log.WARN)) {
			String message = String.format(format, args);
			return w(withStack, message);
		} else
			return 0;
	}

	public static int w(String msg) {
		return w(true, msg);
	}

	public static int w(Throwable tr) {
		return w(getStackTraceString(tr));
	}

	public static int w(String msg, Throwable tr) {
		return w("%s\n%s", msg, getStackTraceString(tr));
	}

	public static int w(boolean withStack, String msg) {
		return printLog(Log.WARN, withStack, msg);
	}

	public static int e(String format, Object... args) {
		return e(true, format, args);
	}

	public static int e(boolean withStack, String format, Object... args) {
		if (isLoggable(Log.ERROR)) {
			String message = String.format(format, args);
			return e(withStack, message);
		} else
			return 0;
	}

	public static int e(String msg) {
		return e(true, msg);
	}

	public static int e(Throwable tr) {
		return e(getStackTraceString(tr));
	}

	public static int e(String msg, Throwable tr) {
		return e("%s\n%s", msg, getStackTraceString(tr));
	}

	public static int e(boolean withStack, String msg) {
		return printLog(Log.ERROR, withStack, msg);
	}

	public static int dev(String format, Object... args) {
		return dev(true, format, args);
	}

	public static int dev(boolean withStack, String format, Object... args) {
		if (isLoggable(DEV)) {
			String message = String.format(format, args);
			return dev(withStack, message);
		} else
			return 0;
	}

	public static int dev(String msg) {
		return dev(true, msg);
	}

	public static int dev(Throwable tr) {
		return dev(getStackTraceString(tr));
	}

	public static int dev(String msg, Throwable tr) {
		return dev("%s\n%s", msg, getStackTraceString(tr));
	}

	public static int dev(boolean withStack, String msg) {
		return printLog(DEV, withStack, msg);
	}

	public static String getStackTraceString(Throwable tr) {
		return Log.getStackTraceString(tr);
	}

	public static int println(int priority, String msg) {
		return Log.println(priority, DEFAULT_TAG, msg);
	}
	
	public static String getArrayPrintString(Object [] objects) {
		if (objects == null) return null;
		return TextUtils.join(", ", objects);
	}
	
	
}


