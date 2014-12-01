package idc.aast.edu.activities;

import java.util.ArrayList;

import idc.aast.Other.TabsPagerAdapter;
import idc.aast.edu.adapters.CommunityTabAdapter;
import idc.aast.test2.R;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar.Tab;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

@SuppressLint("NewApi") public class Community extends FragmentActivity implements TabListener {

	
	private ViewPager viewPager;
	private CommunityTabAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private ArrayList<String> tabss = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_community);
		
	
		tabss.add("Groups");

		tabss.add("Notifications");
		CommunityTabAdapter.tabs.addAll(tabss);
        // Initilization
        viewPager = (ViewPager) findViewById(R.id.page22r);
        actionBar = getActionBar();
        mAdapter = new CommunityTabAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
    
        // Bind the tabs to the ViewPager
//     

        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabss) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }
 
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
 
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
 
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
 
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
	}

	@Override
	public void onTabReselected(Tab arg0, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, android.app.FragmentTransaction arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

}
