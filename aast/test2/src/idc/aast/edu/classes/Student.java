/**
 * 
 */
package idc.aast.edu.classes;

import idc.aast.edu.database.MySQLiteHelper;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

/**
 * @author amr
 *
 */
public class Student extends User { 

	/**
	 * 
	 */
	public String [] all_terms;
	public ArrayList<String>  all_days;
	public 	MySQLiteHelper db;
	public Student(String user_id , Context con ) {
		db = new MySQLiteHelper(con);
		this.user_id = user_id;
		user_type="0";
		this.con=con;
		
		// TODO Auto-generated constructor stub
	}
	public String []  get_terms()
	{
	 
		ArrayList<String> terms = db.get_terms(user_id);
 all_terms = new String[terms.size()];
	 all_terms = terms.toArray(all_terms);
	 return all_terms;
	 
		
	}
	public ArrayList<String>  get_days()
	{
	 
		ArrayList<String> temp =  db.get_days(user_id);
		
		all_days = new ArrayList<String>();
		for( int i =0 ;i <6 ;i++)
		{
			all_days.add("none");
		
		}
		for(int i=0;i<temp.size();i++)
		{
			int t = Integer.parseInt(temp.get(i));
			all_days.set(t-1, "ok");
		
		}
		return all_days;

	 
		
	}
	public ArrayList<scheduele_slot> get_day_sch(String day)
	{
		return db.get_Shcedueleday(user_id, day);
		
		
	}
	public ArrayList<news_item> get_news() {
		
		
		return db.get_all_news();
		
	}
	public ArrayList<result_item> get_results() {
	
			
		return db.get_all_results(get_last(), user_id);
		
	}
	public List<result_item> get_results(String term) {
		
		
		return db.get_all_results(term, user_id);
		
	}
	public List<result_item> get_results(int term) {
		
		
		return db.get_all_results(all_terms[term], user_id);
		
	}
	public String get_last()
	{
		
		return all_terms[all_terms.length-1];
	}
	public result_item get_course_result(String course_code) {
		return db.get_course_result(course_code,user_id);
	}

}
