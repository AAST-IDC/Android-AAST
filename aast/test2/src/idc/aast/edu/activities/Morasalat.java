/*
 * 
 */
package idc.aast.edu.activities;


import idc.aast.edu.CallWeb.Caller;
import idc.aast.edu.adapters.MorasalatAdapter;
import idc.aast.edu.database.MySQLiteHelper;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;
import java.util.Collections;


import android.net.Uri;
import android.os.Bundle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;


import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;

// TODO: Auto-generated Javadoc
// this is the activity of the links
/**
 * The Class List_detail.
 */
@TargetApi(10)
public class Morasalat extends Activity implements TabListener {
	
	/** The double back to exit pressed once. */
//	private boolean doubleBackToExitPressedOnce = false;
	
	/** The tabs. */
//	private String[] tabs = { "Links", "Notifications" };
	
	/** The bb. */
	static Boolean bb = false;
	
	/** The rslt. */
	public static String rslt;
	
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bb = false;
		// used for fading in and out
		
		setContentView(R.layout.activity_morasalat);

        // Set the list's click listener

 
	
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		String name = preferences1.getString("username", "noone");
		Caller c = new Caller();
		c.a = name;
		// get the links of the inbox , outbox .....
		c.c = "getlinks_morasalat";
		c.con = this;
		//rslt = "start";
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		
		c= new Caller();
		c.a = name;
		// get the links of the inbox , outbox .....
		c.c = "getcounts";
		c.preferences1=preferences1;
		c.con = this;
		//rslt = "start";
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start();
		if(rslt==null)
			rslt="";
		if(rslt.equals("error"))
		{
			rslt= preferences1.getString("settlinks_morasalat", "http://www.aast.edu^http://www.aast.edu^http://www.aast.edu^http://www.aast.edu");
		}
		MySQLiteHelper db = new MySQLiteHelper(this);
		rslt=db.getmorasalat(name);
		ListView myList = (ListView) findViewById(R.id.morasalat1);
		if (arr2 == null)
			arr2 = new ArrayList<String>();
		if (arr3 == null)
			arr3 = new ArrayList<String>();
		arr2.clear();
		arr3.clear();
		count=preferences1.getString("counts", "0^0^0^0");
		arr2.add(" Õ  «· ‰›Ì–");
		arr2.add("’‰œÊﬁ «·Ê«—œ");
		arr2.add(" ’‰œÊﬁ «·’«œ—");
		arr2.add("’‰œÊﬁ «·„‰ ÂÌ");
		int n1 = count.indexOf("^", 0);
		int n2 = count.indexOf("^", n1 + 1);
		int n33 = count.indexOf("^", n2 + 1);
		//int n4 = count.indexOf("^", n33 + 1);
		
		arr3.add(count.substring(0, n1));
		arr3.add(count.substring(n1 + 1, n2));
		arr3.add(count.substring(n2 + 1, n33));
		arr3.add(count.substring(n33 + 1));
		MorasalatAdapter adap = new MorasalatAdapter(this, arr2, arr3);
	
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				String arr[] = new String[4];
				int n1 = rslt.indexOf("^", 0);
				int n2 = rslt.indexOf("^", n1 + 1);
				int n33 = rslt.indexOf("^", n2 + 1);
				//int n4 = rslt.indexOf("^", n33 + 1);
			//	int n5 = rslt.indexOf("^", n4 + 1);

				arr[0] = rslt.substring(0, n1);
				arr[1] = rslt.substring(n1 + 1, n2);
				arr[2] = rslt.substring(n2 + 1, n33);
				arr[3] = rslt.substring(n33 + 1);
				Uri uri = Uri.parse(arr[(arg2+3)%4]);
				startActivity(new Intent(Intent.ACTION_VIEW, uri));
			}
		});
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
					Morasalat.this);
			builder.setTitle("About")
					.setMessage("Build number is" + Login.version)
					.setNegativeButton("Ok", null);
			AlertDialog alert = builder.create();
			alert.show();

			return true;
		
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBar.TabListener#onTabReselected(android.support.v7.app.ActionBar.Tab, android.support.v4.app.FragmentTransaction)
	 */
	@Override
	public void onTabReselected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBar.TabListener#onTabSelected(android.support.v7.app.ActionBar.Tab, android.support.v4.app.FragmentTransaction)
	 */
	@Override
	public void onTabSelected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		if (bb == false)
			bb = true;
		else {
			if (arg0.getPosition() == 0) {

			} else if (arg0.getPosition() == 1) {
				Intent i = new Intent(getApplicationContext(),
						ListActivity.class);
				startActivity(i);
				finish();
			}
		}

	}

	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBar.TabListener#onTabUnselected(android.support.v7.app.ActionBar.Tab, android.support.v4.app.FragmentTransaction)
	 */
	@Override
	public void onTabUnselected(Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

}
