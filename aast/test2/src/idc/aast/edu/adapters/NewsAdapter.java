package idc.aast.edu.adapters;


import idc.aast.edu.classes.news_item;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {

	 int [] r={196,0,248,86,255,134,};
	 int [] g={0,156,88,146,191,1};
	 int [] b={2,156,0,0,1,110};
	 static Boolean searc=false;
	 static String word="";
	 int [] r2={196,0,248,86,255,134,29};
	 int [] g2={0,156,88,146,191,1,29};
	 int [] b2={2,156,0,0,1,110,29};
	 String[] nmon = {"","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	Activity context;
	ArrayList<news_item> news;
 	/** The links. */

	public NewsAdapter(Activity context,ArrayList<news_item> news ) {
		this.context = context;
		this.news = news;
	}
	private class ViewHolder {
        TextView txtViewTitle;
        TextView txtViewDescription;
        TextView time;
        TextView year;
        TextView dumm;
        TextView dumm1;
        TextView dumm2;
        TextView cat;
        TextView date;
	 LinearLayout lLayout;
        
	}
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		LayoutInflater inflater =  context.getLayoutInflater();
	
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.activity_test, null);
			holder = new ViewHolder();
			holder = new ViewHolder();
			holder.txtViewTitle = (TextView) convertView.findViewById(R.id.title);
			holder.time = (TextView) convertView.findViewById(R.id.time);
			holder.txtViewDescription = (TextView) convertView.findViewById(R.id.desc);
			holder.dumm = (TextView) convertView.findViewById(R.id.textView44);
			holder.dumm1 = (TextView) convertView.findViewById(R.id.textView45);
			holder.cat = (TextView) convertView.findViewById(R.id.cat);
			holder.date = (TextView) convertView.findViewById(R.id.Date);
			holder.dumm2 = (TextView) convertView.findViewById(R.id.textView46);
			holder.year = (TextView) convertView.findViewById(R.id.year);
			holder.lLayout = (LinearLayout) convertView.findViewById(R.id.linear_layout);
			convertView.setTag(holder);

		}
		else
		{
			holder = (ViewHolder) convertView.getTag();
		}
		
		news_item n = news.get(position);
		convertView.setBackgroundColor(Color.rgb(213, 213, 213));
		holder.dumm.setBackgroundColor(Color.rgb(213, 213, 213));
		holder.dumm1.setBackgroundColor(Color.rgb(213, 213, 213));
		holder.dumm2.setBackgroundColor(Color.rgb(213, 213, 213));
		holder.txtViewTitle.setTextColor(Color.BLACK);
		holder.txtViewDescription.setTextColor(Color.BLACK);;
		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  Date date = null;
		try {
			date = format.parse(n.date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		holder.time.setText(new SimpleDateFormat("MMM").format(cal.getTime()));
		holder.time.setTextColor(Color.WHITE);
		holder.cat.setTextColor(Color.WHITE);
		holder.cat.setText("news");
		holder.cat.setTypeface(null, Typeface.BOLD);
	//	count++;
		int mod = 2;
		holder.date.setBackgroundColor(Color.rgb(r[mod], g[mod], b[mod]));
		holder.cat.setBackgroundColor(Color.rgb(r[mod], g[mod], b[mod]));
		
		holder.time.setBackgroundColor(Color.rgb((r[mod]<40 ) ? 0:r[mod]-40, (g[mod]<40 ) ? 0:g[mod]-40,(b[mod]<40 ) ? 0:b[mod]-40));
	//	String til=title.get(position);
		
		holder.date.setText(new SimpleDateFormat("dd").format(cal.getTime())+  System.getProperty("line.separator") +nmon[Integer.parseInt( new SimpleDateFormat("MM").format(cal.getTime()))  ]);
		holder.date.setTextColor(Color.WHITE);
		holder.date.setTextSize(21);
		holder.year.setTextColor(Color.WHITE);
		holder.year.setText("2\n0\n"+ "1" +"\n"+ "5");
		holder.year.setTypeface(null, Typeface.BOLD);
		
		holder.cat.setTextSize(15);
		holder.txtViewTitle.setTextSize(20);
		holder.txtViewTitle.setText(n.title);
		holder.txtViewDescription.setText(n.desc);
		convertView.setMinimumHeight(250);
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