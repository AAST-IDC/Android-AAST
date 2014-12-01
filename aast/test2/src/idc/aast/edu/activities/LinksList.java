/*
 * 
 */
package idc.aast.edu.activities;

import idc.aast.Other.MySQLiteHelper;
import idc.aast.edu.adapters.LinksAdapter;

import idc.aast.test2.R;

import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.bugsense.trace.BugSenseHandler;
import com.google.analytics.tracking.android.EasyTracker;


import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import android.annotation.TargetApi;
import android.app.AlertDialog;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;

import android.widget.ListView;

import android.widget.Toast;
// TODO: Auto-generated Javadoc
// this is the activity of the links
/**
 * The Class List_detail.
 */
@TargetApi(10)
public class LinksList extends ActionBarActivity implements TabListener {
	
	/** The double back to exit pressed once. */
	private boolean doubleBackToExitPressedOnce = false;
	
	/** The tabs. */
	private String[] tabs = { "Links", "Notifications" };
	
	/** The bb. */
	static Boolean bb = false;
	
	/** The rslt. */
	static String rslt;
	static String rslt2;
	/** The arr2. */
	static ArrayList<String> arr2 ; // used to have the name of the links
	
	/** The arr3. */
	static	ArrayList<String> arr3; // used to have the counts of the links

	public static String count;
	
	/* (non-Javadoc)
	 * @see android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */
	
	/**
	 * 
	 */static 	String name;
	 static String type;
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
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
	name = preferences1.getString("username", "noone");
	type = preferences1.getString("type", "0");
		BugSenseHandler.initAndStartSession(getApplicationContext(),"1fd17091");
		BugSenseHandler.addCrashExtraData("Name", name);
		bb = false;
		overridePendingTransition(0, 0);
		// used for fading in and out
	//	overridePendingTransition(R.anim.fadein2, R.anim.fadeout2);
		setContentView(R.layout.activity_list_detail);
//		mPlanetTitles = getResources().getStringArray(R.array.planets_array);
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.left_drawer);
//      
//        arr4 = new ArrayList<String>(set);
//        Collections.sort(arr4);
//        mPlanetTitles=arr4.toArray(new String[0]);
//     // Set the adapter for the list view
//        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.drawer_list_item,mPlanetTitles));
//        // Set the list's click listener
//
//        mDrawerList.setOnItemClickListener(new OnItemClickListener()
//        {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//					long arg3) {
//				ListActivity.filter=arr4.get(arg2);
//				   mDrawerList.setItemChecked(arg2, true);
//
//				mDrawerLayout.closeDrawer(mDrawerList);
//				
//			}
//        	
//			
//        });

		ActionBar actionBar = getSupportActionBar();
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}
		
	
		ListView myList = (ListView) findViewById(R.id.listView3);
		if (arr2 == null)
			arr2 = new ArrayList<String>();
		if (arr3 == null)
			arr3 = new ArrayList<String>();
		arr2.clear();
		arr3.clear();
		int prev=0;
		int nw=0;
		MySQLiteHelper db = new MySQLiteHelper(this);
		rslt2= db.getlinks(name);
		
	//	rslt="@nam1^https://www.google.com.eg/@nam2^https://www.facebook.com/@";
		while(rslt2.indexOf('@',prev)!=-1)
		{
			try {
				
			
			nw=rslt2.indexOf('@',prev);
			arr2.add(rslt2.substring(nw+1,rslt2.indexOf('^',nw)));
			arr3.add(rslt2.substring(rslt2.indexOf('^',nw)+1,rslt2.indexOf('@',nw+1)));
			  prev=nw+1;
			}
			catch (Exception e) {
				// TODO: handle exception
				prev=prev*1000;
			}
		}
		
//		arr2.add(" Õ  «· ‰›Ì–");
//		arr2.add("’‰œÊﬁ «·Ê«—œ");
//		arr2.add(" ’‰œÊﬁ «·’«œ—");
//		arr2.add("’‰œÊﬁ «·„‰ ÂÌ");
//		int n1 = count.indexOf("^", 0);
//		int n2 = count.indexOf("^", n1 + 1);
//		int n33 = count.indexOf("^", n2 + 1);
//		int n4 = count.indexOf("^", n33 + 1);
//		
//		arr3.add(count.substring(0, n1));
//		arr3.add(count.substring(n1 + 1, n2));
//		arr3.add(count.substring(n2 + 1, n33));
//		arr3.add(count.substring(n33 + 1));
		LinksAdapter adap = new LinksAdapter(this, arr2, arr2);
	
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String url="https://payslip.aast.edu/online_payroll/Emp_Salary.aspx";
				 url =arr3.get(arg2);
				 if(url.equals("results"))
				 {
						Intent i = new Intent(getApplicationContext(), Results.class);
						startActivity(i);
						return;
				 }
//				 if(url.equals("scheduele"))
//				 {
//						Intent i = new Intent(getApplicationContext(), SchDays.class);
//						startActivity(i);
//						return;
//				 }
//				 if(url.equals("news"))
//				 {
//						Intent i = new Intent(getApplicationContext(), News.class);
//						startActivity(i);
//						return;
//				 }
				String emp =name;
				try {
					
				emp = Encrypt(emp, "123");
				url=Encrypt(url, "123");
			
				
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Uri uri;
				try {
					
					int currentapiVersion = android.os.Build.VERSION.SDK_INT;
					
				
						if(type.equals("0"))
						uri = Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid=" +URLEncoder.encode(emp, "ISO-8859-1") +"&url=" +URLEncoder.encode(url, "ISO-8859-1")  );
						else
							uri = Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid=" +URLEncoder.encode(emp, "ISO-8859-1") +"&url=" +URLEncoder.encode(url, "ISO-8859-1")+ "&std=1" );
							//String xxx= "https://aastmtic.aast.edu/notification/AppMaster.aspx?empid=" +URLEncoder.encode(emp, "ISO-8859-1") +"&url=" +URLEncoder.encode(url, "ISO-8859-1");
								startActivity(new Intent(Intent.ACTION_VIEW, uri));
					
				//	uri = Uri.parse("https://aastmtic.aast.edu/notification/AppMaster.aspx?empid=" +URLEncoder.encode(emp, "ISO-8859-1") +"&url=" +URLEncoder.encode(url, "ISO-8859-1")  );
				
			//		String xxx= "https://aastmtic.aast.edu/notification/AppMaster.aspx?empid=" +URLEncoder.encode(emp, "ISO-8859-1") +"&url=" +URLEncoder.encode(url, "ISO-8859-1");
				//	startActivity(new Intent(Intent.ACTION_VIEW, uri));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
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
    String Encrypt(String text, String key)
    		throws Exception {
    		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    		byte[] keyBytes= new byte[16];
    		byte[] b= key.getBytes("UTF-8");
    		int len= b.length;
    		if (len > keyBytes.length) len = keyBytes.length;
    		System.arraycopy(b, 0, keyBytes, 0, len);
    		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
    		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
    		cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);

    		byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
    	
    		return 	Base64.encodeToString(results, Base64.DEFAULT);
    		} 
	public void onBackPressed() {
		if (doubleBackToExitPressedOnce) {

			super.onBackPressed();

			return;
		}
		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "Please click BACK again to exit",
				Toast.LENGTH_SHORT).show();
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				doubleBackToExitPressedOnce = false;

			}
		}, 2000);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.item1) {
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
		} else if (itemId == R.id.item2) {
			SharedPreferences preferences2 = getSharedPreferences("AAST", 0);
			Editor edit = preferences2.edit();
			edit.putString("login", "no");
			edit.commit();
			finish();
			return true;
		}  else if (itemId == R.id.item4) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					LinksList.this);
			builder.setTitle("About")
					.setMessage("Build number is" + Login.version)
					.setNegativeButton("Ok", null);
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		} 
		else if (itemId == R.id.item6) {
			Intent i = new Intent(this, Accounts.class);
			i.putExtra("id", "ok");
			 finish();
			startActivity(i);
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
			else if (arg0.getPosition() == 2) {
				Intent i = new Intent(getApplicationContext(),
						Accounts.class);
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
