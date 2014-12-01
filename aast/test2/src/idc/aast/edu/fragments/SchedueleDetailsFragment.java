package idc.aast.edu.fragments;

import idc.aast.edu.activities.CourseDetails;
import idc.aast.edu.adapters.SchedueleDetailAdapter;
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
import android.view.LayoutInflater;
import android.view.Menu;
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

	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		bb = false;
		Bundle extras = getArguments();//.getExtras();
		String day = "";
		if (extras != null) {
			day = extras.getString("day_code");
		}
		day="1";
		SharedPreferences preferences1 = getActivity(). getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");

		student = new Student(name, getActivity());
		sch = student.get_day_sch(day);

		ListView myList = (ListView) getActivity().findViewById(R.id.scheduele_sub_list);

		myList.setOnItemClickListener(new OnItemClickListener(

		) {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int postition, long arg3) {
				Intent in = new Intent(getActivity(),
						CourseDetails.class);
				postition+=1;
				for (int i = 0; i < sch.size(); i++) {
					scheduele_slot curr = sch.get(i);
					int start = Integer.parseInt(curr.getFrom());
					if (start == (postition * 2) || start == (postition*2 - 1)) {
						in.putExtra("course_code", curr.getCourse_code());
						startActivity(in);
					}
				}

				// TODO Auto-generated method stub

			}
		});

		adap = new SchedueleDetailAdapter(getActivity(), sch);
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		super.onStart();
	}
	
	/** The rslt2. */
	static String count;
	  @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
		   View rootView = inflater.inflate(R.layout.scheduele_detail_item, container, false);
		   setHasOptionsMenu(true);
	        return rootView;
	    }

}
