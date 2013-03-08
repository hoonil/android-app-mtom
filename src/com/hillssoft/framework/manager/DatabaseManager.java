package com.hillssoft.framework.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hillssoft.app.mtom.application.AppGlobalApplication;
import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.app.mtom.db.AppDBQuery;
import com.hillssoft.framework.base.BaseDB;
import com.hillssoft.framework.type.IDisposable;

public class DatabaseManager extends BaseDB implements IDisposable  {

	private static DatabaseManager instance;
	
	
	
	private DatabaseManager(Context context) {
		super(context, getAppDBName(), AppManager.getInstance().getAppVersionCode());
	}
	
	
	public static DatabaseManager getInstance(){
		if(instance == null){
			synchronized (DatabaseManager.class) {
				instance = new DatabaseManager(AppGlobalApplication.getAppGlobalApplicationContext());
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	
	public void dispose() {
		instance = null;
	}
	
	
	public static String getAppDBName(){
		return AppConf.APP_DB_NAME;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		super.onCreate(db);
		
		
		/**
		 * [ Create Default Install Schema ]
		 */
		getWritableDatabase().execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.INSERT_TABLE_POST));
		getWritableDatabase().execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.INSERT_TABLE_POST_COMMENT));
		
		
	}
	
	@Override
	final public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		super.onUpgrade(db, oldVersion, newVersion);
		
		switch(oldVersion){
		case 1 :
			Log.d("DB - 1", "version : 1");
		case 2 :
			Log.d("DB - 2", "version : 2");
		case 3 :
			Log.d("DB - 3", "version : 3");
			
		}
	}
	
	

}
