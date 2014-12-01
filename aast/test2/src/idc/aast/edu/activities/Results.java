package idc.aast.edu.activities;

import idc.aast.Other.MySQLiteHelper;
import idc.aast.edu.adapters.adapter_results;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.result_item;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.google.analytics.tracking.android.EasyTracker;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.ActionBar.Tab;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Results extends Activity implements OnItemSelectedListener{ 

    private Spinner spinner;

	/** The double back to exit pressed once. */
//	private boolean doubleBackToExitPressedOnce = false;
	
	/** The tabs. */
//	private String[] tabs = { "Links", "Notifications" };
	
	/** The bb. */
	static Boolean bb = false;
	static String name;
	static   	ArrayList<result_item> res;
	static String[] all_terms;
	/** The rslt. */
	static String rslt;
	static adapter_results adap;
	/** The arr2. */
	static ArrayList<String> arr2 ; // used to have the name of the links
	static Student student;
	/** The arr3. */
	static	ArrayList<String> arr3; // used to have the counts of the links
	
	/** The rslt2. */
	static String count;
	
	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */
	
	/**
	 * 
	 */
	// private String[] mPlanetTitles;
   // private DrawerLayout mDrawerLayout;
   // private ListView mDrawerList;
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
		bb = false;
	
		setContentView(R.layout.activity_results);

		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		 student = new Student(name,this);
		ListView myList = (ListView) findViewById(R.id.results1);

		 spinner = (Spinner)findViewById(R.id.spinner1);
	        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Results.this,
	                android.R.layout.simple_spinner_item,student.get_terms());
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(adapter);
	        spinner.setOnItemSelectedListener(this);

		 res = student.get_results();
		 adap = new adapter_results(this, res, res);
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
	}

	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onBackPressed()
	 */
 //   @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

     
    	
    	MySQLiteHelper db = new MySQLiteHelper(this);
    	res.clear();
        	res.addAll(  student.get_results(position));
		

	
	
		adap.notifyDataSetChanged();

        
    }
	public void onBackPressed() {
		
			super.onBackPressed();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.item1:
			SharedPreferences preferences1 = getSharedPreferences("AAST", 0);

			int size = preferences1.getInt(ListActivity.name + "_size", 0);
			if (ListActivity.arr == null)
				ListActivity.arr = new ArrayList<String>();

			ListActivity.arr.clear();
			for (int i = 0; i < size; i++) {
				ListActivity.arr.add(preferences1.getString(ListActivity.name
						+ "_" + i, null));
			}
			Collections.sort(ListActivity.arr, Collections.reverseOrder());
			ListActivity.lviewAdapter.notifyDataSetChanged();

			return true;
		case R.id.item2:
			SharedPreferences preferences2 = getSharedPreferences("AAST", 0);

			Editor edit = preferences2.edit();
			edit.putString("login", "no");
			edit.commit();
			finish();

			return true;

		case R.id.item4:
			AlertDialog.Builder builder = new AlertDialog.Builder(
					Results.this);
			builder.setTitle("About")
					.setMessage("Build number is" + MainActivity.version)
					.setNegativeButton("Ok", null);
			AlertDialog alert = builder.create();
			alert.show();

			return true;
		
		}
		return true;
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBar.TabListener#onTabReselected(android.support.v7.app.ActionBar.Tab, android.support.v4.app.FragmentTransaction)
	 */
	

}
