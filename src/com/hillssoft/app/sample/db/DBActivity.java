package com.hillssoft.app.sample.db;

import java.util.Calendar;
import java.util.HashMap;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.hillssoft.app.R;
import com.hillssoft.app.mtom.db.AppDB;
import com.hillssoft.app.mtom.db.AppDBQuery;
import com.hillssoft.framework.base.BaseActivity;

public class DBActivity extends BaseActivity {

	
	
	private AppDB mAppDB = null;
	private SQLiteDatabase mDB = null;
	private Cursor mCursor = null;
	private ContentValues mContentValue = null;
	
	private String sql = null;
	private HashMap<String, String> sqlParams = null;
	
	
	
	

	private TextView txt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		/*
		 * [ Open DB ]
		 */
		mAppDB = new AppDB(this);
		mDB = mAppDB.getWritableDatabase();
		sqlParams = new HashMap();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sample_db_db_activity, menu);
		return true;
	}
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.sample_db_db_activity);
		txt1 = (TextView)findViewById(R.id.txt1);
	}
	
	@Override
	protected void setInitializeViewEventListener() {
	
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		if(mAppDB != null){
			mAppDB.close();
		}
		super.onStop();
		
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
			case R.id.Create :
				
				sql = AppDBQuery.getQuery(AppDBQuery.QueryKey.CREATE_TABLE_POST, null);
				mDB.execSQL(sql);
				sql = AppDBQuery.getQuery(AppDBQuery.QueryKey.CREATE_TABLE_POST_COMMENT, null);
				mDB.execSQL(sql);
				
				Toast.makeText(getApplicationContext(), "Create OK !!!", Toast.LENGTH_SHORT).show();
				
			break;
				
			case R.id.Insert :
				
				sqlParams.clear();
				sqlParams.put("message", "test~~~ message");
				sqlParams.put("create_at", Long.toString(Calendar.getInstance().getTimeInMillis() / 1000));
				sqlParams.put("state", "1");
				sqlParams.put("is_del", "0");
				sql = AppDBQuery.getQuery(AppDBQuery.QueryKey.INSERT_TABLE_POST, sqlParams);
				
				mDB.execSQL(sql);
				Toast.makeText(getApplicationContext(), "Insert OK !!!", Toast.LENGTH_SHORT).show();
				
				/*
				 * [DAO]
				 */
				//mContentValue.clear();
				//mContentValue.put("name", "aa");
				//mContentValue.put("code", 11);
				//mDB.insert(DB_TABLE_NAME, null, mContentValue);
				
			break;
				
			case R.id.Update :
				
				sqlParams.clear();
				sqlParams.put("message", "update~~~ ok!!!!!");
				sqlParams.put("post_id", "1");
				sql = AppDBQuery.getQuery(AppDBQuery.QueryKey.UPDATE_TABLE_POST, sqlParams);
				
				mDB.execSQL(sql);
				Toast.makeText(getApplicationContext(), "Update OK !!!", Toast.LENGTH_SHORT).show();
				
			break;
				
			case R.id.Delete :
				
				sql = AppDBQuery.getQuery(AppDBQuery.QueryKey.DELETE_TABLE_POST, null);
				
				mDB.execSQL(sql);
				Toast.makeText(getApplicationContext(), "Delete OK !!!", Toast.LENGTH_SHORT).show();
				
			break;
				
			case R.id.Select :
				
				sql = AppDBQuery.getQuery(AppDBQuery.QueryKey.SELECT_TABLE_POST, null);
				
				txt1 = (TextView)findViewById(R.id.txt1);
				txt1.setText("[ DATA SELECT] \n");
				mCursor = mDB.rawQuery(sql, null);
				if(mCursor != null){
					while(mCursor.moveToNext()){
						String msg = 	"post_id : " + mCursor.getInt(0) + " \t " +
										"message : " + mCursor.getString(1) + " \t " +
										"create_at : " + mCursor.getInt(2) + " \t " +
										"state : " + mCursor.getInt(3) + " \t " +
										"is_del : " + mCursor.getInt(4) + "\n ";
						txt1.append(msg);
					}
				}
				mCursor.close();
				Toast.makeText(getApplicationContext(), "Select OK !!!", Toast.LENGTH_SHORT).show();
				
			break;
				
			default :
				return false;
		}
		
		return true;
	}

}
