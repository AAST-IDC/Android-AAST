package idc.aast.test2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.ListView;

public class SchedueleDetails extends Activity {

	static Boolean bb = false;
	static String name;
	static   	ArrayList<scheduele_slot> sch;
	static String[] alldays;
	/** The rslt. */
	
	static adapter_scheduele_detail adap;
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
		setContentView(R.layout.activity_scheduele_details);
		bb = false;
		Bundle extras = getIntent().getExtras();
		String day =""; 
		if (extras != null) {
		     day = extras.getString("day_code");
		}
		
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		
		 student = new Student(name, this)	;	
		 sch= student.get_day_sch(day);
		 
		 
		 
		 
		ListView myList = (ListView) findViewById(R.id.scheduele_sub_list);
		
		 adap = new  adapter_scheduele_detail(this, sch);
			myList.setAdapter(adap);
			adap.notifyDataSetChanged();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.scheduele_details, menu);
		return true;
	}

}
