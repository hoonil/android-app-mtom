package com.hillssoft.framework.manager;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.framework.type.IDisposable;

public class HttpConnectionManager implements IDisposable {
	
	
	/*
	 * [ Define Object ]
	 */
	private static HttpConnectionManager instance;
	private ArrayList<Runnable> httpQueue = new ArrayList<Runnable>();
	private Executor httpQueueExecutor;
	
	public static enum HttpMethod{
		GET, POST;
	}
	
	public HttpConnectionManager() {
		
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
	
	private void push(Runnable runnable) {
		httpQueue.add(runnable);
		startNext();
	}

	private void startNext() {
		if (!httpQueue.isEmpty()) {
			Runnable next = null;
			try {
				next = httpQueue.remove(0);
			} catch (java.lang.IndexOutOfBoundsException e) {
				LoggerManager.e(e);
			}

			if (next != null) {
				httpQueueExecutor.execute(next);
			}
		}
	}

	private void didComplete(Runnable runnable) {
		startNext();
	}
	
	

	
	public void doRequest(HttpMethod method, ResponseHandler<HttpResponse> responseHandler, String url, String params){
		/*
		 * [ Check network connection state ]
		 */
//		if(!DeviceUtil.isNetworkAvailable(AppGlobalApplication.getAppGlobalApplicationContext())){
//			return;
//		}

		if(method.equals(HttpMethod.GET)){
			GetMethodRequestObject requestObject = new GetMethodRequestObject(responseHandler, url);
			requestObject.start();
		}else if(method.equals(HttpMethod.POST)){
			
		}
	}
	
	
	private class GetMethodRequestObject extends Thread{
		private ResponseHandler responseHandler;
		private String url;
		
		public GetMethodRequestObject(ResponseHandler<HttpResponse> responseHandler, String url) {
			this.responseHandler = responseHandler;
			this.url = url;
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
				HttpResponse response = client.execute(httpGet, responseHandler);
				
				/**
				 * [ Check Status ]
				 */
				int status = response.getStatusLine().getStatusCode();
				if (status != HttpStatus.SC_OK){
					throw new Exception("");
				}
				
				/**
				 * [ Return result ]
				 */
				//return EntityUtils.toString(response.getEntity(), "UTF-8");
			}catch(Exception e){
				LoggerManager.e("!!!!!!!!!!!!!!!! ----------------------  Http Get Method Error !!!!!!!!!!!!!!!!!!!!!!!!!!" + e.getMessage() + e.toString());
				
				//return null;
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
	
	
	
	
}
