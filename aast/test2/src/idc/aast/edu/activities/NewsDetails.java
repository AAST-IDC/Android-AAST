package idc.aast.edu.activities;


import com.google.analytics.tracking.android.EasyTracker;

import idc.aast.edu.classes.news_item;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class NewsDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_details);
		ViewHolder holder = new ViewHolder();
		holder.title = (TextView) findViewById(R.id.news_title);
		holder.desc = (TextView) findViewById(R.id.news_desc);
		Intent i = getIntent();
		
		news_item n =  i.getParcelableExtra("news_item");;
		holder.title.setText(n.title);
		holder.desc.setText(n.desc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news_details, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	    EasyTracker.getInstance(this).activityStart(this);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	    EasyTracker.getInstance(this).activityStop(this);
	}
}
class ViewHolder {
	 
		/** The link t. */
		TextView title;
		TextView desc;
	 
		/** The Count t. */
	
 
 }
