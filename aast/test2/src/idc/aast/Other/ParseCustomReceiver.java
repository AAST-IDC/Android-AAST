package idc.aast.Other;

import idc.aast.edu.classes.Message;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ParseCustomReceiver extends BroadcastReceiver {
private static final String TAG = "MyCustomReceiver";
 
  @Override
  public void onReceive(Context context, Intent intent) {
    try {
      String action = intent.getAction();
      String channel = intent.getExtras().getString("com.parse.Channel");
      JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
 
      Log.d(TAG, "got action " + action + " on channel " + channel + " with:");
      Iterator itr = json.keys();
      while (itr.hasNext()) {
        String key = (String) itr.next();
        if(key.equals("mess"))
        {
        	
        	String mess = json.getString(key); 
        	MySQLiteHelper db = new MySQLiteHelper(context);
        	Date d = new Date();
			Format formatter = new SimpleDateFormat(
					"yy-MM-dd \n HH:mm:ss");
        	db.addMessage(new Message(mess.toString(),formatter.format(d),json.getString("name"),json.getString("stype")));
        }
        Log.d(TAG, "..." + key + " => " + json.getString(key));
      }
    } catch (JSONException e) {
      Log.d(TAG, "JSONException: " + e.getMessage());
    }
  }
}