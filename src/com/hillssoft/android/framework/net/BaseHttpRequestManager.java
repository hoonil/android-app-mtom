package com.hillssoft.android.framework.net;

import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.app.mtom.manager.AppManager;
import com.hillssoft.android.framework.log.Logger;

public abstract class BaseHttpRequestManager implements Request.Method {

	/*
	 * [　Define Variables ]
	 */
	private RequestQueue requestQueue = null;
	private ImageLoader imageLoader = null;
	private	HttpRequestImageBitmapCache imageBitmapCache = null;
	
	private class HttpRequestImageBitmapCache implements ImageLoader.ImageCache{
		private int maxCacheSize = 10 * 1024 * 1024;
		private LruCache<String, Bitmap> lruCache;
		
		public HttpRequestImageBitmapCache() {
			lruCache = new LruCache<String, Bitmap>(maxCacheSize) {
	            @Override
	            protected int sizeOf(String key, Bitmap value) {
	                return value.getRowBytes() * value.getHeight();
	            }
	        };
		}
		
		@Override
		public Bitmap getBitmap(String url) {
			return lruCache.get(url);
		}
		@Override
		public void putBitmap(String url, Bitmap bitmap) {
			lruCache.put(url, bitmap);
		}
	}
	
	
	
	
	
	
	
	public BaseHttpRequestManager() {
		requestQueue = Volley.newRequestQueue(AppGlobalApplication.getAppGlobalApplicationContext());
		imageBitmapCache = new HttpRequestImageBitmapCache();
		imageLoader = new ImageLoader(requestQueue, imageBitmapCache);
	}
	
	
	
	protected Map<String, String> getHttpRequestHeaders(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("APP-OS-TYPE", "ANDROID");
		headers.put("APP-VERSION", Integer.toString(AppManager.getInstance().getAppVersionCode()));
		headers.put("SESSION-KEY", "aaaaabbbbbccccddd-111111111");
    	headers.put("REQUEST-TIME", Long.toString(Calendar.getInstance().getTimeInMillis()));
    	
        return headers;
	}
	
	
	/*
	 * [ json request ]
	 */
	public void addJsonRequest(int method, String url, Listener<JSONObject> listener, ErrorListener errorListener){
		addJsonRequest(method, url, null, listener, errorListener);
	}
	public void addJsonRequest(int method, String url, final Map<String, String> params, Listener<JSONObject> listener, ErrorListener errorListener){
		
		JSONObject jsonPostParams = null;
		if(params != null){
			jsonPostParams = new JSONObject(params);
		}
		
		JsonObjectRequest request = new JsonObjectRequest(method, url, jsonPostParams, listener, errorListener){
			@Override
			public Map<String, String> getParams() throws AuthFailureError {
				if(params == null){
					return super.getParams();
				}else{
					return params;
				}
			}
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				if(getHttpRequestHeaders() == null){
					return super.getHeaders();
				}else{
					return getHttpRequestHeaders();
				}
			}
		};
		requestQueue.add(request);
		requestQueue.start();
	}
	
	
	/*
	 * [ image request ]
	 */
	public void addImageRequest(String url, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener){
		addImageRequest(url, listener, 0, 0, errorListener);
	}
	public void addImageRequest(String url, Response.Listener<Bitmap> listener, int maxWidth, int maxHeight, Response.ErrorListener errorListener){
		ImageRequest request = new ImageRequest(url, listener, maxWidth, maxHeight, Bitmap.Config.ARGB_8888, errorListener);
		requestQueue.add(request);
		requestQueue.start();
	}
	public void addImageLoaderRequest(String url, ImageView view, int defaultImageResId, int errorImageResId){
		addImageLoaderRequest(url, view, defaultImageResId, errorImageResId, 0, 0);
	}
	public void addImageLoaderRequest(String url, ImageView view, int defaultImageResId, int errorImageResId, int viewWidth, int viewHeight){
		ImageListener listener = ImageLoader.getImageListener(view, defaultImageResId, errorImageResId);
		imageLoader.get(url, listener);
	}
	
	
	/*
	 * [ View Background Image ]
	 */
	public void addViewBackgroundImageLoaderRequest(String url ,View view, WindowManager windowManager){
		addViewBackgroundImageLoaderRequest(url ,view, windowManager, (Response.ErrorListener)null);
	}
	public void addViewBackgroundImageLoaderRequest(String url ,View view, WindowManager windowManager, Response.ErrorListener errorListener){
		Display display = windowManager.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		addViewBackgroundImageLoaderRequest(url, view, width, height, errorListener);
	}
	public void addViewBackgroundImageLoaderRequest(String url ,View view){
		addViewBackgroundImageLoaderRequest(url, view, (Response.ErrorListener)null);
	}
	public void addViewBackgroundImageLoaderRequest(String url, View view, Response.ErrorListener errorListener){
		addViewBackgroundImageLoaderRequest(url, view, 0, 0, errorListener);
	}
	public void addViewBackgroundImageLoaderRequest(final String url, final View view, int viewWidth, int viewHeight, Response.ErrorListener errorListener){
		HttpResponse.Listener<Bitmap> listener = new HttpResponse.Listener<Bitmap>(){
			@Override
			public void onResponse(Bitmap response) {
				if(response == null){
					return;
				}
				BitmapDrawable bmDrawable = new BitmapDrawable(AppGlobalApplication.getAppGlobalApplicationContext().getResources(), response);
				view.setBackground(bmDrawable);
				if(imageBitmapCache.getBitmap(url) == null){
					imageBitmapCache.putBitmap(url, response);
				}
			}
		};
		
		/*
		 * [ Cache Check ]
		 */
		if(imageBitmapCache.getBitmap(url) != null){
			listener.onResponse(imageBitmapCache.getBitmap(url));
			return;
		}
		
		ImageRequest request = new ImageRequest(url, listener, 0, 0, Bitmap.Config.ARGB_8888, errorListener);
		requestQueue.add(request);
		requestQueue.start();
	}
	
	
	/*
	 * [ string request ]
	 */
	public void addStringRequest(int method, String url, final Map<String, String> params, Listener<String> listener, ErrorListener errorListener){
		/*
		 * [ Set Get Method Params Url ]
		 */
		if(method == GET && params != null){
			url = getMergeGetMethodParamsUrl(url, params);
		}
		
		StringRequest request = new StringRequest(method, url, listener, errorListener){
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				if(params == null){
					return super.getParams();
				}else{
					return params;
				}
			}
			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				if(getHttpRequestHeaders() == null){
					return super.getHeaders();
				}else{
					return getHttpRequestHeaders();
				}
			}
		};
		requestQueue.add(request);
		requestQueue.start();
	}
	
	
	public String getMergeGetMethodParamsUrl(String url, Map<String, String> params){
		try{
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
			return url;
		}catch(Exception e){
			Logger.i(e);
			return null;
		}
	}
	
	
}
