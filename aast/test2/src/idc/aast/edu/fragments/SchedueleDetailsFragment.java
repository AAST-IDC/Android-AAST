package idc.aast.edu.fragments;

import idc.aast.edu.activities.Accounts;
import idc.aast.edu.activities.CourseDetails;
import idc.aast.edu.activities.Login;
import idc.aast.edu.adapters.SchedueleDetailAdapter;
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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SchedueleDetailsFragment extends Fragment {

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

	public static String day;
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
		
		SharedPreferences preferences1 = getActivity(). getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");

		student = new Student(name, getActivity());
		sch = student.get_day_sch(day);

		ListView myList = (ListView) getView().findViewById(R.id.scheduele_sub_list);

		myList.setOnItemClickListener(new OnItemClickListener(

		) {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int postition, long arg3) {
//				Intent in = new Intent(getActivity(),
//						CourseDetails.class);
//				postition+=1;
//				for (int i = 0; i < sch.size(); i++) {
//					scheduele_slot curr = sch.get(i);
//					int start = Integer.parseInt(curr.getFrom());
//					if (start == (postition * 2) || start == (postition*2 - 1)) {
//						in.putExtra("course_code", curr.getCourse_code());
//						startActivity(in);
//					}
//				}

				// TODO Auto-generated method stub

			}
		});

		adap = new SchedueleDetailAdapter(getActivity(), sch);
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
;
			// TextView v=(TextView)
			// context.findViewById(R.id.actionbar_notifcation_textview);
			// v.setText(""+db.getmessagecount(name, type, filter));
			// ContentValues cv = new ContentValues();
			// cv.put("badgecount", db.getmessagecount(name, type, ""));
			// getContentResolver().update(Uri.parse("content://com.sec.badge/apps"),
			// cv, "package=?", new String[] {getPackageName()});
			return true;
		}else if (itemId == R.id.item4) {
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
	/** The rslt2. */
	static String count;
	  @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
		   View rootView = inflater.inflate(R.layout.activity_scheduele_details, container, false);
		   setHasOptionsMenu(true);
	        return rootView;
	    }

}
