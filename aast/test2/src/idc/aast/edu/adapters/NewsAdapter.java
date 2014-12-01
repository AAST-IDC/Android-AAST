package idc.aast.edu.adapters;


import idc.aast.edu.classes.news_item;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {


	Activity context;
	ArrayList<news_item> news;
 	/** The links. */

	public NewsAdapter(Activity context,ArrayList<news_item> news ) {
		this.context = context;
		this.news = news;
	}
	private class ViewHolder {
		 
 		/** The link t. */
 		TextView title;
 		TextView desc;
		 
 		/** The Count t. */
 	
	 
	 }
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		LayoutInflater inflater =  context.getLayoutInflater();
	
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.news_item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.news_title);
			holder.desc = (TextView) convertView.findViewById(R.id.news_desc);
			convertView.setTag(holder);

		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		news_item n = news.get(position);
		holder.title.setText(n.title);
		holder.desc.setText(n.desc);
		
		// TODO Auto-generated method stub
		return convertView;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return news.size();
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