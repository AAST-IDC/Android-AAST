/*
 * 
 */
package idc.aast.edu.adapters;

import idc.aast.edu.classes.Message;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.util.ArrayList;




import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;

import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;
// TODO: Auto-generated Javadoc

/**
 * The Class ListViewAdapter.
 */
@TargetApi(10)

public class NotificationAdapter extends BaseAdapter
{
	
	/** The context. */
	Activity context;
	 
 	/** The title. */
	ArrayList<Message> msgs;
	 
 	/** The description. */
 	ArrayList<String> description;
	 
 	/** The r. */
 	int [] r={196,0,248,86,255,134,};
	 
 	/** The g. */
 	int [] g={0,156,88,146,191,1};
	 
 	/** The b. */
 	int [] b={2,156,0,0,1,110};
	 
 	/** The searc. */
 	static Boolean searc=false;
	 
 	/** The word. */
 	static String word="";
	 
 	/** The r2. */
 	int [] r2={196,0,248,86,255,134,29};
	 
 	/** The g2. */
 	int [] g2={0,156,88,146,191,1,29};
	 
 	/** The b2. */
 	int [] b2={2,156,0,0,1,110,29};
	 
 	/** The nmon. */
 	String[] nmon = {"","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	  
  	/** The count. */
  	static int count=0;
	  
  	/** The counta. */
  	static int counta=0;

/** The dpi. */
static int dpi;
	
	/**
	 * Instantiates a new list view adapter.
	 *
	 * @param context the context
	 * @param title the title
	 * @param description the description
	 */
	public NotificationAdapter(Activity context,  ArrayList<Message> msgs) {
		super();
		count=0;
		
	//	TextView v=(TextView) context.findViewById(R.id.actionbar_notifcation_textview);
		//v.setText(""+ListViewAdapter2.count);
		this.context = context;
		this.msgs=msgs;
	
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	public int getCount() {
		// TODO Auto-generated method stub


		return msgs.size();


		
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see android.widget.BaseAdapter#notifyDataSetChanged()
	 */
	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
	
		
		super.notifyDataSetChanged();
		
	}
	
	/**
	 * The Class ViewHolder.
	 */
	private class ViewHolder {
        
        /** The txt view title. */
        TextView txtViewTitle;
        
        /** The txt view description. */
        TextView txtViewDescription;
        
        /** The time. */
     //   TextView time;
        
        /** The year. */
      //  TextView year;
        
       // /** The dumm. */
       // TextView dumm;
        
        /** The dumm1. */
       // TextView dumm1;
        
        /** The dumm2. */
        TextView col;
        
        /** The cat. */
        TextView cat;
        
        /** The date. */
        TextView date;
	 
 	/** The l layout. */
 	//LinearLayout lLayout;
        
	}
	
	/**
	 * Removes the.
	 *
	 * @param s the s
	 */
	public void remove(int s) {
	msgs.remove(s);
		
		//description.remove(s);
	
	}

	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		//Boolean ok = true;
		
		Message msg= msgs.get(position);
		 String mk;
		 
		// TODO Auto-generated method stub
		 try
		 {
			 	mk=msg.getSys_name();
		 }
		 catch(Exception e)
		 {
			 mk="2";
		 }
		ViewHolder holder;
		LayoutInflater inflater =  context.getLayoutInflater();
		int mod = 0;
		for(int i=0;i<mk.length();i++)
			mod+=mk.charAt(i);
		mod%=6;
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.list1, null);
			holder = new ViewHolder();
			holder.txtViewTitle = (TextView) convertView.findViewById(R.id.txtViewTitle2);
		//	holder.time = (TextView) convertView.findViewById(R.id.time);
			holder.txtViewDescription = (TextView) convertView.findViewById(R.id.txtViewDescription2);
		//	holder.dumm = (TextView) convertView.findViewById(R.id.textView44);
		//	holder.dumm1 = (TextView) convertView.findViewById(R.id.textView45);
			holder.cat = (TextView) convertView.findViewById(R.id.cat2);
			holder.date = (TextView) convertView.findViewById(R.id.date2);
			holder.col = (TextView) convertView.findViewById(R.id.col);
		//	holder.year = (TextView) convertView.findViewById(R.id.year);
		//	holder.lLayout = (LinearLayout) convertView.findViewById(R.id.linear_layout);
			convertView.setTag(holder);

		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
	
		if(msg.getRead().equals("1"))
		{
			convertView.setBackgroundColor(Color.rgb(245, 245, 245));
		//	holder.dumm.setBackgroundColor(Color.rgb(245, 245, 245));
		//	holder.dumm1.setBackgroundColor(Color.rgb(245, 245, 245));
		//	holder.dumm2.setBackgroundColor(Color.rgb(245, 245, 245));
			holder.txtViewDescription.setTextColor(Color.rgb(149, 149, 149));
			holder.txtViewTitle.setTextColor(Color.rgb(149, 149, 149));
			
		}
		else
		{
			count++;
			convertView.setBackgroundColor(Color.rgb(213, 213, 213));
	//		holder.dumm.setBackgroundColor(Color.rgb(213, 213, 213));
	//		holder.dumm1.setBackgroundColor(Color.rgb(213, 213, 213));
	//		holder.dumm2.setBackgroundColor(Color.rgb(213, 213, 213));
			holder.txtViewTitle.setTextColor(Color.BLACK);
			holder.txtViewDescription.setTextColor(Color.BLACK);
		}
		counta++;
		
	//	holder.time.setText(title.get(position).substring(11, 16));
	//	holder.time.setTextColor(Color.WHITE);
	//	holder.cat.setTextColor(Color.WHITE);
		holder.cat.setText(msg.getSys_name());
		holder.cat.setTypeface(null, Typeface.BOLD);
		holder.date.setTypeface(null, Typeface.BOLD);
	//	count++;
	//	holder.date.setBackgroundColor(Color.rgb(r[mod], g[mod], b[mod]));
		holder.col.setBackgroundColor(Color.rgb(r[mod], g[mod], b[mod]));
		holder.cat.setBackgroundColor(Color.rgb(r[mod], g[mod], b[mod]));
		
	//	holder.time.setBackgroundColor(Color.rgb((r[mod]<40 ) ? 0:r[mod]-40, (g[mod]<40 ) ? 0:g[mod]-40,(b[mod]<40 ) ? 0:b[mod]-40));
		//String til=msg;
		
		holder.date.setText("20"+msg.getDateTime().substring(0, 8)+"   "+msg.getDateTime().substring(11, 16));
		holder.date.setTextColor(Color.WHITE);
		holder.date.setTextSize(15);
		//holder.year.setTextColor(Color.WHITE);
	//	holder.year.setText("2\n0\n"+ til.charAt(0) +"\n"+ til.charAt(1));
		//holder.year.setTypeface(null, Typeface.BOLD);
		holder.date.setTextSize(15);
		holder.txtViewDescription.setTextSize(18);
		holder.txtViewDescription.setMaxLines(2);
		holder.txtViewDescription.setEllipsize(TruncateAt.END);
		holder.cat.setTextSize(14);
		holder.txtViewTitle.setTextSize(30);
		holder.cat.setTextColor(Color.WHITE);
		
		
		holder.date.setTextColor(Color.rgb(r[mod], g[mod], b[mod]));
		//String tempstr= title.get(position).substring(n1+1,n2);
		
	//	tempstr=tempstr.substring(0,i+3);
		holder.txtViewTitle.setText(msg.getMessage_title());
		holder.txtViewDescription.setText(msg.getMessage_desc());
		
	    int temd=dpi/7;
	    if(temd<110)
	    	temd=120;
		convertView.setMinimumHeight(100);
			convertView.setMinimumHeight(temd+1);
		
				return convertView;
	}

}
