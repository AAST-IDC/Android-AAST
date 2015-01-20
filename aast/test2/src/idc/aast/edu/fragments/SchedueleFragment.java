package idc.aast.edu.fragments;

import idc.aast.edu.activities.SchedueleDetails;
import idc.aast.edu.adapters.SchedueleAdapters;
import idc.aast.edu.adapters.TabsPagerAdapter;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.scheduele_slot;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class SchedueleFragment extends Fragment {

	static Boolean bb = false;
	static String name;
	static ArrayList<scheduele_slot> sch;
	static String[] alldays;
	/** The rslt. */
	static SchedueleAdapters adap;
	/** The arr2. */
	static ArrayList<String> arr2; // used to have the name of the links
	static Student student;
	/** The arr3. */
	static ArrayList<String> arr3; // used to have the counts of the links

	/** The rslt2. */
	static String count;

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		bb = false;

		SharedPreferences preferences1 = getActivity().getSharedPreferences(
				"AAST", 0);
		name = preferences1.getString("username", "noone");

		student = new Student(name, getActivity());
		ArrayList<String> sch = student.get_days();

		ListView myList = (ListView) getActivity().findViewById(
				R.id.scheduele_main_list);
		myList.setOnItemClickListener(new OnItemClickListener(

		) {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int postition, long arg3) {
				//Intent i = new Intent(getActivity(), SchedueleDetails.class);
				postition += 1;
				// i.putExtra("day_code",postition + "");
				// startActivity(i);
				SchedueleDetailsFragment.day = postition + "";
				FragmentTransaction trans = getFragmentManager()
						.beginTransaction();
				/*
				 * IMPORTANT: We use the "root frame" defined in
				 * "root_fragment.xml" as the reference to replace fragment
				 */
				trans.replace(R.id.sch_root_frame,
						new SchedueleDetailsFragment());

				/*
				 * IMPORTANT: The following lines allow us to add the fragment
				 * to the stack and return to it later, by pressing back
				 */
				trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				trans.addToBackStack(null);

				trans.commit();

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

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_sch_days, container,
				false);
		setHasOptionsMenu(true);
		return rootView;
	}

}
