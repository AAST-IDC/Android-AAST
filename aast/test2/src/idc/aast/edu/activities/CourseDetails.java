package idc.aast.edu.activities;


import idc.aast.edu.classes.Student;
import idc.aast.edu.classes.result_item;
import idc.aast.test2.R;
import idc.aast.test2.R.id;
import idc.aast.test2.R.layout;
import idc.aast.test2.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.TextView;

public class CourseDetails extends Activity {

	
	 	private class ViewHolder {
			 
	 		/** The link t. */
	 		TextView cname;
	 		TextView seven;
	 		TextView tewelve;
	 		TextView a3mal;
	 		TextView sfinal;
		 }
		 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_course_details);
		Bundle extras = getIntent().getExtras();
		String course_code =""; 
		if (extras != null) {
			course_code = extras.getString("course_code");
		}
		
		SharedPreferences preferences1 = getSharedPreferences("AAST", 0);
		String name = preferences1.getString("username", "noone");
		Student student = new Student(name,this);
		
		ViewHolder holder = new ViewHolder();
		holder.cname = (TextView) findViewById(R.id.cname);
		holder.seven = (TextView) findViewById(R.id.seven);
		holder.tewelve = (TextView) findViewById(R.id.twelve);
		holder.sfinal = (TextView) findViewById(R.id.a3mal);
		holder.a3mal = (TextView) findViewById(R.id.ffinal);
		TextView c_name = (TextView) findViewById(R.id.course_name);
		result_item x = student.get_course_result(course_code);
		c_name.setText(x.getCourse());
 		holder.cname.setText(x.getCourse() + "   " + x.getCourse_code());
		holder.seven.setText(x.getSeventh_degree());
		holder.tewelve.setText(x.getTwelves_degree());
		holder.sfinal.setText(x.getSemi_degree());
		holder.a3mal.setText(x.getGrade_degree());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.course_details, menu);
		return true;
	}

}
