package idc.aast.test2;

import org.json.JSONException;
import org.json.JSONObject;

public class scheduele_slot {

	String serial;
	String course_code;
	String course;
	String day;
	String from;
	String to;
	String type;
	String name;
	String room_num;
	String room_symbol;
	String fac_code;
	String room_desc;
	String user_id;
	public scheduele_slot(JSONObject j,String user_id)
	{
		try {
			serial = j.getString("l_serial_key").trim();
			course_code = j.getString("l_crsnum_e").trim();
			course = j.getString("l_crs_name").trim();
			day = j.getString("l_day").trim();
			from = j.getString("l_from").trim();
			to = j.getString("l_to").trim();
			type = j.getString("l_kind").trim();
			name = j.getString("l_name").trim();
			room_num = j.getString("l_room_no").trim();
			fac_code = j.getString("l_fac_code").trim();
			room_symbol = j.getString("l_room_symbol").trim();
			room_desc = j.getString("l_room_desc").trim();
			this.user_id = user_id;
			
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
		
			this.serial = serial;
			this.course_code = course_code;
			this.course = course;
			this.day = day;
			this.from = from;
			this.to = to;
			this.type = type;
			this.name = name;
			this.room_num = room_num;
			this.fac_code = fac_code;
			this.room_symbol = room_symbol;
			this.room_desc = room_desc;
	
		
	
	}
	
	public scheduele_slot() {
		// TODO Auto-generated constructor stub
		
	
	}

}
