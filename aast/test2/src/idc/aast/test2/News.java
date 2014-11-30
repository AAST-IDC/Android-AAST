package idc.aast.test2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class News extends Activity {
	static Boolean bb = false;
	static String name;
	static   	ArrayList<news_item> news;
	static String[] alldays;
	/** The rslt. */
	
	static adapter_news adap;
	/** The arr2. */
	static ArrayList<String> arr2 ; // used to have the name of the links
	static Student student;
	/** The arr3. */
	static	ArrayList<String> arr3; // used to have the counts of the links
	
	/** The rslt2. */
	static String count;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news, menu);

		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		
		 student = new Student(name, this)	;	
		news= student.get_news();
		 
		 
		 
		ListView myList = (ListView) findViewById(R.id.news_main_list);
		myList.setOnItemClickListener( new OnItemClickListener(
				
				) {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int postition, long arg3) {
					Intent i=new Intent(News.this,NewsDetails.class);
//						postition+=1;
					news_item n = news.get(postition);
					i.putExtra("news_item",n);
						 startActivity(i);
//						// TODO Auto-generated method stub
//						
					}
		});
		 adap = new  adapter_news(this, news);
			myList.setAdapter(adap);
			adap.notifyDataSetChanged();
		return true;
	}

}
