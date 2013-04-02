package com.hillssoft.android.framework.net;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.hillssoft.android.app.mtom.conf.AppConf;

public class HttpConnectionResponseHandler implements ResponseHandler {
	
	
	private String responseString;
	private JSONObject jsonObject;
	
	
	/*
	 * [ Define Response Status ]
	 */
	private static String SUCCESS = "SUCCESS";
	private static String ERROR = "ERROR";
	
	
	
	@Override
	public HttpResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		responseString = EntityUtils.toString(response.getEntity(), AppConf.APP_WEB_SERVER_ENCODING);
		try{
			jsonObject = new JSONObject((String) responseString);
		}catch(Exception e){
			jsonObject = null;
		}
		
		/*
		 * [ Response Status Check ]
		 */
		String result = getJsonToString("result");
		if(result.equals(SUCCESS)){
			this.onComplete(result, response);
		}else if(result.equals(ERROR)){
			this.onError(result, response);
		}else{
			this.onError(result, response);
		}
		
		return response;
	}
	
	
	public boolean onComplete(String status, HttpResponse response) throws ClientProtocolException, IOException {
		return true;
	}
	
	
	public boolean onError(String status, HttpResponse response){
		return true;
	}

	
	protected JSONObject getJsonObject(){
		return jsonObject;
	}
	
	protected String getResponseString(){
		return responseString;
	}
	
	protected String getJsonToString(String name){
		try{
			return getJsonObject().getString(name);
		}catch(JSONException e){
			return null;
		}
	}
	
	protected JSONObject getReturnDataToJson(){
		try{
			return new JSONObject((String)getJsonObject().getString("return_data"));
		}catch(JSONException e){
			return null;
		}
	}
	
	
	
	
	
	
}
