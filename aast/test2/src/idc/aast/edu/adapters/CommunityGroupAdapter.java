package idc.aast.edu.adapters;



import idc.aast.edu.classes.news_item;
import idc.aast.edu.classes.community.Group;
import idc.aast.test2.R;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CommunityGroupAdapter extends BaseAdapter {


	Activity context;
	ArrayList<Group> us;
 	/** The links. */

	public CommunityGroupAdapter(Activity context,ArrayList<Group> us ) {
		this.context = context;
		this.us = us;
	}
	private class ViewHolder {
		 
 		/** The link t. */
 		TextView title;
 		TextView desc;
		 
 		/** The Count t. */
 	
	 
	 }
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		if(position == 3)
		{
			ViewHolder holder;
			LayoutInflater inflater =  context.getLayoutInflater();
		
			if (convertView == null)
			{
				convertView = inflater.inflate(R.layout.news_item, null);
				holder = new ViewHolder();
				holder.title = (TextView) convertView.findViewById(R.id.news_title);
			//	holder.desc = (TextView) convertView.findViewById(R.id.news_desc);
				convertView.setTag(holder);

			}
			else
			{
				holder = (ViewHolder) convertView.getTag();
			}
			
			Group n = us.get(position);
			holder.title.setText(n.group_name);
			//holder.desc.setText(n.desc);
			
			// TODO Auto-generated method stub
			return convertView;
		
		}
		else
		{
		ViewHolder holder;
		LayoutInflater inflater =  context.getLayoutInflater();
	
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.community_groups_item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.Community_group_item_text);
		//	holder.desc = (TextView) convertView.findViewById(R.id.news_desc);
			convertView.setTag(holder);

		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		Group n = us.get(position);
		holder.title.setText(n.group_name);
		//holder.desc.setText(n.desc);
		
		// TODO Auto-generated method stub
		return convertView;
		}
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return us.size();
	}
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}


}