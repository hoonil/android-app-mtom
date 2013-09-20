package com.hillssoft.android.app.mtom.manager;

import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.base.BaseSound;
import com.hillssoft.android.framework.type.IDisposable;

public class SoundManager extends BaseSound implements IDisposable{
	
	private static SoundManager instance;
	private SoundPool soundPool = null;
	private int soundID = -1;
	
	
	public static SoundManager getInstance(){
		if(instance == null){
			synchronized (SoundManager.class) {
				instance = new SoundManager();
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	protected SoundManager() {
		soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	}
	
	public void dispose() {
		instance = null;
	}
	
	public void playSound(){
		
		
		
		
		//soundID = soundPool.load(soundPoolContext, R.raw.sample, 1);
		
		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			@Override
			public void onLoadComplete(SoundPool soundPool, int soundId, int status) {
				soundPool.play(soundId, 1f, 1f, 0, -1, 1f);
			}
		});
		
		
	}
	
	public void stopSound(){
		soundPool.stop(soundID);
	}
	
}
