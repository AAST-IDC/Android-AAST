package idc.aast.edu.activities;

import java.util.ArrayList;

import com.google.analytics.tracking.android.EasyTracker;
import com.parse.PushService;

import idc.aast.Other.MySQLiteHelper;
import idc.aast.Other.helper;
import idc.aast.edu.adapters.AccountsAdapter;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;


import android.content.ContentValues;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


import android.view.ContextMenu;

import android.view.Menu;

import android.view.MenuItem;
import android.view.View;

import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.Button;

import android.widget.ListView;



public class Accounts extends ActionBarActivity implements TabListener {
	static Boolean bb = false;
 
	static ArrayList<String> arr2 = new ArrayList<String>();
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
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		if (item.getTitle().equals("Remove")) {
			int pos = info.position;

			SharedPreferences preferences2 = getSharedPreferences("AAST", 0);
		
			MySQLiteHelper db = new MySQLiteHelper(this);
			db.deleteAccount(arr2.get(pos).substring(1));
			PushService.unsubscribe(getApplicationContext(), "a"+arr2.get(pos).substring(1));
			arr2.addAll(db.getAccountscon());
			Editor edit = preferences2.edit();
			Intent intent = getIntent();
			if(arr2.size()==0)
			{
				edit.putString("login", "no");
				edit.commit();
				finish();
				overridePendingTransition(0, 0);
				startActivity(intent);
			}
			else
			{
			
			edit.putString("username",arr2.get(0).substring(1));
			edit.putString("type", arr2.get(0).substring(0, 1));
			edit.putString("login", "ok");
			
			edit.commit();
		
		//	ContentValues cv = new ContentValues();
		//	cv.put("badgecount", db.getmessagecount(arr2.get(0).substring(1), arr2.get(0).substring(0,1), "")); // integer count you want to display
;
			//getContentResolver().update(Uri.parse("content://com.sec.badge/apps"), cv, "package=?", new String[] {getPackageName()}); 
			
			// Execute insert
			
			overridePendingTransition(0, 0);
			intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			
			finish();
			overridePendingTransition(0, 0);
			startActivity(intent);
			}
			
		}
		return super.onContextItemSelected(item);

	}



	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenu.ContextMenuInfo menuInfo) {
		if (v.getId() == R.id.listacc) {
			//ListView lv = (ListView) v;
			menu.clear();
			menu.add("Remove");
			// menu.add("Two");
			// menu.add("Three");
			// menu.add(obj.name);
		}
	}

	@Override
	protected void onResume() {
		SharedPreferences preferences2 = getSharedPreferences("AAST", 0);
		MySQLiteHelper db = new MySQLiteHelper(this);
		if(db.getAccountsCount()!=0 )
		{
			String name = preferences2.getString("username", "noone");
			String type = preferences2.getString("type", "noone");
			Editor edit = preferences2.edit();
			edit.putString("login", "ok");
			edit.commit();
			ArrayList<String> accarr =db.getAccountscon();
			if(!accarr.contains(type+name))
			{
				name=accarr.get(0).substring(1);
				type=accarr.get(0).substring(0,1);
			}
	        LongOperation lo= new LongOperation();
	        lo.con=this;
	        lo.execute(new String[]{name,type});
		}
		super.onResume();
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//overridePendingTransition(R.anim.fadein, R.anim.fadeout); // fadein and
																	// out
																	// animation
		bb = false;
		//overridePendingTransition(R.anim.fadein, R.anim.fadeout); // fadein and
																	// out
																	// animation
		ActionBar actionBar = getSupportActionBar(); // get the actionbar
		// actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setDisplayHomeAsUpEnabled(true);

		// put the tabs in the action bar

		// actionBar.setSelectedNavigationItem(1); // make the selected item the
		// second
		setContentView(R.layout.activity_accounts);

		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
	
		String name = preferences1.getString("username", "nooone");
		
		ListView listView = (ListView) findViewById(R.id.listacc);
		MySQLiteHelper db = new MySQLiteHelper(this);
		arr2=db.getAccountscon();
		AccountsAdapter adapter = new AccountsAdapter(this, arr2, name);
	//	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		//		android.R.layout.simple_list_item_2, android.R.id.text1, arr);
		listView.setAdapter(adapter);
		Button b = (Button) findViewById(R.id.buttonacc);
		registerForContextMenu(listView);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
				Editor e = preferences1.edit();
				e.putString("nine", "no");
				e.putBoolean("ig", true);
				e.commit();
				Intent i = new Intent(getApplicationContext(),
						Login.class);
				i.putExtra("only", "ok");
				startActivity(i);

			}
		});
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// ListView Clicked item index
				SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
				Editor e = preferences1.edit();
				e.putString("login", "ok");
				e.putString("username", arr2.get(position).substring(1));
				e.putString("type", arr2.get(position).substring(0, 1));
				
				e.commit();
				MySQLiteHelper db = new MySQLiteHelper(getApplicationContext());
				String name = arr2.get(position).substring(1);
				ContentValues cv = new ContentValues();
			//	
			//	cv.put("badgecount", db.getmessagecount(name, arr2.get(position).substring(0, 1), "")); // integer count you want to display
			
			//	getContentResolver().update(Uri.parse("content://com.sec.badge/apps"), cv, "package=?", new String[] {getPackageName()}); 
				LongOperation lo= new LongOperation();
		        lo.con=getApplicationContext();
		        lo.execute(new String[]{name,arr2.get(position).substring(0, 1)});
				Intent i = new Intent(getApplicationContext(),
						ListActivity.class);
				finish();
				startActivity(i);
				
				// ListView Clicked item value

				// Show Alert

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accounts, menu);
		return true;
	}

	@Override	
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		

	}


	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
	
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		if (preferences1.getString("login", "no").equals("ok")) {
			if (bb == false)
				bb = true;
			else {
				if (arg0.getPosition() == 0) {

					Intent i = new Intent(getApplicationContext(),
							LinksList.class);
					finish();
					startActivity(i);
					
				} else if (arg0.getPosition() == 1) {
					Intent i = new Intent(getApplicationContext(),
							ListActivity.class);
					startActivity(i);
					finish();
				} else if (arg0.getPosition() == 2) {

				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v7.app.ActionBar.TabListener#onTabUnselected(android.
	 * support.v7.app.ActionBar.Tab, android.support.v4.app.FragmentTransaction)
	 */
	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	
	}
	private class LongOperation extends AsyncTask<String, Void, String> {
		private Context con;
        @Override
        protected String doInBackground(String... params) {

        	helper.getall(con, params[0], params[1], getSharedPreferences("AAST", 0));
            return "Executed";
        }

     
    }
}
