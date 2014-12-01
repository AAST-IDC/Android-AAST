package idc.aast.edu.fragments;

import java.util.ArrayList;

import idc.aast.edu.adapters.CommunityGroupAdapter;
import idc.aast.edu.adapters.NewsAdapter;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.news_item;
import idc.aast.edu.classes.community.Group;
import idc.aast.edu.classes.community.Helper;
import idc.aast.edu.classes.community.User;
import idc.aast.test2.R;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class GroupsFragment extends Fragment {

	static Boolean bb = false;
	static String name;
	static String type;
	static   	ArrayList<Group> usergroups;
	static CommunityGroupAdapter adap;
	static User user;
	@Override
	public void onStart() {
		
		// TODO Auto-generated method stub
		SharedPreferences preferences1 = getActivity().getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		type = preferences1.getString("usertype", "noone");
		Helper.getGroups(name, getActivity());
		User us = new User(getActivity(), name, type);
		usergroups = us.UsGroups;
		adap = new CommunityGroupAdapter(getActivity(), usergroups);
		ListView myList = (ListView) getActivity().findViewById(R.id.Community_Groups_List22);
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		super.onStart();
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
	   View rootView = inflater.inflate(R.layout.activity_groups_fragment, container, false);

        return rootView;
    }


}
