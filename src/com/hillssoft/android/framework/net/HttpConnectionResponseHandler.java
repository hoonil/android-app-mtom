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
	
	
	@Override
	public HttpResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		responseString = EntityUtils.toString(response.getEntity(), AppConf.APP_WEB_SERVER_ENCODING);
		try{
			jsonObject = new JSONObject((String) responseString);
		}catch(Exception e){
			jsonObject = null;
		}
		return response;
	}
	
	public HttpResponse handleError(HttpResponse response){
		return response;
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
	
}
