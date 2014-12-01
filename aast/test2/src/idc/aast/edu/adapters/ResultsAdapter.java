package idc.aast.edu.adapters;

import idc.aast.edu.classes.result_item;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;



import android.R.string;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class ResultsAdapter extends BaseAdapter {

	/** The context. */
	Activity context;
	 
 	/** The links. */
 	ArrayList<result_item> links; // contain the links of the inbox, outbox ....

	 /** The count. */
 	ArrayList<result_item> count; // contains of the counts of all

	 /**
 	 * Instantiates a new list details adapter.
 	 *
 	 * @param context the context
 	 * @param links the links
 	 * @param count the count
 	 */
@Override
public void notifyDataSetChanged() {
	// TODO Auto-generated method stub
	super.notifyDataSetChanged();
}
 	
 	public ResultsAdapter(Activity context,ArrayList<result_item> links,ArrayList<result_item> count)
	 {
		 this.context=context;
		 this.links=links;
		 this.count=count;
	 }
	 
 	/**
 	 * The Class ViewHolder.
 	 */
 	private class ViewHolder {
		 
 		/** The link t. */
 		TextView cname;
 		TextView seven;
 		TextView tewelve;
 		TextView a3mal;
 		TextView sfinal;
	 }
	 
	 /* (non-Javadoc)
 	 * @see android.widget.Adapter#getCount()
 	 */
 	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return links.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		LayoutInflater inflater =  context.getLayoutInflater();
	
		if (convertView == null)  
		{
			convertView = inflater.inflate(R.layout.results_item, null);
			holder = new ViewHolder();
			holder.cname = (TextView) convertView.findViewById(R.id.cname);
			holder.seven = (TextView) convertView.findViewById(R.id.seven);
			holder.tewelve = (TextView) convertView.findViewById(R.id.twelve);
			holder.sfinal = (TextView) convertView.findViewById(R.id.a3mal);
			holder.a3mal = (TextView) convertView.findViewById(R.id.ffinal);
		
			convertView.setTag(holder);

		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		try
		{
		result_item x = links.get(position);
 		holder.cname.setText(x.getCourse() + "   " + x.getCourse_code());
		holder.seven.setText(x.getSeventh_degree());
		holder.tewelve.setText(x.getTwelves_degree());
		holder.sfinal.setText(x.getSemi_degree());
		holder.a3mal.setText(x.getGrade_degree());
		}
		catch (Exception e)
		{
			return convertView;
		}
		// TODO Auto-generated method stub
		return convertView;
	}
}
