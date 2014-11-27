package idc.aast.test2;

import org.json.JSONException;
import org.json.JSONObject;

public class result_item {
	 

	  
	  String user_id;
	  String term_id;
	  String term_desc;
	  String course_code;
	  String course;
	  String seventh_degree;
	  String twelves_degree;
	  String semi_degree;
	  String grade_degree;
	  String hours;
	  public result_item(JSONObject jresult,String user_id)
	  {
		  try {
			this.user_id = user_id;
		
		  term_id = jresult.getString("term_id");
		  term_desc = jresult.getString("term");
		  course_code = jresult.getString("course code");
		  course = jresult.getString("course");
		  seventh_degree = jresult.getString("7th");
		  twelves_degree = jresult.getString("12th");
		  semi_degree = jresult.getString("semi");
		  grade_degree = jresult.getString("grade");
		  hours = jresult.getString("hours");
		  } catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	  }	
	  public result_item(String user_id,String term_id , String term_desc,String course_code , String course,String seventh_degree
			  
	, String	twelves_degree , String 	semi_degree , String  grade_degree, String hours)
	  {
		
			this.user_id = user_id;
		
			this.term_id = term_id;
			this.term_desc = term_desc;
			this.course_code = course_code;
			this.course =  course;
			this.seventh_degree = seventh_degree;
			this.twelves_degree = twelves_degree;
			this.semi_degree = semi_degree;
			this.grade_degree = grade_degree;
			this.hours = hours;
		
	  
	  }
	  
	  
	  

}
