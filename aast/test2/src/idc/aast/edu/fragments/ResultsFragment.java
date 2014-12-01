package idc.aast.edu.fragments;

import idc.aast.edu.adapters.adapter_results;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.result_item;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class ResultsFragment extends Fragment implements OnItemSelectedListener {

	private Spinner spinner;

	/** The double back to exit pressed once. */
	// private boolean doubleBackToExitPressedOnce = false;

	/** The tabs. */
	// private String[] tabs = { "Links", "Notifications" };

	/** The bb. */
	static Boolean bb = false;
	static String name;
	static ArrayList<result_item> res;
	static String[] all_terms;
	/** The rslt. */
	static String rslt;
	static adapter_results adap;
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
		


		SharedPreferences preferences1 = getActivity().getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		 student = new Student(name,getActivity());
		ListView myList = (ListView) getActivity().findViewById(R.id.results1);

		 spinner = (Spinner)getActivity().findViewById(R.id.spinner1);
	        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getActivity(),
	                android.R.layout.simple_spinner_item,student.get_terms());
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        spinner.setAdapter(adapter);
	        spinner.setOnItemSelectedListener(this);

		 res = student.get_results();
		 adap = new adapter_results(getActivity(), res, res);
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		super.onStart();
	}
	
	  @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
		   View rootView = inflater.inflate(R.layout.activity_results, container, false);
		   setHasOptionsMenu(true);
	        return rootView;
	    }
	    @Override
	    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

	     
	    	
	//    	MySQLiteHelper db = new MySQLiteHelper(getActivity());
	    	res.clear();
	        	res.addAll(  student.get_results(position));
			

		
		
			adap.notifyDataSetChanged();

	        
	    }

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
}
