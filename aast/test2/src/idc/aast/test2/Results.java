package idc.aast.test2;

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
	static String[] paths;
	/** The rslt. */
	static String rslt;
	static adapter_results adap;
	/** The arr2. */
	static ArrayList<String> arr2 ; // used to have the name of the links
	
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
		// used for fading in and out
		
		setContentView(R.layout.activity_results);

        // Set the list's click listener

 
	
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		Caller c = new Caller();
		c.a = name;
		// get the links of the inbox , outbox .....
		c.c = "getresult";
		c.con = this;
		//rslt = "start";
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
		
		
		MySQLiteHelper db = new MySQLiteHelper(this);
		rslt=db.getmorasalat(name);
		ListView myList = (ListView) findViewById(R.id.results1);
		if (arr2 == null)
			arr2 = new ArrayList<String>();
		if (arr3 == null)
			arr3 = new ArrayList<String>();
		arr2.clear();
		arr3.clear();
	//	final ArrayList<String> terms = db.get_terms();
		//Collections.addAll(arr2, db.getresults(name).split("\\@"));
		
		ArrayList<String> terms = db.get_terms(name);
	 paths = new String[terms.size()];
		paths = terms.toArray(paths);
		 spinner = (Spinner)findViewById(R.id.spinner1);
	        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Results.this,
	                android.R.layout.simple_spinner_item,paths);

	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(adapter);
	        spinner.setOnItemSelectedListener(this);

		 
		
		 res = db.get_all_results(paths[0], name);
				
		 adap = new adapter_results(this, res, res);
	
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		
		// Bundle extras = getIntent().getExtras();
		// String value;
		//
		// value = extras.getString("item");
		//
		// int n1=value.indexOf("^",0);
		// int n2=value.indexOf("^",n1+1);
		// int n3=value.indexOf("^",n2+1);
		// int n4=value.indexOf("^",n3+1);
		// TextView t1;
		// t1=(TextView)findViewById(R.id.textviewtitle);
		// t1.setText(value.substring(0, n1));

		// TableLayout c = (TableLayout)findViewById(R.id.lay);

	}

	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onBackPressed()
	 */
 //   @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

     
    	
    	MySQLiteHelper db = new MySQLiteHelper(this);
    	res.clear();
        	res.addAll(  db.get_all_results(paths[position], name));
		

	
	
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
