package idc.aast.edu.classes.community;

import org.json.JSONException;
import org.json.JSONObject;

public class Group {

	
	public String group_name;
	public String group_id;
	public String group_type;
	public String user_id;
	public String role_id;
	public Group() {
		// TODO Auto-generated constructor stub
	}
	public Group(JSONObject j)
	{
		
		try {
			group_id  = j.getString("group_id");
			group_name = j.getString("group_name");
			group_type = j.getString("group_type");
			user_id = j.getString("user_id");
			role_id = j.getString("role_id");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Group(String group_name,String group_id,String group_type,String user_id,String role_id)
	{
		this.group_id  = group_id;
		this.group_name = group_name;
		this.group_type =group_type;
		this.user_id = user_id;
		this.role_id = role_id;
	}
	
}
