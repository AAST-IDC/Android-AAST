package idc.aast.edu.fragments;

import idc.aast.edu.activities.Accounts;
import idc.aast.edu.activities.Login;
import idc.aast.edu.adapters.ResultsAdapter;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.result_item;
import idc.aast.edu.database.MySQLiteHelper;
import idc.aast.edu.database.helper;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;

import com.google.analytics.tracking.android.EasyTracker;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class ResultsFragment extends Fragment implements OnItemSelectedListener {

	private static Spinner spinner;

	/** The double back to exit pressed once. */
	// private boolean doubleBackToExitPressedOnce = false;

	/** The tabs. */
	// private String[] tabs = { "Links", "Notifications" };

	/** The bb. */
public static ProgressDialog  progress;
	static Boolean bb = false;
	static String name;
	static ArrayList<result_item> res;
	static String[] all_terms;
	static ArrayAdapter<String> adapter;
	/** The rslt. */
	static String rslt;
	static ResultsAdapter adap;
	/** The arr2. */
	static ArrayList<String> arr2; // used to have the name of the links
	static Student student;
	/** The arr3. */
	static ArrayList<String> arr3; // used to have the counts of the links

	/** The rslt2. */
	static String count;
@Override
public void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
	EasyTracker.getInstance(getActivity()).activityStop(getActivity());
}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		EasyTracker.getInstance(getActivity()).activityStart(getActivity());
		bb = false;

		SharedPreferences preferences1 = getActivity().getSharedPreferences(
				"AAST", 0);
		name = preferences1.getString("username", "noone");
		student = new Student(name, getActivity());
		ListView myList = (ListView) getActivity().findViewById(R.id.results1);

		spinner = (Spinner) getActivity().findViewById(R.id.spinner1);
		 adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, student.get_terms());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		
		res = student.get_results();
		adap = new ResultsAdapter(getActivity(), res, res);
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		super.onStart();
	}
	public static void runOnUiThread(Runnable runnable){
        final Handler UIHandler = new Handler(Looper.getMainLooper());
        runnable = new Runnable() {
			
			@Override
			public void run() {
				
				res.clear();
				
				res.addAll(student.get_results(spinner.getSelectedItemPosition()));

				adap.notifyDataSetChanged();
				//spinner = (Spinner) getActivity().findViewById(R.id.spinner1);
				 adapter = new ArrayAdapter<String>(student.con,
						android.R.layout.simple_spinner_item, student.get_terms());
				adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adapter);
				
			}
		};
        UIHandler .post(runnable);
    } 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_results, container,
				false);
		setHasOptionsMenu(true);
		return rootView;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {

		// MySQLiteHelper db = new MySQLiteHelper(getActivity());
		res.clear();
		res.addAll(student.get_results(position));

		adap.notifyDataSetChanged();

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			// ProjectsActivity is my 'home' activity
			// if
			// (getResources().getString(R.string.app_config).equals("small")) {
			// if (!mDrawerLayout.isDrawerOpen(mDrawerList))
			// mDrawerLayout.openDrawer(mDrawerList);
			// else
			// mDrawerLayout.closeDrawer(mDrawerList);
			// }
			return true;
		} else if (itemId == R.id.item1) {
			MySQLiteHelper db = new MySQLiteHelper(getActivity()
					.getApplicationContext());
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
			.permitAll().build();
			StrictMode.setThreadPolicy(policy);
			if (helper.isInternetAvailable()) {
				helper.getResults_all(name, getActivity());
				 progress = new ProgressDialog(getActivity());
				progress.setTitle("Loading");
				progress.setMessage("Wait while loading...");
				progress.setCancelable(false);
				progress.show();
			} else {
				Toast.makeText(getActivity().getApplicationContext(),
						"No Internet Connection",
						Toast.LENGTH_LONG).show();

			}
			Handler handler = new Handler();
			handler.postDelayed(new Runnable(){
			@Override
			      public void run(){
			      progress.dismiss();
			   }
			}, 3000);
			// context.findViewById(R.id.actionbar_notifcation_textview);
			// v.setText(""+db.getmessagecount(name, type, filter));
			// ContentValues cv = new ContentValues();
			// cv.put("badgecount", db.getmessagecount(name, type, ""));
			// getContentResolver().update(Uri.parse("content://com.sec.badge/apps"),
			// cv, "package=?", new String[] {getPackageName()});
			return true;
		} else if (itemId == R.id.item2) {
			SharedPreferences preferences2 = getActivity()
					.getSharedPreferences("AAST", 0);
			String acc = preferences2.getString("naccount", "");
			String type = preferences2.getString("type", "");
			acc = acc.replace(type + name + "^", ""); 

			Editor edit = preferences2.edit();
			if (acc.equals("^")) {
				edit.putString("login", "no");
				edit.commit();
				// finish();

			}
			if (!acc.equals("^"))
				edit.putString("username",
						acc.substring(2, acc.indexOf("^", 1)));
			edit.putString("type", acc.substring(1, 2));
			edit.putString("login", "no");
			edit.putString("naccount", acc);
			edit.commit();

			Intent i = new Intent(getActivity().getApplicationContext(),
					Accounts.class);
			// finish();
			startActivity(i);

			// edit.putString("login", "no");

			return true;
		} else if (itemId == R.id.item4) {
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setTitle("About AAST Portal")
					.setMessage("AAST Portal v." + Login.version + System.getProperty("line.separator") + "All Rights reserved to Arab Academy For Science And Technology" + System.getProperty("line.separator") + "Information And Documentation Center" + System.getProperty("line.separator") + "2015")
					.setNegativeButton("Ok", null);
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		} else if (itemId == R.id.item6) {
			Intent i = new Intent(getActivity(), Accounts.class);
			i.putExtra("id", "ok");
			// finish();
			startActivity(i);
			return true;
		}
		return true;
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}
