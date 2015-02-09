package idc.aast.edu.adapters;


import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.appcompat.R.color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SchedueleAdapters extends BaseAdapter {

	Activity context;
	 
 	/** The links. */
 	ArrayList<String> days; // contain the links of the inbox, outbox ....
 	 enum days_n {Saturday, Sunday, Monday, Tuesday,Wednesday,Thursday};
	public SchedueleAdapters(Activity context,ArrayList<String> days ) {
		this.context = context;
		this.days = days;
	}
	private class ViewHolder {
		 
 		/** The link t. */
 		TextView Day;
		 
 		/** The Count t. */
 	
	 
	 }
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		LayoutInflater inflater =  context.getLayoutInflater();
	
	
			convertView = inflater.inflate(R.layout.scheduele_day_item, null);
			holder = new ViewHolder();
			holder.Day = (TextView) convertView.findViewById(R.id.day_name);
	

	
		
		if(days.get(position) == "none")
		{
				convertView.setBackgroundColor(Color.GRAY);
				holder.Day.setTextColor(Color.parseColor("#DDDDDD"));
			
		} 
		else
		{
			
			convertView.setBackgroundColor(Color.parseColor("#364C62"));
			holder.Day.setTextColor(Color.parseColor("#FFFFFF"));
		}
			holder.Day.setText(days_n.values()[position].toString());
		
		// TODO Auto-generated method stub
		return convertView;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return days.size();
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
