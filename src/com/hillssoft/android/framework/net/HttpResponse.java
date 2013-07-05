package com.hillssoft.android.framework.net;

import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyError;

public class HttpResponse<T> extends Response<T> {
	protected HttpResponse(T result, Cache.Entry cacheEntry) {
    	super(result, cacheEntry);
    }

    protected HttpResponse(VolleyError error) {
        super(error);
    }
}
