package idc.aast.test2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class SchDays extends Activity {

	static Boolean bb = false;
	static String name;
	static   	ArrayList<scheduele_slot> sch;
	static String[] alldays;
	/** The rslt. */
	
	static adapter_scheduele adap;
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
		setContentView(R.layout.activity_sch_days);
		bb = false;


		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		name = preferences1.getString("username", "noone");
		
		 student = new Student(name, this)	;	
		 ArrayList<String> sch= student.get_days();
		 
		 
		 
		ListView myList = (ListView) findViewById(R.id.scheduele_main_list);
		myList.setOnItemClickListener( new OnItemClickListener(
				
				) {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int postition, long arg3) {
						Intent i=new Intent(SchDays.this,SchedueleDetails.class);
						postition+=1;
						i.putExtra("day_code",postition  + "");
						 startActivity(i); 
						// TODO Auto-generated method stub
						
					}
		});
		 adap = new  adapter_scheduele(this, sch);
			myList.setAdapter(adap);
			adap.notifyDataSetChanged();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sch_days, menu);
		return true;
	}

}
