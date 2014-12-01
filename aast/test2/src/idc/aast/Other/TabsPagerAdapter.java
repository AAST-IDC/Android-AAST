package idc.aast.Other;


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

public class TabsPagerAdapter extends FragmentPagerAdapter {


	
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    private String[] tabs = { "Notification", "Schedule", "News" };
    @Override
    public Fragment getItem(int index) {
 
    	String nw = tabs[index];
    	 if(nw=="Results")
      	   return new ResultsFragment();
         else if(nw=="Notification")
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
        return 3;
    }

}