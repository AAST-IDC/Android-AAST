/**
 * 
 */
package idc.aast.test2;

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

}
