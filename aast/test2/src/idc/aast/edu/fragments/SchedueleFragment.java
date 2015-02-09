package idc.aast.edu.fragments;

import idc.aast.edu.activities.Accounts;
import idc.aast.edu.activities.Login;
import idc.aast.edu.activities.SchedueleDetails;
import idc.aast.edu.adapters.SchedueleAdapters;
import idc.aast.edu.adapters.TabsPagerAdapter;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.scheduele_slot;
import idc.aast.edu.database.MySQLiteHelper;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;


import java.util.ArrayList;

import com.google.analytics.tracking.android.EasyTracker;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
 
public class SchedueleFragment extends Fragment {

	static Boolean bb = false;
	static String name;
	ArrayList<String> sch =  null;
	static String[] alldays;
	/** The rslt. */
	static SchedueleAdapters adap;
	/** The arr2. */
	static ArrayList<String> arr2; // used to have the name of the links
	static Student student;
	/** The arr3. */
	static ArrayList<String> arr3; // used to have the counts of the links
	static ListView myList;
	/** The rslt2. */
	static String count;
	static private ViewGroup container;
	@Override
	public void onStart() {
	
		// TODO Auto-generated method stub
		bb = false;

		SharedPreferences preferences1 = getActivity().getSharedPreferences(
				"AAST", 0);
		name = preferences1.getString("username", "noone");

		student = new Student(name, getActivity());
		if(sch==null)
	 sch = student.get_days();

		myList = (ListView) getView().findViewById(R.id.scheduele_main_list);
		myList.setOnItemClickListener(new OnItemClickListener(

		) {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int postition, long arg3) {
			
				Intent i = new Intent(getActivity(), SchedueleDetails.class);
				postition += 1;
				SchedueleDetails.day = postition + "";
				// i.putExtra("day_code",postition + "");
				 startActivity(i);
				
				
//				FragmentTransaction trans = getFragmentManager()
//						.beginTransaction();
//				/*
//				 * IMPORTANT: We use the "root frame" defined in
//				 * "root_fragment.xml" as the reference to replace fragment
//				 */
//				
//				  trans.replace (container.getId(),
//						new SchedueleDetailsFragment());
//
//				/*
//				 * IMPORTANT: The following lines allow us to add the fragment
//				 * to the stack and return to it later, by pressing back
//				 */
//				trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//				trans.addToBackStack(null);
//
//				trans.commit();

				// getFragmentManager().beginTransaction().replace(R.id.fragment_mainLayout,
				// new GamesFragment()).commit();
				// TODO Auto-generated method stub

			}
		});
		adap = new SchedueleAdapters(getActivity(), sch);
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		super.onStart();
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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.activity_sch_days, container,
				false);
		this.container=container;
		setHasOptionsMenu(true);
		return rootView;
	}

}
