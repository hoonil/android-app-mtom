package com.hillssoft.android.app.mtom.activity.auth;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.hillssoft.android.R;
import com.hillssoft.android.app.mtom.db.AppDBQuery;
import com.hillssoft.android.framework.manager.AppNotificationCenterManager;
import com.hillssoft.android.framework.manager.BaseActivityManager;
import com.hillssoft.android.framework.manager.DatabaseManager;
import com.hillssoft.android.framework.manager.HttpConnectionManager;
import com.hillssoft.android.framework.manager.SharedPreferenceManager;
import com.hillssoft.android.framework.manager.HttpConnectionManager.HttpMethod;
import com.hillssoft.android.framework.manager.LoggerManager;
import com.hillssoft.android.framework.manager.UserManager;
import com.hillssoft.android.framework.net.HttpConnectionResponseHandler;

public class MemberRegisterActivity extends BaseActivityManager {
	
	
	private EditText nickname = null;
	private RadioGroup sexRadioGroup = null;
	private EditText category = null;
	private Button registerBtn = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	
	@Override
	protected void initializeView() {
		super.initializeView();
		setContentView(R.layout.mtom_auth_member_register_activity);
		
		
		/*
		 * [ Set UI Object ]
		 */
		nickname = (EditText)findViewById(R.id.nickname);
		sexRadioGroup = (RadioGroup)findViewById(R.id.sex_group);
		category = (EditText)findViewById(R.id.category);
		registerBtn = (Button)findViewById(R.id.register_btn);
		
	}
	
	
	@Override
	protected void setInitializeViewEventListener() {
		super.setInitializeViewEventListener();
		
		registerBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * [ Validation Check ]
				 */
				if(nickname.getText().length() == 0){
					openErrorMessage(R.string.error_message_for_account_register_activity_to_nickname);
					return;
				}
				if(sexRadioGroup.getCheckedRadioButtonId() == -1){
					openErrorMessage(R.string.error_message_for_account_register_activity_to_sex);
					return;
				}
				if(category.getText().length() == 0){
					openErrorMessage(R.string.error_message_for_account_register_activity_to_category);
					return;
				}
				
				/*
				 * [ Set default value ]
				 */
				String gender = "male";
				if(R.id.female == sexRadioGroup.getCheckedRadioButtonId()){
					gender = "female";
				}
				
				
				/*
				 * [ Set Params ]
				 */
				HashMap<String, String> params = new HashMap<String, String>();
				params.put("action_key", "member_register");
				params.put("user_name", nickname.getText().toString());
				params.put("gender", gender);
				params.put("category_name", category.getText().toString());
				params.put("uuid", UserManager.getInstance().getUUID());
				
				HttpConnectionManager.getInstance().doRequest(HttpMethod.POST, responseHandler, "http://hoonil.codns.com/app_mtom/index.php", params);
			}
		});
		
	}
	
	
	private HttpConnectionResponseHandler responseHandler = new HttpConnectionResponseHandler(){
		public boolean onComplete(String status, HttpResponse response) throws ClientProtocolException, IOException {
			LoggerManager.i(getResponseString());
			try{
				/*
				 * [Get response]
				 */
				String userId = getReturnDataToJson().getString("user_id");
				String sessionKey = getReturnDataToJson().getString("session_key");
				String userName = getReturnDataToJson().getString("user_name");
				String categoryId = getReturnDataToJson().getString("category_id");
				String categoryName = getReturnDataToJson().getString("category_name");
				
				/*
				 * [ Insert DB ]
				 */
				HashMap<String, String> dbSqlParams = new HashMap<String, String>();
				dbSqlParams.put("user_id", userId);
				dbSqlParams.put("category_id", categoryId);
				dbSqlParams.put("category_name", categoryName);
				dbSqlParams.put("date_create", "0000-00-00 00:00:00");
				dbSqlParams.put("state", "10");
				DatabaseManager.getInstance().getDatabase().execSQL(AppDBQuery.getQuery(AppDBQuery.QueryKey.INSERT_TABLE_CATEGORY_LIST, dbSqlParams));
				
				/*
				 * [ Update Preference ]
				 */
				defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_USER_ID, userId);
				defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_USER_NICKNAME, userName);
				defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_USER_SESSION_KEY, sessionKey);
				defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_USER_SESSION_KEY, true);
				defaultAppSharedPreference.commitSharedPreference(SharedPreferenceManager.KEY_IS_INITIALIZE_APPLICATION_COMPLETED, true);
				
				
				
				/*
				 * [ Redirect main tab ]
				 */
				AppNotificationCenterManager.getInstance().notify(AppNotificationCenterManager.APP_GLOBAL_APPLICATION_NOTIFICATION_REDIRECT_MAIN_TAB);
			
			}catch(JSONException e){
				LoggerManager.e(e.toString());
			}
			
			return super.onComplete(status, response);
		}
	};
	
	
	
}
