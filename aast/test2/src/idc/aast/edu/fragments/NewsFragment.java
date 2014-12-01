package idc.aast.edu.fragments;

import idc.aast.edu.activities.NewsDetails;
import idc.aast.edu.adapters.adapter_news;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.news_item;
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

public class NewsFragment extends Fragment {
	static Boolean bb = false;
	static String name;
	static   	ArrayList<news_item> news;
	static String[] alldays;
	/** The rslt. */
	
	static adapter_news adap;
	/** The arr2. */
	static ArrayList<String> arr2 ; // used to have the name of the links
	static Student student;
	/** The arr3. */
	static	ArrayList<String> arr3; // used to have the counts of the links
	
	/** The rslt2. */
	static String count;
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		SharedPreferences preferences1 = getActivity().getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		
		 student = new Student(name, getActivity())	;	
		news= student.get_news();
		 
		 
		 
		ListView myList = (ListView) getActivity().findViewById(R.id.news_main_list);
		myList.setOnItemClickListener( new OnItemClickListener(
				
				) {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int postition, long arg3) {
					Intent i=new Intent(getActivity(),NewsDetails.class);
//						postition+=1;
					news_item n = news.get(postition);
					i.putExtra("news_item",n);
						 startActivity(i);
//						// TODO Auto-generated method stub
//						
					}
		});
		 adap = new  adapter_news(getActivity(), news);
			myList.setAdapter(adap);
			adap.notifyDataSetChanged();
		super.onStart();
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
	   View rootView = inflater.inflate(R.layout.activity_news, container, false);
	   setHasOptionsMenu(true);
        return rootView;
    }


}
