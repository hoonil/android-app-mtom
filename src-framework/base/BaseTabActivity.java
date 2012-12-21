package base;

import android.app.TabActivity;
import android.os.Bundle;

public class BaseTabActivity extends TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeTab();
		initializeBindService();
	}
	protected void initializeTab(){}
	protected void initializeBindService(){}
	
}
