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

public class CustomIntent extends CordovaPlugin {

	public static final String ACTION_RUN_GEO = "geo";
	private static final String TAG = "qConnect";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Log.d(TAG, "Todo bien hasta aqui");
		try {


			String url_str = "geo:37.786971,-122.399677";
			Uri uri = Uri.parse(url_str);
			Intent it = new Intent(Intent.ACTION_VIEW);
			it.setData(uri);
            this.cordova.getActivity().startActivity(it);
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