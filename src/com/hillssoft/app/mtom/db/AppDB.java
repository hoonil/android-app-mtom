package com.hillssoft.app.mtom.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hillssoft.app.mtom.conf.AppConf;
import com.hillssoft.framework.base.BaseDB;
import com.hillssoft.framework.manager.AppManager;

public class AppDB extends BaseDB{

	
	public AppDB(Context context) {
		super(context, getAppDBName(), AppManager.getInstance().getAppVersionCode());
	}
	
	public static String getAppDBName(){
		return AppConf.APP_DB_NAME;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		super.onCreate(db);
		
		/*
		 * [ Default DB Create]
		 */
		Log.d("DB - Create", "version : 0");
		db.execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.CREATE_TABLE_POST));
		db.execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.CREATE_TABLE_POST_COMMENT));
		
		
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
			case 4 :
				Log.d("DB - 4", "version : 4");
			case 5 :
				Log.d("DB - 5", "version : 5");
			case 6 :
				Log.d("DB - 6", "version : 6");
			case 7 :
				Log.d("DB - 7", "version : 7");
			case 8 :
				Log.d("DB - 8", "version : 8");
			case 9 :
				Log.d("DB - 9", "version : 9");
			case 10 :
				Log.d("DB - 10", "version : 10");
			case 11 :
				Log.d("DB - 11", "version : 11");
			case 12 :
				Log.d("DB - 12", "version : 12");
			case 13 :
				Log.d("DB - 13", "version : 13");
			case 14 :
				Log.d("DB - 14", "version : 14");
			case 15 :
				Log.d("DB - 16", "version : 15");
			case 16 :
				Log.d("DB - 16", "version : 16");
			case 17 :
				Log.d("DB - 17", "version : 17");
			case 18 :
				Log.d("DB - 18", "version : 18");
				db.execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.ALTER_TABLE_POST_18));
			case 19 :
				Log.d("DB - 19", "version : 19");
			case 20 :			
				Log.d("DB - 20", "version : 20");
		}
		
		
	}
	
	
	
	
	
	

}
