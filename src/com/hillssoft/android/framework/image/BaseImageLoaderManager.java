package com.hillssoft.android.framework.image;

import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.util.Base64;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.hillssoft.android.app.mtom.application.AppGlobalApplication;

public class BaseImageLoaderManager {

	
	
	
	private	ImageLoaderBitmapCache imageBitmapCache = null;
	
	
	private class ImageLoaderBitmapCache implements ImageLoader.ImageCache{
		private int maxCacheSize = 10 * 1024 * 1024;
		private LruCache<String, Bitmap> lruCache;
		
		public ImageLoaderBitmapCache() {
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
	
	
	
	
	/*
	 * [ Class Constructor ]
	 */
	public BaseImageLoaderManager() {
		imageBitmapCache = new ImageLoaderBitmapCache();
	}
	
	
	
	
	public void loadImage(String url, ImageView v){
		loadImage(url, v, null);
	}
	
	public void loadImage(String url, ImageView v, Handler handler){
		
		if(imageBitmapCache.getBitmap(url) != null){
			v.setImageBitmap(imageBitmapCache.getBitmap(url));
		}
	
		
		
	}
	
	
	
	private Bitmap getBitmap(String url){
		Bitmap bm = null;
		if(imageBitmapCache.getBitmap(url) != null){
			bm = imageBitmapCache.getBitmap(url);
		}
		
		
		return bm;
	}
	
	
	
	
	
	
//	public void loadBackgroundImage(String imgSrcUrl, View v){
//		if(imageBitmapCache.getBitmap(imgSrcUrl) != null){
//			v.setImageBitmap(imageBitmapCache.getBitmap(imgSrcUrl));
//		}
//	}
	
	
	
	
	
	
	public String getImageCacheFilePath(String imgUrl){
		return getImageCacheFilePath(imgUrl, false);
	}
	public String getImageCacheFilePath(String imgUrl, boolean setGrayScale){
		if(setGrayScale){
			return AppGlobalApplication.getAppGlobalApplicationContext().getFilesDir().getAbsolutePath() + "/" + Base64.encodeToString((imgUrl + "_gray").getBytes(), Base64.NO_WRAP | Base64.URL_SAFE);
		}else{
			return AppGlobalApplication.getAppGlobalApplicationContext().getFilesDir().getAbsolutePath() + "/" + Base64.encodeToString(imgUrl.getBytes(),  Base64.NO_WRAP | Base64.URL_SAFE);
		}
		
	}
	
	private Drawable setGrayScale(Drawable d){
	    ColorMatrix matrix = new ColorMatrix();
	    matrix.setSaturation(0);
	    ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
	    d.setColorFilter(cf);
	    return d;
	}
	
	
	
	
	
	
}
