package com.hillssoft.framework.base;

import java.util.Hashtable;
import java.util.Map;

import android.os.Handler;


abstract public class BaseAppNotificationCenter implements IBaseObjectDisposable {
	
	public static final int NOTIFICATION = 0;
	
	
	
	
	/**
	 * [ Class Member Variables ]
	 */
	private Map<String, Map<Object, Handler>> notifications = new Hashtable<String, Map<Object, Handler>>();
	Handler myHandler;
	
	protected BaseAppNotificationCenter(){
		
	}
	
	public synchronized void register(String notificationKey, Object observer, Handler handler) {
		Map<Object, Handler> clients = notifications.get(notificationKey);
		if (clients == null) {
			clients = new Hashtable<Object, Handler>();
			notifications.put(notificationKey, clients);
		}
		//Logger.i(false, "[register] %s, %s", notificationKey, observer.getClass().getSimpleName());
		clients.put(observer, handler);
	}
	
	public synchronized void unregister(String notificationKey, Object observer) {
		Map<Object, Handler> clients = notifications.get(notificationKey);
		if(clients == null){
			return;
		}
		clients.remove(observer);
	}
	
	public void notify(String notificationKey) {
		notify(notificationKey, null);
	}
	
	public void notify(String notificationKey, Object data) {
		//propagateAll(notificationKey, data);
	}
	
//	private synchronized void propagateAll(String notificationKey, final Object data) {
//		final Map<Object, Handler> clients = notifications.get(notificationKey);
//		if(clients == null){
//			return;
//		}
//		
//		for (Handler handler : clients.values()) {
//			try {
//				handler.sendMessage(Message.obtain(handler, NOTIFICATION, data));
//			} catch (Exception e) {
//				//Logger.e(e);
//			}
//		}	
//
//		StringBuilder sb = new StringBuilder();
//		for (Object key : clients.keySet()) {
//			sb.append(key.getClass().getSimpleName()).append("(").append(key.hashCode()).append(")").append(", ");
//		}
//	}
	
}
