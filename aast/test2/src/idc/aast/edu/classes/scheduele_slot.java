package idc.aast.edu.classes;

import org.json.JSONException;
import org.json.JSONObject;

public class scheduele_slot {

	private String serial;
	private String course_code;
	private String course;
	private String day;
	private String from;
	private String to;
	private String type;
	private String name;
	private String room_num;
	private String room_symbol;
	String fac_code;
	private String room_desc;
	private String user_id;
	public scheduele_slot(JSONObject j,String user_id)
	{
		try {
			setSerial(j.getString("l_serial_key").trim());
			setCourse_code(j.getString("l_crsnum_e").trim());
			setCourse(j.getString("l_crs_name").trim());
			setDay(j.getString("l_day").trim());
			setFrom(j.getString("l_from").trim());
			setTo(j.getString("l_to").trim());
			setType(j.getString("l_kind").trim());
			setName(j.getString("l_name").trim());
			setRoom_num(j.getString("l_room_no").trim());
			fac_code = j.getString("l_fac_code").trim();
			setRoom_symbol(j.getString("l_room_symbol").trim());
			setRoom_desc(j.getString("l_room_desc").trim());
			this.setUser_id(user_id);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	  private static final String[] sch_columns = {
		   
	    	"user_id",
	    	"serial_key",
	    	"course_code",
	    	"course",
	    	"day_code",
	    	"from_code",
	    	"to_code",
	    	"kind",
	    	"lec_name",
	    	"fac_code",
	    	"room_symbol",
	    	"room_desc",
	    	
	    };	    
	public scheduele_slot(String user_id , String serial, String course_code , String course , String day , String from , String to
			, String type , String name  , String fac_code, String room_symbol ,  String room_num  , String room_desc)
	{
		
			this.setSerial(serial);
			this.setCourse_code(course_code);
			this.setCourse(course);
			this.setDay(day);
			this.setFrom(from);
			this.setTo(to);
			this.setType(type);
			this.setName(name);
			this.setRoom_num(room_num);
			this.fac_code = fac_code;
			this.setRoom_symbol(room_symbol);
			this.setRoom_desc(room_desc);
	
		
	
	}
	
	public scheduele_slot() {
		// TODO Auto-generated constructor stub
		
	
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
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
	 * @return the course_code
	 */
	public String getCourse_code() {
		return course_code;
	}

	/**
	 * @param course_code the course_code to set
	 */
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	/**
	 * @return the room_num
	 */
	public String getRoom_num() {
		return room_num;
	}

	/**
	 * @param room_num the room_num to set
	 */
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return the room_desc
	 */
	public String getRoom_desc() {
		return room_desc;
	}

	/**
	 * @param room_desc the room_desc to set
	 */
	public void setRoom_desc(String room_desc) {
		this.room_desc = room_desc;
	}

	/**
	 * @return the room_symbol
	 */
	public String getRoom_symbol() {
		return room_symbol;
	}

	/**
	 * @param room_symbol the room_symbol to set
	 */
	public void setRoom_symbol(String room_symbol) {
		this.room_symbol = room_symbol;
	}

}
