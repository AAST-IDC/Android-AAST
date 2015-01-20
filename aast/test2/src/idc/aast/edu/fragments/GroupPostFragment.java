package idc.aast.edu.fragments;

import java.util.ArrayList;

import idc.aast.edu.CallWeb.CommunityCaller;
import idc.aast.edu.adapters.CommunityGroupAdapter;
import idc.aast.edu.adapters.PostAdapter;
import idc.aast.edu.classes.Post;
import idc.aast.edu.classes.community.Group;
import idc.aast.edu.classes.community.Helper;
import idc.aast.edu.classes.community.User;
import idc.aast.edu.database.helper;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class GroupPostFragment extends Fragment {

	static Boolean bb = false;
	static String name;
	static String type;
	static ArrayList<Post> posts = new ArrayList<Post>();
	static PostAdapter adap;
	static User us;
	static public String group_id = "3947";
	static public String group_name = "3947";
	static private ProgressBar spinner;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_group_post_fragment,
				container, false);

		return rootView;
	}

	@Override
	public void onStart() {

		// TODO Auto-generated method stub

		super.onStart();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		SharedPreferences preferences1 = getActivity().getSharedPreferences(
				"AAST", 0);
		name = preferences1.getString("username", "noone");
		type = preferences1.getString("type", "noone");
		Log.v("group_id", group_id);
		us = new User(getActivity(), name, type);
		
		TextView tv = (TextView) getActivity().findViewById(R.id.p_g_name);
		tv.setText(group_name);
		
		String all_ids = us.get_all_ids(group_id);
		Helper.getPosts(name, type, group_id, all_ids, getActivity());
		posts.clear();
		posts.addAll(us.get_posts(group_id));
		adap = new PostAdapter(getActivity(), posts);
		ListView myList = (ListView) getActivity().findViewById(
				R.id.Community_posts_List22);
		myList.setAdapter(adap);
		spinner = (ProgressBar) getActivity().findViewById(R.id.progressBar1);
		myList.setOnScrollListener(new OnScrollListener() {
			private int preLast;

			@Override
			public void onScroll(AbsListView lw, final int firstVisibleItem,
					final int visibleItemCount, final int totalItemCount) {

				// Make your calculation stuff here. You have all your
				// needed info from the parameters of this function.

				// Sample calculation to determine if the last
				// item is fully visible.
				final int lastItem = firstVisibleItem + visibleItemCount + 1;
				// Log.d("Last", firstVisibleItem + "_" + visibleItemCount);
				if (lastItem == totalItemCount) {
					if (preLast != lastItem) { // for last item

						LongOperation lo = new LongOperation();
						spinner.setVisibility(View.VISIBLE);
						lo.con = getActivity().getApplicationContext();
						lo.execute(new String[] { name, type });
						Log.d("Last", "Last");
						preLast = lastItem;

					}

				}

			}

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				// TODO Auto-generated method stub

			}
		});
		adap.notifyDataSetChanged();
		super.onResume();
	}

	private class LongOperation extends AsyncTask<String, Void, String> {
		private Context con;

		@Override
		protected String doInBackground(String... params) {

			CommunityCaller c = new CommunityCaller();
			c.user_id = name;
			c.user_type = type;
			c.group_id = group_id;
			User us = new User(getActivity(), name, type);

			String all_ids = us.get_all_ids(group_id);
			c.all_ids = all_ids;
			c.con = con;
			// get the links of the inbox , outbox .....
			c.function = "getGroupPosts";

			try {
				c.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			c.done = "no";
			c.start();
			while (c.done.equals("no")) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return "yes";

		}

		@Override
		protected void onPostExecute(String result) {
			String all_ids = us.get_all_ids(group_id);
			Helper.getPosts(name, type, group_id, all_ids, getActivity());
			posts.clear();
			adap.notifyDataSetChanged();
			posts.addAll(us.get_posts(group_id));
			spinner.setVisibility(View.GONE);
			super.onPostExecute(result);
		}

	}

}
