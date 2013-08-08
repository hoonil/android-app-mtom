package com.hillssoft.android.app.mtom.manager;

import android.media.AudioManager;
import android.media.SoundPool;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.framework.base.BaseSound;
import com.hillssoft.android.framework.type.IDisposable;

public class SoundManager extends BaseSound implements IDisposable{
	
	private static SoundManager instance;
	private SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);;
	
	
	
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
		sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	}
	
	public void dispose() {
		instance = null;
	}
	
	public void playSound(){
		
	}
	
}