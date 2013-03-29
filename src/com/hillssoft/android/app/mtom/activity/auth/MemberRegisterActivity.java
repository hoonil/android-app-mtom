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

import com.hillssoft.android.R;
import com.hillssoft.android.framework.manager.BaseActivityManager;
import com.hillssoft.android.framework.manager.HttpConnectionManager;
import com.hillssoft.android.framework.manager.HttpConnectionManager.HttpMethod;
import com.hillssoft.android.framework.manager.LoggerManager;
import com.hillssoft.android.framework.net.HttpConnectionResponseHandler;

public class MemberRegisterActivity extends BaseActivityManager {
	
	
	private EditText nickname;
	private EditText category;
	
	private Button registerBtn;
	
	
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
		category = (EditText)findViewById(R.id.category);
		registerBtn = (Button)findViewById(R.id.register_btn);
		
	}
	
	
	@Override
	protected void setInitializeViewEventListener() {
		super.setInitializeViewEventListener();
		
		registerBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				HashMap<String, String> params = new HashMap<String, String>();
				params.put("action_key", "register_uuid");
				params.put("nickname", nickname.getText().toString());
				params.put("category", category.getText().toString());
				HttpConnectionManager.getInstance().doRequest(HttpMethod.POST, responseHandler, "http://hoonil.codns.com/app_mtom/index.php", params);
			}
		});
		
	}
	
	
	private HttpConnectionResponseHandler responseHandler = new HttpConnectionResponseHandler(){
		public HttpResponse handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			super.handleResponse(response);
			LoggerManager.i(getResponseString());
			
			
			/*
			 * 
			 */
			String userId = getJsonToString("result");
			String sessionKey = getJsonToString("result");
			
			return response;
			
			
			
		}
	};
	
	
	
}
