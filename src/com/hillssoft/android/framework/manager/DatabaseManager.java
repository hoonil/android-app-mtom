package com.hillssoft.android.framework.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.app.mtom.db.AppDBQuery;
import com.hillssoft.android.framework.base.BaseDB;
import com.hillssoft.android.framework.type.IDisposable;

public class DatabaseManager extends BaseDB implements IDisposable  {

	private static DatabaseManager instance;
	private static SQLiteDatabase db;
	private static Context context;
	
	
	
	private DatabaseManager(Context context) {
		super(context, getAppDatabaseName(), AppManager.getInstance().getAppVersionCode());
	}
	
	
	public static DatabaseManager getInstance(){
		if(instance == null){
			synchronized (DatabaseManager.class) {
				context = AppGlobalApplication.getAppGlobalApplicationContext().getApplicationContext();
				instance = new DatabaseManager(context);
				db = instance.getWritableDatabase();
				
				AppGlobalApplication.getAppGlobalApplicationContext().addDisposableResource(instance);
			}
		}
		return instance;
	}
	
	
	public void dispose() {
		instance = null;
	}
	
	public SQLiteDatabase getDatabase(){
		return db;
	}
	
	
	public static String getAppDatabaseName(){
		return AppConf.APP_DB_NAME;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		super.onCreate(db);
		
		
		/**
		 * [ Create Default Install Schema ]
		 */
		try{
			db.execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.CREATE_TABLE_POST));
			db.execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.CREATE_TABLE_POST_COMMENT));
		}catch(Exception e){
			LoggerManager.e(e.toString());
		}
		
		
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
