package base;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	protected void initializeView(){}
	protected void initializeBindService(){}
	protected void setInitializeViewEventListener(){}
}
