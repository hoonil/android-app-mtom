package com.hillssoft.mtom.sample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import base.BaseActivity;

import com.hillssoft.mtom.R;
import com.hillssoft.mtom.db.AppDB;
import com.hillssoft.mtom.db.AppDBQuery;
import com.hillssoft.mtom.db.AppDBQuery.AppDBQueryKeyType;

public class DBActivity extends BaseActivity {

	
	
	private AppDB mAppDB = null;
	private SQLiteDatabase mDB = null;
	private Cursor mCursor = null;
	private ContentValues mContentValue = null;
	
	private String sql = null;
	
	
	

	private TextView txt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_db);
		
		/*
		 * [ Open DB ]
		 */
		mAppDB = new AppDB(this);
		mDB = mAppDB.getWritableDatabase();

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sample_db, menu);
		return true;
	}
	
	@Override
	protected void initializeView() {
		// TODO Auto-generated method stub
		super.initializeView();
		txt1 = (TextView)findViewById(R.id.txt1);
	}
	
	@Override
	protected void setInitializeViewEventListener() {
		// TODO Auto-generated method stub
		super.setInitializeViewEventListener();
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
				sql = AppDBQuery.getQuery(AppDBQueryKeyType.CREATE_TABLE_POST, null);
				mDB.execSQL(sql);
				sql = AppDBQuery.getQuery(AppDBQueryKeyType.CREATE_TABLE_POST_COMMENT, null);
				mDB.execSQL(sql);
				
				Toast.makeText(getApplicationContext(), "Create OK !!!", Toast.LENGTH_SHORT).show();
			break;
				
			case R.id.Insert :
				sql = AppDBQuery.getQuery(AppDBQueryKeyType.INSERT_TABLE_POST, null);
				mDB.execSQL(sql);
				Toast.makeText(getApplicationContext(), "Insert OK !!!", Toast.LENGTH_SHORT).show();
				
				/*
				 * [DAO]
				 */
//				mContentValue.clear();
//				mContentValue.put("name", "aa");
//				mContentValue.put("code", 11);
//				mDB.insert(DB_TABLE_NAME, null, mContentValue);
				
			break;
				
			case R.id.Update :
				sql = AppDBQuery.getQuery(AppDBQueryKeyType.UPDATE_TABLE_POST, null);
				mDB.execSQL(sql);
				Toast.makeText(getApplicationContext(), "Update OK !!!", Toast.LENGTH_SHORT).show();
				
			break;
				
			case R.id.Delete :
				sql = AppDBQuery.getQuery(AppDBQueryKeyType.DELETE_TABLE_POST, null);
				mDB.execSQL(sql);
				Toast.makeText(getApplicationContext(), "Delete OK !!!", Toast.LENGTH_SHORT).show();
				
			break;
				
			case R.id.Select :
				sql = AppDBQuery.getQuery(AppDBQueryKeyType.SELECT_TABLE_POST, null);
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
