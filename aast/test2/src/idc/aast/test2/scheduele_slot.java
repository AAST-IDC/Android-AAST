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
	public scheduele_slot(JSONObject j)
	{
		try {
			serial = j.getString("l_serial_key");
			course_code = j.getString("l_crsnum_e");
			course = j.getString("l_crs_name");
			day = j.getString("l_day");
			from = j.getString("l_from");
			to = j.getString("l_to");
			type = j.getString("");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public scheduele_slot() {
		// TODO Auto-generated constructor stub
		
	
	}

}
