package com.hillssoft.android.app.mtom.net;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {
	public LruCache<String, Bitmap> mCache = null;
    
    public BitmapCache() {
        int maxSize = 100 * 1024 * 1024;
        mCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }
 
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }
 
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url, bitmap);
    }
}
