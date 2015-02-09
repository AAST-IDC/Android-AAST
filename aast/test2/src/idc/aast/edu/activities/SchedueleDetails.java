package idc.aast.edu.activities;

import idc.aast.edu.adapters.SchedueleDetailAdapter;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.scheduele_slot;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;

import java.util.ArrayList;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SchedueleDetails extends Activity {

	static Boolean bb = false;
	static String name;
	static ArrayList<scheduele_slot> sch;
	static String[] alldays;
	/** The rslt. */

	static SchedueleDetailAdapter adap;
	/** The arr2. */
	static ArrayList<String> arr2; // used to have the name of the links
	static Student student;
	/** The arr3. */
	static ArrayList<String> arr3; // used to have the counts of the links

	/** The rslt2. */
	static String count;
	public static String day;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scheduele_details);
		bb = false;
		
	

		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");

		student = new Student(name, this);
		sch = student.get_day_sch(day);

		ListView myList = (ListView) findViewById(R.id.scheduele_sub_list);

		
		adap = new SchedueleDetailAdapter(this, sch);
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();

	}
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

			return true;
		} else if (itemId == R.id.item4) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("About AAST Portal")
			.setMessage("AAST Portal v." + Login.version + System.getProperty("line.separator") + "All Rights reserved to Arab Academy For Science And Technology" + System.getProperty("line.separator") + "Information And Documentation Center" + System.getProperty("line.separator") + "2015")
					.setNegativeButton("Ok", null);
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		} else if (itemId == R.id.item6) {
			Intent i = new Intent(this, Accounts.class);
			i.putExtra("id", "ok");
			// finish();
			startActivity(i);
			return true;
		}
		return true;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scheduele_details, menu);
		return true;
	}

}
