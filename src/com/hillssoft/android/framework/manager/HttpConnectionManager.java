package com.hillssoft.android.framework.manager;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.framework.net.HttpConnectionResponseHandler;
import com.hillssoft.android.framework.type.IDisposable;
import com.hillssoft.android.framework.util.DeviceUtil;

public class HttpConnectionManager implements IDisposable {
	
	
	/*
	 * [ Define Object ]
	 */
	private static HttpConnectionManager instance;
	//private ArrayList<Runnable> httpQueue = new ArrayList<Runnable>();
	//private Executor httpQueueExecutor;
	//private ThreadGroup httpConnectionThreadGroup;
	
	public static enum HttpMethod{
		GET, POST;
	}
	
	public HttpConnectionManager() {
		//httpConnectionThreadGroup = new ThreadGroup("HTTP-CONNECTION-MANAGER-THREAD-GROUP");
	}
	
	public static HttpConnectionManager getInstance(){
		if(instance == null){
			synchronized (AppManager.class) {
				instance = new HttpConnectionManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
		
	

	
	public void doRequest(HttpMethod method, HttpConnectionResponseHandler responseHandler, String url, HashMap<String, String> params){
		/*
		 * [ Check network connection state ]
		 */
		if(!DeviceUtil.isNetworkAvailable(AppGlobalApplication.getAppGlobalApplicationContext())){
			return;
		}

		if(method.equals(HttpMethod.GET)){
			
			GetMethodRequestObject requestObject = new GetMethodRequestObject(responseHandler, url, params);
			requestObject.start();
			
		}else if(method.equals(HttpMethod.POST)){
			
			PostMethodRequestObject requestObject = new PostMethodRequestObject(responseHandler, url, params);
			requestObject.start();
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	private class PostMethodRequestObject extends Thread{
		private HttpConnectionResponseHandler responseHandler;
		private String url;
		HashMap<String, String> params;
		
		
		public PostMethodRequestObject(HttpConnectionResponseHandler rh, String u, HashMap<String, String> p) {
			this.responseHandler = rh;
			this.url = u;
			this.params = p;
		}
		
		public void run() {
			doGet();
		}
		
		private void doGet(){
			try{
				/**
				 * [ Create Http Objects ]
				 */
				HttpPost httpPost = new HttpPost(url);
				DefaultHttpClient client = new DefaultHttpClient();
				
				
				/**
				 * [ Set Properties ]
				 */
				httpPost.setHeader("Connection", "Keep-Alive");
				
				/**
				 * [ Set Parameters ]
				 */
				if(params != null){
					BasicHttpParams httpParams = new BasicHttpParams();
					Iterator it = params.keySet().iterator();
					while(it.hasNext()){
						String key = (String)it.next();
						String value = URLEncoder.encode(params.get(key), AppConf.APP_WEB_SERVER_ENCODING);
						httpParams.setParameter(key, value);
					}
					httpPost.setParams(httpParams);
				}
				
				HttpResponse response = client.execute(httpPost, responseHandler);
				
				/**
				 * [ Check Status ]
				 */
				int status = response.getStatusLine().getStatusCode();
				if (status != HttpStatus.SC_OK){
					responseHandler.handleError(response);
				}
			}catch(Exception e){
				LoggerManager.e("!!!!!!!!!!!!!!!! ----------------------  Http Get Method Error !!!!!!!!!!!!!!!!!!!!!!!!!!" + e.getMessage() + e.toString());
			}
		}
	}
	
	
	
	private class GetMethodRequestObject extends Thread{
		private HttpConnectionResponseHandler responseHandler;
		private String url;
		HashMap<String, String> params;
		
		
		public GetMethodRequestObject(HttpConnectionResponseHandler rh, String u, HashMap<String, String> p) {
			this.responseHandler = rh;
			this.url = u;
			this.params = p;
		}
		
		public void run() {
			doGet();
		}
		
		private void doGet(){
			try{
				/**
				 * [ Create Http Objects ]
				 */
				HttpGet httpGet = new HttpGet(url);
				DefaultHttpClient client = new DefaultHttpClient();
				
				
				/**
				 * [ Set Properties ]
				 */
				httpGet.setHeader("Connection", "Keep-Alive");
				
				/**
				 * [ Set Parameters ]
				 */
				if(params != null){
					BasicHttpParams httpParams = new BasicHttpParams();
					Iterator it = params.keySet().iterator();
					while(it.hasNext()){
						String key = (String)it.next();
						String value = URLEncoder.encode(params.get(key), AppConf.APP_WEB_SERVER_ENCODING);
						httpParams.setParameter(key, value);
					}
					httpGet.setParams(httpParams);
				}
				
				HttpResponse response = client.execute(httpGet, responseHandler);
				
				/**
				 * [ Check Status ]
				 */
				int status = response.getStatusLine().getStatusCode();
				if (status != HttpStatus.SC_OK){
					responseHandler.handleError(response);
				}
			}catch(Exception e){
				LoggerManager.e("!!!!!!!!!!!!!!!! ----------------------  Http Get Method Error !!!!!!!!!!!!!!!!!!!!!!!!!!" + e.getMessage() + e.toString());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	private String doGet(ResponseHandler responseHandler, String url){
//		try{
//			/**
//			 * [ Create Http Objects ]
//			 */
//			HttpGet method = new HttpGet(url);
//			DefaultHttpClient client = new DefaultHttpClient();
//			
//			/**
//			 * [ Set Properties ]
//			 */
//			method.setHeader("Connection", "Keep-Alive");
//			HttpResponse response = client.execute(method, responseHandler);
//			
//			/**
//			 * [ Check Status ]
//			 */
//			int status = response.getStatusLine().getStatusCode();
//			if (status != HttpStatus.SC_OK){
//				throw new Exception("");
//			}
//			
//			/**
//			 * [ Return result ]
//			 */
//			return EntityUtils.toString(response.getEntity(), "UTF-8");
//		}catch(Exception e){
//			LoggerManager.e("!!!!!!!!!!!!!!!! Http Get Method Error !!!!!!!!!!!!!!!!!!!!!!!!!!" + e.getMessage() + e.toString());
//			
//			return null;
//		}
//	}
//
//	private String doPost(String url, String params){
//		try{
//			HttpPost method = new HttpPost(url);
//			DefaultHttpClient client = new DefaultHttpClient();
//			
//			StringEntity paramEntity = new StringEntity(params);
//			paramEntity.setChunked(false);
//	        paramEntity.setContentType("application/x-www-form-urlencoded");
//	        method.setEntity(paramEntity);
//	        
//	        
//	        HttpResponse response = client.execute(method);
//	        int status = response.getStatusLine().getStatusCode();
//	        if (status != HttpStatus.SC_OK){
//	        	throw new Exception("");
//	        }
//	        return EntityUtils.toString(response.getEntity(), "UTF-8");
//	    }catch(Exception e){
//			return null;
//		}
//	}
	
	

	
	
//	private void push(Runnable runnable) {
//		httpQueue.add(runnable);
//		startNext();
//	}
//
//	private void startNext() {
//		if (!httpQueue.isEmpty()) {
//			Runnable next = null;
//			try {
//				next = httpQueue.remove(0);
//			} catch (java.lang.IndexOutOfBoundsException e) {
//				LoggerManager.e(e);
//			}
//
//			if (next != null) {
//				httpQueueExecutor.execute(next);
//			}
//		}
//	}
//
//	private void didComplete(Runnable runnable) {
//		startNext();
//	}

	
}
