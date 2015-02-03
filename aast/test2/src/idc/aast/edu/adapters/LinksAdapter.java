/*
 * 
 */
package idc.aast.edu.adapters;

import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.google.analytics.containertag.proto.MutableServing.Resource;




import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class ListDetailsAdapter.
 */
public class LinksAdapter extends BaseAdapter {

	/** The context. */
	Activity context;
	 
 	/** The links. */
 	ArrayList<String> links; // contain the links of the inbox, outbox ....

	 /** The count. */
 	ArrayList<String> count; // contains of the counts of all

	 /**
 	 * Instantiates a new list details adapter.
 	 *
 	 * @param context the context
 	 * @param links the links
 	 * @param count the count
 	 */
 	public LinksAdapter(Activity context,ArrayList<String> links,ArrayList<String> count)
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
 		TextView linkT;
		 
 		/** The Count t. */
 		ImageView image;
	 
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
			convertView = inflater.inflate(R.layout.simple_list_item_1, null);
			holder = new ViewHolder();
			holder.linkT = (TextView) convertView.findViewById(R.id.text1);
			holder.image = (ImageView) convertView.findViewById(R.id.textView111);
		
			convertView.setTag(holder);
 
		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.linkT.setText(links.get(position));

		try { 
	
      String x = links.get(position);
      x = x.replace(" ", "_").toLowerCase();
      Resources res =  context.getResources();
      String mDrawableName = "logo_default";
      
      int resID = res.getIdentifier(x , "drawable", context.getPackageName());
      Drawable drawable = res.getDrawable(resID );
			holder.image.setImageDrawable(drawable);
			
		}catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		// TODO Auto-generated method stub
		return convertView;
	}

}
