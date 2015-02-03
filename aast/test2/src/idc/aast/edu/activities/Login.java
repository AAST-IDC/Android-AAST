/*
 * 
 */
package idc.aast.edu.activities;

import idc.aast.edu.CallWeb.Caller;
import idc.aast.edu.database.MySQLiteHelper;
import idc.aast.edu.database.helper;
import idc.aast.edu.webservice.STDWEBIServiceEvents;
import idc.aast.edu.webservice.STDWEBOperationResult;
import idc.aast.edu.webservice.STDWEBService1Soap;
import idc.aast.test2.HomePage;
import idc.aast.test2.R;
import idc.aast.test2.RoundedImageView;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.bugsense.trace.BugSenseHandler;

import android.net.Uri;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;

import android.animation.ValueAnimator;
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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.transition.Fade;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.MapBuilder;
import com.google.analytics.tracking.android.Tracker;
import com.nineoldandroids.animation.ObjectAnimator;

// TODO: Auto-generated Javadoc
/**
 * This is the class for that have the login activity and also retrieve the
 * basic preference from the web service
 */
@TargetApi(8)
public class Login extends Activity {

	/** The clos. */
	static Boolean clos = false;
	static Boolean another = false;
	/** The version. */
	public static String version = "2.2";

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

		EasyTracker.getInstance(this).activityStart(this); // Add this method.
	}

	@Override
	public void onStop() {
		super.onStop();

		EasyTracker.getInstance(this).activityStop(this); // Add this method.
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BugSenseHandler
				.initAndStartSession(getApplicationContext(), "1fd17091");

		MySQLiteHelper db = new MySQLiteHelper(this);

		int nacc = db.getAccountsCount();
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);

		Editor edit = preferences1.edit();
		if (nacc == 0) {

		} else if (preferences1.getString("nine", "yes").equals("no")) {
			edit.putString("nine", "yes");
			edit.commit();
		} else {

			// edit.putString("username", "8101423");
			// edit.putString("type", "1");
			edit.commit();
			String name = preferences1.getString("username", "noone");
			String type = preferences1.getString("type", "noone");

			edit.putString("login", "ok");
			ArrayList<String> accarr = db.getAccountscon();
			if (!accarr.contains(type + name)) {
				name = accarr.get(0).substring(1);
				type = accarr.get(0).substring(0, 1);
			}
			Tracker t = GoogleAnalytics.getInstance(getApplicationContext())
					.getTracker("UA-51484481-1");
			t.set("&uid", name);
			t.send(MapBuilder.createEvent("UX", // Event category (required)
					"Sign In", // Event action (required)
					null, // Event label
					null) // Event value
					.build());

			// ContentValues cv = new ContentValues();
			// cv.put("package", getPackageName());
			// Name of your activity declared in the manifest as
			// android.intent.action.MAIN.
			// Must be fully qualified name as shown below
			// cv.put("class", "com.example.test2.MainActivity");
			// cv.put("badgecount", db.getmessagecount(name, type, "")); //
			// integer count you want to display

			// Execute insert
			// getContentResolver().insert(Uri.parse("content://com.sec.badge/apps"),
			// cv);

			LongOperation lo = new LongOperation();
			lo.con = this;
			lo.execute(new String[] { name, type });

			finish();
			// open the list activity activity

			Intent i = new Intent(getApplicationContext(), HomePage.class);

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

			@SuppressLint("NewApi")
			@Override
			// on login button click
			public void onClick(View arg0) {
				InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

				inputManager.hideSoftInputFromWindow(getCurrentFocus()
						.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				// TODO Auto-generated method stub
				if (android.os.Build.VERSION.SDK_INT > 9) {
					StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
							.permitAll().build();
					StrictMode.setThreadPolicy(policy);
				}
				if (!helper.isInternetAvailable()) {

					Toast.makeText(getApplicationContext(),
							"No Internet Connection cannot login",
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
						final String name = Integer.toString(Integer
								.parseInt(ed1.getText().toString()));// get the
						// username
						String pass = ed2.getText().toString(); // get the
																// password

						rslt = "START";
						Caller c = new Caller();
						c.a = name;
						c.b = pass;
						// call the webservice login action
						c.c = "main";
						c.join();
						c.start();
						while (rslt == "START")// wait for the webservice
												// response
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

							final JSONObject reader = new JSONObject(rslt);
							final String image = reader.getString("image");

							rslt = reader.getString("ans");

							edit.putString("login", "ok"); // set the login to
															// true
							edit.putString("username", rslt.substring(1));
							edit.putString("type", rslt.substring(0, 1));

							Tracker t = GoogleAnalytics.getInstance(
									getApplicationContext()).getTracker(
									"UA-51484481-1");
							t.set("&uid", rslt.substring(1));
							t.send(MapBuilder.createEvent("UX", // Event
																// category
																// (required)
									"Sign In", // Event action (required)
									null, // Event label
									null) // Event value
									.build());

							LongOperation lo = new LongOperation();
							lo.con = getApplicationContext();
							lo.execute(new String[] { rslt.substring(1),
									rslt.substring(0, 1) });
							MySQLiteHelper db = new MySQLiteHelper(
									getApplicationContext());

							;
							db.addAccount(rslt.substring(1),
									rslt.substring(0, 1));
							db.setImage(image, rslt.substring(1));
							db.setjsondata(reader.toString(), rslt.substring(1));
							edit.commit(); // save the changes

							AlertDialog.Builder builder = new AlertDialog.Builder(
									Login.this);
							Intent i = new Intent(getApplicationContext(),
									HomePage.class);
							byte[] decodedString = Base64.decode(image,
									Base64.DEFAULT);
							Bitmap decodedByte = BitmapFactory.decodeByteArray(
									decodedString, 0, decodedString.length);
							RoundedImageView image1;
							image1 = (RoundedImageView) findViewById(R.id.userimage);
							image1.setImageBitmap(decodedByte);

							TextView txtOne = (TextView) findViewById(R.id.name);

							// txtTwo.getLocationInWindow(fromLoc);
							try {
								String us_name = reader.getString("name");
								String names[] = us_name.split(" ");
								if (names[0].length() > 3) {
									us_name = capitalizeWord(names[0]);

								} else {
									us_name = capitalizeWord(names[0]) + " "
											+ capitalizeWord(names[1]);
								}

								txtOne.setText("Welcome " + us_name);
							} catch (JSONException e) {
								// TODO Auto-generated
								// catch block
								e.printStackTrace();
							}
							Animation slide_in_left, slide_out_right;
							ViewAnimator viewAnimator;
							viewAnimator = (ViewAnimator) findViewById(R.id.viewanimator);

							slide_in_left = AnimationUtils.loadAnimation(
									getApplicationContext(),
									android.R.anim.slide_in_left);
							slide_out_right = AnimationUtils.loadAnimation(
									getApplicationContext(),
									android.R.anim.slide_out_right);

							viewAnimator.setInAnimation(slide_in_left);
							viewAnimator.setOutAnimation(slide_out_right);
							viewAnimator.showNext();
							
							TranslateAnimation t1 = new TranslateAnimation(
									(float) 0.0, (float) 0.0, (float) 1000.0,
									(float) 0.0);
							t1.setDuration(2000);
							AnimationSet animationSet = new AnimationSet(true);

							AlphaAnimation animation1 = new AlphaAnimation(0, 1);
							animation1.setDuration(2000);

							animationSet.addAnimation(t1);
							animationSet.addAnimation(animation1);
							txtOne.startAnimation(animationSet);
							// txtOne.startAnimation(t);
							// txtOne.animate().alphaBy(1).setDuration(5000).translationYBy(-1000).start();
							// image.animate().setStartDelay(2000).alphaBy(1).setDuration(3000).start();
							ScaleAnimation animation = new ScaleAnimation(1, 3,
									1, 3, Animation.RELATIVE_TO_SELF,
									(float) 0.5, Animation.RELATIVE_TO_SELF,
									(float) 0.5);
						
							
							animation.setDuration(1500);
							animation.setFillAfter(true);

							AlphaAnimation alphanim = new AlphaAnimation(0, 1);
							alphanim.setDuration(1500);

							AnimationSet imageset = new AnimationSet(true);
							imageset.addAnimation(animation);
							imageset.addAnimation(alphanim);
							imageset.setStartOffset(2000);
							imageset.setFillAfter(true);
							image1.startAnimation(imageset);
							TextView enjoy = (TextView) findViewById(R.id.enjoy);
							enjoy.animate().alpha(1).setStartDelay(3500).setDuration(1500).start();
							TextView your = (TextView) findViewById(R.id.your);
							your.animate().alpha(1).setStartDelay(5000).setDuration(1500).start();
							Button continu = (Button) findViewById(R.id.continu);
							continu.animate().alpha(1).setStartDelay(6500).setDuration(1500).start();
							continu.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									Intent i = new Intent(getApplicationContext(), HomePage.class);

									startActivity(i);

								}
							});

							// finish();
							// startActivity(i);
							//

						} else// in case not logged in
						{
							edit.putString("login", "no");
							;
							Toast.makeText(getApplicationContext(),
									"Login Failed", Toast.LENGTH_LONG).show();
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

	public static String capitalizeWord(String word) {
		if (word.length() > 0) {
			char[] lowered = word.toLowerCase().toCharArray();
			lowered[0] = Character.toUpperCase(lowered[0]);
			word = new String(lowered);
		}

		return word;
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

			if (helper.isInternetAvailable()) {
				helper.getall(con, params[0], params[1],
						getSharedPreferences("AAST", 0));
				return "Executed";
			} else {
				return "none";

				// setResult(RESULT_CANCELED);
			}
		}

		@Override
		protected void onPostExecute(String result) {
			if (result.equals("none")) {
				Toast.makeText(
						getApplicationContext(),
						"No Internet Connection Application may be out of date",
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
