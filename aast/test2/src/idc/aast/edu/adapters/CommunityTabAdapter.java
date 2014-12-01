package idc.aast.edu.adapters;

import idc.aast.edu.fragments.GamesFragment;
import idc.aast.edu.fragments.GroupsFragment;
import idc.aast.edu.fragments.NewsFragment;
import idc.aast.edu.fragments.NotificationFragment;
import idc.aast.edu.fragments.ResultsFragment;
import idc.aast.edu.fragments.SchedueleFragment;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CommunityTabAdapter extends FragmentPagerAdapter {

	  public CommunityTabAdapter(FragmentManager fm) {
		  
		super(fm);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<String> tabs = new ArrayList<String>();

	@Override
	public Fragment getItem(int index) {
		 String nw = tabs.get(index);
	       if(nw=="Groups")
	    	   return new GroupsFragment();
	       else if(nw=="Notifications")
	    	   return new NotificationFragment();
	       else if(nw=="Schedule")
	    	   return new SchedueleFragment();
	       else if(nw=="News")
	    	   return new NewsFragment();
	       else 
	    	   return new GamesFragment();

	
	}

	  @Override
	   public int getCount() {
	       // get item count - equal to number of tabs
	       return tabs.size();
	   }
	   @Override
		public CharSequence getPageTitle(int position) {
			return tabs.get(position);
		}

}
