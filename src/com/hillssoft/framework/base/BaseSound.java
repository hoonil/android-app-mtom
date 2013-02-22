package com.hillssoft.framework.base;

import android.media.AudioManager;
import android.media.SoundPool;

abstract public class BaseSound implements IBaseObjectDisposable {
	
	SoundPool sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);;
	
	protected BaseSound() {
		sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	}
	
	public void playSound(){
		
	}
}
