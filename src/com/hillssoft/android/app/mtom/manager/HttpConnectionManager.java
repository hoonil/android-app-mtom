package com.hillssoft.android.app.mtom.manager;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
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
				/*
				 * [ Create Http Objects ]
				 */
				HttpPost httpPost = new HttpPost(url);
				DefaultHttpClient client = new DefaultHttpClient();
				
				
				/*
				 * [ Set Properties ]
				 */
				//httpPost.setHeader("Connection", "Keep-Alive");
				
				/*
				 * [ Set Http Default Params ]
				 */
				BasicHttpParams httpParams = new BasicHttpParams();
				httpPost.setParams(httpParams);
				
				/**
				 * [ Set Parameters ]
				 */
				
				if(params != null){
					List<NameValuePair> paramList = new ArrayList<NameValuePair>();
					Iterator it = params.keySet().iterator();
					while(it.hasNext()){
						String key = (String)it.next();
						String value = (String)params.get(key);
						paramList.add(new BasicNameValuePair(key, value));
						
					}
					httpPost.setEntity(new UrlEncodedFormEntity(paramList, AppConf.APP_WEB_SERVER_ENCODING));
				}
				
				
				/*
				 * [ Execute Request ]
				 */
				HttpResponse response = client.execute(httpPost, responseHandler);
				
				/*
				 * [ Check Status ]
				 */
				int status = response.getStatusLine().getStatusCode();
				if (status == HttpStatus.SC_OK){
					responseHandler.onComplete(Integer.toString(status), response);
				}else{
					responseHandler.onError(Integer.toString(status), response);
				}
			}catch(Exception e){
				LoggerManager.e("!!!!!!!!!!!!!!!! ---------------------- PostMethodRequestObject Error ---------------------- !!!!!!!!!!!!!!!!" + e.getMessage() + e.toString());
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
				
				/*
				 * [ Set Url Parameters ]
				 */
				if(params != null){
					Iterator it = params.keySet().iterator();
					while(it.hasNext()){
						String key = (String)it.next();
						String value = URLEncoder.encode(params.get(key), AppConf.APP_WEB_SERVER_ENCODING);
						if(url.indexOf("?") == -1){
							url = url + "?" + key + "=" + value;
						}else{
							url = url + "&" + key + "=" + value;
						}
					}
				}
				LoggerManager.i(url);
				
				/*
				 * [ Create Http Objects ]
				 */
				HttpGet httpGet = new HttpGet(url);
				DefaultHttpClient client = new DefaultHttpClient();
				
				
				/*
				 * [ Set Properties ]
				 */
				//httpGet.setHeader("Connection", "Keep-Alive");
				
				
				/*
				 * [ Set Http Default Params ]
				 */
				BasicHttpParams httpParams = new BasicHttpParams();
				httpGet.setParams(httpParams);
				
				
				/*
				 * [ Execute Request ]
				 */
				HttpResponse response = client.execute(httpGet, responseHandler);
				
				/*
				 * [ Check Status ]
				 */
				int status = response.getStatusLine().getStatusCode();
				if (status == HttpStatus.SC_OK){
					responseHandler.onComplete(Integer.toString(status), response);
				}else{
					responseHandler.onError(Integer.toString(status), response);
				}
			}catch(Exception e){
				LoggerManager.e("!!!!!!!!!!!!!!!! ----------------------  GetMethodRequestObject Method Error ---------------------- !!!!!!!!!!!!!!!!" + e.getMessage() + e.toString());
			}
		}
	}
	
	
	


	
}
