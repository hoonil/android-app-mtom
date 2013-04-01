package com.hillssoft.android.app.mtom.activity.auth;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.hillssoft.android.R;
import com.hillssoft.android.framework.manager.AppManager;
import com.hillssoft.android.framework.manager.BaseActivityManager;
import com.hillssoft.android.framework.manager.HttpConnectionManager;
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
				params.put("category", category.getText().toString());
				params.put("uuid", UserManager.getInstance().getUUID());
				
				HttpConnectionManager.getInstance().doRequest(HttpMethod.POST, responseHandler, "http://hoonil.codns.com/app_mtom/index.php", params);
			}
		});
		
	}
	
	
	private HttpConnectionResponseHandler responseHandler = new HttpConnectionResponseHandler(){
		public boolean onComplete(String status, HttpResponse response) throws ClientProtocolException, IOException {
			LoggerManager.i(getResponseString());
			
			/*
			 * [Get response]
			 */
			String userId = getJsonToString("result");
			String sessionKey = getJsonToString("result");
			
			
			LoggerManager.i(userId);
			return super.onComplete(status, response);
		}
	};
	
	
	
}
