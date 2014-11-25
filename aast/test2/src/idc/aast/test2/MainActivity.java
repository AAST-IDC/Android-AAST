/*
 * 
 */
package idc.aast.test2;

import idc.aast.test2.Caller;

import java.util.ArrayList;


import com.bugsense.trace.BugSenseHandler;



import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;



// TODO: Auto-generated Javadoc
/**
 * This is the class for that have the login activity and also retrieve the
 * basic preference from the web service
 */
@TargetApi(8)
public class MainActivity extends Activity { 

	/** The clos. */
	static Boolean clos = false;
	static Boolean another = false;
	/** The version. */
	static String version = "2.2";

	/** The rslt. */
	public static String rslt = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	  public void onStart() {
	    super.onStart();

	
	    EasyTracker.getInstance(this).activityStart(this);  // Add this method.
	  }
	@Override
	  public void onStop() {
	    super.onStop();

	    EasyTracker.getInstance(this).activityStop(this);  // Add this method.
	  }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BugSenseHandler
				.initAndStartSession(getApplicationContext(), "1fd17091");

		MySQLiteHelper db = new MySQLiteHelper(this);

		int nacc= db.getAccountsCount();
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		
		Editor edit = preferences1.edit();
		if(nacc==0)
		{
			
			
		}
		else if(preferences1.getString("nine", "yes").equals("no"))
		{
			edit.putString("nine","yes");
			edit.commit();
		}
		else
		{
		
			String name = preferences1.getString("username", "noone");
			String type = preferences1.getString("type", "noone");
			
			edit.putString("login", "ok");
			ArrayList<String> accarr =db.getAccountscon();
			if(!accarr.contains(type+name))
			{
				name=accarr.get(0).substring(1);
				type=accarr.get(0).substring(0,1);
			}
			Tracker t = GoogleAnalytics.getInstance(getApplicationContext()).getTracker("UA-51484481-1");
			 t.set("&uid", name);
			 t.send(MapBuilder
				      .createEvent("UX",       // Event category (required)
				                   "Sign In",  // Event action (required)
				                   null,       // Event label
				                   null)       // Event value
				      .build());

	//		ContentValues cv = new ContentValues();
		//	cv.put("package", getPackageName());
			// Name of your activity declared in the manifest as android.intent.action.MAIN.
			// Must be fully qualified name as shown below
		//	cv.put("class", "com.example.test2.MainActivity");
		//	cv.put("badgecount", db.getmessagecount(name, type, "")); // integer count you want to display

			// Execute insert
			//getContentResolver().insert(Uri.parse("content://com.sec.badge/apps"), cv);
		
				 LongOperation lo= new LongOperation();
				 lo.con=this;
				 lo.execute(new String[]{name,type});
				 
		
			finish();
			// open the list activity activity
		
			Intent i = new Intent(getApplicationContext(), ListActivity.class);
 
			startActivity(i);
			
		}  
		
		


		setContentView(R.layout.activity_main);

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
		super.onResume();
		// get the user preference
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);

		Editor edit1 = preferences1.edit();
 
		edit1.commit();

		// get the login buttom view
		Button b1 = (Button) findViewById(R.id.button1);
		final AlertDialog ad = new AlertDialog.Builder(this).create();
		// use this to start and trigger a service
// Start the back
															// ground service

		// add listener to the login button
		b1.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi") @Override
			// on login button click
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				if(!helper.isInternetAvailable())
				{
					if (android.os.Build.VERSION.SDK_INT > 9) {
					    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
					    StrictMode.setThreadPolicy(policy);
					}
					Toast.makeText(getApplicationContext(), "No Internet Connection cannot login",
							   Toast.LENGTH_LONG).show();
					
				}
				
				else
					
				{
				try {
					EditText ed1 = (EditText) findViewById(R.id.editText1); // get
																			// the
																			// username
																			// view
					EditText ed2 = (EditText) findViewById(R.id.editText2); // get
																			// the
																			// password
																			// view
					// int a=Integer.parseInt(ed1.getText().toString());
					// int b=Integer.parseInt(ed2.getText().toString());
					final String name = Integer.toString(Integer.parseInt(ed1.getText().toString()));// get the
																	// username
					String pass = ed2.getText().toString(); // get the password
					rslt = "START";
					Caller c = new Caller();
					c.a = name;
					c.b = pass;
					// call the webservice login action
					c.c = "main";
					c.join();
					c.start();
					while (rslt == "START")// wait for the webservice response
					{
						try {
							Thread.sleep(10);
						} catch (Exception ex) {
						}
					}
					SharedPreferences preferences = getSharedPreferences(
							"AAST", 0);

					Editor edit = preferences.edit();
					// if the user lgged in
					if (!rslt.equals("0")) {
						
					
						
						edit.putString("login", "ok"); // set the login to true
						edit.putString("username", rslt.substring(1));
						edit.putString("type", rslt.substring(0, 1)); 
						
						Tracker t = GoogleAnalytics.getInstance(getApplicationContext()).getTracker("UA-51484481-1");
						 t.set("&uid", rslt.substring(1));
						 t.send(MapBuilder
							      .createEvent("UX",       // Event category (required)
							                   "Sign In"	,  // Event action (required)
							                   null,       // Event label
							                   null)       // Event value
							      .build());
						 

						LongOperation lo= new LongOperation();
				        lo.con=getApplicationContext();
				        lo.execute(new String[]{rslt.substring(1),rslt.substring(0,1)});
						MySQLiteHelper db = new MySQLiteHelper(
								getApplicationContext());
					
					;
						db.addAccount(rslt.substring(1), rslt.substring(0, 1));
						edit.commit(); // save the changes
						
					
						AlertDialog.Builder builder = new AlertDialog.Builder(
								MainActivity.this);
						builder.setTitle("Retrieve")
								.setMessage("Do You want to retrieve all data")
								.setNegativeButton("No",
										new DialogInterface.OnClickListener()// no
																				// retrieve
																				// data
																				// listener
										{
											public void onClick(
													DialogInterface dialog,
													int which) {
												Intent i = new Intent(
														getApplicationContext(),
														ListActivity.class);

												finish();
												startActivity(i);
												//
											}
										}

								)

								.setIcon(android.R.drawable.ic_dialog_alert)
								.setPositiveButton("Yes",
										new DialogInterface.OnClickListener() // retrieved
																				// data
																				// approved
																				// listiner
										{
											public void onClick(
													DialogInterface dialog,
													int which) {
												SharedPreferences pref = getSharedPreferences(
														"AAST", 0);
												Caller c = new Caller();
												c.a = pref.getString(
														"username", "noone");
												c.b = pref.getString("type",
														"noone");
												// call the webservice tht will
												// get all the previeous data
												c.c = "getall";

												Editor edit1 = pref.edit();
												//String name = pref.getString(
													//	"username", "noone");// get
																				// the
																				// username
												// the
												MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());
												db.deleteAllMessage(pref.getString(
														"username", "noone"));							// size
												edit1.commit(); // save the
																// data;
												c.con = getApplicationContext(); // pass
																					// the
																					// current
																					// contect
												try {
													c.join();
												} catch (InterruptedException e) {
													// TODO Auto-generated catch
													// block
													e.printStackTrace();
												}
												c.start();
												while (!rslt.equals("ssa")) {
													try {
														Thread.sleep(10);
													} catch (Exception ex) {
													}
												}
												Intent i = new Intent(
														getApplicationContext(),
														ListActivity.class);
												finish();
												startActivity(i);
												// do some thing here which you
												// need
											}
										}

								);
						AlertDialog alert = builder.create();
						alert.show();

					} else// in case not logged in
					{
						edit.putString("login", "no");
						;
						Toast.makeText(getApplicationContext(), "Login Failed",
								Toast.LENGTH_LONG).show();
						ed2.setText("");
						ad.setMessage("Login Failed");
						;
						// ad.show();
					}

					// finish();

				} catch (Exception ex) {
					ad.setTitle("Error!");
					ad.setMessage(ex.toString());
				}
				}
				// ad.show();

			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */


	private class LongOperation extends AsyncTask<String, Void, String> {
		private Context con;
        @Override
        protected String doInBackground(String... params) {
        	
       	 if(helper.isInternetAvailable())
		 {
          	helper.getall(con, params[0], params[1], getSharedPreferences("AAST", 0));
            return "Executed";
		 }
		 else
		 {
			   return "none";
		
			// setResult(RESULT_CANCELED);
		 }
        }
        @Override
        
        protected void onPostExecute(String result) {
        	if(result.equals( "none"))
            {
         		 Toast.makeText(getApplicationContext(), "No Internet Connection Application may be out of date",
   					   Toast.LENGTH_LONG).show();
         	   
            }
        	super.onPostExecute(result);
        }

     
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

}
