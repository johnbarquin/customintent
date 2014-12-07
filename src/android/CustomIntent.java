package com.electrosoftservice.customintent;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.content.Context;
import android.content.ComponentName;
import android.view.WindowManager;

public class CustomIntent extends CordovaPlugin {

	private static final String TAG = "qConnect";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Log.d(TAG, "Todo bien hasta aqui");
		try {

			Context context=this.cordova.getActivity().getApplicationContext();
			Intent it = new Intent("android.intent.action.MAIN");
			it.setClass(context, this.cordova.getActivity().getClass());
			it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			it.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED + WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD + WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON + WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
			context.getApplicationContext().startActivity(it);
            callbackContext.success();
			return true;

        } catch (Exception e) {
        	String msg = "Exception executing intent: " + e.getMessage();
        	System.err.println(msg);
        	Log.d(TAG, msg);
	        callbackContext.error(msg);
	        return false;
        }
	}	
}