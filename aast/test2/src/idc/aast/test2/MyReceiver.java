/*
 * 
 */
package idc.aast.test2;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
// TODO: Auto-generated Javadoc
import android.net.NetworkInfo;
import android.util.Log;

/**
 * The Class MyReceiver.
 */
@TargetApi(10)

public class MyReceiver extends BroadcastReceiver {

	/* (non-Javadoc)
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context, android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		
		

		  if(intent.getExtras()!=null) {
		        NetworkInfo ni=(NetworkInfo) intent.getExtras().get(ConnectivityManager.EXTRA_NETWORK_INFO);
		        if(ni!=null && ni.getState()==NetworkInfo.State.CONNECTED) {
		        //	ListActivity.amr();
		            Log.i("app","Network "+ni.getTypeName()+" connected");
		        } else if(intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,Boolean.FALSE)) {
		        	//ListActivity.am2r();
		            Log.d("app","There's no network connectivity");
		            
		        }
		  }
	}
}