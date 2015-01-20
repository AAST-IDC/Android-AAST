package idc.aast.edu.fragments;

import java.util.ArrayList;

import idc.aast.edu.activities.Accounts;
import idc.aast.edu.activities.Login;
import idc.aast.edu.adapters.CommunityGroupAdapter;
import idc.aast.edu.adapters.NewsAdapter;
import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.news_item;
import idc.aast.edu.classes.community.Group;
import idc.aast.edu.classes.community.Helper;
import idc.aast.edu.classes.community.User;
import idc.aast.edu.database.MySQLiteHelper;

import idc.aast.test2.R;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
		
		TextView usname = (TextView)getActivity().findViewById(R.id.us_user_name);
		usname.setText(us.getname());
		TextView usdep = (TextView)getActivity().findViewById(R.id.us_dep);
		usdep.setText(us.getdep());
		TextView ustitle = (TextView)getActivity().findViewById(R.id.us_title);
		ustitle.setText(us.gettitle());
		ImageView image = (ImageView)getActivity().findViewById(R.id.us_image);
		byte[] decodedString = Base64.decode(us.getimage(), Base64.DEFAULT);
		Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
		image.setImageBitmap(decodedByte);
		Display  display = getActivity().getWindowManager().getDefaultDisplay();
		//int swidth = display.();
		
		adap = new CommunityGroupAdapter(getActivity(), usergroups);
		ListView myList = (ListView) getActivity().findViewById(R.id.Community_Groups_List22);
		myList.setOnItemClickListener( new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				ViewPager vp=(ViewPager) getActivity().findViewById( R.id.page22r);
				GroupPostFragment.group_id = usergroups.get(position).group_id;
				GroupPostFragment.group_name = usergroups.get(position).group_name;
				//vp.destroyDrawingCache();
				//vp.setCurrentItem(1);
				FragmentTransaction trans = getFragmentManager()
						.beginTransaction();
				/*
				 * IMPORTANT: We use the "root frame" defined in
				 * "root_fragment.xml" as the reference to replace fragment
				 */
				trans.replace(R.id.post_root_frame, new GroupPostFragment());

				/*
				 * IMPORTANT: The following lines allow us to add the fragment
				 * to the stack and return to it later, by pressing back
				 */
				trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				trans.addToBackStack(null);

				trans.commit();

			
			
			}
		});
		myList.setAdapter(adap);
		adap.notifyDataSetChanged();
		
		super.onStart();
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
	   View rootView = inflater.inflate(R.layout.activity_groups_fragment, container, false);
	   setHasOptionsMenu(true);
        return rootView;
    }
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();

		super.onPause();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == android.R.id.home) {
			// ProjectsActivity is my 'home' activity
//			if (getResources().getString(R.string.app_config).equals("small")) {
//				if (!mDrawerLayout.isDrawerOpen(mDrawerList))
//					mDrawerLayout.openDrawer(mDrawerList);
//				else
//					mDrawerLayout.closeDrawer(mDrawerList);
//			}
			return true;
		} else if (itemId == R.id.item1) {
			MySQLiteHelper db = new MySQLiteHelper(getActivity().getApplicationContext());
			
			//TextView v=(TextView) context.findViewById(R.id.actionbar_notifcation_textview);
		//	v.setText(""+db.getmessagecount(name, type, filter));
			//ContentValues cv = new ContentValues();
		//	cv.put("badgecount", db.getmessagecount(name, type, ""));
			//getContentResolver().update(Uri.parse("content://com.sec.badge/apps"), cv, "package=?", new String[] {getPackageName()}); 
			return true;
		} else if (itemId == R.id.item2) {
			SharedPreferences preferences2 = getActivity().getSharedPreferences("AAST", 0);
			String acc = preferences2.getString("naccount", "");
			acc = acc.replace(type+name+ "^", "");

			Editor edit = preferences2.edit();
			if (acc.equals("^")) {
				edit.putString("login", "no");
				edit.commit();
				//finish();

			}
			if(!acc.equals("^"))
			edit.putString("username", acc.substring(2, acc.indexOf("^", 1)));
			edit.putString("type", acc.substring(1, 2));
			edit.putString("login", "no");
			edit.putString("naccount", acc);
			edit.commit();

			Intent i = new Intent(getActivity().getApplicationContext(), Accounts.class);
			//finish();	
			startActivity(i);
			
			// edit.putString("login", "no");

			return true;
		} else if (itemId == R.id.item4) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					getActivity());
			builder.setTitle("About")
					.setMessage("Build number is" + Login.version)
					.setNegativeButton("Ok", null);
			AlertDialog alert = builder.create();
			alert.show();
			return true;
		}  else if (itemId == R.id.item6) {
			Intent i = new Intent(getActivity(), Accounts.class);
			i.putExtra("id", "ok");
			// finish();
			startActivity(i);
			return true;
		}
		return true;
	}

}
