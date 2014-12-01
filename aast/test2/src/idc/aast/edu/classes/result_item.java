package idc.aast.edu.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class result_item {
	 

	  
	  private String user_id;
	  private String term_id;
	  private String term_desc;
	  private String course_code;
	  private String course;
	  private String seventh_degree;
	  private String twelves_degree;
	  private String semi_degree;
	  private String grade_degree;
	  private String hours;
	  public result_item(JSONObject jresult,String user_id)
	  {
		  try {
			this.setUser_id(user_id);
		
		  setTerm_id(jresult.getString("term_id").trim());
		  setTerm_desc(jresult.getString("term").trim());
		  setCourse_code(jresult.getString("course code").trim());
		  setCourse(jresult.getString("course").trim());
		  setSeventh_degree(jresult.getString("7th").trim());
		  setTwelves_degree(jresult.getString("12th").trim());
		  setSemi_degree(jresult.getString("semi").trim());
		  setGrade_degree(jresult.getString("grade").trim());
		  setHours(jresult.getString("hours").trim());
		  } catch (JSONException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	  }	
	  public result_item(String user_id,String term_id , String term_desc,String course_code , String course,String seventh_degree
			  
	, String	twelves_degree , String 	semi_degree , String  grade_degree, String hours)
	  {
		
			this.setUser_id(user_id);
		
			this.setTerm_id(term_id);
			this.setTerm_desc(term_desc);
			this.setCourse_code(course_code);
			this.setCourse(course);
			this.setSeventh_degree(seventh_degree);
			this.setTwelves_degree(twelves_degree);
			this.setSemi_degree(semi_degree);
			this.setGrade_degree(grade_degree);
			this.setHours(hours);
		
	  
	  }
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * @return the seventh_degree
	 */
	public String getSeventh_degree() {
		return seventh_degree;
	}
	/**
	 * @param seventh_degree the seventh_degree to set
	 */
	public void setSeventh_degree(String seventh_degree) {
		this.seventh_degree = seventh_degree;
	}
	/**
	 * @return the twelves_degree
	 */
	public String getTwelves_degree() {
		return twelves_degree;
	}
	/**
	 * @param twelves_degree the twelves_degree to set
	 */
	public void setTwelves_degree(String twelves_degree) {
		this.twelves_degree = twelves_degree;
	}
	/**
	 * @return the semi_degree
	 */
	public String getSemi_degree() {
		return semi_degree;
	}
	/**
	 * @param semi_degree the semi_degree to set
	 */
	public void setSemi_degree(String semi_degree) {
		this.semi_degree = semi_degree;
	}
	/**
	 * @return the grade_degree
	 */
	public String getGrade_degree() {
		return grade_degree;
	}
	/**
	 * @param grade_degree the grade_degree to set
	 */
	public void setGrade_degree(String grade_degree) {
		this.grade_degree = grade_degree;
	}
	/**
	 * @return the term_desc
	 */
	public String getTerm_desc() {
		return term_desc;
	}
	/**
	 * @param term_desc the term_desc to set
	 */
	public void setTerm_desc(String term_desc) {
		this.term_desc = term_desc;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the term_id
	 */
	public String getTerm_id() {
		return term_id;
	}
	/**
	 * @param term_id the term_id to set
	 */
	public void setTerm_id(String term_id) {
		this.term_id = term_id;
	}
	/**
	 * @return the hours
	 */
	public String getHours() {
		return hours;
	}
	/**
	 * @param hours the hours to set
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}
	  
	  
	  

}
