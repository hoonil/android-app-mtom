package com.hillssoft.framework.manager;

import java.util.Hashtable;
import java.util.Map;

import android.os.Handler;
import android.os.Message;

import com.hillssoft.framework.base.BaseAppNotificationCenter;

public class AppNotificationCenterManager extends BaseAppNotificationCenter {
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	/**
	 * [ Class Member Variables ]
	 */
	private static AppNotificationCenterManager instance = null;
	private Map<String, Map<Object, Handler>> notifications = new Hashtable<String, Map<Object, Handler>>();
	
	
	public static final int NOTIFICATION = 0;
	
	
	
	protected AppNotificationCenterManager(){
		
	}
	
	public static AppNotificationCenterManager getInstance(){
		if(instance == null){
			synchronized (AppNotificationCenterManager.class) {
				instance = new AppNotificationCenterManager();
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
	
	
	
	
	
	/**
	 * [  ]
	 * @param notificationKey
	 * @param observer
	 * @param handler
	 */
	public synchronized void register(String notificationKey, Object observer, Handler handler) {
		Map<Object, Handler> clients = notifications.get(notificationKey);
		if (clients == null) {
			clients = new Hashtable<Object, Handler>();
			notifications.put(notificationKey, clients);
		}
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
		
		LoggerManager.i("!!!!! Called notify !!!!! - " + notificationKey.toString());
		notify(notificationKey, null);
	}
	
	public void notify(String notificationKey, Object data) {
		propagateAll(notificationKey, data);
	}
	
	private synchronized void propagateAll(String notificationKey, final Object data) {
		final Map<Object, Handler> clients = notifications.get(notificationKey);
		if(clients == null){
			return;
		}
		
		for (Handler handler : clients.values()) {
			try {
				handler.sendMessage(Message.obtain(handler, NOTIFICATION, data));
			} catch (Exception e) {
				//Logger.e(e);
			}
		}	

		StringBuilder sb = new StringBuilder();
		for (Object key : clients.keySet()) {
			sb.append(key.getClass().getSimpleName()).append("(").append(key.hashCode()).append(")").append(", ");
		}
	}
	
	
	
	/******************************************************************
	 ******************************************************************/
	
	
	
	
	
}
