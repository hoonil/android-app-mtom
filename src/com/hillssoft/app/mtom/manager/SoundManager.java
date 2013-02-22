package com.hillssoft.app.mtom.manager;

import com.hillssoft.framework.base.BaseSound;

public class SoundManager extends BaseSound {
	
	/******************************************************************
	 * [ Required default initialization ]
	 ******************************************************************/
	private static SoundManager instance;
	
	public SoundManager getInstance(){
		if(instance == null){
			synchronized (SoundManager.class) {
				instance = new SoundManager();
			}
		}
		return instance;
	}
	
	public void dispose() {
		instance = null;
	}
	/******************************************************************
	 ******************************************************************/
	
}
