package com.hillssoft.android.framework.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.Gravity;
import android.widget.Toast;

import com.hillssoft.android.R;
import com.hillssoft.android.app.mtom.application.AppGlobalApplication;
import com.hillssoft.android.app.mtom.conf.AppConf;
import com.hillssoft.android.framework.manager.LoggerManager;

public class DialogUtils {

	private Context context;
	//private NotificationManager notificationManager;
	private Object waitingDialogLock = new Object();
	private ProgressDialog waitingDialog;
	
	public DialogUtils(Context context) {
		this.context = context;
	}

	public ProgressDialog showWaitingDialog() {
		return showWaitingDialog(false);
	}

	public ProgressDialog showWaitingDialog(boolean cancelable) {
		return showWaitingDialog(R.string.message_for_waiting_dialog, cancelable);
	}

	public ProgressDialog showWaitingDialog(int messageResourceId) {
		return showWaitingDialog(messageResourceId, false);
	}

	public ProgressDialog showWaitingDialog(int messageResourceId, boolean cancelable) {
		ProgressDialog dialog = getWaitingDialog();
		dialog.setMessage(context.getString(messageResourceId));
		dialog.setCancelable(cancelable);
		if (dialog.isShowing()) {
			return dialog;
		}
		
		try {
			dialog.show();
		} catch (Exception e) {
			LoggerManager.e(e);
		}
		return dialog;
	}

	public void cancelWaitingDialog() {
		try {
			ProgressDialog dialog = getWaitingDialog();
			dialog.cancel();
			synchronized (waitingDialogLock) {
				waitingDialog = null;
			}
		} catch (Exception e) {
			LoggerManager.d(e);
		}
	}

	private ProgressDialog getWaitingDialog() {
		synchronized (waitingDialogLock) {
			if (waitingDialog != null)
				return waitingDialog;

			waitingDialog = new ProgressDialog(context);
			return waitingDialog;
		}
	}
	
	////////////////////////////////////////////////////////////////////////
	// static method
	////////////////////////////////////////////////////////////////////////
	
//	private static final IKakaoSkeletonConfig skeletonConfig = AppGlobalApplication.getAppGlobalApplicationContext().getSkeletonConfig();
	private static AlertDialog errorAlert;

	public static void resetErrorAlert() {
		if (errorAlert != null) {
			try {
				errorAlert.cancel();
			} catch (Exception e) {
			}
		}
		errorAlert = null;
	}

	public static void showErrorAlert(int resourceId) {
		showErrorAlert(AppGlobalApplication.getAppGlobalApplicationContext().getString(resourceId), null);
	}
//
//	public static void showErrorAlert(int resourceId, Runnable run) {
//		showErrorAlert(AppGlobalApplication.getAppGlobalApplicationContext().getString(resourceId), run);
//	}

	public static void showUnknowError(boolean report) {
		showErrorAlert(AppGlobalApplication.getAppGlobalApplicationContext().getString(R.string.error_message_for_unknown_error), null, report);
	}
//
//	public static void showUnknowErrorAndFinish(final Activity activity, boolean report) {
//		showErrorAlert(AppGlobalApplication.getAppGlobalApplicationContext().getString(R.string.error_message_for_unknown_error), new Runnable() {
//			@Override
//			public void run() {
//				activity.finish();
//			}
//		}, report);
//	}
//
//	public static void showErrorAlert(int resourceId, boolean report) {
//		showErrorAlert(AppGlobalApplication.getAppGlobalApplicationContext().getString(resourceId), null, report);
//	}

	public static void showErrorAlert(String message) {
		showErrorAlert(message, null, false);
	}

	public static void showErrorAlert(String message, Runnable run) {
		showErrorAlert(message, run, false);
	}
//
//	public static void showErrorAlert(int resourceId, final Runnable runnable, boolean report) {
//		showErrorAlert(AppGlobalApplication.getAppGlobalApplicationContext().getString(resourceId), runnable, report);
//	}

	public static synchronized void showErrorAlert(String message, final Runnable runnable, boolean report) {
		Context context = AppGlobalApplication.getAppGlobalApplicationContext().getCurrentActivity();

		if (context == null)
			return;

		if (errorAlert != null && errorAlert.isShowing()) {
			return;
		}

		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setCancelable(false);
		builder.setOnCancelListener(new OnCancelListener() {
			public void onCancel(DialogInterface dialog) {
				resetErrorAlert();
			}
		});

		if (report) {
			/*
			 * [ Error 리포트 전송 ]
			 */
			//skeletonConfig.getErrorReportDialog(builder, message, runnable);
			
			
			
			
		} else {
			builder.setMessage(message);
			builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
					if (runnable != null) {
						runnable.run();
					}
				}
			});
		}

		errorAlert = builder.create();
		errorAlert.show();

		if (AppConf.LOGGER_IS_DEBUGGABLE) {
			LoggerManager.w(new Exception(message));
		}
	}
	

	public static Toast showAlertForNetworkIsNotUnavailable() {
		return showToastMessage(R.string.error_message_for_network_is_unavailable, Toast.LENGTH_LONG);
	}

	public static Toast showToastMessage(String message) {
		return showToastMessage(message, Toast.LENGTH_SHORT);
	}

	public static Toast showToastMessage(String message, int length) {
		Context context = AppGlobalApplication.getAppGlobalApplicationContext();
		Toast toast = Toast.makeText(context, message, length);
		toast.setGravity(Gravity.TOP, 0, 150);
		toast.show();
		return toast;
	}

	public static Toast showToastMessage(int resourceId) {
		return showToastMessage(resourceId, Toast.LENGTH_SHORT);
	}

	public static Toast showToastMessage(int resourceId, int length) {
		return showToastMessage(AppGlobalApplication.getAppGlobalApplicationContext().getString(resourceId), length);
	}
//
//	public static void showErrorAlertAndRestartPackage(final Context context, int resourceId) {
//		AlertDialog.Builder builder = new AlertDialog.Builder(context);
//		builder.setCancelable(true);
//		builder.setMessage(context.getString(resourceId));
//		builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int id) {
//				dialog.cancel();
//				ApplicationHelper.getInstance().restartPackage();
//			}
//		});
//		try {
//			builder.show();
//		} catch (Exception e) {
//			Logger.d(e);
//		}
//	}
//
//	public static void showErrorAlertAndFinish(final Activity activity, int resourceId) {
//		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//		builder.setCancelable(true);
//		builder.setMessage(activity.getString(resourceId));
//		builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int id) {
//				dialog.cancel();
//				activity.setResult(Activity.RESULT_CANCELED);
//				activity.finish();
//			}
//		});
//		try {
//			builder.show();
//		} catch (Exception e) {
//			Logger.d(e);
//		}
//	}
//
	public static void showUnexpectedError(String code) {
		String m = AppGlobalApplication.getAppGlobalApplicationContext().getString(R.string.error_messsage_for_unknown_server_code);
		showErrorAlert(String.format(m, code));
	}


}
