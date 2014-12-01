package idc.aast.test2;


import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

   public TabsPagerAdapter(FragmentManager fm) {
       super(fm);
   }
   static ArrayList<String> tabs = new ArrayList<String>();
   @Override
   public Fragment getItem(int index) {

       String nw = tabs.get(index);
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
       return tabs.size();
   }
   @Override
	public CharSequence getPageTitle(int position) {
		return tabs.get(position);
	}

}